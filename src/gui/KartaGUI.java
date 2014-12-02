/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dostihy.Control;
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
public class KartaGUI extends JDialog implements ActionListener {
    Karta karta;
    public KartaGUI(Karta karta) {
        super(Control.plocha);
        this.karta=karta;
        setModal(true);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setUndecorated(true);
        
        //setLayout(new BorderLayout());
        ImageIcon obrazek=new ImageIcon(KartaGUI.class.getResource("/step9.jpg"));
        
        //setShape(new RoundRectangle2D.Double(0, 0, obrazek.getIconWidth(), obrazek.getIconHeight(), 40, 40));

        
        String nadpis=null;
        String popis=null;
        if(this.karta instanceof Finance) {
            nadpis="<html><body style='width: " + obrazek.getIconWidth()*3/4 + "px,text-align: center'><p><center>FINANCE</center></p>";
            popis="<p><center>" + this.karta.toString() + "</center></p></body></html>";
        }
        else if(this.karta instanceof Nahoda) {
            nadpis="<html><body style='width: " + obrazek.getIconWidth()*3/4 + "px,text-align: center'><p><center>NAHODA</center></p>";
            popis="<p><center>" + this.karta.toString() + "</center></p></body></html>";
        }
        else if(this.karta instanceof Kun) {
            Kun tmp=(Kun) this.karta;
            nadpis="<html><body style='width: " + obrazek.getIconWidth()*3/4 + "px,text-align: center'><p><center>" + tmp.getJmeno().toUpperCase() + "</center></p>";
            popis=
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
                    "</body></html>";
        }
        else if(this.karta instanceof Trener) {
            Trener tmp=(Trener) this.karta;
            nadpis="<html><body style='width: " + obrazek.getIconWidth()*3/4 + "px,text-align: center'><p><center>TRENER " + tmp.getCislo() + "</center></p>";
            popis= 
                    "Cena licence:    " + tmp.getPorizovaciCena() + "<br><br>" +
                    "Majitel licenci vybira tyto poplatky:<br>" +
                    "1. licence:      1000<br>" +
                    "2. licence:      2000<br>" +
                    "3. licence:      3000<br>" +
                    "4. licence:      4000<br>" +
                    "</body></html>";
        }
        else if(this.karta instanceof PrepravaStaje) {
            PrepravaStaje tmp=(PrepravaStaje) this.karta;
            nadpis="<html><body style='width: " + obrazek.getIconWidth()*3/4 + "px,text-align: center'><p><center>" + tmp.getJmeno().toUpperCase() + "</center></p>";
            popis="<p>" + tmp.getPopis() + "</p></body></html>";
        }
        Font font=new Font("Ubuntu Mono Regular", Font.PLAIN, 16);
               
        final JButton but=new JButton(nadpis.concat("<br><br>" + popis),obrazek);
        but.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        but.setHorizontalTextPosition(SwingConstants.CENTER);
        but.setSize(obrazek.getIconWidth(),obrazek.getIconHeight());
        but.setContentAreaFilled(false);
        but.setFocusPainted(false);
        but.setBorderPainted(false);
        but.setBackground(Color.red);
        setContentPane(but);
        setBackground(Color.yellow);
        pack();
        setVisible(true);
        setLocationRelativeTo(null); //na stred
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose(); //zavre okno
    }

    
    
    
    
    
}
