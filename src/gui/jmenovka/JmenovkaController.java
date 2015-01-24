/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.jmenovka;

import grafika.GraphicsHandler;
import grafika.RozmeryPlochy;
import gui.Puntik;
import hra.Hrac;
import java.awt.Font;
import pomocne.Barva;
import java.io.Serializable;

/**
 *
 * @author wentsa
 */
public class JmenovkaController implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final JmenovkaModel model;
    private final JmenovkaView view;

    public JmenovkaController(Hrac hrac, Barva barva) {
        model=new JmenovkaModel(hrac, barva);
        view = new JmenovkaView(this);
        view.setToolTipText(model.getToolTipText());
    }
    
    public Puntik getPuntik() {
        return model.getPuntik();
    }
    
    public void nactiSouradnice() {
        model.nactiSouradnice();
        view.setFont(new Font("Ubuntu Mono Regular", Font.BOLD, (int)(16*RozmeryPlochy.getScalingFactor())));
        view.repaint();
    }
    
    public void aktualizujToolTip() {
        view.setToolTipText(model.getToolTipText());
        view.repaint();
    }
    public void setPoradi(int poradi) {
        model.setPoradi(poradi);
    }
    public void aktualizujFont() {
        view.setForeground(GraphicsHandler.getBarvaFontu());
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
