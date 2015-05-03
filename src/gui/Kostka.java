/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import audio.SoundHandler;
import grafika.RozmeryPlochy;
import gui.plocha.HerniPlochaController;
import hra.Hra;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import pomocne.Konstanty;

/**
 *
 * @author wentsa
 */
public final class Kostka extends JButton implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final ResourceBundle bundle = ResourceBundle.getBundle("languages/complementary/Complementary", Konstanty.DEFAULT_LOCALE);

    private int kolik;
    private boolean hozeno;
    private final Random random;

    public Kostka() {
        this.kolik = 0;
        this.hozeno = false;
        random = new Random();

        setContentAreaFilled(false);
        setOpaque(false);
        setBorderPainted(false);
        setEnabled(false);
    }

    public void pridejListener() {
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SoundHandler.play(Konstanty.Sound.DICEROLL);
                kolik += (random.nextInt(6) + 1);
                hozeno = true;
            }
        });
    }

    public int hazej() {
        kolik = 0;
        setEnabled(true);
        System.out.println("zapnuto");
        HerniPlochaController.getInstance().zapniKostky();
        while (!hozeno) {
            if (!Hra.getInstance().jeAktualniHracAktivni()) {
                HerniPlochaController.getInstance().vypniKostky();
                System.out.println("vypnuto");
                setEnabled(false);
                return -1;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Kostka.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        hozeno = false;
        if (kolik == 6) {
            Hra.getInstance().status(bundle.getString("THROW_AGAIN"));
            while (!hozeno) {
                if (!Hra.getInstance().jeAktualniHracAktivni()) {
                    HerniPlochaController.getInstance().vypniKostky();
                    System.out.println("vypnuto");
                    setEnabled(false);
                    return -1;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Kostka.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Hra.getInstance().status(bundle.getString("YOU_THREW")
                    + " " + (kolik - 6) + " "
                    + bundle.getString("MOVING_FOR")
                    + " " + kolik);
            hozeno = false;
        } else {
            Hra.getInstance().status(bundle.getString("YOU_THREW")
                    + " " + kolik);
        }

        HerniPlochaController.getInstance().vypniKostky();
        System.out.println("vypnuto");
        setEnabled(false);
        return kolik;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (RozmeryPlochy.isOriginalniHodnoty()) {
            setBounds(80, 550, 150, 100);
        } else {
            setBounds((int) (80 * RozmeryPlochy.getScalingFactor()),
                    (int) (550 * RozmeryPlochy.getScalingFactor()),
                    (int) (150 * RozmeryPlochy.getScalingFactor()),
                    (int) (100 * RozmeryPlochy.getScalingFactor()));
        }
    }

}
