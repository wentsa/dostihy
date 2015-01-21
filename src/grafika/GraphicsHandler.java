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
 */
public class GraphicsHandler {

    private static Map<String, BufferedImage> obrazky;
    private static Map<String, ImageIcon> ikony;
    private static int jas = 0;
    private static float kontrast = 1.0f;
    public static Color barvaFontu;
    private static int stupenSedi;
    private static Map<String, int[][]> pixely;

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

    private static String parseColor(Barva barva) {
        return barva.toString().toLowerCase();
    }

    public static void nactiFigurku(String ID, Barva barva) {
        nactiIkonu("fig/" + parseColor(barva), "png", ID);
        pixely.put(ID, getARGB(obrazky.get(ID)));
        rescale();
    }

    public static void nactiDostih(String ID, boolean hlavniDostih) {
        nactiIkonu("dostih" + (hlavniDostih ? "2" : ""), "png", ID);
        pixely.put(ID, getARGB(obrazky.get(ID)));
        rescale();
    }

    public static void nactiPuntik(String ID, Barva barva) {
        nactiIkonu("puntiky/" + parseColor(barva) + "p", "png", ID);
        pixely.put(ID, getARGB(obrazky.get(ID)));
    }

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

    private static void nactiIkonu(String soubor, String pripona, String ID) {
        nacti(soubor, pripona, ID);
        if (ID == null) {
            ID = soubor;
        }
        ikony.put(ID, new ImageIcon(obrazky.get(ID)));
    }

    private static void nactiARGB() {
        System.out.println("zacinam nacitat");
        Set<Map.Entry<String, BufferedImage>> set = obrazky.entrySet();
        for (Map.Entry<String, BufferedImage> entry : set) {
            pixely.put(entry.getKey(), getARGB(obrazky.get(entry.getKey())));
        }

        System.out.println("koncim");
    }

    public static void nastavKontrast(int value) {
        kontrast = 259.0f * (value + 255) / (255 * (259 - value));
        rescale();
    }

    public static void nastavJas(final int value) {
        jas = value;
        rescale();

    }

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

    public static void zmenFont() {
        stupenSedi = (int) ((jas + 200) * 100 / 400);
        barvaFontu = new Color(stupenSedi, stupenSedi, stupenSedi);
        for (Hrac h : Hra.getInstance().getHraci()) {
            h.getJmenovka().aktualizujFont();
        }
        HerniPlochaController.getInstance().aktualizujFont();
    }

    public static BufferedImage get(String nazev) {
        return obrazky.get(nazev);
    }

    public static ImageIcon getIcon(String nazev) {
        return ikony.get(nazev);
    }

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

    private static int[] getPixelARGB(BufferedImage image, int x, int y) {
        int argb = image.getRGB(x, y);
        return new int[]{(argb >> 16) & 0xff, //red
            (argb >> 8) & 0xff, //green
            argb & 0xff, //blue
            (argb >> 24) & 0xff};//alpha
    }

    private static int newPix(int x) {
        int tmp = (int) (kontrast * (x - 128) + 128 + jas);
        if (tmp < 0) {
            return 0;
        }
        if (tmp > 255) {
            return 255;
        }
        return tmp;
    }

    private static int parseRGB(int red, int green, int blue, int alpha) {
        int color = 0;
        color |= alpha << 24;
        color |= red << 16;
        color |= green << 8;
        color |= blue;
        return color;
    }

}
