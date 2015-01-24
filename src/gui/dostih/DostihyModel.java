/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dostih;

import grafika.GraphicsHandler;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author wentsa
 */
public class DostihyModel implements Serializable {
    private static final long serialVersionUID = 1L;
    protected final int pozice;
    protected final int poradi;
    private int souradniceX=-1;
    private int souradniceY=-1;
    private double uhel=-1;
    
    protected DostihyModel(int pozice, boolean hlavniDostih, int poradi) {
        this.pozice = pozice;
        this.poradi=poradi+1;
        GraphicsHandler.nactiDostih("" + this.hashCode(), hlavniDostih);
    }

    protected int getSouradniceX() {
        return souradniceX;
    }

    protected ImageIcon getDostih() {
        return GraphicsHandler.getIcon("" + this.hashCode());
    }

    protected int getSouradniceY() {
        return souradniceY;
    }

    double getUhel() {
        return uhel;
    }

    /**
     * @param souradniceX the souradniceX to set
     */
    public void setSouradniceX(int souradniceX) {
        this.souradniceX = souradniceX;
    }

    /**
     * @param souradniceY the souradniceY to set
     */
    public void setSouradniceY(int souradniceY) {
        this.souradniceY = souradniceY;
    }

    /**
     * @param uhel the uhel to set
     */
    public void setUhel(double uhel) {
        this.uhel = uhel;
    }
}
