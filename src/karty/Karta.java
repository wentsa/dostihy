/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty;

import gui.KartaGUIDialog;
import java.io.Serializable;

/**
 *
 * @author wentsa
 */
public abstract class Karta implements Serializable {
    private static final long serialVersionUID = 1L;
    
            
    public void zobraz() throws InterruptedException {
        new KartaGUIDialog(this);
    }
}
