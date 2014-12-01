/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dostihy.Control;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author wentsa
 */
public class ProdejDialog extends JDialog {

    public ProdejDialog(JPanel prodej) {
        super(Control.plocha,"Prodej");
        setModal(true);
        setContentPane(prodej);
        pack();
        setLocationRelativeTo(null);
        //setSize(prodej.getWidth(), prodej.getHeight());
        setVisible(true);
    }
    
}
