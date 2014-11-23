/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty.nahoda;

import dostihy.Hra;
import dostihy.Hrac;
import java.io.Serializable;

/**
 *
 * @author wentsa
 */
public class NahodaZdrzeni extends Nahoda implements Serializable {
    int kolik;

    public NahodaZdrzeni(String popis, int kolik) {
        super(popis);
        this.kolik = kolik;
    }
    
    

    @Override
    public void proved(Hrac h) {
        h.setZdrzeni(h.getZdrzeni()+kolik);
    }
    
    
}
