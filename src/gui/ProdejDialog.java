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
public class ProdejDialog extends JDialog implements Serializable {

    public ProdejDialog(ProdejGUI prodej) {
        setModal(true);
        setContentPane(prodej);
        pack();
        setLocationRelativeTo(null);
        //setSize(prodej.getWidth(), prodej.getHeight());
        setVisible(true);
    }
    
}
