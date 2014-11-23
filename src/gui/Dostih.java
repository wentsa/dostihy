/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author wentsa
 */
public class Dostih extends Dostihy implements Serializable {

    private final int poradi;
    public Dostih(int pozice, int poradi) {
        super(pozice, new ImageIcon(Dostih.class.getResource("/dostih.png")));
        this.poradi=poradi+1;
    }
    

    @Override
    protected int souradniceX() {
        return (int)(308*Math.cos(Math.toRadians((pozice+5)*9 + (poradi*2)))) + 340;
    }
    
    @Override
    protected int souradniceY() {
        return (int)(308*Math.sin(Math.toRadians((pozice+5)*9 + (poradi*2)))) + 345;
    }
    
    
}
