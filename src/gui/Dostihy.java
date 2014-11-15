/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author wentsa
 */
public abstract class Dostihy extends JLabel {
    protected final int pozice;
    ImageIcon dostih;

    public Dostihy(int pozice, ImageIcon dostih) {
        this.pozice = pozice;
        this.dostih = dostih;
        setIcon(dostih);
        setVisible(false);
    }
    protected abstract int souradniceX();
    protected abstract int souradniceY();
    
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        setLocation(souradniceX(), souradniceY());
    }
    
}
