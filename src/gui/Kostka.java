/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.plocha.HerniPlochaController;
import hra.Hra;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import audio.SoundHandler;

/**
 *
 * @author wentsa
 */
public final class Kostka extends JButton implements Serializable {

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
                SoundHandler.play("diceroll");
                kolik += (random.nextInt(6) + 1);
                hozeno = true;
                System.out.println(hozeno);
            }
        });
    }

    public int hazej() {
        kolik = 0;
        setEnabled(true);
        HerniPlochaController.getInstance().prepniKostky();
        
        while (!hozeno) {
            if (!Hra.getInstance().jeAktualniHracAktivni()) {
                HerniPlochaController.getInstance().prepniKostky();
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
            System.out.println(Thread.currentThread());
            Hra.getInstance().status("Hodil jsi 6, hazej znovu");
            while (!hozeno) {
                if (!Hra.getInstance().jeAktualniHracAktivni()) {
                    HerniPlochaController.getInstance().prepniKostky();
                    setEnabled(false);
                    return -1;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Kostka.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Hra.getInstance().status("Hodil jsi " + (kolik - 6) + " posouvas se o " + kolik);
            hozeno = false;
        } else {
            Hra.getInstance().status("Hodil jsi " + kolik);
        }

        HerniPlochaController.getInstance().prepniKostky();
        setEnabled(false);
        return kolik;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBounds(80, 550, 150, 100);
    }

}
