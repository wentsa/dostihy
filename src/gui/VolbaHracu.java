/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.Serializable;
import pomocne.DataHraci;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author wentsa
 */
public class VolbaHracu extends javax.swing.JPanel implements Serializable {
    private static final long serialVersionUID = 1L;

    private final DataHraci data=new DataHraci();
    /**
     * Creates new form VolbaHracu
     * @param d
     */
    public VolbaHracu() {
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jComboBox6 = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jComboBox7 = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jComboBox8 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jButton1.setBackground(new java.awt.Color(249, 249, 249));
        jButton1.setText("Hraj");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Počet hráčů:");

        jComboBox1.setMaximumRowCount(6);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4", "5", "6", "7" }));
        jComboBox1.setSelectedItem(jComboBox1.getItemAt(5)
        );
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(jTextField1);

        jComboBox2.setMaximumRowCount(9);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bílá", "Černá", "Červená", "Fialová", "Modrá", "Oranžová", "Tyrkysová", "Zelená", "Žlutá" }));
        jComboBox2.setSelectedIndex(0);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2);

        jComboBox3.setMaximumRowCount(9);
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bílá", "Černá", "Červená", "Fialová", "Modrá", "Oranžová", "Tyrkysová", "Zelená", "Žlutá" }));
        jComboBox3.setSelectedIndex(1);
        jPanel2.add(jComboBox3);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));
        jPanel3.add(jTextField3);

        jComboBox4.setMaximumRowCount(9);
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bílá", "Černá", "Červená", "Fialová", "Modrá", "Oranžová", "Tyrkysová", "Zelená", "Žlutá" }));
        jComboBox4.setSelectedIndex(2);
        jPanel3.add(jComboBox4);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));
        jPanel4.add(jTextField4);

        jComboBox5.setMaximumRowCount(9);
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bílá", "Černá", "Červená", "Fialová", "Modrá", "Oranžová", "Tyrkysová", "Zelená", "Žlutá" }));
        jComboBox5.setSelectedIndex(3);
        jPanel4.add(jComboBox5);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));
        jPanel5.add(jTextField5);

        jComboBox6.setMaximumRowCount(9);
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bílá", "Černá", "Červená", "Fialová", "Modrá", "Oranžová", "Tyrkysová", "Zelená", "Žlutá" }));
        jComboBox6.setSelectedIndex(4);
        jPanel5.add(jComboBox6);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));
        jPanel6.add(jTextField6);

        jComboBox7.setMaximumRowCount(9);
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bílá", "Černá", "Červená", "Fialová", "Modrá", "Oranžová", "Tyrkysová", "Zelená", "Žlutá" }));
        jComboBox7.setSelectedIndex(5);
        jPanel6.add(jComboBox7);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));
        jPanel7.add(jTextField7);

        jComboBox8.setMaximumRowCount(9);
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bílá", "Černá", "Červená", "Fialová", "Modrá", "Oranžová", "Tyrkysová", "Zelená", "Žlutá" }));
        jComboBox8.setSelectedIndex(6);
        jPanel7.add(jComboBox8);

        jLabel2.setText("Jméno");

        jLabel3.setText("Barva");

        jButton2.setText("Zpět");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(66, 66, 66))))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        JComboBox box=(JComboBox) evt.getSource();
        int selected = Integer.parseInt((String)box.getSelectedItem());
        jTextField1.setVisible(true);jComboBox2.setVisible(true);
        jTextField2.setVisible(true);jComboBox3.setVisible(true);
        jTextField3.setVisible(true);jComboBox4.setVisible(true);
        jTextField4.setVisible(true);jComboBox5.setVisible(true);
        jTextField5.setVisible(true);jComboBox6.setVisible(true);
        jTextField6.setVisible(true);jComboBox7.setVisible(true);
        jTextField7.setVisible(true);jComboBox8.setVisible(true);
        if(selected < 7) {
            jTextField7.setVisible(false);
            jComboBox8.setVisible(false);
            if(selected < 6) {
                jTextField6.setVisible(false);
                jComboBox7.setVisible(false);
                if(selected < 5) {
                    jTextField5.setVisible(false);
                    jComboBox6.setVisible(false);
                    if(selected < 4) {
                        jTextField4.setVisible(false);
                        jComboBox5.setVisible(false);
                        if(selected < 3) {
                            jTextField3.setVisible(false);
                            jComboBox4.setVisible(false);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List<String> jmena=new ArrayList<>();
        List<String> barvy=new ArrayList<>();
        if(!vyplnJmena(jmena)) {
            JOptionPane.showMessageDialog(this, "Každý hráč musí mít nějakou přezdívku!");
            return;
        }
        vyplnBarvy(barvy,jmena.size());
        if(duplicityBarev(barvy)) {
            JOptionPane.showMessageDialog(this, "Žádní dva hráči nesmí mít stejnou barvu!");
            return;
        }
        if(duplicityJmen(jmena)) {
            JOptionPane.showMessageDialog(this, "Žádní dva hráči nesmí používat stejnou přezdívku!");
            return;
        }
        data.barvy=barvy;
        data.jmena=jmena;
        try {
            ((HlavniOkno)SwingUtilities.getWindowAncestor(this)).zalozHrace(getData());
        } catch (InterruptedException ex) {
            Logger.getLogger(VolbaHracu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ((HlavniOkno)SwingUtilities.getWindowAncestor(this)).nastavMenu();
    }//GEN-LAST:event_jButton2ActionPerformed

        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables

    private boolean duplicityBarev(List<String> barvy) {
        for (int i=0;i<barvy.size();i++) {
            for (int k=i+1;k<barvy.size();k++) {
                if(barvy.get(i).equals(barvy.get(k))) return true;
            }
        }
        return false;
    }

    private boolean duplicityJmen(List<String> jmena) {
        for (int i=0;i<jmena.size();i++) {
            for (int k=i+1;k<jmena.size();k++) {
                if(jmena.get(i).equals(jmena.get(k))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean vyplnJmena(List<String> jmena) {
        jmena.add(jTextField1.getText());
        jmena.add(jTextField2.getText());
        if(jTextField3.isVisible()) {
            jmena.add(jTextField3.getText());
        }
        if(jTextField4.isVisible()) {
            jmena.add(jTextField4.getText());
        }
        if(jTextField5.isVisible()) {
            jmena.add(jTextField5.getText());
        }
        if(jTextField6.isVisible()) {
            jmena.add(jTextField6.getText());
        }
        if(jTextField7.isVisible()) {
            jmena.add(jTextField7.getText());
        }
        for (String s : jmena) {
            if(s.equals("")) {
                return false;
            }
        }
        return true;
    }

    private void vyplnBarvy(List<String> barvy, int delka) {
        barvy.add(jComboBox2.getSelectedItem().toString());
        barvy.add(jComboBox3.getSelectedItem().toString());
        barvy.add(jComboBox4.getSelectedItem().toString());
        barvy.add(jComboBox5.getSelectedItem().toString());
        barvy.add(jComboBox6.getSelectedItem().toString());
        barvy.add(jComboBox7.getSelectedItem().toString());
        barvy.add(jComboBox8.getSelectedItem().toString());
        for(int i=6;i>=delka;i--) {
            barvy.remove(i);
        }
    }

    /**
     * @return the data
     */
    public DataHraci getData() {
        return data;
    }
}
