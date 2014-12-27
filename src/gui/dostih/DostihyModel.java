/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dostih;

import javax.swing.ImageIcon;

/**
 *
 * @author wentsa
 */
public class DostihyModel {
    protected final int pozice;
    protected final ImageIcon dostih;
    protected final int poradi;
    protected int souradniceX;
    protected int souradniceY;
    protected DostihyModel(int pozice, ImageIcon dostih, int poradi) {
        this.pozice = pozice;
        this.dostih = dostih;
        this.poradi=poradi+1;
    }

    protected int getSouradniceX() {
        return souradniceX;
    }

    protected ImageIcon getDostih() {
        return dostih;
    }

    protected int getSouradniceY() {
        return souradniceY;
    }
}
