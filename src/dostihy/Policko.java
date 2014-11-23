/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dostihy;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JButton;
import karty.VlastnickaKarta;

/**
 *
 * @author wentsa
 */
public class Policko extends JButton implements Serializable {

    private final int cislo;
    private final String nazev;
    private boolean vlastnicka;
    private boolean obsazeno;
    private Hrac majitel;
    private final VlastnickaKarta karta;
    private ObsazovaciFigurka obsazFigurka;

    public Policko(int cislo, String nazev, VlastnickaKarta karta) {
        this.obsazeno = false;
        this.majitel = null;
        this.karta = karta;
        this.nazev=nazev;
        this.vlastnicka=true;
        this.cislo=cislo-1;
        this.obsazFigurka=new ObsazovaciFigurka(Barva.RED, cislo-1, 0);
    }

    public Policko(int cislo, String nazev) {
        this.obsazeno = false;
        this.majitel = null;
        this.karta = null;
        this.nazev=nazev;
        this.vlastnicka=false;
        this.cislo=cislo-1;
        this.obsazFigurka=new ObsazovaciFigurka(Barva.RED, cislo-1, 0);
    }

    @Override
    public String toString() {
        return "Policko{" + "nazev=" + getNazev() + ", karta=" + getKarta() + '}';
    }

    /**
     * @return the nazev
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * @return the vlastnik
     */
    public boolean isVlastnicka() {
        return vlastnicka;
    }

    /**
     * @return the obsazeno
     */
    public boolean isObsazeno() {
        return obsazeno;
    }

    /**
     * @param obsazeno the obsazeno to set
     */
    public void setObsazeno(boolean obsazeno) {
        this.obsazeno = obsazeno;
    }

    /**
     * @return the majitel
     */
    public Hrac getMajitel() {
        return majitel;
    }

    /**
     * @param majitel the majitel to set
     */
    public void setMajitel(Hrac majitel) {
        this.majitel = majitel;
    }

    /**
     * @return the karta
     */
    public VlastnickaKarta getKarta() {
        return karta;
    }

    public int souradniceX() {
        return (int)(255*Math.cos(Math.toRadians((cislo+5)*9 + 4.5))) + 330;
    }
    
    public int souradniceY() {
        return (int)(255*Math.sin(Math.toRadians((cislo+5)*9 + 4.5))) + 330;
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        setBounds(souradniceX(), souradniceY(), 40, 40);
    }

    /**
     * @return the obsazFigurka
     */
    public ObsazovaciFigurka getObsazFigurka() {
        return obsazFigurka;
    }

     
    
    
    

}
