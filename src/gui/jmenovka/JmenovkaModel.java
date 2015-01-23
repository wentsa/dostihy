/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.jmenovka;

import grafika.RozmeryPlochy;
import gui.Puntik;
import hra.Hrac;
import java.io.Serializable;
import karty.vlastnicke.Kun;
import karty.vlastnicke.VlastnickaKarta;
import pomocne.Barva;

/**
 *
 * @author wentsa
 */
public class JmenovkaModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Hrac hrac;
    private int souradniceY;
    private final Puntik puntik;
    private boolean aktivni=true;
    private int poradi;
    
    protected JmenovkaModel(Hrac hrac, Barva barva) {
        this.hrac=hrac;
        this.puntik=new Puntik(barva);
        nactiSouradnice();
    }

    protected void nactiSouradnice() {
        this.souradniceY=souradnice()-(int)(13*RozmeryPlochy.getScalingFactor());
        this.puntik.nacti(souradniceY);
    }

    protected String getJmeno() {
        return hrac.getJmeno();
    }

    protected int getCastka() {
        return hrac.getRozpocet();
    }

    protected void setPoradi(int poradi) {
        this.poradi=poradi;
        this.aktivni=false;
    }

    protected Puntik getPuntik() {
        return puntik;
    }
    
    private int souradnice() {
        switch(hrac.getCislo()) {
            case(1):{return (int)(58*RozmeryPlochy.getScalingFactor());}
            case(2):{return (int)(126*RozmeryPlochy.getScalingFactor());}
            case(3):{return (int)(215*RozmeryPlochy.getScalingFactor());}
            case(4):{return (int)(270*RozmeryPlochy.getScalingFactor());}
            case(5):{return (int)(326*RozmeryPlochy.getScalingFactor());}
            case(6):{return (int)(410*RozmeryPlochy.getScalingFactor());}
            case(7):{return (int)(468*RozmeryPlochy.getScalingFactor());}
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

    protected String getToolTipText() {
        String text="<html><b><i>Inventář</i></b><br><br><table>";
        if(hrac.getZdrzeni()>0) {
            text+="<tr><td>Zdržení: </td><td>" + hrac.getZdrzeni() + "</td></tr>";
        }
        for (VlastnickaKarta k: hrac.getKarty()) {
            text=text + "<tr><td>" + k.getJmeno() + "</td><td>";
            if(k instanceof Kun) {
                Kun kun=(Kun)k;
                String tmp="";
                switch(kun.getPocetDostihu()) {
                    case 0: break;
                    case 1: {tmp="1 dostih";} break;
                    case 2: {tmp="2 dostihy";} break;
                    case 3: {tmp="3 dostihy";} break;
                    case 4: {tmp="4 dostihy";} break;
                    case 5: {tmp="hlavní dostih";} break;
                }
                text=text + " - " + tmp;
            }
            text=text + "</td><td>" + k.getPorizovaciCena() + ",-</td></tr><br>";
        }
        if(hrac.getKarty().isEmpty()) {
            text += "<i>--prázdné--</i><br>";
        }
        
        text += "</table></html>";
        return text;
    }
}
