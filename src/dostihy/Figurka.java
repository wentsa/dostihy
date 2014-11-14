/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dostihy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author wentsa
 */
public class Figurka extends JLabel {
        
    protected Color barva; //bila cerna cervena fialova modra oranzova tyrkysova zelena zluta
    protected int pozice;
    private final int cislo;
    ImageIcon obrazek;

    public Figurka(Color barva, int cislo) {
        this.barva = barva;
        this.pozice=0;
        this.cislo=cislo;
        nactiObrazek();
        
    }
    private void nactiObrazek() {
        String file=new String("/fig/");
        if(barva==Color.BLACK) {        file=file.concat("black");}
        else if(barva==Color.BLUE) {    file=file.concat("blue");}
        else if(barva==Color.CYAN) {    file=file.concat("cyan");}
        else if(barva==Color.GREEN) {   file=file.concat("green");}
        else if(barva==Color.MAGENTA) { file=file.concat("magenta");}
        else if(barva==Color.ORANGE) {  file=file.concat("orange");}
        else if(barva==Color.RED) {     file=file.concat("red");}
        else if(barva==Color.WHITE) {   file=file.concat("white");}
        else if(barva==Color.YELLOW) {  file=file.concat("yellow");}
        else {
            throw new IllegalArgumentException("Spatna barva");
        }
        file=file.concat(".png");
        obrazek=new ImageIcon(Figurka.class.getResource(file));
        setIcon(obrazek);
    }
    public void zmenB(Color barva) {
        this.barva=barva;
        nactiObrazek();
    }

    /**
     * @return the barva
     */
    public Color getBarva() {
        return barva;
    }

    public void popojdi(int kolik) {
        setPozice((pozice+kolik)%40);
        if(pozice<0) {
            setPozice(pozice + 40);
        }
        repaint();
    }

    /**
     * @return the pozice
     */
    public int getPozice() {
        return pozice;
    }

       
    private int souradniceX() {
        return (int)((150+(cislo<=5?cislo:cislo-5)*10)*Math.cos(Math.toRadians((pozice+5)*9 + (cislo<=5 ? 2 : 7)))) + 340;
    }
    
    private int souradniceY() {
        return (int)((150+(cislo<=5?cislo:cislo-5)*10)*Math.sin(Math.toRadians((pozice+5)*9 + (cislo<=5 ? 2 : 7)))) + 345;
    }
    
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        setLocation(souradniceX(), souradniceY());
    }

    /**
     * @param pozice the pozice to set
     */
    public void setPozice(int pozice) {
        this.pozice = pozice;
    }

    
    
    
}
