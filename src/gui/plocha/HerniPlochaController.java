/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.plocha;

import audio.SoundHandler;
import grafika.GraphicsHandler;
import gui.dostih.DostihController;
import hra.Hra;
import hra.Hrac;
import gui.Kostka;
import hra.Policko;
import gui.JasDialog;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import karty.vlastnicke.Kun;

/**
 *
 * @author wentsa
 */
public class HerniPlochaController {

    

    private final HerniPlochaModel model;
    private final HerniPlochaView view;

    private static HerniPlochaController instance=null;
    
    
    public static HerniPlochaController getInstance() {
        if(instance==null) {
            instance= new HerniPlochaController();
        }
        return instance;
    }
    
    public static void smazInstance() {
        HerniPlochaModel.smazInstance();
        HerniPlochaView.smazInstance();
        Hra.smazInstance();
        instance=null;
    }
    
    private HerniPlochaController() {
        System.out.println("Audio");
        SoundHandler.inicializovat();
        System.out.println("Grafiku");
        GraphicsHandler.inicializovat();
        model = HerniPlochaModel.getInstance();
        System.out.println("Herní prostředí");
        view= HerniPlochaView.getInstance(this);
        System.out.println("Pole + dostihy");
        nactiPole();
        nactiKostku();
        view.pridejSlider(model.getSlider().getView());
    }
    
    
    public HerniPlochaView getView() {
        return view;
    }

    public void nactiHrace() {
        for (Hrac h : Hra.getInstance().getHraci()) {
            view.pridejHrace(h);
        }
    }

    public void aktualizujFont() {
        view.aktualizujFont();
    }
    private void nactiPole() {
        for (final Policko p : Hra.getInstance().getPolicka()) {
            if (p.isVlastnicka()) {

                view.pridejPolicko(p);

                if (p.getKarta() instanceof Kun) {
                    Kun kun = (Kun) p.getKarta();
                    for (DostihController d : kun.getDostihy()) {
                        view.pridejDostih(d.getView());
                        view.pridejDostih(kun.getHlavniDostih().getView());
                    }
                }
            }
        }
    }

    private void nactiKostku() {
        Kostka k = Hra.getInstance().getKostka();
        k.pridejListener();
        view.pridejKostku(k);
    }

    public void zapniKostky() {
        model.zapniKostky();
    }
    
    public void vypniKostky() {
        model.vypniKostky();
    }

    protected Image getPl() {
        return model.getPlochu();
    }

    protected Image getSt() {
        return model.getStred();
    }

    protected Image getAktualniPr() {
        return model.getAktualniPr();
    }

    public BufferedImage getStatusP() {
        return model.getStatusP();
    }

    protected Image getSt_d() {
        return model.getSt_d();
    }

    protected void setUkladacOption(int showSaveDialog) {
        model.setUkladacOption(showSaveDialog);
    }

    protected void ulozHru(File selectedFile) {
        if (model.getUkladacOption() == JFileChooser.APPROVE_OPTION) {
            try {
                File f;
                if (selectedFile.getAbsolutePath().toLowerCase().endsWith(".das")) {
                    f = selectedFile;
                } else {
                    f = new File(selectedFile + ".das");
                }
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
                    Hra.getInstance().pripravUlozeni();
                    oos.writeObject(Hra.getInstance());
                    Hra.getInstance().vratPredUlozeni();
                }
            } catch (IOException ex) {
                Logger.getLogger(HerniPlochaView.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void nactiHru(File selectedFile) {
        if (model.getNacitacOption() == JFileChooser.APPROVE_OPTION) {
            if(selectedFile==null) {
                return;
            }
            ObjectInputStream ois = null;
            try {
                if ("".equals(selectedFile.getName())) {
                    return;
                }
                ois = new ObjectInputStream(new FileInputStream(selectedFile));
                System.out.println("A");
                Hra.changeInstance((Hra) ois.readObject());
                ois.close();
                System.out.println("B");
                Hra.getInstance().getCaller().nastavPropertyChangeSupport();
                System.out.println("C");
                Hra.getInstance().nastavStatusBox();
                System.out.println("D");
                view.vycistiPlochu();
                view.pridejSlider(model.getSlider().getView());
                System.out.println("E");
                nactiHrace();
                System.out.println("F");
                nactiPole();
                System.out.println("G");
                nactiKostku();
                System.out.println("H");
                view.repaint();
                System.out.println("I");
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(HerniPlochaView.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(HerniPlochaView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    protected void setNacitacOption(int showOpenDialog) {
        model.setNacitacOption(showOpenDialog);
    }

    public void nastavKontrast(int value) {
        GraphicsHandler.nastavKontrast(value);
        view.repaint();
    }

    public void nastavJas(int value) {
        GraphicsHandler.nastavJas(value);
        view.repaint();
    }

    protected ImageIcon getUkoncit() {
        return model.getUkoncit();
    }
    protected ImageIcon getUkoncitAktiv() {
        return model.getUkoncitAktiv();
    }
    protected ImageIcon getProdat() {
        return model.getProdat();
    }
    protected ImageIcon getVzdat() {
        return model.getVzdat();
    }

    public void setUkoncenTah(boolean b) {
        model.setUkoncenTah(b);
    }

    public void zapniTlacitko() {
        view.zapniTlacitko();
    }

    public boolean isUkoncenTah() {
        return model.isUkoncenTah();
    }

    public void vypniTlacitko() {
        view.vypniTlacitko();
    }

    public void odpalVzdatSe() {
        view.vzdatSe();
    }
    public void aktualizujSlider() {
        model.getSlider().setSouradniceY(Hra.getInstance().getAktualniHrac().getJmenovka().getSouradniceY());
        
    }
    public JFileChooser getNacitac() {
        return view.getNacitac();
    }
    
    public void nastavVolbuNacitace(int volba) {
        model.setNacitacOption(volba);
    }
    
    public int getNacitacOption() {
        return model.getNacitacOption();
    }

    protected void zobrazNapovedu() {
        model.getNapoveda().setVisible(true);
    }

    protected void zobrazPravidla() {
        model.getPravidla().setVisible(true);
    }
    
    protected void zobrazJas() {
        (new Thread() {
            @Override
            public void run() {
                model.getJas().setVisible(true);
            }
        }).start();
        
    }
    

}
