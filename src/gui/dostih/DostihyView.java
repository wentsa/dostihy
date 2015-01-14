/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dostih;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JLabel;
import pomocne.Konstanty;

/**
 *
 * @author wentsa
 */
public class DostihyView extends JLabel implements Serializable {
    private final DostihController controller1;
    private final HlavniDostihController controller2;
    
    protected  DostihyView(DostihController controller) {
        this.controller1=controller;
        this.controller2=null;
        setBorder(null);
        setIcon(controller1.getDostih());
        setVisible(false);
    }
    protected  DostihyView(HlavniDostihController controller) {
        this.controller2=controller;
        this.controller1=null;
        setBorder(null);
        setIcon(controller2.getDostih());
        setVisible(false);
    }
    
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        if(controller1==null) {
            setLocation(controller2.getSouradniceX(), controller2.getSouradniceY());
        }
        else {
            setLocation(controller1.getSouradniceX(), controller1.getSouradniceY());
        }
        
    }
    
}
