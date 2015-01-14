/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import grafika.GraphicsHandler;
import pomocne.Barva;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author wentsa
 */
public class Puntik extends JLabel implements Serializable {

    private final int souradniceY;
    
    public Puntik(Barva barva, int y) {
        this.souradniceY=y-2;
        GraphicsHandler.nactiPuntik(this.hashCode() + "", barva);
        setIcon(GraphicsHandler.getIcon(this.hashCode() + ""));
        setVisible(true);
    }
    
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        setLocation(38, souradniceY);
    }
    
    
    
    
}
