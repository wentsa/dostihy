/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dostihy;

import gui.HerniPlocha;
import gui.VolbaHracu;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author wentsa
 */
public class Control {
    static HerniPlocha plocha;
    public class DataHraci{
        public List<String> jmena;
        public List<String> barvy;

        public DataHraci() {
            jmena=new ArrayList<>();
            barvy=new ArrayList<>();
        }
        
    }
    DataHraci data;
    
    public void run() throws InterruptedException {
        // ----------  1 - MENU -------------------
        // ----------  2 - HRACI ------------------
        data=new DataHraci();
        final VolbaHracu volba=new VolbaHracu(data);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                volba.setVisible(true);
            }
        });
        while(data.jmena.isEmpty()) {Thread.sleep(1);}
        List<Hrac> hraci=new LinkedList<>();
        int i=0;
        for (String jmeno : data.jmena) {
            hraci.add(new Hrac(jmeno,parseColor(data.barvy.get(i)),i+1));
            i++;
        }
        // ----------  3 - PLOCHA -----------------
        Hra hra=new Hra();
        hra.zalozHrace(hraci);
        plocha=new HerniPlocha(hra);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                plocha.setVisible(true);
            }
        });
        
        boolean status=false;
        while(!status) {
            System.out.println("dalsi tah");
           status=hra.tahni();
        }
        // ----------------------------------------
    }
    
    Color parseColor(String barva) {
        switch (barva) {
            case "Cerna":
                return Color.BLACK;
            case "Modra":
                return Color.BLUE;
            case "Tyrkysova":
                return Color.CYAN;
            case "Zelena":
                return Color.GREEN;
            case "Fialova":
                return Color.MAGENTA;
            case "Oranzova":
                return Color.ORANGE;
            case "Cervena":
                return Color.RED;
            case "Bila":
                return Color.WHITE;
            case "Zluta":
                return Color.YELLOW;
        }
        return null;
    }
}
