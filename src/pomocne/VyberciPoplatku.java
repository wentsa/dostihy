/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocne;

import hra.Hrac;
import java.io.Serializable;

/**
 *
 * @author wentsa
 */
public class VyberciPoplatku extends Navstevnik implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int vybrano;
    
    public VyberciPoplatku() {
        this.vybrano=0;
    }

    @Override
    public void navstiv(Hrac h) {
        h.pricti(-200);
        vybrano+=200;
    }

    /**
     * @return the vybrano
     */
    public int getVybrano() {
        return vybrano;
    }
    
    
    
}
