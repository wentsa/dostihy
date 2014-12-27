/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.figurka;

import java.awt.PopupMenu;
import pomocne.Barva;

/**
 *
 * @author wentsa
 */
public class FigurkaController {
    private final FigurkaModel model;
    private final FigurkaView view;
    
    public FigurkaController(Barva barva, int cislo) {
        model=new FigurkaModel(barva, cislo);
        view=new FigurkaView(this);
        view.setIcon(model.getObrazek());
    }
    public void zmenBarvu(Barva barva) {
        model.zmenBarvu(barva);
        
    }
    public Barva getBarva() {
        return model.getBarva();
    }
    public void popojdi(int kolik) {
        model.setPozice((model.getPozice()+kolik)%40);
        if(model.getPozice()<0) {
            model.setPozice(model.getPozice() + 40);
        }
        model.nastavSouradnice();
        view.repaint();
    }
    public int getPozice() {
        return model.getPozice();
    }
    protected int getSouradniceX() {
        return model.getSouradniceX();
    }
    protected int getSouradniceY() {
        return model.getSouradniceY();
    }

    public void setVisible(boolean b) {
        view.setVisible(b);
    }

    public FigurkaView getView() {
        return view;
    }
}
