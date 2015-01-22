/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty.vlastnicke;

import hra.Hrac;
import java.io.Serializable;
import karty.Karta;

/**
 *
 * @author wentsa
 */
public abstract class VlastnickaKarta extends Karta implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int porizovaciCena;
    private final int pozice;
    protected final String jmeno;
    private Hrac majitel;

    public VlastnickaKarta(int pozice, int porizovaciCena, String jmeno) {
        this.porizovaciCena = porizovaciCena;
        this.pozice=pozice-1;
        this.jmeno=jmeno;
        this.majitel=null;
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

    public String getJmeno() {
        return jmeno;
    }

    public Hrac getMajitel() {
        return majitel;
    }

    public void setMajitel(Hrac majitel) {
        this.majitel = majitel;
    }
    
    
    
    
}
