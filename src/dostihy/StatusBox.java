/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dostihy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author wentsa
 */
public class StatusBox extends JLabel {

    boolean first;
    
    public StatusBox() {
        setForeground(new Color(200, 35, 35));
        setFont(new Font("Ubuntu Mono Regular", Font.BOLD, 16));
        setVisible(true);
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setLocation(50, 650);
    }
}
