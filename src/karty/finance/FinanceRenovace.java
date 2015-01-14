/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty.finance;

import hra.Hra;
import hra.Hrac;
import java.io.Serializable;
import karty.vlastnicke.Kun;
import karty.vlastnicke.VlastnickaKarta;

/**
 *
 * @author wentsa
 */
public class FinanceRenovace extends Finance implements Serializable { // Renovujes vsechny staje, za kazdy...

    public FinanceRenovace(String popis, int castka) {
        super(popis, castka);
    }

    @Override
    public void proved(Hrac h) {
        int res=0;
        if(super.getCastka()==500) {
            for (VlastnickaKarta k : h.getKarty()) {
                if(k instanceof Kun) {
                    Kun tmp=(Kun) k;
                    res+=tmp.getPocetDostihu()*500;
                }
            }
        }
        else { // 800 + 2300
            for (VlastnickaKarta k : h.getKarty()) {
                if(k instanceof Kun) {
                    Kun tmp=(Kun) k;
                    if(tmp.getPocetDostihu()==5) {
                        res+=2300;
                    }
                    else {
                        res+=tmp.getPocetDostihu()*500;
                    }
                }
            }
        }
        h.pricti(-res);
    }
    
    
    
}
