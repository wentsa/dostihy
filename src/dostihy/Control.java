/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dostihy;

import gui.HerniPlocha;
import gui.VolbaHracu;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
    public static HerniPlocha plocha;
    public static Hra hra;
    public class DataHraci{
        public List<String> jmena;
        public List<String> barvy;

        public DataHraci() {
            jmena=new ArrayList<>();
            barvy=new ArrayList<>();
        }
        
    }
    DataHraci data;
    
    public void run() throws InterruptedException, IOException, ClassNotFoundException {
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
        //hra=new Hra();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("/home/wentsa/ewew.das")));
        hra=(Hra) ois.readObject();
        ois.close();
        //hra.setKostka(new Kostka());
        //hra.getKostka().setEnabled(true);
        //hra.zalozHrace(hraci);
        hra.getKostka().pridejListener();
        plocha=new HerniPlocha();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                plocha.setVisible(true);
            }
        });
        
        boolean status=false;
        while(!status) {
           status=hra.tahni();
        }
        // ----------------------------------------
    }
    
    Barva parseColor(String barva) {
        switch (barva) {
            case "Cerna":
                return Barva.BLACK;
            case "Modra":
                return Barva.BLUE;
            case "Tyrkysova":
                return Barva.CYAN;
            case "Zelena":
                return Barva.GREEN;
            case "Fialova":
                return Barva.MAGENTA;
            case "Oranzova":
                return Barva.ORANGE;
            case "Cervena":
                return Barva.RED;
            case "Bila":
                return Barva.WHITE;
            case "Zluta":
                return Barva.YELLOW;
        }
        return null;
    }
}
