/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.figurka.obsazovaci;

import pomocne.Barva;
import java.io.Serializable;

/**
 *
 * @author wentsa
 */
public class ObsazovaciFigurkaController implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ObsazovaciFigurkaModel model;
    private final ObsazovaciFigurkaView view;
    
    public ObsazovaciFigurkaController(Barva barva, int pozice, int cislo) {
        model=new ObsazovaciFigurkaModel(barva,pozice, cislo);
        view=new ObsazovaciFigurkaView(this);
        view.setIcon(model.getObr());
    }
    
    public void aktualizuj() {
        model.nastavX();
        model.nastavY();
        view.setIcon(model.getObr());
        view.repaint();
    }
    
    public void zmenBarvu(Barva barva) {
        model.zmenBarvu(barva);
        view.setIcon(model.getObr());
    }
    
    public void setObsazeno(boolean obsazeno) {
        view.setVisible(obsazeno);
    }
    protected int getSouradniceX() {
        return model.getSouradniceX();
    }
    protected int getSouradniceY() {
        return model.getSouradniceY();
    }

    public ObsazovaciFigurkaView getView() {
        return view;
    }
    
}
