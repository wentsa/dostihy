/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dostihy.Figurka;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author wentsa
 */
public class NewClass extends JFrame {
    public NewClass() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(300,300);
        JPanel pan=new JPanel();
        pan.setLayout(new BorderLayout());
        pan.setBackground(Color.red);
        setContentPane(pan);
        Figurka f=new Figurka(Color.blue,1);
        //f.setBackground(Color.BLUE);
        JPanel pan2=new JPanel();
        pan2.setBackground(Color.BLUE);
        pan.add(f);
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewClass().setVisible(true);
            }
        });
    }
}
