/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dostih;

import grafika.RozmeryPlochy;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author wentsa
 */
public class DostihController implements Serializable {
    private static final long serialVersionUID = 1L;

    private final DostihyModel model;
    private final DostihyView view;

    public DostihController(int pozice, int poradi) {
        model = new DostihyModel(pozice, false, poradi);
        view = new DostihyView(this);
    }

    protected int getSouradniceX() {
        if(model.getSouradniceX()==-1) {
            nactiX();
        }
        return model.getSouradniceX();
    }

    protected int getSouradniceY() {
        if(model.getSouradniceY()==-1) {
            nactiY();
        }
        return model.getSouradniceY();
    }
    
    private void nactiY() {
        model.setSouradniceY((int) ((RozmeryPlochy.getPlochaVyska()/2-(int)(43*RozmeryPlochy.getScalingFactor())) //polomer
                * Math.sin(Math.toRadians((model.pozice + 5) * 9 + (model.poradi * 2)))) //uhel
                + RozmeryPlochy.getPlochaVyska()/2 -(int)(6*RozmeryPlochy.getScalingFactor())); //y stredu
    }
    
    private void nactiX() {
        model.setSouradniceX((int) ((RozmeryPlochy.getPlochaSirka()/2-(int)(43*RozmeryPlochy.getScalingFactor())) //polomer
                * Math.cos(Math.toRadians((model.pozice + 5) * 9 + (model.poradi * 2)))) //uhel
                + RozmeryPlochy.getPlochaSirka()/2 -(int)(8*RozmeryPlochy.getScalingFactor())); //x stredu
    }
    
    
    protected ImageIcon getDostih() {
        return model.getDostih();
    }

    public DostihyView getView() {
        return view;
    }

    public void setVisible(boolean b) {
        view.setVisible(b);
        view.repaint();
    }

    public void aktualizuj() {
        nactiX();
        nactiY();
        view.setIcon(model.getDostih());
    }

}
