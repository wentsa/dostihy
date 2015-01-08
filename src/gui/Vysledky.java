/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import hra.Hra;
import hra.Hrac;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.swing.RowSorter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author wentsa
 */
public class Vysledky extends javax.swing.JPanel implements Serializable {

    /**
     * Creates new form Vysledky
     */
    public Vysledky() {
        initComponents();
        tabulka.setAutoCreateRowSorter(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabulka = new javax.swing.JTable();
        vysledky = new javax.swing.JLabel();
        celkCas = new javax.swing.JLabel();
        cas = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        tabulka.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Pořadí", "Jméno", "Cas ve hře", "Max hotovost", "Max karet"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabulka.setFillsViewportHeight(true);
        tabulka.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabulka);
        if (tabulka.getColumnModel().getColumnCount() > 0) {
            tabulka.getColumnModel().getColumn(0).setPreferredWidth(1);
            tabulka.getColumnModel().getColumn(2).setPreferredWidth(1);
            tabulka.getColumnModel().getColumn(3).setPreferredWidth(1);
            tabulka.getColumnModel().getColumn(4).setPreferredWidth(1);
        }

        vysledky.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        vysledky.setText("Výsledky");

        celkCas.setText("Celkový čas hry:");

        jButton1.setText("Nová hra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 288, Short.MAX_VALUE)
                        .addComponent(vysledky)
                        .addGap(0, 288, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(celkCas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vysledky)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(celkCas)
                        .addComponent(cas)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ((HlavniOkno)SwingUtilities.getWindowAncestor(this)).reset();
        ((HlavniOkno)SwingUtilities.getWindowAncestor(this)).nastavMenu();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cas;
    private javax.swing.JLabel celkCas;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabulka;
    private javax.swing.JLabel vysledky;
    // End of variables declaration//GEN-END:variables

    public void vyplnTabulku(List<Hrac> vysledky) {
        ((DefaultTableModel)tabulka.getModel()).setRowCount(vysledky.size());
        cas.setText(Hra.getInstance().getCelkovyCas());
        int i=0;
        Collections.reverse(vysledky);
        for (Hrac h : vysledky) {
            tabulka.setValueAt(i+1, i, 0);
            tabulka.setValueAt(h.getJmeno(), i, 1);
            tabulka.setValueAt(h.getCas(), i, 2);
            tabulka.setValueAt(h.getMaxHotovost(), i, 3);
            tabulka.setValueAt(h.getMaxKaret(), i, 4);
            i++;
        }
        
    }
}
