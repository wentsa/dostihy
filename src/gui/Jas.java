/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import grafika.GraphicsHandler;
import gui.plocha.HerniPlochaController;
import java.io.Serializable;
import javax.swing.JSlider;

/**
 *
 * @author wentsa
 */
public class Jas extends javax.swing.JPanel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Creates new form Jas
     */
    public Jas() {
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

        jas = new javax.swing.JSlider();
        kontrast = new javax.swing.JSlider();
        jasLabel = new javax.swing.JLabel();
        kontrastLabel = new javax.swing.JLabel();
        reset = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setMinimumSize(new java.awt.Dimension(279, 229));

        jas.setMaximum(200);
        jas.setMinimum(-200);
        jas.setPaintTicks(true);
        jas.setValue(0);
        jas.setBorder(null);
        jas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jasMouseReleased(evt);
            }
        });
        jas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jasStateChanged(evt);
            }
        });

        kontrast.setMaximum(130);
        kontrast.setMinimum(-130);
        kontrast.setToolTipText("");
        kontrast.setValue(0);
        kontrast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                kontrastMouseReleased(evt);
            }
        });
        kontrast.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                kontrastStateChanged(evt);
            }
        });

        jasLabel.setText("Jas");

        kontrastLabel.setText("Kontrast");

        reset.setText("Nastavit původní hodnoty");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kontrast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 30, Short.MAX_VALUE)
                                .addComponent(reset))
                            .addComponent(jasLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kontrastLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addComponent(jas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jasLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kontrastLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kontrast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reset))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void kontrastStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_kontrastStateChanged
        
    }//GEN-LAST:event_kontrastStateChanged

    private void jasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jasStateChanged
        
    }//GEN-LAST:event_jasStateChanged

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        jas.setValue((jas.getMaximum()-jas.getMinimum())/2 + jas.getMinimum());
        kontrast.setValue((kontrast.getMaximum()-kontrast.getMinimum())/2 + kontrast.getMinimum());
        HerniPlochaController.getInstance().nastavJas(0);
        HerniPlochaController.getInstance().nastavKontrast(0);
        GraphicsHandler.zmenFont();
    }//GEN-LAST:event_resetActionPerformed

    private void jasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jasMouseReleased
        JSlider source = (JSlider) evt.getSource();
        int value = source.getValue();
        HerniPlochaController.getInstance().nastavJas(value);
        GraphicsHandler.zmenFont();
    }//GEN-LAST:event_jasMouseReleased

    private void kontrastMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kontrastMouseReleased
        JSlider source = (JSlider) evt.getSource();
        int value = source.getValue();
        HerniPlochaController.getInstance().nastavKontrast(value);
        GraphicsHandler.zmenFont();
    }//GEN-LAST:event_kontrastMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider jas;
    private javax.swing.JLabel jasLabel;
    private javax.swing.JSlider kontrast;
    private javax.swing.JLabel kontrastLabel;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}
