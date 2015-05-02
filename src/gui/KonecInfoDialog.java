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
public class KonecInfoDialog extends JDialog implements Serializable {
    
    private static final ResourceBundle bundle = ResourceBundle.getBundle("languages/gui/GUI", Konstanty.defaultLocale);
    
    public KonecInfoDialog() {
        setModal(true);
        setTitle(bundle.getString("END_OF_GAME"));
        setContentPane(new KonecInfo());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
