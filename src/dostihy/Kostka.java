/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dostihy;

import MVC.HerniPlochaController;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

/**
 *
 * @author wentsa
 */
public final class Kostka extends JButton implements Serializable {

    private int kolik;
    private boolean hozeno;
    Random random;

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
                System.out.println("hazi");
                kolik += (random.nextInt(6) + 1);
                hozeno = true;
            }
        });
    }

    public int hazej() {
        kolik = 0;
        setEnabled(true);
        HerniPlochaController.getInstance().prepniKostky();
        System.out.println("nehozeno " + SwingUtilities.isEventDispatchThread());
        
        while (!hozeno) {
            if (!Hra.getInstance().jeAktualniHracAktivni()) {
                HerniPlochaController.getInstance().prepniKostky();
                setEnabled(false);
                System.out.println("          vyhodil");
                return -1;
            }
           
            System.out.print("j-");
        }
        System.out.println("hozeno");
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
