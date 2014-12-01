/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dostihy.Control;
import dostihy.Hra;
import dostihy.Hrac;
import dostihy.Kostka;
import dostihy.Policko;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import karty.Kun;

/**
 *
 * @author wentsa
 */
public class HerniPlocha extends javax.swing.JFrame {

    Hra hra;
    Image pl;
    Image st;
    Image pr,pr2;
    Image aktualniPr;
    Image st_d;
    Image statusP;
    int ukladacOption;
    int nacitacOption;
    private boolean ukoncenTah=false;
    /**
     * Creates new form HerniPlocha
     * @param hra
     */
    public HerniPlocha() {
        this.hra=Control.hra;
        pl=new ImageIcon(HerniPlocha.class.getResource("/plocha.jpg")).getImage();
        st=new ImageIcon(HerniPlocha.class.getResource("/stred.jpg")).getImage();
        aktualniPr=pr=new ImageIcon(HerniPlocha.class.getResource("/prava.jpg")).getImage();
        pr2=new ImageIcon(HerniPlocha.class.getResource("/prava-aktiv.jpg")).getImage();
        st_d=new ImageIcon(HerniPlocha.class.getResource("/spodek_lista.jpg")).getImage();
        statusP=new ImageIcon(HerniPlocha.class.getResource("/status.jpg")).getImage();
        
        initComponents();
        
        nactiHrace();
        nactiPole();
        nactiKostku();
        //nactiStatusBox();
        
        
        setLocationRelativeTo(null);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nacitacSouboru = new javax.swing.JFileChooser();
        ukladacSouboru = new javax.swing.JFileChooser() {
            @Override
            public void approveSelection(){
                File f = getSelectedFile();
                File f2=new File(getSelectedFile()+".das");
                if((f.exists() || f.exists()) && getDialogType() == SAVE_DIALOG){
                    Object[] volby={"Ano","Ne"};
                    int result = JOptionPane.showOptionDialog(this,"Tento soubor jiz existuje. Prejete si jej prepsat?","Soubor existuje",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, volby, volby[0]);
                    switch(result){
                        case JOptionPane.YES_OPTION:
                        super.approveSelection();
                        return;
                        case JOptionPane.NO_OPTION:
                        return;
                        case JOptionPane.CLOSED_OPTION:
                        return;
                        case JOptionPane.CANCEL_OPTION:
                        cancelSelection();
                        return;
                    }
                }
                super.approveSelection();
            }
        };
        cela_plocha = new javax.swing.JSplitPane();
        hlavni_plocha = new javax.swing.JPanel();
        plocha = new javax.swing.JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(pl, 0, 0, null);
            }
        };
        stred = new javax.swing.JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(st, 0, 0, null);
            }
        };
        prava = new javax.swing.JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(aktualniPr, 0, 0, null);
            }
        };
        cely_spodek = new javax.swing.JSplitPane();
        leva = new javax.swing.JSplitPane();
        statusB = new javax.swing.JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(statusP, 0, 0, null);
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        statusBoxik = Control.hra.getStatusBox();
        stredD = new javax.swing.JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(st_d, 0, 0, null);
            }};
            tlacitka = new javax.swing.JPanel();
            ukoncit = new javax.swing.JButton();
            prodat = new javax.swing.JButton();
            vzdat = new javax.swing.JButton();
            menuBar = new javax.swing.JMenuBar();
            soubor = new javax.swing.JMenu();
            nacist = new javax.swing.JMenuItem();
            ulozit = new javax.swing.JMenuItem();
            upravit = new javax.swing.JMenu();

            nacitacSouboru.setAcceptAllFileFilterUsed(false);
            nacitacSouboru.setCurrentDirectory(new java.io.File("/home/wentsa"));
            nacitacSouboru.setDialogTitle("");
            nacitacSouboru.setFileFilter(new FileNameExtensionFilter("Ulozene hry (.das)", "DAS"));
            nacitacSouboru.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nacitacSouboruActionPerformed(evt);
                }
            });

            ukladacSouboru.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ukladacSouboruActionPerformed(evt);
                }
            });

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setBackground(new java.awt.Color(255, 0, 0));
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

            cela_plocha.setBorder(null);
            cela_plocha.setDividerSize(0);
            cela_plocha.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
            cela_plocha.setMinimumSize(new java.awt.Dimension(1280, 750));
            cela_plocha.setPreferredSize(new java.awt.Dimension(1280, 750));

            hlavni_plocha.setBackground(new java.awt.Color(1, 1, 1));
            hlavni_plocha.setBorder(null);
            hlavni_plocha.setMaximumSize(new java.awt.Dimension(1280, 700));
            hlavni_plocha.setMinimumSize(new java.awt.Dimension(1280, 700));
            hlavni_plocha.setPreferredSize(new java.awt.Dimension(1280, 700));
            hlavni_plocha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            plocha.setBackground(new java.awt.Color(0, 255, 221));
            plocha.setBorder(null);
            plocha.setMaximumSize(new java.awt.Dimension(700, 700));
            plocha.setMinimumSize(new java.awt.Dimension(700, 700));
            plocha.setLayout(new javax.swing.OverlayLayout(plocha));
            hlavni_plocha.add(plocha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 701));

            stred.setBackground(new java.awt.Color(0, 176, 255));
            stred.setBorder(null);
            stred.setMaximumSize(new java.awt.Dimension(100, 700));
            stred.setMinimumSize(new java.awt.Dimension(100, 700));
            stred.setPreferredSize(new java.awt.Dimension(100, 700));
            stred.setLayout(new javax.swing.OverlayLayout(stred));
            hlavni_plocha.add(stred, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, -1, -1));

            prava.setBackground(new java.awt.Color(0, 108, 255));
            prava.setBorder(null);
            prava.setMaximumSize(new java.awt.Dimension(480, 700));
            prava.setMinimumSize(new java.awt.Dimension(480, 700));
            prava.setName(""); // NOI18N
            prava.setLayout(new javax.swing.OverlayLayout(prava));
            hlavni_plocha.add(prava, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 480, 700));

            cela_plocha.setLeftComponent(hlavni_plocha);

            cely_spodek.setBorder(null);
            cely_spodek.setDividerLocation(800);
            cely_spodek.setDividerSize(0);
            cely_spodek.setMaximumSize(new java.awt.Dimension(1280, 2147483647));
            cely_spodek.setMinimumSize(new java.awt.Dimension(1280, 50));
            cely_spodek.setPreferredSize(new java.awt.Dimension(1280, 50));

            leva.setBorder(null);
            leva.setDividerLocation(700);
            leva.setDividerSize(0);
            leva.setLastDividerLocation(700);
            leva.setMaximumSize(new java.awt.Dimension(800, 50));
            leva.setMinimumSize(new java.awt.Dimension(800, 50));
            leva.setPreferredSize(new java.awt.Dimension(800, 50));

            statusB.setBackground(new java.awt.Color(0, 24, 255));
            statusB.setBorder(null);
            statusB.setMaximumSize(new java.awt.Dimension(100, 50));
            statusB.setMinimumSize(new java.awt.Dimension(100, 50));
            statusB.setPreferredSize(new java.awt.Dimension(100, 50));
            statusB.setLayout(new javax.swing.OverlayLayout(statusB));

            jScrollPane1.setBackground(new Color(0,0,0,0));
            jScrollPane1.setBorder(null);
            jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

            statusBoxik.setEditable(false);
            statusBoxik.setBackground(new Color(0,0,0,0));
            statusBoxik.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 20, 10, 20));
            statusBoxik.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
            statusBoxik.setForeground(new java.awt.Color(29, 29, 29));
            statusBoxik.setOpaque(false);
            jScrollPane1.setViewportView(statusBoxik);

            statusB.add(jScrollPane1);

            leva.setLeftComponent(statusB);
            leva.setRightComponent(stredD);

            cely_spodek.setLeftComponent(leva);

            tlacitka.setBackground(new java.awt.Color(93, 93, 93));
            tlacitka.setBorder(null);
            tlacitka.setMaximumSize(new java.awt.Dimension(480, 50));
            tlacitka.setMinimumSize(new java.awt.Dimension(480, 50));
            tlacitka.setPreferredSize(new java.awt.Dimension(480, 50));
            tlacitka.setLayout(new javax.swing.BoxLayout(tlacitka, javax.swing.BoxLayout.LINE_AXIS));

            ukoncit.setBackground(new java.awt.Color(93, 93, 93));
            ukoncit.setForeground(new java.awt.Color(254, 254, 254));
            ukoncit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ukoncit.jpg"))); // NOI18N
            ukoncit.setBorder(null);
            ukoncit.setBorderPainted(false);
            ukoncit.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/ukoncit.jpg"))); // NOI18N
            ukoncit.setEnabled(false);
            ukoncit.setMaximumSize(new java.awt.Dimension(218, 50));
            ukoncit.setMinimumSize(new java.awt.Dimension(218, 50));
            ukoncit.setPreferredSize(new java.awt.Dimension(218, 50));
            ukoncit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ukoncitActionPerformed(evt);
                }
            });
            tlacitka.add(ukoncit);

            prodat.setBackground(new java.awt.Color(93, 93, 93));
            prodat.setForeground(new java.awt.Color(254, 254, 254));
            prodat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prodat.jpg"))); // NOI18N
            prodat.setBorder(null);
            prodat.setBorderPainted(false);
            prodat.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    prodatActionPerformed(evt);
                }
            });
            tlacitka.add(prodat);

            vzdat.setBackground(new java.awt.Color(93, 93, 93));
            vzdat.setForeground(new java.awt.Color(254, 254, 254));
            vzdat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vzdat.jpg"))); // NOI18N
            vzdat.setBorder(null);
            vzdat.setBorderPainted(false);
            tlacitka.add(vzdat);

            cely_spodek.setRightComponent(tlacitka);

            cela_plocha.setRightComponent(cely_spodek);

            getContentPane().add(cela_plocha);

            menuBar.setBackground(new java.awt.Color(19, 19, 19));
            menuBar.setBorder(null);
            menuBar.setForeground(new java.awt.Color(232, 232, 232));

            soubor.setText("Soubor");

            nacist.setText("Nacist hru");
            nacist.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nacistActionPerformed(evt);
                }
            });
            soubor.add(nacist);

            ulozit.setText("jMenuItem1");
            ulozit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ulozitActionPerformed(evt);
                }
            });
            soubor.add(ulozit);

            menuBar.add(soubor);

            upravit.setText("Upravy");
            menuBar.add(upravit);

            setJMenuBar(menuBar);

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void nacistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacistActionPerformed
        nacitacOption=nacitacSouboru.showOpenDialog(nacist);
    }//GEN-LAST:event_nacistActionPerformed

    private void ukoncitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ukoncitActionPerformed
        setUkoncenTah(true);
    }//GEN-LAST:event_ukoncitActionPerformed

    private void ulozitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozitActionPerformed
        ukladacSouboru.setSelectedFile(new File(""));
        ukladacSouboru.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                if(f.isDirectory()) return true;
                String path=f.getAbsolutePath().toLowerCase();
                return path.endsWith(".das") && (path.charAt(path.length()-4)=='.');
            }

            @Override
            public String getDescription() {
                return "Dostihy a Sazky (*.das)";
            }
        });
        ukladacOption=ukladacSouboru.showSaveDialog(ulozit);       // TODO add your handling code here:
    }//GEN-LAST:event_ulozitActionPerformed

    private void ukladacSouboruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ukladacSouboruActionPerformed
        if(ukladacOption==JFileChooser.APPROVE_OPTION) {
            try {
                File f;
                if(ukladacSouboru.getSelectedFile().getAbsolutePath().toLowerCase().endsWith(".das")) {
                    f=ukladacSouboru.getSelectedFile();
                }
                else {
                    f=new File(ukladacSouboru.getSelectedFile()+".das");
                }
                ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
                oos.writeObject(Control.hra);
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(HerniPlocha.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
        }
    }//GEN-LAST:event_ukladacSouboruActionPerformed

    private void nacitacSouboruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacitacSouboruActionPerformed
        if(nacitacOption==JFileChooser.APPROVE_OPTION) {
            
                ObjectInputStream ois=null;
            try {
                if("".equals(nacitacSouboru.getSelectedFile().getName())) {
                    return;
                }
                ois = new ObjectInputStream(new FileInputStream(nacitacSouboru.getSelectedFile()));
                Control.hra=(Hra) ois.readObject();
                ois.close();
                plocha.removeAll();
                plocha.updateUI();
                nactiHrace();
                nactiPole();
                nactiKostku();
                Control.plocha.repaint();
                System.out.println(Control.hra.getHraci().get(0).getRozpocet());
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
    }//GEN-LAST:event_nacitacSouboruActionPerformed

    private void prodatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodatActionPerformed
        ProdejDialog dialog=new ProdejDialog(new ProdejGUI(Control.hra.getHraci().get(Control.hra.getAktualniHrac())));
        //dialog.setSize(300,300);
        //Control.hra.nabidkaProdat();
    }//GEN-LAST:event_prodatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HerniPlocha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HerniPlocha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HerniPlocha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HerniPlocha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HerniPlocha().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane cela_plocha;
    private javax.swing.JSplitPane cely_spodek;
    private javax.swing.JPanel hlavni_plocha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane leva;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem nacist;
    private javax.swing.JFileChooser nacitacSouboru;
    private javax.swing.JPanel plocha;
    private javax.swing.JPanel prava;
    private javax.swing.JButton prodat;
    private javax.swing.JMenu soubor;
    private javax.swing.JPanel statusB;
    private javax.swing.JTextPane statusBoxik;
    private javax.swing.JPanel stred;
    private javax.swing.JPanel stredD;
    private javax.swing.JPanel tlacitka;
    private javax.swing.JFileChooser ukladacSouboru;
    private javax.swing.JButton ukoncit;
    private javax.swing.JMenuItem ulozit;
    private javax.swing.JMenu upravit;
    private javax.swing.JButton vzdat;
    // End of variables declaration//GEN-END:variables

    private void nactiHrace() {
        //plocha.setLayout(new OverlayLayout(plocha));
        //prava.setLayout(new OverlayLayout(prava));
        for (Hrac h : hra.getHraci()) {
            plocha.add(h.getFigurka());
            prava.add(h.getJmenovka());
            prava.add(h.getJmenovka().getPuntik());
        }
        //prava.add(new JLabel("ahoj"));
        
        //pack();
        
    }
    
    private void nactiPole() {
        //plocha.setLayout(new OverlayLayout(plocha));
        for (final Policko p : hra.getPolicka()) {
            if(p.isVlastnicka()) {
                
                p.setOpaque(false);
                p.setContentAreaFilled(false);
                p.setBorderPainted(false);
                p.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            p.getKarta().zobraz();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(HerniPlocha.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                plocha.add(p.getObsazFigurka());
                plocha.add(p);
                if(p.getKarta() instanceof Kun) {
                    Kun kun=(Kun)p.getKarta();
                    for(Dostihy d : kun.getDostihy()) {
                        plocha.add(d);
                    }
                }
            }
        }
        //pack();
    }
    
    private void nactiKostku() {
        Kostka k=Control.hra.getKostka();
        k.pridejListener();
        prava.add(k);
    }
    public void prepniKostky() {
        if(aktualniPr.equals(pr)) {
            aktualniPr=pr2;
        }
        else {
            aktualniPr=pr;
        }
    }

    /**
     * @return the ukoncenTah
     */
    public boolean isUkoncenTah() {
        return ukoncenTah;
    }

    /**
     * @param ukoncenTah the ukoncenTah to set
     */
    public void setUkoncenTah(boolean ukoncenTah) {
        this.ukoncenTah = ukoncenTah;
    }
    public void zapniTlacitko() {
        ukoncit.setEnabled(true);
    }
    public void vypniTlacitko() {
        ukoncit.setEnabled(false);
    }
    
}
