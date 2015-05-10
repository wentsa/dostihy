/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.figurka;

import java.io.Serializable;
import pomocne.Barva;

/**
 *
 * @author wentsa
 */
public abstract class FigurkyController implements Serializable {

    protected final FigurkaModel model;
    protected final FigurkaView view;

    public FigurkyController(Barva barva, int pozice, int cislo, boolean visible) {
        model = new FigurkaModel(barva, pozice, cislo);
        view = new FigurkaView(this, visible);
        view.setIcon(model.getObrazek());
        nastavSouradnice();
    }

    protected final void nastavSouradnice() {
        nastavX();
        nastavY();
    }

    public FigurkaView getView() {
        return view;
    }

    protected int getSouradniceX() {
        return model.getSouradniceX();
    }

    protected int getSouradniceY() {
        return model.getSouradniceY();
    }

    public void setVisible(boolean obsazeno) {
        view.setVisible(obsazeno);
    }

    public void aktualizuj() {
        nastavSouradnice();
        view.setIcon(model.getObrazek());
        view.repaint();
    }

    public void zmenBarvu(Barva barva) {
        model.zmenBarvu(barva);
        view.setIcon(model.getObrazek());
    }

    protected abstract void nastavX();

    protected abstract void nastavY();
}
