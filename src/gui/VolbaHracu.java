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
import javax.swing.SwingUtilities;

/**
 *
 * @author wentsa
 */
public class VolbaHracu extends javax.swing.JPanel implements Serializable {

    DataHraci data=new DataHraci();
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

        jButton1.setBackground(new java.awt.Color(249, 249, 249));
        jButton1.setText("Hraj");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Pocet hracu:");

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
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bila", "Cerna", "Cervena", "Fialova", "Modra", "Oranzova", "Tyrkysova", "Zelena", "Zluta" }));
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
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bila", "Cerna", "Cervena", "Fialova", "Modra", "Oranzova", "Tyrkysova", "Zelena", "Zluta" }));
        jComboBox3.setSelectedItem(jComboBox3.getItemAt(1)
        );
        jPanel2.add(jComboBox3);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));
        jPanel3.add(jTextField3);

        jComboBox4.setMaximumRowCount(9);
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bila", "Cerna", "Cervena", "Fialova", "Modra", "Oranzova", "Tyrkysova", "Zelena", "Zluta" }));
        jComboBox4.setSelectedItem(jComboBox4.getItemAt(2));
        jPanel3.add(jComboBox4);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));
        jPanel4.add(jTextField4);

        jComboBox5.setMaximumRowCount(9);
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bila", "Cerna", "Cervena", "Fialova", "Modra", "Oranzova", "Tyrkysova", "Zelena", "Zluta" }));
        jComboBox5.setSelectedItem(jComboBox5.getItemAt(3));
        jPanel4.add(jComboBox5);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));
        jPanel5.add(jTextField5);

        jComboBox6.setMaximumRowCount(9);
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bila", "Cerna", "Cervena", "Fialova", "Modra", "Oranzova", "Tyrkysova", "Zelena", "Zluta" }));
        jComboBox6.setSelectedItem(jComboBox6.getItemAt(5));
        jPanel5.add(jComboBox6);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));
        jPanel6.add(jTextField6);

        jComboBox7.setMaximumRowCount(9);
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bila", "Cerna", "Cervena", "Fialova", "Modra", "Oranzova", "Tyrkysova", "Zelena", "Zluta" }));
        jComboBox7.setSelectedItem(jComboBox7.getItemAt(4));
        jPanel6.add(jComboBox7);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));
        jPanel7.add(jTextField7);

        jComboBox8.setMaximumRowCount(9);
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bila", "Cerna", "Cervena", "Fialova", "Modra", "Oranzova", "Tyrkysova", "Zelena", "Zluta" }));
        jComboBox8.setSelectedItem(jComboBox8.getItemAt(6));
        jPanel7.add(jComboBox8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
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
                .addContainerGap(32, Short.MAX_VALUE))
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
        List<String> tmp=new ArrayList<>();
        if(jTextField1.isVisible()) {
            String jmeno=jTextField1.getText();
            if("".equals(jmeno)) jmeno="zadne jmeno hrace 1";
            String barva=(String)jComboBox2.getSelectedItem();
            tmp.add(jmeno);
            data.barvy.add(barva);
        }
        if(jTextField2.isVisible()) {
            String jmeno=jTextField2.getText();
            if("".equals(jmeno)) jmeno="zadne jmeno hrace 2";
            String barva=(String)jComboBox3.getSelectedItem();
            tmp.add(jmeno);
            data.barvy.add(barva);
        }
        if(jTextField3.isVisible()) {
            String jmeno=jTextField3.getText();
            if("".equals(jmeno)) jmeno="zadne jmeno hrace 3";
            String barva=(String)jComboBox4.getSelectedItem();
            tmp.add(jmeno);
            data.barvy.add(barva);
        }
        if(jTextField4.isVisible()) {
            String jmeno=jTextField4.getText();
            if("".equals(jmeno)) jmeno="zadne jmeno hrace 4";
            String barva=(String)jComboBox5.getSelectedItem();
            tmp.add(jmeno);
            data.barvy.add(barva);
        }
        if(jTextField5.isVisible()) {
            String jmeno=jTextField5.getText();
            if("".equals(jmeno)) jmeno="zadne jmeno hrace 5";
            String barva=(String)jComboBox6.getSelectedItem();
            tmp.add(jmeno);
            data.barvy.add(barva);
        }
        if(jTextField6.isVisible()) {
            String jmeno=jTextField6.getText();
            if("".equals(jmeno)) jmeno="zadne jmeno hrace 6";
            String barva=(String)jComboBox7.getSelectedItem();
            tmp.add(jmeno);
            data.barvy.add(barva);
        }
        if(jTextField7.isVisible()) {
            String jmeno=jTextField7.getText();
            if("".equals(jmeno)) jmeno="zadne jmeno hrace 7";
            String barva=(String)jComboBox8.getSelectedItem();
            tmp.add(jmeno);
            data.barvy.add(barva);
        }
        data.jmena=tmp;
        try {
            ((HlavniOkno)SwingUtilities.getWindowAncestor(this)).zalozHrace(data);
        } catch (InterruptedException ex) {
            Logger.getLogger(VolbaHracu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JLabel jLabel1;
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
}
