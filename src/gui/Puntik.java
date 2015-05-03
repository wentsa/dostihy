/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import grafika.GraphicsHandler;
import grafika.RozmeryPlochy;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JLabel;
import pomocne.Barva;

/**
 *
 * @author wentsa
 */
public class Puntik extends JLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    private int souradniceY;

    public Puntik(Barva barva) {
        GraphicsHandler.nactiPuntik(this.hashCode() + "", barva);
        setIcon(GraphicsHandler.getIcon(this.hashCode() + ""));
        setVisible(true);
    }

    public void nacti(int y) {
        this.souradniceY = y - 2;
        setIcon(GraphicsHandler.getIcon(this.hashCode() + ""));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setLocation((int) (38 * RozmeryPlochy.getScalingFactor()), souradniceY);
    }

}
