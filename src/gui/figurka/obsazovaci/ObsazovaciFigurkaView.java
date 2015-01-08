/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.figurka.obsazovaci;

import gui.figurka.FigurkaController;
import gui.figurka.FigurkaView;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author wentsa
 */
public class ObsazovaciFigurkaView extends JLabel implements Serializable {

    ObsazovaciFigurkaController controller;
    public ObsazovaciFigurkaView(ObsazovaciFigurkaController controller) {
        this.controller=controller;
        setVisible(false);
    }
    
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        setLocation(controller.getSouradniceX(), controller.getSouradniceY());
    }
    
}
