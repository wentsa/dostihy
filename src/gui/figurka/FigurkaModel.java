/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.figurka;

import grafika.GraphicsHandler;
import java.io.Serializable;
import javax.swing.ImageIcon;
import pomocne.Barva;

/**
 *
 * @author wentsa
 */
public class FigurkaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private Barva barva; //bila cerna cervena fialova modra oranzova tyrkysova zelena zluta
    protected int pozice;
    private final int cislo;
    protected int souradniceX;
    protected int souradniceY;

    public FigurkaModel(Barva barva, int pozice, int cislo) {
        this.barva = barva;
        this.pozice = pozice;
        this.cislo = cislo;
        GraphicsHandler.nactiFigurku("" + this.hashCode(), barva);
    }

    public void zmenBarvu(Barva barva) {
        this.barva = barva;
        GraphicsHandler.nactiFigurku("" + this.hashCode(), barva);
    }

    protected ImageIcon getObrazek() {
        return GraphicsHandler.getIcon("" + this.hashCode());
    }

    protected Barva getBarva() {
        return barva;
    }

    protected int getPozice() {
        return pozice;
    }

    protected void setPozice(int i) {
        this.pozice = i;
    }

    public int getSouradniceX() {
        return souradniceX;
    }

    public int getSouradniceY() {
        return souradniceY;
    }

    protected void setSouradniceX(int x) {
        souradniceX = x;
    }

    protected void setSouradniceY(int y) {
        souradniceY = y;
    }

    protected int getCislo() {
        return cislo;
    }

}
