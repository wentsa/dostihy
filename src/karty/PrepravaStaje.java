/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty;

import java.util.Objects;

/**
 *
 * @author wentsa
 */
public class PrepravaStaje extends VlastnickaKarta {
    
    private final String jmeno;
    private final String popis;

    public PrepravaStaje(int pozice, int porizovaciCena, String jmeno) {
        super(pozice, porizovaciCena);
        this.jmeno=jmeno;
        this.popis="Hráč, který se zastavil na poli Stáje nebo Přeprava, které patří některému ze soupeřů, zaplatí majiteli 80tinásobek hodu kostkou. Jestliže majitel vlastní obě karty, cena se zvyšuje na 200násobek.";
    }

    /**
     * @return the jmeno
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * @return the popis
     */
    public String getPopis() {
        return popis;
    }

    @Override
    public String toString() {
        return jmeno;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.jmeno);
        hash = 83 * hash + Objects.hashCode(this.popis);
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
        final PrepravaStaje other = (PrepravaStaje) obj;
        if (!Objects.equals(this.jmeno, other.jmeno)) {
            return false;
        }
        if (!Objects.equals(this.popis, other.popis)) {
            return false;
        }
        return true;
    }
    
    
    
}
