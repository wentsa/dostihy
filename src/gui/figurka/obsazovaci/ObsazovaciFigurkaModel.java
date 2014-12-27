/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.figurka.obsazovaci;

import gui.figurka.FigurkaModel;
import javax.swing.ImageIcon;
import pomocne.Barva;

/**
 *
 * @author wentsa
 */
public class ObsazovaciFigurkaModel extends FigurkaModel {

    private boolean obsazeno;
    
    public ObsazovaciFigurkaModel(Barva barva, int pozice, int cislo) {
        super(barva, cislo);
        System.out.println("obsazovaci je " + barva);
        super.pozice=pozice;
        super.nastavSouradnice();
        this.obsazeno=false;
    }
    
    @Override
    protected void nastavX() {
        super.souradniceX=(int)(280*Math.cos(Math.toRadians((pozice+5)*9+5))) + 339;
    }
    
    @Override
    protected void nastavY() {
        super.souradniceY=(int)(280*Math.sin(Math.toRadians((pozice+5)*9+5))) + 342;
    }

    void setObsazeno(boolean obsazeno) {
        this.obsazeno=obsazeno;
    }
    protected ImageIcon getObr() {
        return super.getObrazek();
    }
    
}
