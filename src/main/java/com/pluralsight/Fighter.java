package com.pluralsight;

public class Fighter {
    private String name;
    private int powerLevel;
    private int health;

    public Fighter(String name, int powerLevel, int health) {
        this.name = name;
        this.powerLevel = powerLevel;
        this.health = health;
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

    public String specialMove() {
        return name + " is ready for battle!";
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
