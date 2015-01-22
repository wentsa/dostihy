/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dostih;

import java.io.Serializable;
import javax.swing.ImageIcon;
import pomocne.Konstanty;

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
            int stredX=Konstanty.sirkaPlochy/2;
            model.setSouradniceX((int) ((Konstanty.sirkaPlochy/2-50+7) * Math.cos(Math.toRadians((model.pozice + 5) * 9 + (model.poradi * 2)))) + stredX -6);
        }
        return model.getSouradniceX();
    }

    protected int getSouradniceY() {
        if(model.getSouradniceY()==-1) {
            int stredY=Konstanty.vyskaPlochy/2;
            model.setSouradniceY((int) ((Konstanty.vyskaPlochy/2-50+7) * Math.sin(Math.toRadians((model.pozice + 5) * 9 + (model.poradi * 2)))) + stredY -6);
        }
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
        view.repaint();
    }

}
