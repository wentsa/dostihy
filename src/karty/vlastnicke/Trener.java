/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty.vlastnicke;

import java.io.Serializable;
import pomocne.RBHandler;

/**
 *
 * @author wentsa
 */
public class Trener extends VlastnickaKarta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    final private int cislo;

    public Trener(int pozice, int cislo) {
        super(pozice, 4000, RBHandler.getInstance().getRBString("trainer") + " " + cislo);
        this.cislo = cislo;
    }
    
    

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.cislo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trener other = (Trener) obj;
        return this.cislo == other.getCislo();
    }
    

    /**
     * @return the cislo
     */
    public int getCislo() {
        return cislo;
    }
    
    
    
}

