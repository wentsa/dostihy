/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dostih;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author wentsa
 */
public class DostihController {

    private final DostihyModel model;
    private final DostihyView view;

    public DostihController(int pozice, int poradi) {
        model = new DostihyModel(pozice, new ImageIcon(DostihController.class.getResource("/dostih.png")), poradi);

        model.souradniceX = (int) (308 * Math.cos(Math.toRadians((pozice + 5) * 9 + (poradi * 2)))) + 340;

        model.souradniceY = (int) (308 * Math.sin(Math.toRadians((pozice + 5) * 9 + (poradi * 2)))) + 345;

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
        view.repaint();
    }

}
