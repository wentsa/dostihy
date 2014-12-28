/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.plocha;

import gui.slider.SliderController;
import gui.slider.SliderView;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import javax.swing.ImageIcon;

/**
 *
 * @author wentsa
 */
public class HerniPlochaModel {

    protected static void smazInstance() {
        instance=null;
    }
    private final BufferedImage plocha,plochaOrig,
                                stred,stredOrig,
                                prava, pravaOrig, pravaAktiv, pravaAktivOrig,
                                stredSpodek, stredSpodekOrig,
                                statusBox,statusBoxOrig,
                                ukoncit, ukoncitOrig,
                                prodat, prodatOrig,
                                vzdat, vzdatOrig,
                                ukoncitAktiv, ukoncitAktivOrig;
    private BufferedImage       aktualniPrava;
    private ImageIcon           ukoncitIcon,
                                prodatIcon,
                                vzdatIcon,
                                ukoncitAktivIcon;
    private final SliderController slider;
    private int ukladacOption;
    private int nacitacOption;
    private float scale;
    private float offset;
    private boolean ukoncenTah;
    
    private static HerniPlochaModel instance=null;
    
    
    protected static HerniPlochaModel getInstance() {
        if(instance==null) {
            instance= new HerniPlochaModel();
        }
        return instance;
    }
    
    private HerniPlochaModel() {
        scale=1.0f;
        offset=0;
        ukoncenTah=false;
        Image tmp=new ImageIcon(HerniPlochaView.class.getResource("/plocha.jpg")).getImage();
        plochaOrig = new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        plocha = new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        Graphics2D gr=plochaOrig.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        gr=plocha.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        
        tmp = new ImageIcon(HerniPlochaView.class.getResource("/stred.jpg")).getImage();
        stredOrig = new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        stred= new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        gr=stredOrig.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        gr=stred.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        
        tmp = new ImageIcon(HerniPlochaView.class.getResource("/prava.jpg")).getImage();
        pravaOrig = new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        aktualniPrava = prava = new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        gr=pravaOrig.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        gr=prava.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        
        tmp = new ImageIcon(HerniPlochaView.class.getResource("/prava-aktiv.jpg")).getImage();
        pravaAktivOrig= new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        pravaAktiv= new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        gr=pravaAktivOrig.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        gr=pravaAktiv.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        
        tmp = new ImageIcon(HerniPlochaView.class.getResource("/spodek_lista.jpg")).getImage();
        stredSpodekOrig= new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        stredSpodek= new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        gr=stredSpodekOrig.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        gr=stredSpodek.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        
        tmp = new ImageIcon(HerniPlochaView.class.getResource("/status.jpg")).getImage();
        statusBoxOrig= new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        statusBox= new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        gr=statusBoxOrig.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        gr=statusBox.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        
        tmp = new ImageIcon(HerniPlochaView.class.getResource("/ukoncit.jpg")).getImage();
        ukoncit= new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        ukoncitOrig= new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        gr=ukoncitOrig.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        gr=ukoncit.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        ukoncitIcon=new ImageIcon(ukoncit);
        
        tmp = new ImageIcon(HerniPlochaView.class.getResource("/ukoncit-aktiv.jpg")).getImage();
        ukoncitAktiv= new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        ukoncitAktivOrig= new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        gr=ukoncitAktivOrig.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        gr=ukoncitAktiv.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        ukoncitAktivIcon=new ImageIcon(ukoncitAktiv);
        
        tmp = new ImageIcon(HerniPlochaView.class.getResource("/prodat.jpg")).getImage();
        prodatOrig= new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        prodat= new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        gr=prodatOrig.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        gr=prodat.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        prodatIcon=new ImageIcon(prodat);
        
        tmp = new ImageIcon(HerniPlochaView.class.getResource("/vzdat.jpg")).getImage();
        vzdatOrig= new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        vzdat= new BufferedImage(tmp.getWidth(null), tmp.getHeight(null), BufferedImage.TYPE_USHORT_565_RGB);
        gr=vzdatOrig.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        gr=vzdat.createGraphics();
        gr.drawImage(tmp, 0,0,null);
        vzdatIcon=new ImageIcon(vzdat);
        
        gr.dispose();
        
        this.slider=new SliderController();
    }

    void prepniKostky() {
        if (aktualniPrava.equals(prava)) {
            aktualniPrava = pravaAktiv;
            System.out.println("---zapnul kostky");
        } else {
            aktualniPrava = prava;
            System.out.println("---vypnul kostky");
        }
    }

    protected Image getPl() {
        return plocha;
    }

    protected Image getSt() {
        return stred;
    }

    protected Image getAktualniPr() {
        return aktualniPrava;
    }

    protected Image getSt_d() {
        return stredSpodek;
    }

    protected Image getStatusP() {
        return statusBox;
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

    protected void nastavKontrast(int value) {
        scale=value/10f;
        rescale();
    }

    protected void nastavJas(int value) {
        offset=value-20;
        rescale();
        ukoncitIcon=new ImageIcon(ukoncit);
        prodatIcon=new ImageIcon(prodat);
        vzdatIcon=new ImageIcon(vzdat);
        ukoncitAktivIcon=new ImageIcon(ukoncitAktiv);
    }
    private void rescale() {
        RescaleOp rescaleOp = new RescaleOp(scale,offset, null);
        rescaleOp.filter(plochaOrig, plocha);
        rescaleOp.filter(stredOrig, stred);
        rescaleOp.filter(pravaOrig, prava);
        rescaleOp.filter(pravaAktivOrig, pravaAktiv);
        rescaleOp.filter(stredSpodekOrig, stredSpodek);
        rescaleOp.filter(statusBoxOrig, statusBox);
        rescaleOp.filter(ukoncitOrig, ukoncit);
        rescaleOp.filter(prodatOrig, prodat);
        rescaleOp.filter(vzdatOrig, vzdat);
        rescaleOp.filter(ukoncitAktivOrig, ukoncitAktiv);
    }

    protected BufferedImage getBoxPozadi() {
        return statusBox;
    }

    protected ImageIcon getUkoncit() {
        return ukoncitIcon;
    }
    protected ImageIcon getProdat() {
        return prodatIcon;
    }
    protected ImageIcon getVzdat() {
        return vzdatIcon;
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
        return ukoncitAktivIcon;
    }
    
    
}


