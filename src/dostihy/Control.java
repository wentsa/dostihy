/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dostihy;

import gui.HerniPlocha;
import gui.Menu;
import gui.NacitacSouboru;
import gui.VolbaHracu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

/**
 *
 * @author wentsa
 */
public class Control {

    
    

    public class DataHraci {

        public List<String> jmena;
        public List<String> barvy;

        public DataHraci() {
            jmena = new ArrayList<>();
            barvy = new ArrayList<>();
        }

    }

    public enum Volba {

        nic, nova, nacist, konec
    }
    DataHraci data;
    public static Volba zvoleno;

    public int run() throws InterruptedException, IOException, ClassNotFoundException {
        // ----------  1 - MENU -------------------
        zvoleno=Volba.nic;
        final Menu menu = new Menu();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                menu.setVisible(true);
            }
        });
        System.out.println(zvoleno);
        while (zvoleno == Volba.nic) {
            Thread.sleep(100);
        }
        if (zvoleno == Volba.nova) {
            // ----------  2 - HRACI ------------------
            data = new DataHraci();
            final VolbaHracu volba = new VolbaHracu(data);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    volba.setVisible(true);
                }
            });
            while (data.jmena.isEmpty()) {
                Thread.sleep(1);
            }
            List<Hrac> hraci = new LinkedList<>();
            int i = 0;
            for (String jmeno : data.jmena) {
                hraci.add(new Hrac(jmeno, parseColor(data.barvy.get(i)), i + 1));
                i++;
            }
            Hra.getInstance().zalozHrace(hraci);
        }
        else if(zvoleno==Volba.nacist) {
            NacitacSouboru nacitac = new NacitacSouboru();
            int volba=nacitac.showOpenDialog(null);
            if(volba==JFileChooser.APPROVE_OPTION) {
                nacitac.vyhodnot();
            }
            else return 1;
        }
        else if(zvoleno==Volba.konec) {
            return 0;
        }
        // ----------  3 - PLOCHA -----------------
        HerniPlocha.getInstance();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HerniPlocha h=HerniPlocha.getInstance();
                h.repaint();
            }
        });

        boolean status = false;
        while (!status) {
            status = Hra.getInstance().tahni();
        }
        // ----------------------------------------
        return 1;
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
