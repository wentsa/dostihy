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

    private static Clip diceroll, horse, end, stables, transport;

    private static Clip nactiClip(String jmeno) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        Clip clip;
        clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                SoundHandler.class.getResource("/sound/" + jmeno + ".wav"));
        clip.open(inputStream);
        return clip;
    }

    public static void rollDice() {
        try {
            if(diceroll==null) diceroll = nactiClip("diceroll");
            playFile(diceroll);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void horse() {
        try {
            if(horse==null) horse = nactiClip("horse");
            playFile(horse);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void end() {
        try {
            if(end==null) end = nactiClip("end");
            playFile(end);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void stables() {
        if(stables==null) try {
            stables = nactiClip("stables");
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        //playFile("stables");
        
        //playFile("stables");
    }

    public static void transport() {
        if(transport==null) try {
            transport = nactiClip("transport");
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        playFile(transport);
    }

    private static void playFile(final Clip clip) {
        clip.stop();
        clip.setFramePosition(0);
        (new Thread(new Runnable() {
            @Override
            public void run() {
                clip.start();
                try {
                    Thread.sleep(clip.getMicrosecondLength() / 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                clip.stop();
            }
        })).start();
    }
}
