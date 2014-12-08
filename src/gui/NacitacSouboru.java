/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dostihy.Control;
import dostihy.Hra;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author wentsa
 */
public class NacitacSouboru extends JFileChooser {

    public NacitacSouboru() {
        setAcceptAllFileFilterUsed(false);
        setCurrentDirectory(new java.io.File("/home/wentsa"));
        setDialogTitle("");
        setFileFilter(new FileNameExtensionFilter("Ulozene hry (.das)", "DAS"));
    }

    public void vyhodnot() {

        ObjectInputStream ois = null;
        try {
            if ("".equals(getSelectedFile().getName())) {
                return;
            }
            ois = new ObjectInputStream(new FileInputStream(getSelectedFile()));
            Hra.changeInstance((Hra) ois.readObject());
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(HerniPlocha.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(HerniPlocha.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
