package com.pluralsight;

import java.util.Scanner;

public class Namekian extends Fighter {
    private static final String SPECIAL_BEAM_CANNON_SOUND = "sounds/special-beam-cannon-made-with-Voicemod.mp3";
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String BOLD = "\u001B[1m";

    public Namekian(String name, int powerLevel, int health) {
        super(name, powerLevel, health);
    }

    public String specialBeamCannon() {
        SoundPlayer.playSound(SPECIAL_BEAM_CANNON_SOUND);
        setDamageMultiplier(10);

        return getName() + " uses Special Beam Cannon! The next attack is 10 times stronger!";
    }

    public String regenerate() {
        int healingAmount = 100;
        int energyCost = 3000;

        if (getPowerLevel() < energyCost) {
            return getName() + " doesn't have enough power to regenerate!";
        }

        setHealth(getHealth() + healingAmount);
        setPowerLevel(getPowerLevel() - energyCost);

        return getName() + " regenerates " + healingAmount
                + " health! Current health: " + getHealth()
                + ". Current power level: " + getPowerLevel();
    }

    public String heal() {
        int healingAmount = 50;
        int energyCost = 1500;

        if (getPowerLevel() < energyCost) {
            return getName() + " doesn't have enough power to heal!";
        }

        setHealth(getHealth() + healingAmount);
        setPowerLevel(getPowerLevel() - energyCost);

        return getName() + " heals " + healingAmount
                + " health! Current health: " + getHealth()
                + ". Current power level: " + getPowerLevel();
    }

    @Override
    public String specialMove(Scanner scanner) {
        System.out.println(BOLD + CYAN + "Choose " + getName() + "'s special move:" + RESET);
        System.out.println(GREEN + "1) Regenerate" + RESET);
        System.out.println(GREEN + "2) Heal" + RESET);
        System.out.println(GREEN + "3) Special Beam Cannon" + RESET);
        System.out.println("0) Save energy");
        System.out.print("Choose an option: ");

        int choice = getChoice(scanner);

        switch (choice) {
            case 1:
                return regenerate();
            case 2:
                return heal();
            case 3:
                return specialBeamCannon();
            case 0:
                return getName() + " saves energy.";
            default:
                return getName() + " loses focus and saves energy.";
        }
    }
}
