/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.jmenovka;

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
    private final Hrac hrac;
    private final int souradniceY;
    private final Puntik puntik;
    private boolean aktivni=true;
    private int poradi;
    
    protected JmenovkaModel(Hrac hrac, Barva barva) {
        this.hrac=hrac;
        this.souradniceY=souradnice()-13;
        this.puntik=new Puntik(barva, this.souradniceY);
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
                System.out.println(kun.getPocetDostihu());
                text=text + " - " + tmp;
            }
            text=text + "</td><td>" + k.getPorizovaciCena() + ",-</td></tr><br>";
        }
        if(hrac.getKarty().isEmpty()) {
            text=text+"<i>--prázdné--</i><br>";
        }
        
        text=text+"</table></html>";
        return text;
    }
}
