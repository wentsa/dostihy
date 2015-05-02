/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ResourceBundle;
import pomocne.Konstanty;

/**
 *
 * @author chaluto2
 */
public class Napoveda extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    private static final ResourceBundle bundle = ResourceBundle.getBundle("languages/gui/GUI", Konstanty.defaultLocale);

    /**
     * Creates new form Napoveda
     */
    public Napoveda() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        help = new javax.swing.JPanel();
        text = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        help1 = new javax.swing.JPanel();
        text1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        help2 = new javax.swing.JPanel();
        text2 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        help3 = new javax.swing.JPanel();
        text3 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        help4 = new javax.swing.JPanel();
        text4 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText(bundle.getString("HELP_1")); // NOI18N
        jTextArea1.setWrapStyleWord(true);
        text.setViewportView(jTextArea1);

        javax.swing.GroupLayout helpLayout = new javax.swing.GroupLayout(help);
        help.setLayout(helpLayout);
        helpLayout.setHorizontalGroup(
            helpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );
        helpLayout.setVerticalGroup(
            helpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Karty", help);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText(bundle.getString("HELP_2")); // NOI18N
        jTextArea2.setWrapStyleWord(true);
        text1.setViewportView(jTextArea2);

        javax.swing.GroupLayout help1Layout = new javax.swing.GroupLayout(help1);
        help1.setLayout(help1Layout);
        help1Layout.setHorizontalGroup(
            help1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(help1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );
        help1Layout.setVerticalGroup(
            help1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(help1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inventář", help1);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setText(bundle.getString("HELP_3")); // NOI18N
        jTextArea3.setWrapStyleWord(true);
        text2.setViewportView(jTextArea3);

        javax.swing.GroupLayout help2Layout = new javax.swing.GroupLayout(help2);
        help2.setLayout(help2Layout);
        help2Layout.setHorizontalGroup(
            help2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(help2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text2, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );
        help2Layout.setVerticalGroup(
            help2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(help2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text2, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Jas", help2);

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setText(bundle.getString("HELP_4")); // NOI18N
        jTextArea4.setWrapStyleWord(true);
        text3.setViewportView(jTextArea4);

        javax.swing.GroupLayout help3Layout = new javax.swing.GroupLayout(help3);
        help3.setLayout(help3Layout);
        help3Layout.setHorizontalGroup(
            help3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(help3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text3, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );
        help3Layout.setVerticalGroup(
            help3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(help3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text3, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sázení", help3);

        jTextArea5.setEditable(false);
        jTextArea5.setColumns(20);
        jTextArea5.setLineWrap(true);
        jTextArea5.setRows(5);
        jTextArea5.setText(bundle.getString("HELP_5")); // NOI18N
        jTextArea5.setWrapStyleWord(true);
        text4.setViewportView(jTextArea5);

        javax.swing.GroupLayout help4Layout = new javax.swing.GroupLayout(help4);
        help4.setLayout(help4Layout);
        help4Layout.setHorizontalGroup(
            help4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(help4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text4, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );
        help4Layout.setVerticalGroup(
            help4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(help4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text4, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Výsledky", help4);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel help;
    private javax.swing.JPanel help1;
    private javax.swing.JPanel help2;
    private javax.swing.JPanel help3;
    private javax.swing.JPanel help4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JScrollPane text;
    private javax.swing.JScrollPane text1;
    private javax.swing.JScrollPane text2;
    private javax.swing.JScrollPane text3;
    private javax.swing.JScrollPane text4;
    // End of variables declaration//GEN-END:variables
}
