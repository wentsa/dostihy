/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.jmenovka;

import grafika.GraphicsHandler;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author wentsa
 */
public class JmenovkaView extends JLabel implements Serializable {
    private final JmenovkaController controller;

    protected JmenovkaView(JmenovkaController controller) {
        this.controller = controller;
        setText("<html><table width=345><tr><td>" + controller.getJmeno().toUpperCase() + "</td><td align=right>" + controller.getCastka() + "</td></tr></table></html>");
        setForeground(GraphicsHandler.barvaFontu);
        setFont(new Font("Ubuntu Mono Regular", Font.BOLD, 16));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setText("<html><table width=345><tr><td>" + controller.getJmeno().toUpperCase() + "</td><td align=right>" + (controller.isAktivni()? controller.getCastka() : (controller.getPoradi() + ". misto") ) + "</td></tr></table></html>");
        setLocation(70, controller.getSouradniceY());
    }
    
    
}
