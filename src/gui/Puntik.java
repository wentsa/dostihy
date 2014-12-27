/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.figurka.FigurkaView;
import pomocne.Barva;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author wentsa
 */
public class Puntik extends JLabel implements Serializable {

    private final int souradniceY;
    private final Barva barva;
    private final ImageIcon obrazek;
    public Puntik(Barva barva, int y) {
        this.barva=barva;
        this.souradniceY=y+8;
        
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
        obrazek=new ImageIcon(FigurkaView.class.getResource(file));
        setIcon(obrazek);
    }
    
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        setLocation(50, souradniceY);
    }
    
    
    
    
}
