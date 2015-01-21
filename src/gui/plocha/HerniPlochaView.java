/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.plocha;

import grafika.GraphicsHandler;
import gui.HlavniOkno;
import hra.Hra;
import hra.Hrac;
import gui.Kostka;
import hra.Policko;
import gui.dostih.DostihyView;
import gui.JasDialog;
import gui.ProdejDialog;
import gui.ProdejGUI;
import gui.slider.SliderView;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author wentsa
 */
public class HerniPlochaView extends javax.swing.JPanel {

    

    private final HerniPlochaController controller;
    private static HerniPlochaView instance = null;

    protected static HerniPlochaView getInstance(HerniPlochaController controller) {
        if (instance == null) {
            instance = new HerniPlochaView(controller);
        }
        return instance;
    }

    protected static void smazInstance() {
        instance=null;
    }
    
    private HerniPlochaView(HerniPlochaController controller) {
        this.controller = controller;
        initComponents();
        
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
        menuBar = new javax.swing.JMenuBar();
        soubor = new javax.swing.JMenu();
        nacist = new javax.swing.JMenuItem();
        ulozit = new javax.swing.JMenuItem();
        upravit = new javax.swing.JMenu();
        jas = new javax.swing.JMenuItem();
        napoveda = new javax.swing.JMenu();
        help = new javax.swing.JMenuItem();
        pravidla = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        cela_plocha = new javax.swing.JSplitPane();
        hlavni_plocha = new javax.swing.JPanel();
        plocha = new javax.swing.JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(controller.getPl(), 0, 0, null);
            }
        };
        stred = new javax.swing.JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(controller.getSt(), 0, 0, null);
            }
        };
        prava = new javax.swing.JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(controller.getAktualniPr(), 0, 0, null);
            }
        };
        cely_spodek = new javax.swing.JSplitPane();
        leva = new javax.swing.JSplitPane();
        statusB = new javax.swing.JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(controller.getStatusP(), 0, 0, null);
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        statusBoxik = Hra.getInstance().getStatusBox();
        stredD = new javax.swing.JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(controller.getSt_d(), 0, 0, null);
            }};
            tlacitka = new javax.swing.JPanel();
            ukoncit = new javax.swing.JButton();
            prodat = new javax.swing.JButton();
            vzdat = new javax.swing.JButton();

            nacitacSouboru.setAcceptAllFileFilterUsed(false);
            nacitacSouboru.setCurrentDirectory(new java.io.File("/home/classroom/user/chaluto2"));
            nacitacSouboru.setDialogTitle("Načíst");
            nacitacSouboru.setFileFilter(new FileNameExtensionFilter("Ulozene hry (.das)", "DAS"));
            nacitacSouboru.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nacitacSouboruActionPerformed(evt);
                }
            });

            ukladacSouboru.setCurrentDirectory(new java.io.File("/home/classroom/user/chaluto2"));
            ukladacSouboru.setDialogTitle("Uložit");
            ukladacSouboru.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ukladacSouboruActionPerformed(evt);
                }
            });

            setBackground(new java.awt.Color(1, 1, 1));
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            setLayout(new java.awt.BorderLayout());

            menuBar.setBackground(new java.awt.Color(19, 19, 19));
            menuBar.setBorder(null);
            menuBar.setForeground(new java.awt.Color(232, 232, 232));

            soubor.setText("Soubor");

            nacist.setText("Načíst hru");
            nacist.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nacistActionPerformed(evt);
                }
            });
            soubor.add(nacist);

            ulozit.setText("Uložit hru");
            ulozit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ulozitActionPerformed(evt);
                }
            });
            soubor.add(ulozit);

            menuBar.add(soubor);

            upravit.setText("Úpravy");

            jas.setText("Jas a kontrast");
            jas.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jasActionPerformed(evt);
                }
            });
            upravit.add(jas);

            menuBar.add(upravit);

            napoveda.setText("Nápověda");

            help.setText("Nápověda");
            help.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    helpActionPerformed(evt);
                }
            });
            napoveda.add(help);

            pravidla.setText("Pravidla");
            pravidla.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    pravidlaActionPerformed(evt);
                }
            });
            napoveda.add(pravidla);

            menuBar.add(napoveda);

            add(menuBar, java.awt.BorderLayout.CENTER);

            jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

            cela_plocha.setBorder(null);
            cela_plocha.setDividerSize(0);
            cela_plocha.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
            cela_plocha.setMinimumSize(new java.awt.Dimension(1280, 750));
            cela_plocha.setPreferredSize(new java.awt.Dimension(1280, 750));

            hlavni_plocha.setBackground(new java.awt.Color(1, 1, 1));
            hlavni_plocha.setMaximumSize(new java.awt.Dimension(1280, 700));
            hlavni_plocha.setMinimumSize(new java.awt.Dimension(1280, 700));
            hlavni_plocha.setPreferredSize(new java.awt.Dimension(1280, 700));
            hlavni_plocha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            plocha.setBackground(new java.awt.Color(0, 255, 221));
            plocha.setMaximumSize(new java.awt.Dimension(700, 700));
            plocha.setMinimumSize(new java.awt.Dimension(700, 700));
            plocha.setLayout(new javax.swing.OverlayLayout(plocha));
            hlavni_plocha.add(plocha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 701));

            stred.setBackground(new java.awt.Color(0, 176, 255));
            stred.setMaximumSize(new java.awt.Dimension(100, 700));
            stred.setMinimumSize(new java.awt.Dimension(100, 700));
            stred.setPreferredSize(new java.awt.Dimension(100, 700));
            stred.setLayout(new javax.swing.OverlayLayout(stred));
            hlavni_plocha.add(stred, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, -1, -1));

            prava.setBackground(new java.awt.Color(0, 108, 255));
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
            statusB.setMaximumSize(new java.awt.Dimension(100, 50));
            statusB.setMinimumSize(new java.awt.Dimension(100, 50));
            statusB.setPreferredSize(new java.awt.Dimension(100, 50));
            statusB.setLayout(new javax.swing.OverlayLayout(statusB));

            jScrollPane1.setBackground(new Color(0,0,0,0));
            jScrollPane1.setBorder(null);
            jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
            jScrollPane1.setViewportView(statusBoxik);

            statusB.add(jScrollPane1);

            leva.setLeftComponent(statusB);
            leva.setRightComponent(stredD);

            cely_spodek.setLeftComponent(leva);

            tlacitka.setBackground(new java.awt.Color(93, 93, 93));
            tlacitka.setMaximumSize(new java.awt.Dimension(480, 50));
            tlacitka.setMinimumSize(new java.awt.Dimension(480, 50));
            tlacitka.setPreferredSize(new java.awt.Dimension(480, 50));
            tlacitka.setLayout(new javax.swing.BoxLayout(tlacitka, javax.swing.BoxLayout.LINE_AXIS));

            ukoncit.setBackground(new java.awt.Color(93, 93, 93));
            ukoncit.setForeground(new java.awt.Color(254, 254, 254));
            ukoncit.setIcon(controller.getUkoncitAktiv());
            ukoncit.setBorder(null);
            ukoncit.setBorderPainted(false);
            ukoncit.setDisabledIcon(controller.getUkoncit());
            ukoncit.setEnabled(false);
            ukoncit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ukoncitActionPerformed(evt);
                }
            });
            tlacitka.add(ukoncit);

            prodat.setBackground(new java.awt.Color(93, 93, 93));
            prodat.setForeground(new java.awt.Color(254, 254, 254));
            prodat.setIcon(controller.getProdat());
            prodat.setBorder(null);
            prodat.setBorderPainted(false);
            prodat.setDisabledIcon(prodat.getIcon());
            prodat.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    prodatActionPerformed(evt);
                }
            });
            tlacitka.add(prodat);

            vzdat.setBackground(new java.awt.Color(93, 93, 93));
            vzdat.setForeground(new java.awt.Color(254, 254, 254));
            vzdat.setIcon(controller.getVzdat());
            vzdat.setBorder(null);
            vzdat.setBorderPainted(false);
            vzdat.setDisabledIcon(vzdat.getIcon());
            vzdat.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    vzdatActionPerformed(evt);
                }
            });
            tlacitka.add(vzdat);

            cely_spodek.setRightComponent(tlacitka);

            cela_plocha.setRightComponent(cely_spodek);

            jPanel1.add(cela_plocha);

            add(jPanel1, java.awt.BorderLayout.PAGE_END);
        }// </editor-fold>//GEN-END:initComponents

    private void nacistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacistActionPerformed
        controller.setNacitacOption(nacitacSouboru.showOpenDialog(nacist));
    }//GEN-LAST:event_nacistActionPerformed

    private void ukoncitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ukoncitActionPerformed
        controller.setUkoncenTah(true);
    }//GEN-LAST:event_ukoncitActionPerformed

    private void ulozitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozitActionPerformed

        ukladacSouboru.setSelectedFile(new File(""));
        ukladacSouboru.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String path = f.getAbsolutePath().toLowerCase();
                return path.endsWith(".das") && (path.charAt(path.length() - 4) == '.');
            }

            @Override
            public String getDescription() {
                return "Dostihy a Sazky (*.das)";
            }
        });
        controller.setUkladacOption(ukladacSouboru.showSaveDialog(ulozit));
    }//GEN-LAST:event_ulozitActionPerformed

    private void ukladacSouboruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ukladacSouboruActionPerformed
        controller.ulozHru(ukladacSouboru.getSelectedFile());
    }//GEN-LAST:event_ukladacSouboruActionPerformed

    private void nacitacSouboruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacitacSouboruActionPerformed
        try {
            controller.nactiHru(nacitacSouboru.getSelectedFile());
            HlavniOkno okno=(HlavniOkno)SwingUtilities.getWindowAncestor(this);
            okno.tahni();
        } catch (InterruptedException ex) {
            Logger.getLogger(HerniPlochaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nacitacSouboruActionPerformed

    private void prodatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodatActionPerformed
        ProdejDialog dialog = new ProdejDialog(new ProdejGUI(Hra.getInstance().getAktualniHrac()));        
    }//GEN-LAST:event_prodatActionPerformed

    private void vzdatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vzdatActionPerformed
        Object[] volby = {"Ano", "Ne"};
        int odpoved = JOptionPane.showOptionDialog(this, "Opravdu se chcete vzdát?", "Vzdát se", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION, null, volby, volby[0]);
        if (odpoved == JOptionPane.YES_OPTION) {
            Hra.getInstance().getAktualniHrac().setAktivni(false);
        }
    }//GEN-LAST:event_vzdatActionPerformed

    private void jasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jasActionPerformed
        controller.zobrazJas();
    }//GEN-LAST:event_jasActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        controller.zobrazNapovedu();
    }//GEN-LAST:event_helpActionPerformed

    private void pravidlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pravidlaActionPerformed
        controller.zobrazPravidla();
    }//GEN-LAST:event_pravidlaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane cela_plocha;
    private javax.swing.JSplitPane cely_spodek;
    private javax.swing.JMenuItem help;
    private javax.swing.JPanel hlavni_plocha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jas;
    private javax.swing.JSplitPane leva;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem nacist;
    private javax.swing.JFileChooser nacitacSouboru;
    private javax.swing.JMenu napoveda;
    private javax.swing.JPanel plocha;
    private javax.swing.JPanel prava;
    private javax.swing.JMenuItem pravidla;
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

    
    protected void zapniTlacitko() {
        ukoncit.setEnabled(true);
        ukoncit.repaint();
    }

    protected void vypniTlacitko() {
        ukoncit.setEnabled(false);
        ukoncit.repaint();
    }

    protected void pridejHrace(Hrac h) {
        System.out.println("Přidávám hráče " + h.getJmeno());
        plocha.add(h.getFigurka().getView());
        prava.add(h.getJmenovka().getView());
        prava.add(h.getJmenovka().getPuntik());
    }

    protected void pridejPolicko(Policko p) {
        plocha.add(p.getObsazFigurka().getView());
        plocha.add(p);
    }

    protected void pridejDostih(DostihyView d) {
        plocha.add(d);
    }

    protected void pridejKostku(Kostka k) {
        prava.add(k);
    }

    protected void vycistiPlochu() {
        plocha.removeAll();
        prava.removeAll();
        plocha.updateUI();
        prava.updateUI();
        statusBoxik=Hra.getInstance().getStatusBox();
        jScrollPane1.setViewportView(statusBoxik);
    }

    protected void vzdatSe() {
        vzdat.doClick();
    }

    protected void pridejSlider(SliderView sliderView) {
        prava.add(sliderView);
    }

    protected void aktualizujFont() {
        statusBoxik.setForeground(GraphicsHandler.barvaFontu);
    }

    protected JFileChooser getNacitac() {
        return nacitacSouboru;
    }

}
