/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author wentsa
 */
public class Menu extends javax.swing.JPanel implements Serializable {
    private static final long serialVersionUID = 1L;

    

    /**
     * Creates new form Menu
     */
    
    public Menu() {
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

        nova_hra = new javax.swing.JButton();
        nacist_hru = new javax.swing.JButton();
        pravidla = new javax.swing.JButton();
        konec = new javax.swing.JButton();
        sit = new javax.swing.JButton();

        nova_hra.setText("Nová hra");
        nova_hra.setPreferredSize(new java.awt.Dimension(200, 40));
        nova_hra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nova_hraActionPerformed(evt);
            }
        });

        nacist_hru.setText("Načíst hru");
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

        konec.setText("Ukončit");
        konec.setMargin(new java.awt.Insets(10, 10, 10, 10));
        konec.setPreferredSize(new java.awt.Dimension(200, 40));
        konec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konecActionPerformed(evt);
            }
        });

        sit.setText("Hrát po síti");
        sit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(konec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pravidla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nacist_hru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nova_hra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(nova_hra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nacist_hru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pravidla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(konec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pravidlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pravidlaActionPerformed
        ((HlavniOkno)SwingUtilities.getWindowAncestor(this)).nastavPravidla();
    }//GEN-LAST:event_pravidlaActionPerformed

    private void nova_hraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nova_hraActionPerformed
        ((HlavniOkno)SwingUtilities.getWindowAncestor(this)).nastavVolbu();
    }//GEN-LAST:event_nova_hraActionPerformed

    private void nacist_hruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacist_hruActionPerformed
        try {
            ((HlavniOkno)SwingUtilities.getWindowAncestor(this)).nactiHru();
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nacist_hruActionPerformed

    private void konecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konecActionPerformed
        SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_konecActionPerformed

    private void sitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sitActionPerformed
        ((HlavniOkno)SwingUtilities.getWindowAncestor(this)).nastavMultiplayer();
    }//GEN-LAST:event_sitActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton konec;
    private javax.swing.JButton nacist_hru;
    private javax.swing.JButton nova_hra;
    private javax.swing.JButton pravidla;
    private javax.swing.JButton sit;
    // End of variables declaration//GEN-END:variables
    
}
