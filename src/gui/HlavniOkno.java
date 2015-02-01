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
import pomocne.ListenerTask;
import pomocne.MyCardLayout;
import audio.SoundHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import networking.NetCommunication;
import pomocne.Barva;

/**
 *
 * @author wentsa
 */
public class HlavniOkno extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    /**
     * Creates new form HlavniOkno
     */
    private final Menu menu = new Menu();
    private VolbaHracu volba = new VolbaHracu();
    private HerniPlochaView plocha;
    private Vysledky vysledky;
    private final MyCardLayout layout = new MyCardLayout();
    private final Thread vlakno;
    private final Pravidla  pravidla= new Pravidla(true);
    
    public HlavniOkno() {
        initComponents();
        vlakno=new Thread() {
            @Override
            public void run() {
                System.out.println("načítám...\n");
                plocha = HerniPlochaController.getInstance().getView();
                System.out.println("Hra načtena");
                vysledky = new Vysledky();
                jPanel2.add(plocha, "plocha");
                jPanel2.add(vysledky, "vysledky");
            }
        };
        vlakno.start();
        nactiKarty();
        setLocationRelativeTo(null);
    }
    
    public void zalozHrace(DataHraci d) throws InterruptedException {
        vlakno.join();
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
    
    public void nactiHru() throws InterruptedException {
        vlakno.join();
        JFileChooser nacitac=HerniPlochaController.getInstance().getNacitac();
        HerniPlochaController.getInstance().nastavVolbuNacitace(nacitac.showOpenDialog(this));
        if(HerniPlochaController.getInstance().getNacitacOption()==JFileChooser.APPROVE_OPTION) {
            HerniPlochaController.getInstance().nactiHru(nacitac.getSelectedFile());
            nastavPlochu();
            tahni();
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
        vlakno.join();
        layout.show(jPanel2, "plocha");
        pack();
        setLocationRelativeTo(null);
    }
    
    public void nastavMultiplayer() {
        String[] volby={"Založit hru","Připojit se"};
        int odpoved=JOptionPane.showOptionDialog(null,
                "Chcete hru založit nebo se připojit k již existující?",
                "Hra více hráčů",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                volby,
                null);
        if(odpoved==0) {
            NetCommunication.zalozHru();
            //nastavLobby1();
        } else {
            String sPort=JOptionPane.showInputDialog("port");
            int port=Integer.parseInt(sPort);
            NetCommunication.pripojSeDoHry(port);
            DataHraci dataHraci = new DataHraci();
            dataHraci.jmena.add("pepa");
            dataHraci.barvy.add("Oranžová");
            dataHraci.jmena.add("franta");
            dataHraci.barvy.add("Tyrkysová");
            try {
                zalozHrace(dataHraci);
            } catch (InterruptedException ex) {
                Logger.getLogger(HlavniOkno.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                //nastavLobby2();
        }
    }
    
    public void nastavPravidla() {
        layout.show(jPanel2, "pravidla");
        pack();
        setLocationRelativeTo(null);
    }
    
    public void nastavVysledky() {
        try {
            vlakno.join();
            vysledky.vyplnTabulku(Hra.getInstance().getVyherci());
            layout.show(jPanel2, "vysledky");
            pack();
            setLocationRelativeTo(null);
        } catch (InterruptedException ex) {
            Logger.getLogger(HlavniOkno.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        setTitle("Dostihy & Sázky");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    
    }//GEN-LAST:event_formWindowClosing

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
            private static final long serialVersionUID = 1L;
            
            @Override
            protected void process(List<String> chunks) {
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
                            int cislo = Integer.parseInt(chunk.substring(2));
                            for (Policko p : Hra.getInstance().getPolicka()) {
                                if (p.getPozice() == cislo) {
                                    p.setObsazeno(true);
                                    break;
                                }
                            }
                        } else {
                            chunk = chunk.substring(3);
                            Hra.getInstance().nastavTextStatusBoxu(chunk);
                            Hra.getInstance().getStatusBox().repaint();
                        }
                    }
                    break;
                }
            }

            @Override
            protected void done() {
                SoundHandler.play("end");
                new KonecInfoDialog();
                HlavniOkno.this.nastavVysledky();
            }
            
        }).execute();
    }
    
    private void nactiKarty() {
            jPanel2.add(menu, "menu");
            jPanel2.add(volba, "volba");
            jPanel2.add(pravidla, "pravidla");
            pack();
    }

    

    
    
}
