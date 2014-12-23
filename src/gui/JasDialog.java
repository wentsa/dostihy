/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import MVC.HerniPlochaController;
import java.awt.Container;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author wentsa
 */
public class JasDialog extends JDialog {
    
    private static JasDialog instance=null;
    private Jas jas=new Jas();
    
    public static JasDialog getInstance(Container parent) {
        if(instance==null) {
            instance=new JasDialog(parent);
        }
        return instance;
    }
    
    private JasDialog(Container parent) {
        setModal(true);
        add(jas);
        pack();
        setLocationRelativeTo(parent);
    }
        
}
