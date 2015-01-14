/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.slider;

import grafika.GraphicsHandler;
import javax.swing.ImageIcon;

/**
 *
 * @author wentsa
 */
public class SliderModel {
    private int souradniceY;
    protected SliderModel() {
        souradniceY=45-23;
    }
    protected ImageIcon getObrazek() {
        return GraphicsHandler.getIcon("slider");
    }
    protected void setSouradniceY(int y) {
        this.souradniceY=y-23;
    }
    protected int getSouradniceY() {
        return souradniceY;
    }
}
