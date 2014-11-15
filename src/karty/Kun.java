/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty;

import dostihy.Staj;
import gui.Dostih;
import gui.Dostihy;
import gui.HlavniDostih;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author wentsa
 */
public class Kun extends VlastnickaKarta {

    private final String jmeno;
    private final Staj staj;
    private final int prohlidkaStaje;
    private final int dostih1;
    private final int dostih2;
    private final int dostih3;
    private final int dostih4;
    private final int hlDostih;
    private final int pripravaDostihu;
    private final int pripravaHlavnihoDostihu;
    private int pocetDostihu;
    private final List<Dostihy> dostihy;

    public Kun(int pozice, String jmeno, int porizovaciCena, Staj staj, int prohlidkaStaje, int dostih1, int dostih2, int dostih3, int dostih4, int hlDostih, int pripravaDostihu, int pripravaHlavnihoDostihu) {
        super(pozice, porizovaciCena);
        this.jmeno = jmeno;
        this.staj = staj;
        this.prohlidkaStaje = prohlidkaStaje;
        this.dostih1 = dostih1;
        this.dostih2 = dostih2;
        this.dostih3 = dostih3;
        this.dostih4 = dostih4;
        this.hlDostih = hlDostih;
        this.pripravaDostihu = pripravaDostihu;
        this.pripravaHlavnihoDostihu = pripravaHlavnihoDostihu;
        this.pocetDostihu=0;
        this.dostihy=new ArrayList<>(5);
        dostihy.add(new Dostih(pozice-1, 0));
        dostihy.add(new Dostih(pozice-1, 1));
        dostihy.add(new Dostih(pozice-1, 2));
        dostihy.add(new Dostih(pozice-1, 3));
        dostihy.add(new HlavniDostih(pozice-1));
    }
    
    
    
    
    @Override
    public String toString() {
        return jmeno;
    }

    /**
     * @return the jmeno
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * @return the staj
     */
    public Staj getStaj() {
        return staj;
    }

    /**
     * @return the prohlidkaStaje
     */
    public int getProhlidkaStaje() {
        return prohlidkaStaje;
    }

    /**
     * @return the dostih1
     */
    public int getDostih1() {
        return dostih1;
    }

    /**
     * @return the dostih2
     */
    public int getDostih2() {
        return dostih2;
    }

    /**
     * @return the dostih3
     */
    public int getDostih3() {
        return dostih3;
    }

    /**
     * @return the dostih4
     */
    public int getDostih4() {
        return dostih4;
    }

    /**
     * @return the hlDostih
     */
    public int getHlDostih() {
        return hlDostih;
    }

    /**
     * @return the pripravaDostihu
     */
    public int getPripravaDostihu() {
        return pripravaDostihu;
    }

    /**
     * @return the pripravaHlavnihoDostihu
     */
    public int getPripravaHlavnihoDostihu() {
        return pripravaHlavnihoDostihu;
    }

    /**
     * @return the pocetDostihu
     */
    public int getPocetDostihu() {
        return pocetDostihu;
    }

    /**
     * @param pocetDostihu the pocetDostihu to set
     */
    public void pridejDostih() {
        this.pocetDostihu++;
        dostihy.get(pocetDostihu-1).setVisible(true);
        if(pocetDostihu==5) {
            for(int i=0;i<4;i++) {
                dostihy.get(i).setVisible(false);
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.jmeno);
        hash = 79 * hash + this.prohlidkaStaje;
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
        final Kun other = (Kun) obj;
        if (!Objects.equals(this.jmeno, other.jmeno)) {
            return false;
        }
        if (this.prohlidkaStaje != other.prohlidkaStaje) {
            return false;
        }
        return true;
    }

    /**
     * @return the dostihy
     */
    public List<Dostihy> getDostihy() {
        return dostihy;
    }
    
    
    
}
