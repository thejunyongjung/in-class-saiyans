package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Fighter> team = new ArrayList<>();
    static ArrayList<String> battleReport = new ArrayList<>();
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String PURPLE = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String BOLD = "\u001B[1m";

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getIntInput("Choose an option: ");

            switch (choice) {
                case 1:
                    createSaiyan();
                    break;
                case 2:
                    createNamekian();
                    break;
                case 3:
                    viewTeam();
                    break;
                case 4:
                    calculateTotalTeamPower();
                    break;
                case 5:
                    startBattle();
                    break;
                case 6:
                    saveBattleReport();
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    System.out.println();
                    break;
            }
        }
    }

    public static void displayMenu() {
        printDivider();
        System.out.println(BOLD + CYAN + "=== DBZ Battle Arena ===" + RESET);
        System.out.println();
        System.out.println(GREEN + "1) Create Saiyan" + RESET);
        System.out.println(GREEN + "2) Create Namekian" + RESET);
        System.out.println(BLUE + "3) View Team" + RESET);
        System.out.println(BLUE + "4) Calculate Total Team Power" + RESET);
        System.out.println(RED + "5) Start Battle" + RESET);
        System.out.println(YELLOW + "6) Save Battle Report" + RESET);
        System.out.println("0) Exit");
        System.out.println();
    }

    public static void createSaiyan() {
        System.out.print("Enter Saiyan name: ");
        String name = scanner.nextLine();
        int powerLevel = getIntInput("Enter power level: ");
        int health = getIntInput("Enter health: ");

        Saiyan saiyan = new Saiyan(name, powerLevel, health);
        team.add(saiyan);

        String message = name + " has been added to your team!";
        System.out.println();
        System.out.println(GREEN + message + RESET);
        System.out.println();
        battleReport.add(message);
        pause(3000);
    }

    public static void createNamekian() {
        System.out.print("Enter Namekian name: ");
        String name = scanner.nextLine();
        int powerLevel = getIntInput("Enter power level: ");
        int health = getIntInput("Enter health: ");

        Namekian namekian = new Namekian(name, powerLevel, health);
        team.add(namekian);

        String message = name + " has been added to your team!";
        System.out.println();
        System.out.println(GREEN + message + RESET);
        System.out.println();
        battleReport.add(message);
        pause(3000);
    }

    public static void viewTeam() {
        if (team.isEmpty()) {
            System.out.println("Your team is empty.");
            System.out.println();
            return;
        }

        printDivider();
        System.out.println(BOLD + CYAN + "=== Your Team ===" + RESET);
        System.out.println();

        for (int i = 0; i < team.size(); i++) {
            Fighter fighter = team.get(i);
            System.out.println(YELLOW + (i + 1) + ") " + RESET + fighter.getFighterInfo());
        }

        System.out.println();
    }

    public static void calculateTotalTeamPower() {
        int totalPower = 0;

        for (Fighter fighter : team) {
            totalPower += fighter.getPowerLevel();
        }

        String message = "Total team power: " + totalPower;
        System.out.println();
        System.out.println(BOLD + GREEN + message + RESET);
        System.out.println();
        battleReport.add(message);
    }

    public static void startBattle() {
        if (team.isEmpty()) {
            System.out.println("You need to create fighters before starting a battle.");
            System.out.println();
            return;
        }

        battleReport.add("=== Battle Started ===");
        printDivider();
        System.out.println(BOLD + RED + "=== Battle Started ===" + RESET);
        System.out.println();

        Frieza frieza = new Frieza("Frieza", 15000, 500);
        String friezaMessage = "Frieza enters the arena! " + frieza.getFighterInfo();
        System.out.println(BOLD + PURPLE + friezaMessage + RESET);
        battleReport.add(friezaMessage);
        System.out.println();

        int round = 1;

        while (frieza.getHealth() > 0 && !isTeamDefeated()) {
            String roundMessage = "=== Round " + round + " ===";
            printDivider();
            System.out.println(BOLD + YELLOW + roundMessage + RESET);
            System.out.println();
            battleReport.add(roundMessage);

            for (Fighter fighter : team) {
                if (frieza.getHealth() <= 0 || isTeamDefeated()) {
                    break;
                }

                if (fighter.getHealth() <= 0) {
                    continue;
                }

                String turnMessage = "[" + fighter.getName() + "'s turn!]";
                System.out.println(BOLD + CYAN + turnMessage + RESET);
                System.out.println();
                battleReport.add(turnMessage);

                String specialMoveMessage = fighter.specialMove(scanner);
                int damage = fighter.getAttackDamage();
                String attackMessage = fighter.attack();
                String friezaDamageMessage = frieza.takeDamage(damage);
                System.out.println();
                System.out.println(YELLOW + specialMoveMessage + RESET);
                System.out.println(GREEN + attackMessage + RESET);
                System.out.println(RED + friezaDamageMessage + RESET);

                battleReport.add(specialMoveMessage);
                battleReport.add(attackMessage);
                battleReport.add(friezaDamageMessage);

                if (frieza.getHealth() > 0) {
                    String friezaTurnMessage = "[Frieza's turn!]";
                    System.out.println();
                    System.out.println(BOLD + PURPLE + friezaTurnMessage + RESET);
                    System.out.println();
                    battleReport.add(friezaTurnMessage);

                    String friezaAttackMessage = frieza.attack();
                    int friezaDamage = frieza.getPowerLevel() / 300;

                    if (friezaDamage < 45) {
                        friezaDamage = 45;
                    }

                    String fighterDamageMessage = fighter.takeDamage(friezaDamage);

                    System.out.println(PURPLE + friezaAttackMessage + RESET);
                    System.out.println(RED + fighterDamageMessage + RESET);

                    battleReport.add(friezaAttackMessage);
                    battleReport.add(fighterDamageMessage);
                }

                System.out.println();
            }

            round++;
        }

        String resultMessage;

        if (frieza.getHealth() <= 0) {
            resultMessage = "Your team defeated Frieza!";
        } else {
            resultMessage = "Your team has been defeated. Frieza wins!";
        }

        printDivider();
        if (frieza.getHealth() <= 0) {
            System.out.println(BOLD + GREEN + resultMessage + RESET);
        } else {
            System.out.println(BOLD + RED + resultMessage + RESET);
        }
        System.out.println();
        battleReport.add(resultMessage);
        battleReport.add("=== Battle Ended ===");
        System.out.println(BOLD + CYAN + "=== Battle Ended ===" + RESET);
        System.out.println();
    }

    public static void saveBattleReport() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt"));

            writer.write("=== DBZ Battle Arena Report ===");
            writer.newLine();
            writer.newLine();
            writer.write("Team:");
            writer.newLine();

            if (team.isEmpty()) {
                writer.write("No fighters have been added.");
                writer.newLine();
            } else {
                for (Fighter fighter : team) {
                    writer.write("- " + fighter.getFighterInfo());
                    writer.newLine();
                }
            }

            writer.newLine();
            writer.write("Battle Results:");
            writer.newLine();

            for (String line : battleReport) {
                writer.write(line);
                writer.newLine();
            }

            writer.close();
            System.out.println();
            System.out.println(GREEN + "Battle report saved to transactions.txt" + RESET);
            System.out.println();
        } catch (IOException e) {
            System.out.println(RED + "There was a problem saving the battle report." + RESET);
            System.out.println();
        }
    }

    public static int getIntInput(String prompt) {
        System.out.print(prompt);
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public static boolean isTeamDefeated() {
        for (Fighter fighter : team) {
            if (fighter.getHealth() > 0) {
                return false;
            }
        }

        return true;
    }

    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void printDivider() {
        System.out.println();
        System.out.println(BOLD + "----------------------------------------" + RESET);
    }
}
