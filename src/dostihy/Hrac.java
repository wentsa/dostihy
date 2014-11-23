/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dostihy;

import gui.ProdejGUI;
import java.awt.Color;
import java.io.Serializable;
import java.util.HashSet;
import karty.VlastnickaKarta;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import karty.PrepravaStaje;
import karty.Trener;

/**
 *
 * @author wentsa
 */
public class Hrac implements Serializable {
    
    private int zdrzeni; // 0 muze hrat, jinak pocet kol kolik stoji
    private boolean distanc;
    private final String jmeno;
    private int rozpocet;
    private Set<VlastnickaKarta> karty;
    protected final Figurka figurka;
    private final int cislo; //1-7
    private final Jmenovka jmenovka;
    private int pocetTreneru;
    private int pocetPrepravaStaje;

    public Hrac(String jmeno, Barva barva,int cislo) {
        this.jmeno = jmeno;
        this.rozpocet = 30000;
        this.karty = new HashSet<>();
        this.figurka=new Figurka(barva,cislo);
        this.zdrzeni=0;
        this.distanc=false;
        this.cislo=cislo;
        this.jmenovka=new Jmenovka(this.jmeno, this.getRozpocet(), this.cislo, barva);
        this.pocetTreneru=0;
        this.pocetPrepravaStaje=0;
    }
    

    public void popojdi(int kolik) {
        if(kolik<0) {
            kolik*=-1;
            for(int i=0;i<kolik;i++) {
                this.figurka.popojdi(-1);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hrac.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else {
            for(int i=0;i<kolik;i++) {
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
        rozpocet+=castka;
        this.jmenovka.aktualizujCastku(getRozpocet());
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
    public Figurka getFigurka() {
        return figurka;
    }

    /**
     * @return the volnaHra
     */
    public int getZdrzeni() {
        return zdrzeni;
    }
    public void setZdrzeni(int kolik) {
        zdrzeni=kolik;
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
        if(distanc) {
            popojdi(figurka.getPozice() <= 10 ? 10-figurka.getPozice() : 50-figurka.getPozice());
        }
    }

    /**
     * @return the jmenovka
     */
    public Jmenovka getJmenovka() {
        return jmenovka;
    }

    void pridejKartu(VlastnickaKarta karta) {
        this.karty.add(karta);
        if(karta instanceof Trener) {
            this.pocetTreneru++;
        }
        else if(karta instanceof PrepravaStaje) {
            this.pocetPrepravaStaje++;
        }
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

    public void prodej() throws InterruptedException {
        final ProdejGUI prodej=new ProdejGUI(this);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                prodej.setVisible(true);
            }
        });   
        while(!prodej.isProdal()) {Thread.sleep(1);}
    }

    /**
     * @return the rozpocet
     */
    public int getRozpocet() {
        return rozpocet;
    }
        
    
}
