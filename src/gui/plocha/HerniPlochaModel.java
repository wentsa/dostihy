/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.plocha;

import grafika.GraphicsHandler;
import gui.slider.SliderController;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

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
    }

    void prepniKostky() {
        if (aktualniPrava.equals(GraphicsHandler.get("prava"))) {
            aktualniPrava = GraphicsHandler.get("prava_aktiv");
            System.out.println("---zapnul kostky");
        } else {
            aktualniPrava = GraphicsHandler.get("prava");
            System.out.println("---vypnul kostky");
        }
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
    
    
}


