/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audio;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author wentsa
 */
public class SoundHandler {

    public static void rollDice() {
        playFile("diceroll");
    }

    public static void horse() {
        playFile("horse");
    }
    
    public static void end() {
        playFile("end");
    }
    
    public static void stables() {
        playFile("stables");
    }
    
    public static void transport() {
        playFile("transport");
    }
    

    private static void playFile(final String file) {
        (new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            SoundHandler.class.getResourceAsStream("/sound/" + file + ".wav"));
                    clip.open(inputStream);
                    clip.loop(0);
                    clip.start();
                    Thread.sleep(clip.getMicrosecondLength()/1000);
                    clip.stop();
                    clip.close();
                    inputStream.close();
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException | InterruptedException ex) {
                    Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        })).start();

    }

}
