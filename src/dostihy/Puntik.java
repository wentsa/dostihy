/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dostihy;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author wentsa
 */
public class Puntik extends Figurka {

    int souradniceY;
    public Puntik(Color barva, int cislo, int y) {
        super(barva, cislo);
        this.souradniceY=y+8;
    }
    
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        setLocation(50, souradniceY);
    }
    
    
}
