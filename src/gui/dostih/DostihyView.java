/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dostih;

import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author wentsa
 */
public class DostihyView extends JLabel implements Serializable {

    private static final long serialVersionUID = 1L;
    private final DostihyController controller;

    protected DostihyView(DostihyController controller) {
        this.controller = controller;
        setBorder(null);
        setIcon(controller.getDostih());
        setVisible(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setLocation(controller.getSouradniceX(), controller.getSouradniceY());
    }

}
