/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty.finance;

import dostihy.Control;
import dostihy.Hrac;
import java.io.Serializable;
import pomocne.VyberciDani;

/**
 *
 * @author wentsa
 */
public class FinanceDarek extends Finance implements Serializable { // od kazdeho vyber 200

    public FinanceDarek(String popis, int castka) {
        super(popis, castka);
    }

    @Override
    public void proved(Hrac h) {
        VyberciDani vyberci=new VyberciDani();
        for (Hrac hrac : Control.hra.getHraci()) {
            if(!hrac.equals(h)) {
                vyberci.navstiv(hrac);
            }
        }
        h.pricti(vyberci.getVybrano());
    }

   
    
    
}
