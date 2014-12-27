/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.jmenovka;

import gui.Puntik;
import pomocne.Barva;

/**
 *
 * @author wentsa
 */
public class JmenovkaModel {
    private final String jmeno;
    private int castka;
    private final int pozice;
    private final int souradniceY;
    private final Puntik puntik;
    private boolean aktivni=true;
    private int poradi;
    
    protected JmenovkaModel(int castka, int pozice, String jmeno, Barva barva) {
        this.castka = castka;
        this.pozice = pozice;
        this.jmeno=jmeno;
        this.souradniceY=souradnice()-13;
        this.puntik=new Puntik(barva, this.souradniceY);
    }

    protected String getJmeno() {
        return jmeno;
    }

    protected int getCastka() {
        return castka;
    }

    protected void setPoradi(int poradi) {
        this.poradi=poradi;
        this.aktivni=false;
    }

    protected void aktualizujCastku(int castka) {
        this.castka=castka;
    }

    protected Puntik getPuntik() {
        return puntik;
    }
    
    private int souradnice() {
        switch(pozice) {
            case(1):{return 58;}
            case(2):{return 126;}
            case(3):{return 215;}
            case(4):{return 270;}
            case(5):{return 326;}
            case(6):{return 410;}
            case(7):{return 468;}
        }
    return 0;
    }

    protected int getSouradniceY() {
        return souradniceY;
    }

    protected boolean isAktivni() {
        return aktivni;
    }

    protected int getPoradi() {
        return poradi;
    }
}
