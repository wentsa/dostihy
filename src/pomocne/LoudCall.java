/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocne;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wentsa
 * @param <T>
 * @param <S>
 */
public abstract class LoudCall<T, S> implements Callable<T>, Serializable {
    private static final long serialVersionUID = 1L;

    private transient PropertyChangeSupport pcs;
    private S shout;

    public LoudCall() {
        nastavPropertyChangeSupport();
    }
    
    public final void nastavPropertyChangeSupport() {
        pcs = new PropertyChangeSupport(this);
    }

    public void shoutOut(S s) {
        try {
            pcs.firePropertyChange("shout", this.shout,
                    this.shout = s);
            Thread.sleep(Konstanty.SHOUT_DELAY);
        } catch (InterruptedException ex) {
            Logger.getLogger(LoudCall.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    @Override
    public abstract T call() throws Exception;
}
