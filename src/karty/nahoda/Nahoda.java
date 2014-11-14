/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty.nahoda;

import dostihy.Hra;
import dostihy.Hrac;
import karty.Karta;

/**
 *
 * @author wentsa
 */
public abstract class Nahoda extends Karta {

    private final String popis;

    public Nahoda(String popis) {
        this.popis = popis;
    }
    
    
    
    public abstract void proved(Hrac h, Hra hra);

    @Override
    public String toString() {
        return getPopis();
    }

    /**
     * @return the popis
     */
    public String getPopis() {
        return popis;
    }

    
    
}
