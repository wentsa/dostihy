/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Container;
import javax.swing.JDialog;

/**
 *
 * @author wentsa
 */
public class JasDialog extends JDialog {
    
    private static JasDialog instance=null;
    private final Jas jas=new Jas();
    
    public static JasDialog getInstance(Container parent) {
        if(instance==null) {
            instance=new JasDialog(parent);
        }
        return instance;
    }
    
    public static void smazInstance() {
        instance=null;
    }
    
    private JasDialog(Container parent) {
        setModal(true);
        add(jas);
        pack();
        setLocationRelativeTo(parent);
    }
        
}
