/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty.finance;

import hra.Hrac;
import java.io.Serializable;
import karty.Karta;

/**
 *
 * @author wentsa
 */
public abstract class Finance extends Karta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final String popis;
    private final int castka;

    public Finance(String popis, int castka) {
        this.popis = popis;
        this.castka = castka;
    }

    
    
    public abstract void proved(Hrac h);

    @Override
    public String toString() {
        return popis;
    }
    
    
    
    
    

    
    
    

    /**
     * @return the popis
     */
    public String getPopis() {
        return popis;
    }

    /**
     * @return the castka
     */
    public int getCastka() {
        return castka;
    }
    
}
