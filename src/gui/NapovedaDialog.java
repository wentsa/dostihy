/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JDialog;

/**
 *
 * @author chaluto2
 */
public class NapovedaDialog extends JDialog {
    
    private final Napoveda napoveda=new Napoveda();
    
    public NapovedaDialog() {
        setModal(true);
        setContentPane(napoveda);
        pack();
        setLocationRelativeTo(null);
        setVisible(false);
    }
    
}
