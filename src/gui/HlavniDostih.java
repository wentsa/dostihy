/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.ImageIcon;

/**
 *
 * @author wentsa
 */
public class HlavniDostih extends Dostihy {
    public HlavniDostih(int pozice) {
        super(pozice, new ImageIcon(HlavniDostih.class.getResource("/dostih2.png")));
    }
    
    @Override
    protected int souradniceX() {
        return (int)(310*Math.cos(Math.toRadians((pozice+5)*9 + 5))) + 338;
    }
    
    @Override
    protected int souradniceY() {
        return (int)(310*Math.sin(Math.toRadians((pozice+5)*9 + 5))) + 343;
    }
}
