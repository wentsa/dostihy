/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dostih;

import grafika.GraphicsHandler;
import java.io.Serializable;
import javax.swing.ImageIcon;
import pomocne.Barva;

/**
 *
 * @author wentsa
 */
public class DostihyModel implements Serializable {
    protected final int pozice;
    protected final int poradi;
    protected int souradniceX=-1;
    protected int souradniceY=-1;
    protected double uhel=-1;
    
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
}
