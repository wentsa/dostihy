/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty;

import dostihy.Hrac;

/**
 *
 * @author wentsa
 */
public abstract class VlastnickaKarta extends Karta {

    private final int porizovaciCena;
    private final int pozice;

    public VlastnickaKarta(int pozice, int porizovaciCena) {
        this.porizovaciCena = porizovaciCena;
        this.pozice=pozice-1;
    }

    /**
     * @return the porizovaciCena
     */
    public int getPorizovaciCena() {
        return porizovaciCena;
    }

    /**
     * @return the pozice
     */
    public int getPozice() {
        return pozice;
    }
    
    
    
    
}
