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
public class ProdejDialog extends JDialog implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final ResourceBundle bundle = ResourceBundle.getBundle("languages/gui/GUI", Konstanty.DEFAULT_LOCALE);

    public ProdejDialog(ProdejGUI prodej) {
        setModal(true);
        setTitle(bundle.getString("SELLING"));
        setContentPane(prodej);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
