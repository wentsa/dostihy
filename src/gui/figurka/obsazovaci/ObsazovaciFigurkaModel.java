/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.figurka.obsazovaci;

import gui.figurka.FigurkaModel;
import java.io.Serializable;
import javax.swing.ImageIcon;
import pomocne.Barva;

/**
 *
 * @author wentsa
 */
public class ObsazovaciFigurkaModel extends FigurkaModel implements Serializable {
    private static final long serialVersionUID = 2L;

    
    public ObsazovaciFigurkaModel(Barva barva, int pozice, int cislo) {
        super(barva, cislo);
        super.pozice=pozice;
        super.nastavSouradnice();
    }
    
    @Override
    protected void nastavX() {
        super.souradniceX=(int)(280*Math.cos(Math.toRadians((getPozice()+5)*9+5))) + 339;
    }
    
    @Override
    protected void nastavY() {
        super.souradniceY=(int)(280*Math.sin(Math.toRadians((getPozice()+5)*9+5))) + 342;
    }

    protected ImageIcon getObr() {
        return super.getObrazek();
    }
    
}
