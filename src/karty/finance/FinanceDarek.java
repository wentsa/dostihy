/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty.finance;

import hra.Hra;
import hra.Hrac;
import java.io.Serializable;
import pomocne.VyberciPoplatku;

/**
 *
 * @author wentsa
 */
public class FinanceDarek extends Finance implements Serializable { 
    private static final long serialVersionUID = 1L;

    public FinanceDarek(String popis, int castka) {
        super(popis, castka);
    }

    @Override
    public void proved(Hrac h) {
        VyberciPoplatku vyberci=new VyberciPoplatku();
        for (Hrac hrac : Hra.getInstance().getHraci()) {
            if(!hrac.equals(h) && hrac.isAktivni()) {
                vyberci.navstiv(hrac);
            }
        }
        h.pricti(vyberci.getVybrano());
    }

   
    
    
}
