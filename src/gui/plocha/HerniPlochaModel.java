/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.plocha;

import grafika.GraphicsHandler;
import gui.JasDialog;
import gui.NapovedaDialog;
import gui.Pravidla;
import gui.Rozliseni;
import gui.slider.SliderController;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import pomocne.Konstanty;

/**
 *
 * @author wentsa
 */
public class HerniPlochaModel {

    protected static void smazInstance() {
        instance = null;
    }

    private BufferedImage aktualniPrava = GraphicsHandler.get(Konstanty.Graphics.RIGHT_BOARD_INACTIVE);

    private boolean zapnutyKostky;
    private final SliderController slider;
    private int ukladacOption;
    private int nacitacOption;
    private boolean ukoncenTah;
    private final NapovedaDialog napoveda = new NapovedaDialog();
    private final JDialog pravidla = new JDialog();
    private final JasDialog jas = new JasDialog();
    private final JDialog rozliseni = new JDialog();

    private static HerniPlochaModel instance = null;

    protected static HerniPlochaModel getInstance() {
        if (instance == null) {
            instance = new HerniPlochaModel();
        }
        return instance;
    }

    private HerniPlochaModel() {
        ukoncenTah = false;
        this.slider = new SliderController();

        pravidla.setModal(true);
        pravidla.setContentPane(new Pravidla(false));
        pravidla.pack();
        pravidla.setLocationRelativeTo(null);
        pravidla.setVisible(false);

        rozliseni.setModal(true);
        rozliseni.setContentPane(new Rozliseni());
        rozliseni.pack();
        rozliseni.setLocationRelativeTo(null);
        rozliseni.setVisible(false);
    }

    protected void vypniKostky() {
        zapnutyKostky = false;
        aktualniPrava = GraphicsHandler.get(Konstanty.Graphics.RIGHT_BOARD_INACTIVE);
    }

    protected void zapniKostky() {
        zapnutyKostky = true;
        aktualniPrava = GraphicsHandler.get(Konstanty.Graphics.RIGHT_BOARD_ACTIVE);
    }

    protected void nactiPravou() {
        if (zapnutyKostky) {
            aktualniPrava = GraphicsHandler.get(Konstanty.Graphics.RIGHT_BOARD_ACTIVE);
        } else {
            aktualniPrava = GraphicsHandler.get(Konstanty.Graphics.RIGHT_BOARD_INACTIVE);
        }
        slider.nactiIkonu();

    }

    protected Image getPlochu() {
        return GraphicsHandler.get(Konstanty.Graphics.MAIN_BOARD);
    }

    protected Image getStred() {
        return GraphicsHandler.get(Konstanty.Graphics.MIDDLE_BOARD);
    }

    protected Image getAktualniPr() {
        return aktualniPrava;
    }

    protected Image getSt_d() {
        return GraphicsHandler.get(Konstanty.Graphics.BOTTOM_BAR);
    }

    protected BufferedImage getStatusP() {
        return GraphicsHandler.get(Konstanty.Graphics.STATUS_BAR);
    }

    protected int getUkladacOption() {
        return ukladacOption;
    }

    protected void setUkladacOption(int ukladacOption) {
        this.ukladacOption = ukladacOption;
    }

    protected int getNacitacOption() {
        return nacitacOption;
    }

    protected void setNacitacOption(int nacitacOption) {
        this.nacitacOption = nacitacOption;
    }

    protected ImageIcon getUkoncit() {
        return GraphicsHandler.getIcon(Konstanty.Graphics.Icons.END_ROUND_BUTTON_INACTIVE);
    }

    protected ImageIcon getProdat() {
        return GraphicsHandler.getIcon(Konstanty.Graphics.Icons.SELL_BUTTON);
    }

    protected ImageIcon getVzdat() {
        return GraphicsHandler.getIcon(Konstanty.Graphics.Icons.GIVE_UP_BUTTON);
    }

    protected void setUkoncenTah(boolean b) {
        ukoncenTah = b;
    }

    protected boolean isUkoncenTah() {
        return ukoncenTah;
    }

    protected SliderController getSlider() {
        return slider;
    }

    protected ImageIcon getUkoncitAktiv() {
        return GraphicsHandler.getIcon(Konstanty.Graphics.Icons.END_ROUND_BUTTON_ACTIVE);
    }

    /**
     * @return the napoveda
     */
    public NapovedaDialog getNapoveda() {
        return napoveda;
    }

    /**
     * @return the pravidla
     */
    public JDialog getPravidla() {
        return pravidla;
    }

    protected JasDialog getJas() {
        return jas;
    }

    protected JDialog getRozliseni() {
        return rozliseni;
    }

}
