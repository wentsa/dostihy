/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.figurka;

import grafika.GraphicsHandler;
import grafika.RozmeryPlochy;
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
    
    protected FigurkaModel(Barva barva, int cislo) {
        this.barva = barva;
        this.pozice=0;
        this.cislo=cislo;
        nastavSouradnice();
        GraphicsHandler.nactiFigurku("" + this.hashCode(), barva);
    }
    
    protected final void nastavSouradnice() {
        nastavX();
        nastavY();
    }
    
    protected void nastavX() {
        souradniceX=(int)(((int)(150*RozmeryPlochy.getScalingFactor())+(cislo<=5?cislo:cislo-5)*(int)(10*RozmeryPlochy.getScalingFactor())) //polomer
                * Math.cos(Math.toRadians((getPozice()+5)*9 //uhel
                + (cislo<=5 ? (int)(2*RozmeryPlochy.getScalingFactor()) : (int)(7*RozmeryPlochy.getScalingFactor()))))) //dorovnani uhlu podle pozice
                + (int)(340*RozmeryPlochy.getScalingFactor()); //x stredu
    }
    
    protected void nastavY() {
        //souradniceY=(int)((150+(cislo<=5?cislo:cislo-5)*10)*Math.sin(Math.toRadians((getPozice()+5)*9 + (cislo<=5 ? 2 : 7)))) + 345;
        souradniceY=(int)(((int)(150*RozmeryPlochy.getScalingFactor())+(cislo<=5?cislo:cislo-5)*(int)(10*RozmeryPlochy.getScalingFactor())) //polomer
                * Math.sin(Math.toRadians((getPozice()+5)*9 //uhel
                + (cislo<=5 ? (int)(2*RozmeryPlochy.getScalingFactor()) : (int)(7*RozmeryPlochy.getScalingFactor()))))) //dorovnani uhlu podle pozice
                + (int)(345*RozmeryPlochy.getScalingFactor()); //x stredu
    }
    
    public void zmenBarvu(Barva barva) {
        this.barva=barva;
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
        this.pozice=i;
    }

    public int getSouradniceX() {
        return souradniceX;
    }

    public int getSouradniceY() {
        return souradniceY;
    }
    
}
