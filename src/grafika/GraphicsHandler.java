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
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import pomocne.Barva;
import pomocne.Konstanty;

/**
 * 
 * @author wentsa
 * 
 * Třída sloužící pro načítání obrazových podkladů a jejich zpracovávání a delegování ostatním třídám (včetně fontu)
 */

public class GraphicsHandler {

    private static Map<String, BufferedImage> obrazky;  //soubor všech obrazových podkladů
    private static Map<String, ImageIcon> ikony;        //některé obrázky překonvertované do ImageIcon
    private static Map<String, int[][]> pixely;         //obrázky jako pole pixelů - délka je celkový počet pixelů a každá položka má 4 atributy (red, green, blue, alpha)
    private static int jas = 0;                         //úroveň jasu
    private static float kontrast = 1.0f;               //faktor násobnosti kontrastu
    public static Color barvaFontu;                     //barva fontu používaná na jmenovkách a statusboxu
    private static int stupenSedi;                      //stupeň šedi pro tvorbu fontu

    /**
     * Inicializuje všechny obrázky, které patří k herní ploše a nejsou závislé na počtu hráčů atd.
     */
    public static void inicializovat() {
        stupenSedi = 35;
        barvaFontu = new Color(35, 35, 35);

        obrazky = new TreeMap<>();
        pixely = new TreeMap<>();
        ikony = new TreeMap<>();

        nacti("plocha", "jpg", null);
        nacti("stred", "jpg", null);
        nacti("prava", "jpg", null);
        nacti("prava_aktiv", "jpg", null);
        nacti("spodek_lista", "jpg", null);
        nacti("status", "jpg", null);
        nactiIkonu("slider", "png", null);
        nactiIkonu("ukoncit", "jpg", null);
        nactiIkonu("ukoncit_aktiv", "jpg", null);
        nactiIkonu("prodat", "jpg", null);
        nactiIkonu("vzdat", "jpg", null);
        nactiIkonu("karta", "jpg", null);

        nactiARGB();

        Konstanty.sirkaPlochy = obrazky.get("plocha").getWidth() - 3;
        Konstanty.vyskaPlochy = obrazky.get("plocha").getHeight();
    }

    /**
     * Převede barvu na její textovou reprezentaci, která se používá k načítání souboru
     * @param barva barva
     * @return      textová reprezentace barvy
     */
    private static String parseColor(Barva barva) {
        return barva.toString().toLowerCase();
    }

    /**
     * Načte obrázek pro reprezentaci figurky a uloží do kolekce
     * @param ID    unikátní ID podle kterého se konkrétní figurka následně vyhledává (HashCode objektu Figurka)
     * @param barva barva figurky
     */
    public static void nactiFigurku(String ID, Barva barva) {
        nactiIkonu("fig/" + parseColor(barva), "png", ID);
        pixely.put(ID, getARGB(obrazky.get(ID)));
        rescale();
    }

    /**
     * Načte obrázek pro reprezentaci dostihu a uloží do kolekce
     * @param ID            unikátní ID podle kterého se konkrétní dostih následně vyhledává (HashCode objektu Dostih)
     * @param hlavniDostih  true - jedná se o hlavní dostih, false - jedná se o normální dostih
     */
    public static void nactiDostih(String ID, boolean hlavniDostih) {
        nactiIkonu("dostih" + (hlavniDostih ? "2" : ""), "png", ID);
        pixely.put(ID, getARGB(obrazky.get(ID)));
        rescale();
    }

    /**
     * Načte obrázek pro reprezentaci puntíku jmenovky a uloží do kolekce
     * @param ID    unikátní ID podle kterého se konkrétní puntík následně vyhledává (HashCode objektu Puntik)
     * @param barva barva puntíku
     */
    public static void nactiPuntik(String ID, Barva barva) {
        nactiIkonu("puntiky/" + parseColor(barva) + "p", "png", ID);
        pixely.put(ID, getARGB(obrazky.get(ID)));
    }

    /**
     * Načte soubor a uloží jej do obrázků
     * @param soubor    cesta k souboru, který se má načíst
     * @param pripona   přípona souboru
     * @param ID        null pokud se jako ID obrázku použije /p soubor, jinak jednoznačné ID
     */
    private static void nacti(String soubor, String pripona, String ID) {
        if (ID == null) {
            ID = soubor;
        }
        Image tmp = new ImageIcon(GraphicsHandler.class.getResource("/" + soubor + "." + pripona)).getImage();

        obrazky.put(ID, new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_INT_ARGB));

        Graphics2D gr;

        gr = obrazky.get(ID).createGraphics();
        gr.drawImage(tmp, 0, 0, null);

        gr.dispose();
    }

    /**
     * Načte obrázek a jeho verzi ve formátu ImageIcon uloží do ikon
     * @param soubor    cesta k souboru, který se má načíst
     * @param pripona   přípona souboru
     * @param ID        null pokud se jako ID obrázku použije /p soubor, jinak jednoznačné ID
     */
    private static void nactiIkonu(String soubor, String pripona, String ID) {
        nacti(soubor, pripona, ID);
        if (ID == null) {
            ID = soubor;
        }
        ikony.put(ID, new ImageIcon(obrazky.get(ID)));
    }

    /**
     * Načte pixelovou reprezentaci všech obrázků
     */
    private static void nactiARGB() {
        Set<Map.Entry<String, BufferedImage>> set = obrazky.entrySet();
        for (Map.Entry<String, BufferedImage> entry : set) {
            pixely.put(entry.getKey(), getARGB(obrazky.get(entry.getKey())));
        }
    }

    /**
     * Nastaví kontrast na požadovanou hodnotu
     * @param value hodnota kontrastu (-255 až 255)
     */
    public static void nastavKontrast(int value) {
        kontrast = 259.0f * (value + 255) / (255 * (259 - value));
        rescale();
    }

    /**
     * Nastaví jas na požadovanou hodnotu
     * @param value hodnota jasu (-255 až 255)
     */
    public static void nastavJas(final int value) {
        jas = value;
        rescale();

    }

    /**
     * Provede úpravu obrázků na základě změny jasu nebo kontrastu.
     * Přizpůsobí jednotlivé pixely všech obrázků podle nastavených hodnot a uloží je do obrázků a do ikon (v pixelech zůstanou vždy původní hodnoty originálního obrázku)
     */
    private static void rescale() {
        Set<Entry<String, int[][]>> set = pixely.entrySet();
        for (Map.Entry<String, int[][]> entry : set) {
            BufferedImage image = obrazky.get(entry.getKey());
            int[][] argb = pixely.get(entry.getKey());
            int count = 0;
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    image.setRGB(x, y, parseRGB(newPix(argb[count][0]), newPix(argb[count][1]), newPix(argb[count][2]), argb[count][3]));
                    count++;
                }
            }
        }
        Set<String> keys = ikony.keySet();
        for (String nazev : keys) {
            ikony.put(nazev, new ImageIcon(obrazky.get(nazev)));
        }
    }

    /**
     * Změní barvu fontu na základě nastaveného jasu
     */
    public static void zmenFont() {
        stupenSedi = (int) ((jas + 200) * 0.25);
        barvaFontu = new Color(stupenSedi, stupenSedi, stupenSedi);
        for (Hrac h : Hra.getInstance().getHraci()) {
            h.getJmenovka().aktualizujFont();
        }
        HerniPlochaController.getInstance().aktualizujFont();
    }

    /**
     * Vrátí obrázek na základě jeho ID
     * @param ID    ID obrázku
     * @return      obrázek s /p ID
     */
    public static BufferedImage get(String ID) {
        return obrazky.get(ID);
    }
    
    /**
     * Vrátí ikonu na základě její ID
     * @param ID    ID ikony
     * @return      ikona s /p ID
     */
    public static ImageIcon getIcon(String ID) {
        return ikony.get(ID);
    }

    /**
     * Načte hodnoty obrázku ve formátu TYPE_INT_ARGB jako pixelovou reprezentaci
     * @param image obrázek
     * @return      pixelová reprezentace obrázku
     */
    private static int[][] getARGB(BufferedImage image) {
        int sirka = image.getWidth();
        int vyska = image.getHeight();
        int[][] res = new int[sirka * vyska][4];
        int count = 0;
        for (int y = 0; y < vyska; y++) {
            for (int x = 0; x < sirka; x++) {
                res[count] = getPixelARGB(image, x, y);
                count++;
            }
        }
        return res;
    }

    /**
     * Dekóduje hodnotu ARGB pixelu na souřadnicích x,y daného obrázku
     * @param image obrázek
     * @param x     x-ová souřadnice pixelu
     * @param y     y-ová souřadnice pixelu
     * @return      reprezentace pixelu - red, green, blue, alpha
     */
    private static int[] getPixelARGB(BufferedImage image, int x, int y) {
        int argb = image.getRGB(x, y);
        return new int[]{(argb >> 16) & 0xff, //red
            (argb >> 8) & 0xff, //green
            argb & 0xff, //blue
            (argb >> 24) & 0xff};//alpha
    }

    /**
     * Vrátí přetransformovaný vstupní pixel na základě úrovně jasu a kontrastu
     * @param pixel originální pixel reprezentovaný jako 32 bitový int
     * @return      transformovaný pixel
     */
    private static int newPix(int pixel) {
        int tmp = (int) (kontrast * (pixel - 128) + 128 + jas);
        if (tmp < 0) {
            return 0;
        }
        if (tmp > 255) {
            return 255;
        }
        return tmp;
    }

    /**
     * Převede hodnoty jednotlivých kanálů na reprezentaci pomocí TYPE_INT_ARGB (32 bitový int)
     * @param red   červený kanál
     * @param green zelený kanál
     * @param blue  modrý kanál
     * @param alpha alfa kanál
     * @return      pixel složený z jednotlivých kanálů
     */
    private static int parseRGB(int red, int green, int blue, int alpha) {
        int color = 0;
        color |= alpha << 24;
        color |= red << 16;
        color |= green << 8;
        color |= blue;
        return color;
    }

}
