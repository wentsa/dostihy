/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty.nahoda;

import hra.Hra;
import hra.Hrac;
import java.io.Serializable;

/**
 *
 * @author wentsa
 */
public class NahodaPopojdi extends Nahoda implements Serializable {
    private static final long serialVersionUID = 1L;

    private final boolean dostatBonus;
    private final boolean presnyPocet;
    private final boolean dopredu;
    private final int kolik;
    private final String kam;

    public NahodaPopojdi(String popis, boolean dostatBonus, boolean dopredu, int kolik) {
        super(popis);
        this.dostatBonus = dostatBonus;
        this.dopredu = dopredu;
        this.kolik = kolik;
        this.presnyPocet = true;
        this.kam=null;
    }

    public NahodaPopojdi(String popis, boolean dostatBonus, boolean dopredu, String kam) {
        super(popis);
        this.dostatBonus = dostatBonus;
        this.dopredu = dopredu;
        this.kam = kam;
        this.presnyPocet = false;
        kolik=0;
    }

    @Override
    public void proved(Hrac h) {
        int pozicePred = h.getFigurka().getPozice();
        if (presnyPocet) {
            h.popojdi(dopredu ? kolik : -kolik);
        } else {
            Hra.getInstance().popojdiNa(h, kam, dopredu);
        }
        int pozicePo = h.getFigurka().getPozice();
        if (dopredu && dostatBonus && pozicePred > pozicePo) {
            h.pricti(4000);
        } else if (!dopredu && dostatBonus && (pozicePred < pozicePo || pozicePo==0)) {
            h.pricti(4000);
        }
        
    }

}

