/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ResourceBundle;
import javax.swing.JDialog;
import pomocne.Konstanty;

/**
 *
 * @author chaluto2
 */
public class NapovedaDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    private static final ResourceBundle bundle = ResourceBundle.getBundle("languages/gui/GUI", Konstanty.DEFAULT_LOCALE);
    
    private final Napoveda napoveda = new Napoveda();
    
    public NapovedaDialog() {
        setModal(true);
        setTitle(bundle.getString("HELP"));
        setContentPane(napoveda);
        pack();
        setLocationRelativeTo(null);
        setVisible(false);
    }
    
}
