/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JDialog;

/**
 *
 * @author wentsa
 */
public class KonecInfoDialog extends JDialog{

    public KonecInfoDialog() {
        setModal(true);
        setContentPane(new KonecInfo());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
}