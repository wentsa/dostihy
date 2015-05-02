/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.plocha;

import grafika.GraphicsHandler;
import grafika.RozmeryPlochy;
import gui.HlavniOkno;
import gui.Kostka;
import gui.ProdejDialog;
import gui.ProdejGUI;
import gui.dostih.DostihyView;
import gui.slider.SliderView;
import hra.Hra;
import hra.Hrac;
import hra.Policko;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import pomocne.Konstanty;

/**
 *
 * @author wentsa
 */
public class HerniPlochaView extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    private final HerniPlochaController controller;
    private static HerniPlochaView instance = null;
    private static final ResourceBundle bundle = ResourceBundle.getBundle("languages/gui/GUI", Konstanty.defaultLocale);

    protected static HerniPlochaView getInstance(HerniPlochaController controller) {
        if (instance == null) {
            instance = new HerniPlochaView(controller);
        }
        return instance;
    }

    protected static void smazInstance() {
        instance = null;
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
                    Object[] volby={bundle.getString("YES"),bundle.getString("NO")};
                    int result = JOptionPane.showOptionDialog(this,bundle.getString("OVERWRITE_EXISTING_FILE"),bundle.getString("FILE_EXISTS"),JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, volby, volby[0]);
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
        rozliseni = new javax.swing.JMenuItem();
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
            nacitacSouboru.setCurrentDirectory(new java.io.File("/home/wentsa"));
            nacitacSouboru.setDialogTitle(bundle.getString("LOAD")); // NOI18N
            nacitacSouboru.setFileFilter(new FileNameExtensionFilter(bundle.getString("SAVED_GAMES"), "DAS"));
            nacitacSouboru.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nacitacSouboruActionPerformed(evt);
                }
            });

            ukladacSouboru.setCurrentDirectory(new java.io.File("/home/wentsa"));
            ukladacSouboru.setDialogTitle(bundle.getString("SAVE")); // NOI18N
            ukladacSouboru.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ukladacSouboruActionPerformed(evt);
                }
            });

            setBackground(new java.awt.Color(1, 1, 1));
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            setMaximumSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka()+RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getPlochaVyska()+RozmeryPlochy.getStatusVyska()+19));
            setMinimumSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka()+RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getPlochaVyska()+RozmeryPlochy.getStatusVyska()+19)
            );
            setPreferredSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka()+RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getPlochaVyska()+RozmeryPlochy.getStatusVyska()+19));
            setLayout(new java.awt.BorderLayout());

            menuBar.setBackground(new java.awt.Color(19, 19, 19));
            menuBar.setBorder(null);
            menuBar.setForeground(new java.awt.Color(232, 232, 232));
            menuBar.setMaximumSize(new java.awt.Dimension(175, 19));

            soubor.setText(bundle.getString("FILE")); // NOI18N

            nacist.setText(bundle.getString("LOAD_GAME")); // NOI18N
            nacist.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nacistActionPerformed(evt);
                }
            });
            soubor.add(nacist);

            ulozit.setText(bundle.getString("SAVE_GAME")); // NOI18N
            ulozit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ulozitActionPerformed(evt);
                }
            });
            soubor.add(ulozit);

            menuBar.add(soubor);

            upravit.setText(bundle.getString("EDIT")); // NOI18N

            jas.setText(bundle.getString("BRIGHTNESS_AND_CONTRAST")); // NOI18N
            jas.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jasActionPerformed(evt);
                }
            });
            upravit.add(jas);

            rozliseni.setText(bundle.getString("RESOLUTION")); // NOI18N
            rozliseni.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rozliseniActionPerformed(evt);
                }
            });
            upravit.add(rozliseni);

            menuBar.add(upravit);

            napoveda.setText(bundle.getString("HELP")); // NOI18N

            help.setText(bundle.getString("HELP")); // NOI18N
            help.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    helpActionPerformed(evt);
                }
            });
            napoveda.add(help);

            pravidla.setText(bundle.getString("RULES")); // NOI18N
            pravidla.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    pravidlaActionPerformed(evt);
                }
            });
            napoveda.add(pravidla);

            menuBar.add(napoveda);

            add(menuBar, java.awt.BorderLayout.CENTER);

            jPanel1.setMaximumSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka()+RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getPlochaVyska()+RozmeryPlochy.getStatusVyska()));
            jPanel1.setMinimumSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka()+RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getPlochaVyska()+RozmeryPlochy.getStatusVyska()));
            jPanel1.setPreferredSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka()+RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getPlochaVyska()+RozmeryPlochy.getStatusVyska()));
            jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

            cela_plocha.setBackground(new java.awt.Color(255, 0, 0));
            cela_plocha.setBorder(null);
            cela_plocha.setDividerSize(0);
            cela_plocha.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
            cela_plocha.setMaximumSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka()+RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getPlochaVyska()+RozmeryPlochy.getStatusVyska()));
            cela_plocha.setMinimumSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka()+RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getPlochaVyska()+RozmeryPlochy.getStatusVyska()));
            cela_plocha.setPreferredSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka()+RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getPlochaVyska()+RozmeryPlochy.getStatusVyska()));

            hlavni_plocha.setBackground(new java.awt.Color(204, 0, 204));
            hlavni_plocha.setMaximumSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka()+RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getPlochaVyska()));
            hlavni_plocha.setPreferredSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka()+RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getPlochaVyska()));
            hlavni_plocha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            plocha.setBackground(new java.awt.Color(0, 255, 221));
            plocha.setMaximumSize(RozmeryPlochy.plocha()
            );
            plocha.setMinimumSize(new Dimension(0, 0));
            plocha.setPreferredSize(RozmeryPlochy.plocha());
            plocha.setLayout(new javax.swing.OverlayLayout(plocha));
            hlavni_plocha.add(plocha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

            stred.setBackground(new java.awt.Color(0, 176, 255));
            stred.setMaximumSize(RozmeryPlochy.stred());
            stred.setMinimumSize(RozmeryPlochy.stred());
            stred.setPreferredSize(RozmeryPlochy.stred());
            stred.setLayout(new javax.swing.OverlayLayout(stred));
            hlavni_plocha.add(stred, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, -1, -1));

            prava.setBackground(new java.awt.Color(0, 108, 255));
            prava.setMaximumSize(RozmeryPlochy.prava());
            prava.setMinimumSize(RozmeryPlochy.prava());
            prava.setName(""); // NOI18N
            prava.setPreferredSize(RozmeryPlochy.prava());
            prava.setLayout(new javax.swing.OverlayLayout(prava));
            hlavni_plocha.add(prava, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, -1, -1));

            cela_plocha.setLeftComponent(hlavni_plocha);

            cely_spodek.setBorder(null);
            cely_spodek.setDividerLocation(RozmeryPlochy.getStatusSirka()+RozmeryPlochy.getStredDolniSirka());
            cely_spodek.setDividerSize(0);
            cely_spodek.setMaximumSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka()+RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getStatusVyska()));
            cely_spodek.setMinimumSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka()+RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getStatusVyska()));
            cely_spodek.setPreferredSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka()+RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getStatusVyska()));

            leva.setBorder(null);
            leva.setDividerLocation(RozmeryPlochy.getStatusSirka());
            leva.setDividerSize(0);
            leva.setLastDividerLocation(700);
            leva.setMaximumSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka(), RozmeryPlochy.getStatusVyska()));
            leva.setMinimumSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka(), RozmeryPlochy.getStatusVyska()));
            leva.setPreferredSize(new Dimension(RozmeryPlochy.getPlochaSirka()+RozmeryPlochy.getStredSirka(), RozmeryPlochy.getStatusVyska()));

            statusB.setBackground(new java.awt.Color(0, 24, 255));
            statusB.setMaximumSize(RozmeryPlochy.status());
            statusB.setMinimumSize(RozmeryPlochy.status());
            statusB.setPreferredSize(RozmeryPlochy.status());
            statusB.setLayout(new javax.swing.OverlayLayout(statusB));

            jScrollPane1.setBackground(new Color(0,0,0,0));
            jScrollPane1.setBorder(null);
            jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
            jScrollPane1.setMaximumSize(RozmeryPlochy.status());
            jScrollPane1.setMinimumSize(RozmeryPlochy.status());
            jScrollPane1.setPreferredSize(RozmeryPlochy.status());

            statusBoxik.setMaximumSize(RozmeryPlochy.status());
            statusBoxik.setMinimumSize(RozmeryPlochy.status());
            statusBoxik.setPreferredSize(RozmeryPlochy.status());
            jScrollPane1.setViewportView(statusBoxik);

            statusB.add(jScrollPane1);

            leva.setLeftComponent(statusB);

            stredD.setMaximumSize(RozmeryPlochy.stredDolni());
            stredD.setMinimumSize(RozmeryPlochy.stredDolni());
            stredD.setPreferredSize(RozmeryPlochy.stredDolni());
            leva.setRightComponent(stredD);

            cely_spodek.setLeftComponent(leva);

            tlacitka.setBackground(new java.awt.Color(93, 93, 93));
            tlacitka.setMaximumSize(RozmeryPlochy.tlacitka());
            tlacitka.setMinimumSize(RozmeryPlochy.tlacitka());
            tlacitka.setPreferredSize(RozmeryPlochy.tlacitka());
            tlacitka.setLayout(new javax.swing.BoxLayout(tlacitka, javax.swing.BoxLayout.LINE_AXIS));

            ukoncit.setBackground(new java.awt.Color(93, 93, 93));
            ukoncit.setForeground(new java.awt.Color(254, 254, 254));
            ukoncit.setIcon(controller.getUkoncitAktiv());
            ukoncit.setBorder(null);
            ukoncit.setBorderPainted(false);
            ukoncit.setDisabledIcon(controller.getUkoncit());
            ukoncit.setEnabled(false);
            ukoncit.setMaximumSize(RozmeryPlochy.ukoncit());
            ukoncit.setMinimumSize(RozmeryPlochy.ukoncit());
            ukoncit.setPreferredSize(RozmeryPlochy.ukoncit());
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
            prodat.setMaximumSize(RozmeryPlochy.prodat());
            prodat.setMinimumSize(RozmeryPlochy.prodat());
            prodat.setPreferredSize(RozmeryPlochy.prodat());
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
            vzdat.setMaximumSize(RozmeryPlochy.vzdat());
            vzdat.setMinimumSize(RozmeryPlochy.vzdat());
            vzdat.setPreferredSize(RozmeryPlochy.vzdat());
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
            HlavniOkno okno = (HlavniOkno) SwingUtilities.getWindowAncestor(this);
            okno.tahni();
        } catch (InterruptedException ex) {
            Logger.getLogger(HerniPlochaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nacitacSouboruActionPerformed

    private void prodatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodatActionPerformed
        ProdejDialog dialog = new ProdejDialog(new ProdejGUI(Hra.getInstance().getAktualniHrac()));
    }//GEN-LAST:event_prodatActionPerformed

    private void vzdatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vzdatActionPerformed
        Object[] volby = {bundle.getString("YES"), bundle.getString("NO")};
        int odpoved = JOptionPane.showOptionDialog(this, bundle.getString("GIVE_UP_CHECK"), bundle.getString("GIVE_UP"), JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION, null, volby, volby[0]);
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

    private void rozliseniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rozliseniActionPerformed
        controller.zobrazRozliseni();
    }//GEN-LAST:event_rozliseniActionPerformed

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
    private javax.swing.JMenuItem rozliseni;
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
        statusBoxik = Hra.getInstance().getStatusBox();
        jScrollPane1.setViewportView(statusBoxik);
    }

    protected void vzdatSe() {
        vzdat.doClick();
    }

    protected void pridejSlider(SliderView sliderView) {
        prava.add(sliderView);
    }

    protected void aktualizujFont() {
        statusBoxik.setForeground(GraphicsHandler.getBarvaFontu());
    }

    protected JFileChooser getNacitac() {
        return nacitacSouboru;
    }

    protected void zmenRozliseni() {
        controller.nactiPravou();
        for (Hrac h : Hra.getInstance().getHraci()) {
            h.getJmenovka().nactiSouradnice();
            h.getFigurka().aktualizuj();
        }
        for (Policko p : Hra.getInstance().getPolicka()) {
            p.aktualizuj();
        }

        prava.setPreferredSize(RozmeryPlochy.prava());
        plocha.setPreferredSize(RozmeryPlochy.plocha());
        stred.setPreferredSize(RozmeryPlochy.stred());
        hlavni_plocha.setPreferredSize(new Dimension(RozmeryPlochy.getPlochaSirka() + RozmeryPlochy.getStredSirka() + RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getPlochaVyska()));
        cela_plocha.setPreferredSize(new Dimension(RozmeryPlochy.getPlochaSirka() + RozmeryPlochy.getStredSirka() + RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getPlochaVyska() + RozmeryPlochy.getStatusVyska()));

        jPanel1.setPreferredSize(new Dimension(RozmeryPlochy.getPlochaSirka() + RozmeryPlochy.getStredSirka() + RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getPlochaVyska() + RozmeryPlochy.getStatusVyska()));
        cely_spodek.setPreferredSize(new Dimension(RozmeryPlochy.getPlochaSirka() + RozmeryPlochy.getStredSirka() + RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getStatusVyska()));

        leva.setPreferredSize(new Dimension(RozmeryPlochy.getPlochaSirka() + RozmeryPlochy.getStredSirka(), RozmeryPlochy.getStatusVyska()));
        statusB.setPreferredSize(RozmeryPlochy.status());
        jScrollPane1.setPreferredSize(RozmeryPlochy.status());
        statusBoxik.setPreferredSize(RozmeryPlochy.status());
        stredD.setPreferredSize(RozmeryPlochy.stredDolni());
        tlacitka.setPreferredSize(RozmeryPlochy.tlacitka());
        prodat.setPreferredSize(RozmeryPlochy.prodat());
        ukoncit.setPreferredSize(RozmeryPlochy.ukoncit());
        vzdat.setPreferredSize(RozmeryPlochy.vzdat());

        prodat.setIcon(GraphicsHandler.getIcon("prodat"));
        ukoncit.setDisabledIcon(GraphicsHandler.getIcon("ukoncit"));
        ukoncit.setIcon(GraphicsHandler.getIcon("ukoncit_aktiv"));
        vzdat.setIcon(GraphicsHandler.getIcon("vzdat"));

        leva.setRightComponent(stredD);

        setPreferredSize(new Dimension(RozmeryPlochy.getPlochaSirka() + RozmeryPlochy.getStredSirka() + RozmeryPlochy.getPravaSirka(), RozmeryPlochy.getPlochaVyska() + RozmeryPlochy.getStatusVyska() + 19));

        cela_plocha.setDividerLocation(RozmeryPlochy.getPlochaVyska());
        cely_spodek.setDividerLocation(RozmeryPlochy.getStatusSirka() + RozmeryPlochy.getStredDolniSirka());
        leva.setDividerLocation(RozmeryPlochy.getStatusSirka());
        hlavni_plocha.remove(stred);
        hlavni_plocha.remove(prava);
        hlavni_plocha.add(stred, new org.netbeans.lib.awtextra.AbsoluteConstraints(RozmeryPlochy.getPlochaSirka(), 0, -1, -1));
        hlavni_plocha.add(prava, new org.netbeans.lib.awtextra.AbsoluteConstraints(RozmeryPlochy.getPlochaSirka() + RozmeryPlochy.getStredSirka(), 0, -1, -1));

        List<Component> list = getAllComponents(this);
        for (Component c : list) {
            c.revalidate();
            c.repaint();
        }

        GraphicsHandler.rescale();

        SwingUtilities.getWindowAncestor(this).pack();
        SwingUtilities.getWindowAncestor(this).repaint();
        SwingUtilities.getWindowAncestor(this).setLocationRelativeTo(null);
        repaint();

    }

    private List<Component> getAllComponents(final Container c) {
        Component[] comps = c.getComponents();
        List<Component> compList = new ArrayList<>();
        for (Component comp : comps) {
            compList.add(comp);
            if (comp instanceof Container) {
                compList.addAll(getAllComponents((Container) comp));
            }
        }
        return compList;
    }

}
