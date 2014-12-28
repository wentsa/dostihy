/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.jmenovka;

import gui.Puntik;
import pomocne.Barva;
import java.io.Serializable;

/**
 *
 * @author wentsa
 */
public class JmenovkaController implements Serializable {
    
    private final JmenovkaModel model;
    private final JmenovkaView view;

    public JmenovkaController(String jmeno, int castka, int pozice, Barva barva) {
        model=new JmenovkaModel(castka, pozice, jmeno, barva);
        view = new JmenovkaView(this);
    }
    
    public Puntik getPuntik() {
        return model.getPuntik();
    }
    
    public void aktualizujCastku(int castka) {
        model.aktualizujCastku(castka);
        view.repaint();
    }
    public void setPoradi(int poradi) {
        model.setPoradi(poradi);
        
    }

    protected String getJmeno() {
        return model.getJmeno();
    }

    protected int getCastka() {
        return model.getCastka();
    }

    public int getSouradniceY() {
        return model.getSouradniceY();
    }

    protected boolean isAktivni() {
        return model.isAktivni();
    }

    protected int getPoradi() {
        return model.getPoradi();
    }

    public JmenovkaView getView() {
        return view;
    }
    

    
    
    
}
