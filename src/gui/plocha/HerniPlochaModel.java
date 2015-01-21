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
import gui.slider.SliderController;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

/**
 *
 * @author wentsa
 */
public class HerniPlochaModel {

    protected static void smazInstance() {
        instance=null;
    }
    
    private BufferedImage aktualniPrava=GraphicsHandler.get("prava");
    
    private final SliderController slider;
    private int ukladacOption;
    private int nacitacOption;
    private boolean ukoncenTah;
    private final NapovedaDialog napoveda=new NapovedaDialog();
    private final JDialog pravidla=new JDialog();
    private final JasDialog jas=new JasDialog();
    
    private static HerniPlochaModel instance=null;
    
    
    protected static HerniPlochaModel getInstance() {
        if(instance==null) {
            instance= new HerniPlochaModel();
        }
        return instance;
    }
    
    private HerniPlochaModel() {
        ukoncenTah=false;
        this.slider=new SliderController();
        pravidla.setModal(true);
        pravidla.setContentPane(new Pravidla(false));
        pravidla.pack();
        pravidla.setLocationRelativeTo(null);
        pravidla.setVisible(false);
    }

    protected void vypniKostky() {
        aktualniPrava = GraphicsHandler.get("prava");
    }
    
    protected void zapniKostky() {
        aktualniPrava = GraphicsHandler.get("prava_aktiv");
    }

    protected Image getPlochu() {
        return GraphicsHandler.get("plocha");
    }

    protected Image getStred() {
        return GraphicsHandler.get("stred");
    }

    protected Image getAktualniPr() {
        return aktualniPrava;
    }

    protected Image getSt_d() {
        return GraphicsHandler.get("spodek_lista");
    }

    protected BufferedImage getStatusP() {
        return GraphicsHandler.get("status");
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
        return GraphicsHandler.getIcon("ukoncit");
    }
    protected ImageIcon getProdat() {
        return GraphicsHandler.getIcon("prodat");
    }
    protected ImageIcon getVzdat() {
        return GraphicsHandler.getIcon("vzdat");
    }

    protected void setUkoncenTah(boolean b) {
        ukoncenTah=b;
    }

    protected boolean isUkoncenTah() {
        return ukoncenTah;
    }
    protected SliderController getSlider() {
        return slider;
    }

    protected ImageIcon getUkoncitAktiv() {
        return GraphicsHandler.getIcon("ukoncit_aktiv");
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
    
    
}


