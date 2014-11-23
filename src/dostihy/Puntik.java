/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dostihy;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 *
 * @author wentsa
 */
public class Puntik extends Figurka implements Serializable {

    int souradniceY;
    public Puntik(Barva barva, int cislo, int y) {
        super(barva, cislo);
        this.souradniceY=y+8;
    }
    
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        setLocation(50, souradniceY);
    }
    
    
}
