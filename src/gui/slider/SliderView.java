/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.slider;

import grafika.GraphicsHandler;
import grafika.RozmeryPlochy;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author wentsa
 */
public class SliderView extends JLabel {
    private static final long serialVersionUID = 1L;
    private final SliderController controller;

    public SliderView(SliderController controller) {
        this.controller = controller;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setLocation((int)(3*RozmeryPlochy.getScalingFactor()), controller.getSouradniceY());
    }
}
