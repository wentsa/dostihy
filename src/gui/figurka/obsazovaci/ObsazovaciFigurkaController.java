/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.figurka.obsazovaci;

import pomocne.Barva;
import java.io.Serializable;
import javax.swing.SwingUtilities;

/**
 *
 * @author wentsa
 */
public class ObsazovaciFigurkaController implements Serializable {

    private final ObsazovaciFigurkaModel model;
    private final ObsazovaciFigurkaView view;
    
    public ObsazovaciFigurkaController(Barva barva, int pozice, int cislo) {
        model=new ObsazovaciFigurkaModel(barva,pozice, cislo);
        view=new ObsazovaciFigurkaView(this);
        view.setIcon(model.getObr());
    }
    
    public void zmenBarvu(Barva barva) {
        System.out.println("menim barvu na " + barva);
        model.zmenBarvu(barva);
        view.setIcon(model.getObr());
    }
    
    public void setObsazeno(boolean obsazeno) {
        model.setObsazeno(obsazeno);
        System.out.println("  do view");
        view.setVisible(obsazeno);
        System.out.println("hotovo" + getSouradniceX() + ", " + getSouradniceY() + SwingUtilities.isEventDispatchThread());
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
