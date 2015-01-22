/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty.finance;

import hra.Hrac;
import java.io.Serializable;

/**
 *
 * @author wentsa
 */
public class FinanceKlasika extends Finance implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final boolean platit;

    public FinanceKlasika(String popis, int castka,boolean platit) {
        super(popis, castka);
        this.platit=platit;
    }
    
    @Override
    public void proved(Hrac h) {
        if(platit) {
            h.pricti(-super.getCastka());
        }
        else {
            h.pricti(super.getCastka());
        }
    }

    
    
    
    
}
