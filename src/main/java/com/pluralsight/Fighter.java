package com.pluralsight;

import java.util.Scanner;

public class Fighter {
    private String name;
    private int powerLevel;
    private int health;
    private int damageMultiplier;

    public Fighter(String name, int powerLevel, int health) {
        this.name = name;
        this.powerLevel = powerLevel;
        this.health = health;
        damageMultiplier = 1;
    }

    public String attack() {
        return name + " attacks with power level " + powerLevel + "!";
    }

    public String takeDamage(int damage) {
        health -= damage;

        if (health < 0) {
            health = 0;
        }

        return name + " takes " + damage + " damage. Health left: " + health;
    }

    public String specialMove(Scanner scanner) {
        damageMultiplier = 1;
        return name + " is ready for battle!";
    }

    public int getAttackDamage() {
        int damage = powerLevel / 1000;

        if (damage < 10) {
            damage = 10;
        }

        damage *= damageMultiplier;
        damageMultiplier = 1;

        return damage;
    }

    public void setDamageMultiplier(int damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public int getChoice(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getFighterInfo() {
        return name + " | Power Level: " + powerLevel + " | Health: " + health;
    }
}
