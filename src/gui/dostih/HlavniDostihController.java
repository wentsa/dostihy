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
public class HlavniDostihController implements Serializable {
    private static final long serialVersionUID = 1L;

    private final DostihyModel model;
    private final DostihyView view;

    public HlavniDostihController(int pozice) {
        model = new DostihyModel(pozice, true, pozice);

        nactiX();

        nactiY();

        view = new DostihyView(this);
    }

    private void nactiY() {
        model.setSouradniceY((int) ((int)(310*RozmeryPlochy.getScalingFactor())
                * Math.sin(Math.toRadians((model.pozice + 5) * 9 + 5))) 
                + (int)(343*RozmeryPlochy.getScalingFactor()));
    }

    private void nactiX() {
        model.setSouradniceX((int) ((int)(310*RozmeryPlochy.getScalingFactor())
                * Math.cos(Math.toRadians((model.pozice + 5) * 9 + 5))) 
                + (int)(338*RozmeryPlochy.getScalingFactor()));
    }
    
    public void aktualizuj() {
        nactiX();
        nactiY();
        view.setIcon(model.getDostih());
    }
    
    protected int getSouradniceX() {
        return model.getSouradniceX();
    }

    protected int getSouradniceY() {
        return model.getSouradniceY();
    }

    protected ImageIcon getDostih() {
        return model.getDostih();
    }

    public DostihyView getView() {
        return view;
    }

    public void setVisible(boolean b) {
        view.setVisible(b);
    }

}
