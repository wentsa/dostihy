/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hra;

import gui.jmenovka.JmenovkaController;
import gui.figurka.FigurkaController;
import pomocne.Barva;
import java.io.Serializable;
import static java.lang.Math.max;
import java.util.HashSet;
import karty.vlastnicke.VlastnickaKarta;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import karty.vlastnicke.Kun;
import karty.vlastnicke.PrepravaStaje;
import karty.vlastnicke.Trener;

/**
 *
 * @author wentsa
 */
public class Hrac implements Serializable {
    private static final long serialVersionUID = 1L;

    private int zdrzeni; // 0 muze hrat, jinak pocet kol kolik stoji
    private boolean distanc;
    private boolean nahodaDistanc;
    private final String jmeno;
    private int rozpocet;
    private Set<VlastnickaKarta> karty;
    protected final FigurkaController figurka;
    private final int cislo; //1-7
    private final JmenovkaController jmenovka;
    private int pocetTreneru;
    private int pocetPrepravaStaje;
    private boolean aktivni;
    private String cas;
    private int maxKaret;
    private int maxHotovost;

    public Hrac(String jmeno, Barva barva, int cislo) {
        this.jmeno = jmeno;
        this.rozpocet = 30000;
        this.karty = new HashSet<>();
        this.figurka = new FigurkaController(barva, cislo);
        this.zdrzeni = 0;
        this.distanc = false;
        this.cislo = cislo;
        this.jmenovka = new JmenovkaController(this, barva);
        this.pocetTreneru = 0;
        this.pocetPrepravaStaje = 0;
        this.aktivni=true;
        this.maxHotovost=30000;
        this.maxKaret=0;
        this.nahodaDistanc=false;
    }

    public void popojdi(int kolik) {
        if (kolik < 0) {
            kolik *= -1;
            for (int i = 0; i < kolik; i++) {
                this.figurka.popojdi(-1);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hrac.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            for (int i = 0; i < kolik; i++) {
                this.figurka.popojdi(1);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hrac.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void pricti(int castka) {
        rozpocet += castka;
        maxHotovost=max(maxHotovost,rozpocet);
        this.jmenovka.aktualizujToolTip();
    }

    /**
     * @return the jmeno
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * @return the karty
     */
    public Set<VlastnickaKarta> getKarty() {
        return karty;
    }

    /**
     * @param karty the karty to set
     */
    public void setKarty(Set<VlastnickaKarta> karty) {
        this.karty = karty;
    }

    /**
     * @return the figurka
     */
    public FigurkaController getFigurka() {
        return figurka;
    }

    /**
     * @return the volnaHra
     */
    public int getZdrzeni() {
        return zdrzeni;
    }

    public void setZdrzeni(int kolik) {
        zdrzeni = kolik;
    }

    public void snizZdrzeni() {
        this.zdrzeni--;
    }

    /**
     * @return the distanc
     */
    public boolean isDistanc() {
        return distanc;
    }

    /**
     * @param distanc the distanc to set
     */
    public void setDistanc(boolean distanc) {
        this.distanc = distanc;
        if (distanc) {
            popojdi(figurka.getPozice() <= 10 ? 10 - figurka.getPozice() : 50 - figurka.getPozice());
        }
    }

    /**
     * @return the jmenovka
     */
    public JmenovkaController getJmenovka() {
        return jmenovka;
    }

    public void pridejKartu(VlastnickaKarta karta) {
        this.karty.add(karta);
        karta.setMajitel(this);
        if (karta instanceof Trener) {
            this.pocetTreneru++;
        } else if (karta instanceof PrepravaStaje) {
            this.pocetPrepravaStaje++;
        }
        this.maxKaret=max(maxKaret,karty.size());
        this.jmenovka.aktualizujToolTip();
    }

    /**
     * @return the pocetTreneru
     */
    public int getPocetTreneru() {
        return pocetTreneru;
    }

    /**
     * @return the pocetPrepravaStaje
     */
    public int getPocetPrepravaStaje() {
        return pocetPrepravaStaje;
    }

    /**
     * @return the rozpocet
     */
    public int getRozpocet() {
        return rozpocet;
    }

    /**
     * @return the aktivni
     */
    public boolean isAktivni() {
        return aktivni;
    }

    void vyrad(int poradi) {
        this.setAktivni(false);
        this.figurka.setVisible(false);
        for (VlastnickaKarta k : karty) {
            if(k instanceof Kun) {
                Kun kun=(Kun) k;
                while(kun.getPocetDostihu()>0) {
                    kun.odeberDostih(this);
                }
            }
            k.setMajitel(null);
        }
        this.karty.clear();
        this.rozpocet=0;
        this.jmenovka.setPoradi(poradi);
        this.cas=Hra.getInstance().getCelkovyCas();
    }

    public String getCas() {
        return cas;
    }

    public int getMaxHotovost() {
        return maxHotovost;
    }

    public int getMaxKaret() {
        return maxKaret;
    }

    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }

    public int getCislo() {
        return cislo;
    }

    public boolean isNahodaDistanc() {
        return nahodaDistanc;
    }

    public void setNahodaDistanc(boolean nahodaDistanc) {
        this.nahodaDistanc = nahodaDistanc;
    }

   
}
