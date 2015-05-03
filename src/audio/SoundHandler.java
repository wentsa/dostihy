/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audio;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import pomocne.Konstanty;

/**
 *
 * @author wentsa
 */
public class SoundHandler {

    private static Map<String, Clip> klipy;

    public static void inicializovat() {
        klipy = new HashMap<>();
        try {
            nactiClip(Konstanty.Sound.DICEROLL);
            nactiClip(Konstanty.Sound.HORSE);
            nactiClip(Konstanty.Sound.END);
            nactiClip(Konstanty.Sound.STABLES);
            nactiClip(Konstanty.Sound.TRANSPORT);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void nactiClip(String jmeno) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        Clip clip;
        clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                SoundHandler.class.getResource("/sound/" + jmeno + ".wav"));
        clip.open(inputStream);
        klipy.put(jmeno, clip);
    }

    public static void play(String nazev) {
        playFile(klipy.get(nazev));
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
