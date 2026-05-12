package com.pluralsight;

import java.util.Scanner;

public class Saiyan extends Fighter {
    private static final String KAMEHAMEHA_SOUND = "sounds/goku-kamehameha-sound-effect.wav";
    private static final String RESET = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String BOLD = "\u001B[1m";
    private int originalPowerLevel;

    public Saiyan(String name, int powerLevel, int health) {
        super(name, powerLevel, health);
        originalPowerLevel = powerLevel;
    }

    @Override
    public String attack() {
        int attackPowerLevel = getPowerLevel();
        SoundPlayer.playSound(KAMEHAMEHA_SOUND);
        setPowerLevel(originalPowerLevel);

        return getName() + " uses Kamehameha with power level " + attackPowerLevel
                + "! Power level returns to " + getPowerLevel() + ".";
    }

    public String transformSuperSaiyan() {
        int newPowerLevel = getPowerLevel() * 2;
        setPowerLevel(newPowerLevel);
        setDamageMultiplier(2);

        return getName() + " transforms into Super Saiyan! New power level: " + getPowerLevel();
    }

    public String transformSuperSaiyanGod() {
        int newPowerLevel = getPowerLevel() * 3;
        setPowerLevel(newPowerLevel);
        setDamageMultiplier(5);

        return getName() + " transforms into Super Saiyan God! New power level: " + getPowerLevel()
                + ". The next attack is 5 times stronger!";
    }

    public String transformSuperSaiyanBlue() {
        int newPowerLevel = getPowerLevel() * 4;
        setPowerLevel(newPowerLevel);
        setDamageMultiplier(8);

        return getName() + " transforms into Super Saiyan Blue! New power level: " + getPowerLevel()
                + ". The next attack is 8 times stronger!";
    }

    @Override
    public String specialMove(Scanner scanner) {
        System.out.println(BOLD + CYAN + "Choose " + getName() + "'s transformation:" + RESET);
        System.out.println(YELLOW + "1) Super Saiyan" + RESET);
        System.out.println(YELLOW + "2) Super Saiyan God" + RESET);
        System.out.println(YELLOW + "3) Super Saiyan Blue" + RESET);
        System.out.println("0) Do not transform");
        System.out.print("Choose an option: ");

        int choice = getChoice(scanner);

        switch (choice) {
            case 1:
                return transformSuperSaiyan();
            case 2:
                return transformSuperSaiyanGod();
            case 3:
                return transformSuperSaiyanBlue();
            case 0:
                return getName() + " saves energy and does not transform.";
            default:
                return getName() + " hesitates and does not transform.";
        }
    }
}
