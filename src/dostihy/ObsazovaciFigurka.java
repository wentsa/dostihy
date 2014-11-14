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
public class ObsazovaciFigurka extends Figurka {

    private boolean obsazeno;
    public ObsazovaciFigurka(Color barva, int pozice, int cislo) {
        super(barva, cislo);
        super.pozice=pozice;
        this.obsazeno=false;
        setVisible(false);
    }
    
    public void zmenBarvu(Color barva) {
        zmenB(barva);
        repaint();
    }
    
    private int souradniceX() {
        return (int)(280*Math.cos(Math.toRadians((pozice+5)*9+5))) + 339;
    }
    
    private int souradniceY() {
        return (int)(280*Math.sin(Math.toRadians((pozice+5)*9+5))) + 342;
    }
    
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        setLocation(souradniceX(), souradniceY());
    }

    /**
     * @param obsazeno the obsazeno to set
     */
    public void setObsazeno(boolean obsazeno) {
        this.obsazeno = obsazeno;
        if(obsazeno) setVisible(true);
        else setVisible(false);
    }
    
    
}
