/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dostihy;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author wentsa
 */
public class Kostka extends JButton {
    private int kolik;
    private boolean hozeno;
    Random random;

    public Kostka() {
        this.kolik=0;
        this.hozeno=false;
        random=new Random();
        
        setContentAreaFilled(false);
        setOpaque(false);
        setBorderPainted(false);
        setEnabled(false);
        addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        kolik+=(random.nextInt(6)+1);
                        hozeno=true;
                    }
                });
    }
    
    public int hazej(StatusBox box) {
        kolik=0;
        System.out.println("hazej");
        setEnabled(true);
        while(!hozeno) {try {
            Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Kostka.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        hozeno=false;
        box.setText("Hodil jsi " + kolik);
        if(kolik==6) {
            box.setText("Hodil jsi 6, hazek znovu");
            while(!hozeno) {try {
                Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Kostka.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            box.setText("Hodil jsi " + (kolik-6));
            hozeno=false;
        }
        setEnabled(false);
        return kolik;
    }

        
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBounds(80, 550, 150, 100);
    }
    
}
