/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dostihy.Control;
import static dostihy.Control.Volba;
import javax.swing.SwingUtilities;

/**
 *
 * @author wentsa
 */
public class Menu1 extends javax.swing.JPanel {

    

    /**
     * Creates new form Menu
     */
    
    public Menu1() {
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        nova_hra = new javax.swing.JButton();
        nacist_hru = new javax.swing.JButton();
        pravidla = new javax.swing.JButton();
        konec = new javax.swing.JButton();

        jSplitPane1.setDividerLocation(80);
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jSplitPane1.setTopComponent(jPanel1);

        nova_hra.setText("Nova hra");
        nova_hra.setPreferredSize(new java.awt.Dimension(200, 40));
        nova_hra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nova_hraActionPerformed(evt);
            }
        });

        nacist_hru.setText("Nacist hru");
        nacist_hru.setPreferredSize(new java.awt.Dimension(200, 40));
        nacist_hru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nacist_hruActionPerformed(evt);
            }
        });

        pravidla.setText("Pravidla");
        pravidla.setPreferredSize(new java.awt.Dimension(200, 40));
        pravidla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pravidlaActionPerformed(evt);
            }
        });

        konec.setText("Ukoncit");
        konec.setMargin(new java.awt.Insets(10, 10, 10, 10));
        konec.setPreferredSize(new java.awt.Dimension(200, 40));
        konec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(konec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pravidla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(nacist_hru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nova_hra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(66, 66, 66))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(nova_hra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nacist_hru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pravidla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(konec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pravidlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pravidlaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pravidlaActionPerformed

    private void nova_hraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nova_hraActionPerformed
        ((TEST)SwingUtilities.getWindowAncestor(this)).nastavVolbu();
    }//GEN-LAST:event_nova_hraActionPerformed

    private void nacist_hruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacist_hruActionPerformed
        ((TEST)SwingUtilities.getWindowAncestor(this)).nactiHru();
    }//GEN-LAST:event_nacist_hruActionPerformed

    private void konecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konecActionPerformed
        ((TEST)SwingUtilities.getWindowAncestor(this)).dispose();
    }//GEN-LAST:event_konecActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton konec;
    private javax.swing.JButton nacist_hru;
    private javax.swing.JButton nova_hra;
    private javax.swing.JButton pravidla;
    // End of variables declaration//GEN-END:variables
    
}