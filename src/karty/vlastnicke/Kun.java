/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty.vlastnicke;

import hra.Hrac;
import gui.dostih.DostihController;
import gui.dostih.HlavniDostihController;
import hra.Hra;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import pomocne.Staj;

/**
 *
 * @author wentsa
 */
public class Kun extends VlastnickaKarta implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Staj staj;
    private final int prohlidkaStaje;
    private final int cenaDostih1;
    private final int cenaDostih2;
    private final int cenaDostih3;
    private final int cenaDostih4;
    private final int cenaHlavnihoDostihu;
    private final int pripravaDostihu;
    private final int pripravaHlavnihoDostihu;
    private int pocetDostihu;
    private final List<DostihController> dostihy;
    private final HlavniDostihController hlavniDostih;
    private int sazka=0;

    public Kun(int pozice, String jmeno, int porizovaciCena, Staj staj, int prohlidkaStaje, int dostih1, int dostih2, int dostih3, int dostih4, int hlDostih, int pripravaDostihu, int pripravaHlavnihoDostihu) {
        super(pozice, porizovaciCena, jmeno);
        this.staj = staj;
        this.prohlidkaStaje = prohlidkaStaje;
        this.cenaDostih1 = dostih1;
        this.cenaDostih2 = dostih2;
        this.cenaDostih3 = dostih3;
        this.cenaDostih4 = dostih4;
        this.cenaHlavnihoDostihu = hlDostih;
        this.pripravaDostihu = pripravaDostihu;
        this.pripravaHlavnihoDostihu = pripravaHlavnihoDostihu;
        this.pocetDostihu = 0;
        this.dostihy = new ArrayList<>(4);
        dostihy.add(new DostihController(pozice - 1, 0));
        dostihy.add(new DostihController(pozice - 1, 1));
        dostihy.add(new DostihController(pozice - 1, 2));
        dostihy.add(new DostihController(pozice - 1, 3));
        hlavniDostih=new HlavniDostihController(pozice - 1);
    }

    @Override
    public String toString() {
        return jmeno;
    }

    /**
     * @return the jmeno
     */
    @Override
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
     * @return the cenaDostih1
     */
    public int getDostih1() {
        return cenaDostih1;
    }

    /**
     * @return the cenaDostih2
     */
    public int getDostih2() {
        return cenaDostih2;
    }

    /**
     * @return the cenaDostih3
     */
    public int getDostih3() {
        return cenaDostih3;
    }

    /**
     * @return the cenaDostih4
     */
    public int getDostih4() {
        return cenaDostih4;
    }

    /**
     * @return the cenaHlavnihoDostihu
     */
    public int getHlDostih() {
        return cenaHlavnihoDostihu;
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
     */
    public void pridejDostih() {
        this.pocetDostihu++;
        dostihy.get(Math.min(pocetDostihu - 1,3)).setVisible(true);
        if (pocetDostihu == 5) {
            for (int i = 0; i < 4; i++) {
                dostihy.get(i).setVisible(false);
            }
            hlavniDostih.setVisible(true);
        }
    }

    public void odeberDostih(Hrac hrac) {
        switch (pocetDostihu) {
            case 1: {
                hrac.pricti(pripravaDostihu / 2);
                dostihy.get(0).setVisible(false);
            }
            break;
            case 2: {
                hrac.pricti(pripravaDostihu / 2);
                dostihy.get(1).setVisible(false);
            }
            break;
            case 3: {
                hrac.pricti(pripravaDostihu / 2);
                dostihy.get(2).setVisible(false);
            }
            break;
            case 4: {
                hrac.pricti(pripravaDostihu / 2);
                dostihy.get(3).setVisible(false);
            }
            break;
            case 5: {
                hrac.pricti(pripravaHlavnihoDostihu / 2);
                for (int i = 0; i < 4; i++) {
                    dostihy.get(i).setVisible(true);
                }
                hlavniDostih.setVisible(false);
            }
            break;
        }
        this.pocetDostihu--;
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
        return this.prohlidkaStaje == other.getProhlidkaStaje();
    }

    /**
     * @return the dostihy
     */
    public List<DostihController> getDostihy() {
        return dostihy;
    }

    public void setPocetDostihu(int pocetDostihu) {
        this.pocetDostihu = pocetDostihu;
    }

    public HlavniDostihController getHlavniDostih() {
        return hlavniDostih;
    }
    
    public void vsad(int kolik) {
        if(sazka!=0) {
            Hra.getInstance().getAktualniHrac().pricti(sazka);
        }
        sazka=kolik;
    }
    
    public void vyplatSazku(Hrac komu) {
        getMajitel().pricti(-10*sazka);
        komu.pricti(10*sazka);
        sazka=0;
    }
    
    public void stornujSazku() {
        getMajitel().pricti(sazka);
        sazka=0;
    }
    
    public int getSazka() {
        return sazka;
    }

    public void aktualizujDostihy() {
        for (DostihController d : dostihy) {
            d.aktualizuj();
        }
        hlavniDostih.aktualizuj();
    }

}
