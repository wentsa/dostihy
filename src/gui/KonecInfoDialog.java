/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.Serializable;
import javax.swing.JDialog;

/**
 *
 * @author wentsa
 */
public class KonecInfoDialog extends JDialog implements Serializable {
    private static final long serialVersionUID = 1L;

    public KonecInfoDialog() {
        setModal(true);
        setTitle("Konec hry");
        setContentPane(new KonecInfo());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
}
