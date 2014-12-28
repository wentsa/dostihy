/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.slider;

import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author wentsa
 */
public class SliderView extends JLabel {
    private final SliderController controller;

    public SliderView(SliderController controller) {
        this.controller = controller;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setLocation(-2, controller.getSouradniceY());
    }
}
