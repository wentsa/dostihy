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

    private static final long serialVersionUID = -1067063695607971234L;

    private final FigurkyController controller;

    protected FigurkaView(FigurkyController controller, boolean visible) {
        this.controller = controller;
        setVisible(visible);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setLocation(controller.getSouradniceX(), controller.getSouradniceY());
    }

}
