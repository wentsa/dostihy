/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.swing.JDialog;
import pomocne.Konstanty;

/**
 *
 * @author wentsa
 */
public class JasDialog extends JDialog implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final ResourceBundle bundle = ResourceBundle.getBundle("languages/gui/GUI", Konstanty.DEFAULT_LOCALE);
    
    private final Jas jas = new Jas();
    
    public JasDialog() {
        setModal(true);
        setTitle(bundle.getString("BRIGHTNESS_AND_CONTRAST"));
        setContentPane(jas);
        pack();
        setLocationRelativeTo(null);
        setVisible(false);
    }
    
}
