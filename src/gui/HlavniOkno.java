/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.plocha.HerniPlochaView;
import gui.plocha.HerniPlochaController;
import pomocne.DataHraci;
import hra.Hra;
import hra.Policko;
import java.util.List;
import javax.swing.JFileChooser;
import pomocne.ListenerTask;
import pomocne.MyCardLayout;
import audio.SoundHandler;

/**
 *
 * @author wentsa
 */
public class HlavniOkno extends javax.swing.JFrame {

    /**
     * Creates new form HlavniOkno
     */
    Menu menu = new Menu();
    VolbaHracu volba = new VolbaHracu();
    HerniPlochaView plocha = HerniPlochaController.getInstance().getView();
    Vysledky vysledky = new Vysledky();
    MyCardLayout layout = new MyCardLayout();
    private boolean konec = false;
    
    public HlavniOkno() {
        System.out.println("test na " + Thread.currentThread().toString());
        initComponents();
        nactiKarty();
        
        setLocationRelativeTo(null);
    }
    
    public void zalozHrace(DataHraci d) throws InterruptedException {
        Hra.getInstance().zalozHrace(d);
        HerniPlochaController.getInstance().nactiHrace();
        nastavPlochu();
        tahni();
    }
    
    public void reset() {
        jPanel2.removeAll();
        volba = new VolbaHracu();
        HerniPlochaController.smazInstance();
        plocha = HerniPlochaController.getInstance().getView();
        nactiKarty();
        setLocationRelativeTo(null);
    }
    
    public void nactiHru() {
        NacitacSouboru nacitac = new NacitacSouboru();
        int zvoleno = nacitac.showOpenDialog(null);
        if (zvoleno == JFileChooser.APPROVE_OPTION) {
            nacitac.vyhodnot();
        } else {
            nastavMenu();
        }
    }
    
    public void nastavMenu() {
        layout.show(jPanel2, "menu");
        pack();
        setLocationRelativeTo(null);
    }
    
    public void nastavVolbu() {
        layout.show(jPanel2, "volba");
        pack();
        setLocationRelativeTo(null);
    }
    
    public void nastavPlochu() throws InterruptedException {
        /*cardLayout.removeLayoutComponent(plocha);
         jPanel2.remove(plocha);
         plocha = null;
         plocha = HerniPlochaController.getInstance().getView();
         jPanel2.add(plocha, "plocha");
         jPanel2.revalidate();
         jPanel2.repaint();*/
        layout.show(jPanel2, "plocha");
        pack();
        setLocationRelativeTo(null);
    }
    
    public void nastavVysledky() {
        System.out.println("qweweq   " + Thread.currentThread());
        vysledky.vyplnTabulku(Hra.getInstance().getVyherci());
        layout.show(jPanel2, "vysledky");
        pack();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel2.setLayout(layout);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(HlavniOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HlavniOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HlavniOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HlavniOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HlavniOkno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public void tahni() throws InterruptedException {
        (new ListenerTask<Void, String>(Hra.getInstance().getTah()) {
            
            @Override
            protected void process(List<String> chunks) {
                System.out.println("dostal jsem chunk");
                String chunk = chunks.get(chunks.size() - 1);
                switch (chunk) {
                    case "zapni":
                        HerniPlochaController.getInstance().zapniTlacitko();
                        break;
                    case "vypni":
                        HerniPlochaController.getInstance().vypniTlacitko();
                        break;
                    case "aktualizujSlider":
                        HerniPlochaController.getInstance().aktualizujSlider();
                        break;
                    default: {
                        if (chunk.startsWith("p-")) {
                            System.out.println(chunk);
                            System.out.println(Integer.getInteger(chunk.substring(2)));
                            int cislo = Integer.parseInt(chunk.substring(2));
                            for (Policko p : Hra.getInstance().getPolicka()) {
                                if (p.getCislo() == cislo) {
                                    p.setObsazeno(true);
                                    break;
                                }
                            }
                        } else {
                            chunk = chunk.substring(3);
                            Hra.getInstance().getStatusBox().setText(chunk);
                            Hra.getInstance().getStatusBox().repaint();
                            System.out.println("     " + chunk.toUpperCase());
                        }
                    }
                    break;
                }
            }

            @Override
            protected void done() {
                SoundHandler.end();
                new KonecInfoDialog();
                HlavniOkno.this.nastavVysledky();
            }
            
        }).execute();
    }
    
    public void setKonec(boolean konec) {
        this.konec = konec;
    }
    
    private void nactiKarty() {
        jPanel2.add(menu, "menu");
        jPanel2.add(volba, "volba");
        jPanel2.add(plocha, "plocha");
        jPanel2.add(vysledky, "vysledky");
        pack();
    }
    
}
