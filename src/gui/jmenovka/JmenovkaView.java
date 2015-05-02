/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.jmenovka;

import grafika.GraphicsHandler;
import grafika.RozmeryPlochy;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.swing.JLabel;
import pomocne.Konstanty;

/**
 *
 * @author wentsa
 */
public class JmenovkaView extends JLabel implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final ResourceBundle bundle = ResourceBundle.getBundle("languages/gui/GUI", Konstanty.defaultLocale);
    private final JmenovkaController controller;

    protected JmenovkaView(JmenovkaController controller) {
        this.controller = controller;
        setText("<html><table width="
                + (int) (345 * RozmeryPlochy.getScalingFactor())
                + "><tr><td>" + controller.getJmeno().toUpperCase()
                + "</td><td align=right>" + controller.getCastka()
                + "</td></tr></table></html>");
        setForeground(GraphicsHandler.getBarvaFontu());
        setFont(new Font(Konstanty.fontName, Font.BOLD, (int) (16 * RozmeryPlochy.getScalingFactor())));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setText("<html><table width="
                + (int) (345 * RozmeryPlochy.getScalingFactor())
                + "><tr><td>" + controller.getJmeno().toUpperCase()
                + "</td><td align=right>"
                + (controller.isAktivni() ? controller.getCastka() : (controller.getPoradi() + bundle.getString("NTH_PLACE")))
                + "</td></tr></table></html>");
        setLocation((int) (70 * RozmeryPlochy.getScalingFactor()), controller.getSouradniceY());
    }

}
