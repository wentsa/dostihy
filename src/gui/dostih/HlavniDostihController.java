/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dostih;

import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author wentsa
 */
public class HlavniDostihController implements Serializable {

    private final DostihyModel model;
    private final DostihyView view;

    public HlavniDostihController(int pozice) {
        model = new DostihyModel(pozice, new ImageIcon(HlavniDostihController.class.getResource("/dostih2.png")), pozice);

        model.souradniceX = (int) (310 * Math.cos(Math.toRadians((pozice + 5) * 9 + 5))) + 338;

        model.souradniceY = (int) (310 * Math.sin(Math.toRadians((pozice + 5) * 9 + 5))) + 343;

        view = new DostihyView(this);
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
