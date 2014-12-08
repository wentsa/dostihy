/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty.nahoda;

import dostihy.Control;
import dostihy.Hra;
import dostihy.Hrac;
import java.io.Serializable;

/**
 *
 * @author wentsa
 */
public class NahodaPopojdi extends Nahoda implements Serializable {

    boolean dostatBonus;
    boolean presnyPocet;
    boolean dopredu;
    int kolik;
    String kam;

    public NahodaPopojdi(String popis, boolean dostatBonus, boolean dopredu, int kolik) {
        super(popis);
        this.dostatBonus = dostatBonus;
        this.dopredu = dopredu;
        this.kolik = kolik;
        this.presnyPocet = true;
    }

    public NahodaPopojdi(String popis, boolean dostatBonus, boolean dopredu, String kam) {
        super(popis);
        this.dostatBonus = dostatBonus;
        this.dopredu = dopredu;
        this.kam = kam;
        this.presnyPocet = false;
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

