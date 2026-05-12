package com.pluralsight;

public class Namekian extends Fighter {

    public Namekian(String name, int powerLevel, int health) {
        super(name, powerLevel, health);
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
    public String specialMove() {
        String message = takeDamage(30);
        message += "\n" + regenerate();

        return message;
    }
}
