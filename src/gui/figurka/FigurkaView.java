/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.figurka;

import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author wentsa
 */
public class FigurkaView extends JLabel implements Serializable {
        
    private final FigurkaController controller;

    protected FigurkaView(FigurkaController controller) {
        this.controller=controller;
    }
    
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        setLocation(controller.getSouradniceX(), controller.getSouradniceY());
    }

   

    
    
    
}
