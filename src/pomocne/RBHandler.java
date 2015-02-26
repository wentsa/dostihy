/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocne;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import self.chalupnik.tomas.encoder.Encoder;

/**
 *
 * @author wentsa
 */
public class RBHandler {
    
    private Locale loc;
    private ResourceBundle rb;
    
    private static RBHandler instance = null;
    
    public synchronized static RBHandler getInstance() {
        if(instance == null) {
            instance = new RBHandler();
        }
        return instance;
    }
    
    private RBHandler() {
        //File ifile = new File(this.getClass().getClassLoader().getResource("rb/Resources_cs.properties").getFile());
        //Encoder.convertToUnicode(ifile.getPath());
    }
    
    public void setLocale(Locale locale) {
        loc = locale;
        rb = ResourceBundle.getBundle("rb/Resources", loc);
    }
    
    public String getRBString(String key) {
        return rb.getString(key);
    }
}
