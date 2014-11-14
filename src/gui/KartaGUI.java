/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import karty.*;
import karty.finance.*;
import karty.nahoda.*;

/**
 *
 * @author wentsa
 */
public class KartaGUI extends JFrame implements ActionListener {
    Karta karta;
    public KartaGUI(Karta karta) {
        this.karta=karta;
        setTitle("karta");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true); //odstrani horni panel
        
        setLayout(new BorderLayout());
        ImageIcon obrazek=new ImageIcon("res/step9.jpg");
        final JButton but=new JButton(obrazek);
        setShape(new RoundRectangle2D.Double(0, 0, obrazek.getIconWidth(), obrazek.getIconHeight(), 40, 40));

        but.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        
        setSize(obrazek.getIconWidth(),obrazek.getIconHeight());
        setContentPane(but);
        
        setLayout(null);
        JLabel nadpis=new JLabel();
        JLabel popis=null;
        if(this.karta instanceof Finance) {
            nadpis.setText("FINANCE");
            popis=new JLabel("<html><p><center>" + this.karta.toString() + "</center></p></html>",JLabel.CENTER);
        }
        else if(this.karta instanceof Nahoda) {
            nadpis.setText("NAHODA");
            popis=new JLabel("<html><p><center>" + this.karta.toString() + "</center></p></html>",JLabel.CENTER);
        }
        else if(this.karta instanceof Kun) {
            Kun tmp=(Kun) this.karta;
            nadpis.setText(tmp.getJmeno().toUpperCase());
            popis=new JLabel("<html>" +
                    "Porizovaci cena: " + tmp.getPorizovaciCena() + "<br>" +
                    "Prohlidka staje: " + tmp.getProhlidkaStaje() + "<br><br>" +
                    "Zisk z<br>" +
                    "<table><tr><td align=left>1 dostihu:</td><td align=right>" + tmp.getDostih1() + "</td></tr>" +
                    "<tr><td align=left>2 dostihu:</td><td align=right>" + tmp.getDostih2() + "</td></tr>" +
                    "<tr><td align=left>3 dostihu:</td><td align=right>" + tmp.getDostih3() + "</td></tr>" +
                    "<tr><td align=left>4 dostihu:</td><td align=right>" + tmp.getDostih4() + "</td></tr>" +
                    "<tr><td align=left>Hl. dostihu:</td><td align=right>" + tmp.getHlDostih() + "</td></tr></table><br>" +
                    "Naklady na pripravu<br>" +
                    "<table><tr><td>na novy dostih:</td><td align=right>" + tmp.getPripravaDostihu() + "</td></tr>" +
                    "<tr><td>na hl. dostih:</td><td align=right>" + tmp.getPripravaHlavnihoDostihu() + "</td></tr></table>" +
                    "</html>",JLabel.CENTER);
        }
        else if(this.karta instanceof Trener) {
            Trener tmp=(Trener) this.karta;
            nadpis.setText("TRENER " + tmp.getCislo());
            popis=new JLabel("<html>" + 
                    "Cena licence:    " + tmp.getPorizovaciCena() + "<br><br>" +
                    "Majitel licenci vybira tyto poplatky:<br>" +
                    "1. licence:      1000<br>" +
                    "2. licence:      2000<br>" +
                    "3. licence:      3000<br>" +
                    "4. licence:      4000<br>" +
                    "</html>",JLabel.CENTER);
        }
        else if(this.karta instanceof PrepravaStaje) {
            PrepravaStaje tmp=(PrepravaStaje) this.karta;
            nadpis.setText(tmp.getJmeno().toUpperCase());
            popis=new JLabel("<html><p>" + tmp.getPopis() + "</p></html>");
        }
        Font font=new Font("Ubuntu Mono Regular", Font.PLAIN, 16);
        nadpis.setForeground(Color.BLACK);
        popis.setForeground(Color.BLACK);
        popis.setFont(font);
        nadpis.setFont(font);
        nadpis.setLocation(obrazek.getIconWidth()/8, obrazek.getIconHeight()/8);
        popis.setLocation(obrazek.getIconWidth()/8, obrazek.getIconHeight()/4);
        nadpis.setSize(obrazek.getIconWidth()*3/4,obrazek.getIconHeight()/4);
        popis.setSize(obrazek.getIconWidth()*3/4, obrazek.getIconHeight()*3/4);
        nadpis.setVerticalAlignment(SwingConstants.TOP);
        nadpis.setHorizontalAlignment(SwingConstants.CENTER);
        popis.setVerticalAlignment(SwingConstants.TOP);
        add(popis);
        add(nadpis);
        //but.addActionListener(this);
        but.setBorderPainted(false);
        setVisible(true);
        setLocationRelativeTo(null); //na stred
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose(); //zavre okno
    }

    
    
    
    
    
}
