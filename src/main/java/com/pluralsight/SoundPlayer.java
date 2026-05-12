package com.pluralsight;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {

    public static void playSound(String filePath) {
        try {
            File soundFile = new File(filePath);

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();

            clip.open(audioStream);
            clip.start();

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file format.");
        } catch (IOException e) {
            System.out.println("Could not read the audio file.");
        } catch (LineUnavailableException e) {
            System.out.println("Audio line is unavailable.");
        }
    }
}