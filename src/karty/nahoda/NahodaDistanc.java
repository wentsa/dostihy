/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty.nahoda;

import hra.Hrac;
import java.io.Serializable;

/**
 *
 * @author wentsa
 */
public class NahodaDistanc extends Nahoda implements Serializable {

    public NahodaDistanc(String popis) {
        super(popis);
    }

    @Override
    public void proved(Hrac h) {
        h.setNahodaDistanc(true);
    }
    
}
