package com.pluralsight;

public class Saiyan extends Fighter {

    public Saiyan(String name, int powerLevel, int health) {
        super(name, powerLevel, health);
    }

    public String transformSuperSaiyan() {
        int newPowerLevel = getPowerLevel() * 2;
        setPowerLevel(newPowerLevel);

        return getName() + " transforms into Super Saiyan! New power level: " + getPowerLevel();
    }

    public String transformSuperSaiyanGod() {
        int newPowerLevel = getPowerLevel() * 3;
        setPowerLevel(newPowerLevel);

        return getName() + " transforms into Super Saiyan God! New power level: " + getPowerLevel();
    }

    public String transformSuperSaiyanBlue() {
        int newPowerLevel = getPowerLevel() * 4;
        setPowerLevel(newPowerLevel);

        return getName() + " transforms into Super Saiyan Blue! New power level: " + getPowerLevel();
    }

    @Override
    public String specialMove() {
        String message = transformSuperSaiyan();
        message += "\n" + transformSuperSaiyanGod();
        message += "\n" + transformSuperSaiyanBlue();

        return message;
    }
}
