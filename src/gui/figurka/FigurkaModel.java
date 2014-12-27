/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.figurka;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import pomocne.Barva;

/**
 *
 * @author wentsa
 */
public class FigurkaModel {
    private Barva barva; //bila cerna cervena fialova modra oranzova tyrkysova zelena zluta
    protected int pozice;
    private final int cislo;
    private ImageIcon obrazek;
    protected int souradniceX;
    protected int souradniceY;
    
    protected FigurkaModel(Barva barva, int cislo) {
        this.barva = barva;
        this.pozice=0;
        this.cislo=cislo;
        nastavSouradnice();
        nactiObrazek();
        
    }
    
    protected void nastavSouradnice() {
        nastavX();
        nastavY();
    }
    
    protected void nastavX() {
        souradniceX=(int)((150+(cislo<=5?cislo:cislo-5)*10)*Math.cos(Math.toRadians((pozice+5)*9 + (cislo<=5 ? 2 : 7)))) + 340;
    }
    
    protected void nastavY() {
        souradniceY=(int)((150+(cislo<=5?cislo:cislo-5)*10)*Math.sin(Math.toRadians((pozice+5)*9 + (cislo<=5 ? 2 : 7)))) + 345;
    }
    
    private void nactiObrazek() {
        String file="/fig/";
        if(barva==Barva.BLACK) {        file=file.concat("black");}
        else if(barva==Barva.BLUE) {    file=file.concat("blue");}
        else if(barva==Barva.CYAN) {    file=file.concat("cyan");}
        else if(barva==Barva.GREEN) {   file=file.concat("green");}
        else if(barva==Barva.MAGENTA) { file=file.concat("magenta");}
        else if(barva==Barva.ORANGE) {  file=file.concat("orange");}
        else if(barva==Barva.RED) {     file=file.concat("red");}
        else if(barva==Barva.WHITE) {   file=file.concat("white");}
        else if(barva==Barva.YELLOW) {  file=file.concat("yellow");}
        else {
            throw new IllegalArgumentException("Spatna barva");
        }
        file=file.concat(".png");
        obrazek=null;
        obrazek=new ImageIcon(FigurkaView.class.getResource(file));
        System.out.println("novy obrazek " + SwingUtilities.isEventDispatchThread());
    }

    public void zmenBarvu(Barva barva) {
        this.barva=barva;
        nactiObrazek();
    }

    protected ImageIcon getObrazek() {
        return obrazek;
    }

    protected Barva getBarva() {
        return barva;
    }

    protected int getPozice() {
        return pozice;
    }

    void setPozice(int i) {
        this.pozice=i;
    }

    public int getSouradniceX() {
        return souradniceX;
    }

    public int getSouradniceY() {
        return souradniceY;
    }
    
}
