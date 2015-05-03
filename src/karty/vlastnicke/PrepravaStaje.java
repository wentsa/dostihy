/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty.vlastnicke;

import java.io.Serializable;
import java.util.Objects;
import java.util.ResourceBundle;
import pomocne.Konstanty;

/**
 *
 * @author wentsa
 */
public class PrepravaStaje extends VlastnickaKarta implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final ResourceBundle bundle = ResourceBundle.getBundle("languages/game/Cards", Konstanty.DEFAULT_LOCALE);

    private final String popis;

    public PrepravaStaje(int pozice, int porizovaciCena, String jmeno) {
        super(pozice, porizovaciCena, jmeno);
        this.popis = bundle.getString("TRANSPORT_STABLE_INFO");
    }

    /**
     * @return the jmeno
     */
    @Override
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
