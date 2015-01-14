/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import gui.plocha.HerniPlochaController;
import hra.Hra;
import hra.Hrac;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.ImageIcon;
import pomocne.Barva;
import pomocne.Konstanty;

/**
 *
 * @author wentsa
 */
public class GraphicsHandler {
    
    private static Map<String, BufferedImage> obrazky, obrazkyOrig;
    private static Map<String, ImageIcon> ikony;
    private static float scale, offset;
    public static Color barvaFontu;
    private static int stupenSedi;
    
    public static void inicializovat() {
        scale=1.0f;
        offset=0;
        stupenSedi=35;
        barvaFontu=new Color(35,35,35);
        
        obrazky=new HashMap<>();
        obrazkyOrig=new HashMap<>();
        ikony=new HashMap<>();
        
        nacti("plocha","jpg",null);
        nacti("stred","jpg",null);
        nacti("prava","jpg",null);
        nacti("prava_aktiv","jpg",null);
        nacti("spodek_lista","jpg",null);
        nacti("status","jpg",null);
        nactiIkonu("slider","png",null);
        nactiIkonu("ukoncit","jpg",null);
        nactiIkonu("ukoncit_aktiv","jpg",null);
        nactiIkonu("prodat","jpg",null);
        nactiIkonu("vzdat","jpg",null);
        nactiIkonu("karta","jpg",null);
        
        Konstanty.sirkaPlochy=obrazky.get("plocha").getWidth()-3;
        Konstanty.vyskaPlochy=obrazky.get("plocha").getHeight();
    }
    
    private static String parseColor(Barva barva) {
        return barva.toString().toLowerCase();
    }
    
    public static void nactiFigurku(String ID, Barva barva) {
        nactiIkonu("fig/" + parseColor(barva), "png", ID);
        rescale();
    }
    
    public static void nactiDostih(String ID, boolean hlavniDostih) {
        nactiIkonu("dostih" + (hlavniDostih ? "2" : ""), "png", ID);
        rescale();
    }
    
    public static void nactiPuntik(String ID, Barva barva) {
        nactiIkonu("puntiky/" + parseColor(barva) + "p", "png", ID);
    }

    private static void nacti(String soubor, String pripona, String ID) {
        if(ID==null) ID=soubor;
        
        Image tmp=new ImageIcon(GraphicsHandler.class.getResource("/" + soubor + "." + pripona)).getImage();
        
        obrazkyOrig.put(ID, new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_4BYTE_ABGR));
        obrazky.put(ID, new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_4BYTE_ABGR));
        
        Graphics2D gr=obrazkyOrig.get(ID).createGraphics();
        gr.drawImage(tmp, 0,0,null);
        
        gr=obrazky.get(ID).createGraphics();
        gr.drawImage(tmp, 0,0,null);
        
        gr.dispose();
    }
    
    private static void nactiIkonu(String soubor, String pripona, String ID) {
        nacti(soubor, pripona, ID);
        if(ID==null) ID=soubor;
        ikony.put(ID, new ImageIcon(obrazky.get(ID)));
    }
    
    public static void nastavKontrast(float value) {
        scale=value;
        System.out.println("SCALE " + scale);
        rescale();
    }

    public static void nastavJas(float value) {
        offset=value;
        System.out.println("OFFSET " + offset);
        rescale();
    }

    public static void zmenFont() {
        stupenSedi=(int) (scale*(offset+50)*0.9);
        barvaFontu=new Color(stupenSedi, stupenSedi, stupenSedi);
        for(Hrac h : Hra.getInstance().getHraci()) {
            h.getJmenovka().aktualizujFont();
        }
        HerniPlochaController.getInstance().aktualizujFont();
        System.out.println(stupenSedi);
    }

    private static void rescale() {
        RescaleOp rescaleOp = new RescaleOp(scale,offset, null);
        for (String nazev : obrazkyOrig.keySet()) {
            rescaleOp.filter(obrazkyOrig.get(nazev), obrazky.get(nazev));
        }
        Set<String> keys=ikony.keySet();
        for(String nazev : keys) {
            ikony.put(nazev, new ImageIcon(obrazky.get(nazev)));
        }
    }
    
    public static BufferedImage get(String nazev) {
        return obrazky.get(nazev);
    }
    
    public static ImageIcon getIcon(String nazev) {
        return ikony.get(nazev);
    }

    
}
