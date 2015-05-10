/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dostih;

import javax.swing.ImageIcon;

/**
 *
 * @author wentsa
 */
public abstract class DostihyController {

    protected final DostihyModel model;
    protected final DostihyView view;

    /**
     * Konstruktor
     *
     * @param pozice cislo policka (0-39)
     * @param poradi poradi dostihu na konkretnim policku (0-3)
     * @param isHlavni priznak jestli je dostih hlavni
     */
    public DostihyController(int pozice, int poradi, boolean isHlavni) {
        model = new DostihyModel(pozice, isHlavni, poradi);
        view = new DostihyView(this);
    }

    /**
     * Vrati souradnice dostihu na ose x
     *
     * @return souradnice x
     */
    protected int getSouradniceX() {
        if (model.getSouradniceX() == -1) {
            nactiX();
        }
        return model.getSouradniceX();
    }

    /**
     * Vrati souradnice dostihu na ose y
     *
     * @return souradnice y
     */
    protected int getSouradniceY() {
        if (model.getSouradniceY() == -1) {
            nactiY();
        }
        return model.getSouradniceY();
    }

    protected ImageIcon getDostih() {
        return model.getDostih();
    }

    public DostihyView getView() {
        return view;
    }

    /**
     * Nastavi viditelnost
     *
     * @param visible viditelnost
     */
    public void setVisible(boolean visible) {
        view.setVisible(visible);
        view.repaint();
    }

    /**
     * Aktualizuje souradnice a ikonu
     */
    public void aktualizuj() {
        nactiX();
        nactiY();
        view.setIcon(model.getDostih());
    }

    /**
     * Nastavi v modelu souradnice x podle aktualni plochy
     */
    protected abstract void nactiX();

    /**
     * Nastavi v modelu souradnice y podle aktualni plochy
     */
    protected abstract void nactiY();
}
