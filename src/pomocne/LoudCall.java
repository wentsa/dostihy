/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocne;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.Callable;

/**
 *
 * @author wentsa
 */
public abstract class LoudCall<T, S> implements Callable<T> {

    private PropertyChangeSupport pcs;
    private S shout;

    public LoudCall() {
        pcs = new PropertyChangeSupport(this);
    }

    public void shoutOut(S s) {
        pcs.firePropertyChange("shout", this.shout, 
                this.shout = s);
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
