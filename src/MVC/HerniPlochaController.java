/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import dostihy.Hra;
import dostihy.Hrac;
import dostihy.Kostka;
import dostihy.Policko;
import gui.Dostihy;
import gui.TEST;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import karty.Kun;

/**
 *
 * @author wentsa
 */
public class HerniPlochaController {

    private final HerniPlochaModel model = HerniPlochaModel.getInstance();
    private final HerniPlochaView view= HerniPlochaView.getInstance(this);

    private static HerniPlochaController instance=null;
    
    
    public static HerniPlochaController getInstance() {
        if(instance==null) {
            instance= new HerniPlochaController();
        }
        return instance;
    }
    
    private HerniPlochaController() {
        nactiPole();
        nactiKostku();
    }
    
    
    public HerniPlochaView getView() {
        return view;
    }

    public void nactiHrace() {
        for (Hrac h : Hra.getInstance().getHraci()) {
            view.pridejHrace(h);
        }
    }

    private void nactiPole() {
        for (final Policko p : Hra.getInstance().getPolicka()) {
            if (p.isVlastnicka()) {

                p.setOpaque(false);
                p.setContentAreaFilled(false);
                p.setBorderPainted(false);
                p.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            p.getKarta().zobraz();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(HerniPlochaView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                view.pridejPolicko(p);

                if (p.getKarta() instanceof Kun) {
                    Kun kun = (Kun) p.getKarta();
                    for (Dostihy d : kun.getDostihy()) {
                        view.pridejDostih(d);
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

    public void prepniKostky() {
        model.prepniKostky();
    }

    protected Image getPl() {
        return model.getPl();
    }

    protected Image getSt() {
        return model.getSt();
    }

    protected Image getAktualniPr() {
        return model.getAktualniPr();
    }

    protected Image getStatusP() {
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
                    oos.writeObject(Hra.getInstance());
                }
            } catch (IOException ex) {
                Logger.getLogger(HerniPlochaView.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    protected void nactiHru(File selectedFile) {
        if (model.getNacitacOption() == JFileChooser.APPROVE_OPTION) {

            ObjectInputStream ois = null;
            try {
                if ("".equals(selectedFile.getName())) {
                    return;
                }
                ois = new ObjectInputStream(new FileInputStream(selectedFile));
                Hra.changeInstance((Hra) ois.readObject());
                ois.close();
                view.vycistiPlochu();
                nactiHrace();
                nactiPole();
                nactiKostku();
                view.repaint();
                System.out.println(Hra.getInstance().getHraci().get(0).getRozpocet());
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
        model.nastavKontrast(value);
        view.repaint();
    }

    public void nastavJas(int value) {
        model.nastavJas(value);
        view.repaint();
    }

    public BufferedImage getBoxPozadi() {
        return model.getBoxPozadi();
    }

    protected ImageIcon getUkoncit() {
        return model.getUkoncit();
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
    

}
