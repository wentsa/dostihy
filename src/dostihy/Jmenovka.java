/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dostihy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author wentsa
 */
public class Jmenovka extends JLabel implements Serializable {
    private final String jmeno;
    private int castka;
    private final int pozice;
    private final int souradniceY;
    private final Puntik puntik;

    public Jmenovka(String jmeno, int castka, int pozice, Barva barva) {
        super("<html><table width=345><tr><td>" + jmeno.toUpperCase() + "</td><td align=right>" + castka + "</td></tr></table></html>");
        this.castka = castka;
        this.pozice = pozice;
        this.jmeno=jmeno;
        this.souradniceY=souradnice()-13;
        this.puntik=new Puntik(barva, pozice, this.souradniceY);
        setForeground(new Color(35, 35, 35));
        //setBackground(Color.BLUE);
        setFont(new Font("Ubuntu Mono Regular", Font.BOLD, 16));
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
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setText("<html><table width=345><tr><td>" + this.jmeno.toUpperCase() + "</td><td align=right>" + castka + "</td></tr></table></html>");
        setLocation(70, souradniceY);
    }

    /**
     * @return the puntik
     */
    public Puntik getPuntik() {
        return puntik;
    }
    
    public void aktualizujCastku(int castka) {
        this.castka=castka;
    }

    
    
    
}
