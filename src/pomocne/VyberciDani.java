/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocne;

import dostihy.Hrac;

/**
 *
 * @author wentsa
 */
public class VyberciDani extends Navstevnik {
    
    private int vybrano;
    
    public VyberciDani() {
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
