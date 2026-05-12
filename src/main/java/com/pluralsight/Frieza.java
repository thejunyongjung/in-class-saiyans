package com.pluralsight;

public class Frieza extends Fighter {
    private static final String FRIEZA_SOUND = "sounds/frieza-ohohoh-mp3-made-with-Voicemod.mp3";

    public Frieza(String name, int powerLevel, int health) {
        super(name, powerLevel, health);
    }

    @Override
    public String attack() {
        SoundPlayer.playSound(FRIEZA_SOUND);

        return getName() + " attacks back with power level " + getPowerLevel() + "!";
    }
}
