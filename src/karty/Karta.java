/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karty;

import gui.KartaGUI;
import java.io.Serializable;
import javax.swing.SwingUtilities;

/**
 *
 * @author wentsa
 */
public abstract class Karta implements Serializable {
    
            
    public void zobraz() throws InterruptedException {
        final KartaGUI gui=new KartaGUI(this);
        gui.setLocationRelativeTo(null);
        /*SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui.setVisible(true);
            }
        });*/
    }
}
