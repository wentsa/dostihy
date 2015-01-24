/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import grafika.GraphicsHandler;
import grafika.RozmeryPlochy;
import karty.vlastnicke.PrepravaStaje;
import karty.vlastnicke.Kun;
import karty.vlastnicke.Trener;
import gui.plocha.HerniPlochaController;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.Serializable;
import javax.swing.*;
import karty.*;
import karty.finance.*;
import karty.nahoda.*;

/**
 *
 * @author wentsa
 */
public class KartaGUI extends JDialog implements ActionListener, Serializable {
    private static final long serialVersionUID = 1L;
    Karta karta;
    public KartaGUI(Karta karta) {
        this.karta=karta;
        setModal(true);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        
        ImageIcon obrazek=GraphicsHandler.getIcon("karta");
                
        setShape(new RoundRectangle2D.Double(0, 0, obrazek.getIconWidth(), obrazek.getIconHeight(), (int)(40*RozmeryPlochy.getScalingFactor()), (int)(40*RozmeryPlochy.getScalingFactor())));

        
        String nadpis=null;
        String popis=null;
        if(this.karta instanceof Finance) {
            nadpis="<html><body style='width: " + obrazek.getIconWidth()*4/5 + "px,text-align: center'><p><center>FINANCE</center></p>";
            popis="<p><center>" + this.karta.toString() + "</center></p></body></html>";
        }
        else if(this.karta instanceof Nahoda) {
            nadpis="<html><body style='width: " + obrazek.getIconWidth()*4/5 + "px,text-align: center'><p><center>NÁHODA</center></p>";
            popis="<p><center>" + this.karta.toString() + "</center></p></body></html>";
        }
        else if(this.karta instanceof Kun) {
            Kun tmp=(Kun) this.karta;
            nadpis="<html><body style='width: " + obrazek.getIconWidth()*4/5 + "px,text-align: center'><p><center>" + tmp.getJmeno().toUpperCase() + "</center></p>";
            popis=
                    "Pořizovací cena: " + tmp.getPorizovaciCena() + ",-<br>" +
                    "Prohlídka stáje: " + tmp.getProhlidkaStaje() + ",-<br>" +
                    "Zisk z<br>" +
                    "<table><tr><td align=left>1 dostihu:</td><td align=right>" + tmp.getDostih1() + ",-</td></tr>" +
                    "<tr><td align=left>2 dostihů:</td><td align=right>" + tmp.getDostih2() + ",-</td></tr>" +
                    "<tr><td align=left>3 dostihů:</td><td align=right>" + tmp.getDostih3() + ",-</td></tr>" +
                    "<tr><td align=left>4 dostihů:</td><td align=right>" + tmp.getDostih4() + ",-</td></tr>" +
                    "<tr><td align=left>Hl. dostihu:</td><td align=right>" + tmp.getHlDostih() + ",-</td></tr></table><br>" +
                    "Náklady na přípravu<br>" +
                    "<table><tr><td>na nový dostih:</td><td align=right>" + tmp.getPripravaDostihu() + ",-</td></tr>" +
                    "<tr><td>na hl. dostih:</td><td align=right>" + tmp.getPripravaHlavnihoDostihu() + ",-</td></tr>" +
                    "<tr><td><br>Majitel: </td><td><br>" + (tmp.getMajitel()==null?"nikdo": tmp.getMajitel().getJmeno()) + "</td></tr>" +
                    "<tr><td>Aktuální sázka: </td><td>" + tmp.getSazka() + ",-</td></tr>" +
                    "</table></body></html>";
        }
        else if(this.karta instanceof Trener) {
            Trener tmp=(Trener) this.karta;
            nadpis="<html><body style='width: " + obrazek.getIconWidth()*4/5 + "px,text-align: center'><p><center>TRENÉR " + tmp.getCislo() + "</center></p>";
            popis= 
                    "Cena licence:    " + tmp.getPorizovaciCena() + ",-<br><br>" +
                    "Majitel licenci vybírá tyto poplatky:<br>" +
                    "1. licence:      1.000,-<br>" +
                    "2. licence:      2.000,-<br>" +
                    "3. licence:      3.000,-<br>" +
                    "4. licence:      4.000,-<br>" +
                    "<br><table><tr><td>Majitel: </td><td>" + (tmp.getMajitel()==null?"nikdo": tmp.getMajitel().getJmeno()) + "</td></tr></table>" +
                    "</body></html>";
        }
        else if(this.karta instanceof PrepravaStaje) {
            PrepravaStaje tmp=(PrepravaStaje) this.karta;
            nadpis="<html><body style='width: " + obrazek.getIconWidth()*1/2 + "px,text-align: center'><p><center>" + tmp.getJmeno().toUpperCase() + "</center></p>";
            popis="<br>Pořizovací cena: " + tmp.getPorizovaciCena() + ",-<br><br><p>" + tmp.getPopis() + "</p><br>"
                    + "<br><table><tr><td>Majitel: </td><td>" + (tmp.getMajitel()==null? "nikdo" : tmp.getMajitel().getJmeno()) + "</td></tr></table><br><br>" +
"                    </body></html>";
        }
        Font font=new Font("Ubuntu Mono Regular", Font.PLAIN, (int)(16*RozmeryPlochy.getScalingFactor()));
        if(karta instanceof Kun) {
            font=new Font("Ubuntu Mono Regular", Font.PLAIN, (int)(14*RozmeryPlochy.getScalingFactor()));
        }
               
        final JButton but=new JButton(nadpis.concat("<br>" + popis),obrazek);
        but.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        but.setFont(font);
        but.setHorizontalTextPosition(SwingConstants.CENTER);
        but.setMargin(new Insets((int)(15*RozmeryPlochy.getScalingFactor()), (int)(40*RozmeryPlochy.getScalingFactor()), (int) (15 * RozmeryPlochy.getScalingFactor()), (int)(40*RozmeryPlochy.getScalingFactor())));
        but.setSize(obrazek.getIconWidth(),obrazek.getIconHeight());
        but.setBounds(0, 0, obrazek.getIconWidth(), obrazek.getIconHeight());
        but.setContentAreaFilled(false);
        but.setFocusPainted(false);
        but.setBorderPainted(false);
        but.setBackground(Color.red);
        setLayout(null);
        setBounds(0, 0, obrazek.getIconWidth(), obrazek.getIconHeight());
        setContentPane(but);
        setBackground(Color.yellow);
        //pack();
        
        setLocationRelativeTo(SwingUtilities.getWindowAncestor(HerniPlochaController.getInstance().getView()));
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose(); //zavre okno
    }

    
    
    
    
    
}
