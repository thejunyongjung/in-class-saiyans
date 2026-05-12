package com.pluralsight;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {

    public static void playSound(String filePath) {
        if (filePath.endsWith(".mp3")) {
            playMp3(filePath);
            return;
        }

        try {
            File soundFile = new File(filePath);

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();

            clip.open(audioStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file format.");
        } catch (IOException e) {
            System.out.println("Could not read the audio file.");
        } catch (LineUnavailableException e) {
            System.out.println("Audio line is unavailable.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void playMp3(String filePath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("afplay", filePath);
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException e) {
            System.out.println("Could not play the MP3 file.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
