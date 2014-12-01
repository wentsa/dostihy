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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author wentsa
 */
public class Control {

    public static HerniPlocha plocha;
    public static Hra hra;
    

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
    public static Volba zvoleno = Volba.nic;

    public void run() throws InterruptedException, IOException, ClassNotFoundException {
        // ----------  1 - MENU -------------------
        final Menu menu = new Menu();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                menu.setVisible(true);
            }
        });
        while (zvoleno == Volba.nic) {
            Thread.sleep(1);
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
            hra = new Hra();
            hra.zalozHrace(hraci);
        }
        else if(zvoleno==Volba.nacist) {
            NacitacSouboru nacitac = new NacitacSouboru();
            int volba=nacitac.showOpenDialog(null);
            if(volba==JFileChooser.APPROVE_OPTION) {
                nacitac.vyhodnot();
            }
        }
        else if(zvoleno==Volba.konec) {
            return;
        }
        // ----------  3 - PLOCHA -----------------
        plocha = new HerniPlocha();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                plocha.setVisible(true);
            }
        });

        boolean status = false;
        while (!status) {
            status = hra.tahni();
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
