/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.plocha.HerniPlochaController;
import hra.Hra;
import hra.Hrac;
import hra.Policko;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import karty.vlastnicke.Kun;
import karty.vlastnicke.VlastnickaKarta;
import pomocne.Staj;

/**
 *
 * @author wentsa
 */
public class ProdejGUI extends javax.swing.JPanel implements Serializable {

    /**
     * Creates new form ProdejGUI
     */
    private final Hrac hrac;
    private final Set<VlastnickaKarta> karty;
    private String[] hracovyKarty;
    private Map<String, Kun> hracovyDostihy;
    private boolean prodavaBance = true;
    private Hrac kupec;
    private int suma;

    class ComboItem {

        private final String value;

        public ComboItem(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

        public String getValue() {
            return value;
        }
    }

    @SuppressWarnings("unchecked")
    public ProdejGUI(Hrac hrac) {
        this.hrac = hrac;
        karty = this.hrac.getKarty();
        initComponents();
        nactiData();
        vypis.setContentType("text/html");

        kombo.addItem(new ComboItem("--banka--"));
        for (Hrac h : Hra.getInstance().getHraci()) {
            if (!h.equals(hrac) && h.isAktivni()) {
                kombo.addItem(new ComboItem(h.getJmeno()));
            }
        }

        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                boolean adjust = listSelectionEvent.getValueIsAdjusting();
                if (!adjust) {
                    JList list = (JList) listSelectionEvent.getSource();
                    List selectionValues = list.getSelectedValuesList();
                    int sirka = ProdejGUI.this.vypis.getWidth();
                    String text = "<html><table width=" + sirka + ">";
                    suma = 0;
                    for (Object o : selectionValues) {
                        if (((String) o).contains("-")) {
                            Kun k = null;
                            for (Map.Entry<String, Kun> entry : ProdejGUI.this.hracovyDostihy.entrySet()) {
                                if (entry.getKey().equals((String) o)) {
                                    k = entry.getValue();
                                    int porCena;
                                    if (entry.getKey().indexOf('1') != -1
                                            || entry.getKey().indexOf('2') != -1
                                            || entry.getKey().indexOf('3') != -1
                                            || entry.getKey().indexOf('4') != -1) {
                                        porCena = k.getPripravaDostihu();
                                    } else {
                                        porCena = k.getPripravaHlavnihoDostihu();
                                    }
                                    suma += (porCena / 2);
                                    text = text.concat("<tr><td>" + entry.getKey() + "</td>");
                                    if (prodavaBance) {
                                        text = text + "<td align=right>" + (porCena / 2) + ",-</td></tr>";
                                    } else {
                                        text += "</tr>";
                                    }
                                    break;
                                }

                            }

                        } else {
                            VlastnickaKarta k = null;
                            for (VlastnickaKarta c : ProdejGUI.this.karty) {
                                if (c.toString().equals(o.toString())) {
                                    k = c;
                                    break;
                                }
                            }
                            suma += (k.getPorizovaciCena());
                            text = text.concat("<tr><td>" + k.toString() + "</td>");
                            if (prodavaBance) {
                                text = text + "<td align=right>" + k.getPorizovaciCena() + ",-</td></tr>";
                            } else {
                                text += "</tr>";
                            }
                        }
                    }
                    text = text.concat("</table></html>");

                    ProdejGUI.this.vypis.setText(text);
                    if (prodavaBance) {
                        ProdejGUI.this.celkem.setText("<html><table width=" + sirka + "><tr><td>CELKEM</td><td align=right>" + suma + ",-</td></tr></table></html>");
                    } else {
                        ProdejGUI.this.celkem.setText("");
                    }
                    repaint();
                }
            }
        };
        jList1.addListSelectionListener(listSelectionListener);

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
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        vypis = new javax.swing.JTextPane();
        celkem = new javax.swing.JLabel();
        button = new javax.swing.JButton();
        kombo = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jScrollPane1.setBorder(null);

        jList1.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return ProdejGUI.this.hracovyKarty.length; }
            public Object getElementAt(int i) { return ProdejGUI.this.hracovyKarty[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Vzdát se");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Odstranit výběr");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        vypis.setEditable(false);
        vypis.setBorder(null);
        jScrollPane2.setViewportView(vypis);

        celkem.setText("jLabel1");

        button.setText("Prodej");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        kombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                komboItemStateChanged(evt);
            }
        });
        kombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                komboActionPerformed(evt);
            }
        });
        kombo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                komboPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(celkem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(kombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(celkem)
                        .addGap(0, 29, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button)
                    .addComponent(jButton2)
                    .addComponent(jButton1)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        if (!jList1.isSelectionEmpty()) {
            if (!prodavaBance) {
                for (Object o : jList1.getSelectedValuesList()) {
                    String value = o.toString();
                    if (value.contains("-")) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), "Dostihy můžete prodávat pouze bance.");
                        return;
                    }
                    for (VlastnickaKarta k : karty) {
                        if (value.equals(k.toString())) {
                            if (k instanceof Kun) {
                                Kun kun = (Kun) k;
                                if (!overStaj(kun.getStaj())) {
                                    JOptionPane.showMessageDialog((ProdejDialog) SwingUtilities.getWindowAncestor(this), "Nemůžeš prodat svého koně. Nejprve prodej dostihy stáje (" + kun.getStaj() + ")");
                                    return;
                                }
                            }
                            break;
                        }
                    }
                }
                String castka = JOptionPane.showInputDialog(SwingUtilities.getWindowAncestor(this), "Chystáte se prodat hráči " + kupec.getJmeno() + " své karty. Nabídněte prosím požadovanou částku. Doporučená částka je " + suma + ",-");
                if(castka==null) return;
                try {
                    int cena = Integer.parseInt(castka);
                    if (cena < 0) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), "Záporné hodnoty by znamenaly, že vy budete platit za to, že si " + kupec.getJmeno() + " od Vás koupí karty. Zadejte prosím kladné hodnoty.");
                        return;
                    }
                    if (cena > kupec.getRozpocet()) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), "Bohužel kupec nemá dostatek financí. Maximum je " + kupec.getRozpocet() + ",-");
                        return;
                    }

                    Object[] volby = {"Ano", "Ne"};
                    int odpoved = JOptionPane.showOptionDialog(null, (kupec.getJmeno() + " chcete od hráče " + hrac.getJmeno() + " koupit označené karty za " + cena + ",-?"), "Obchod", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, volby, volby[0]);
                    if (odpoved != JOptionPane.YES_OPTION) {
                        return;
                    }
                    suma = cena;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Zadejte pouze číslo reprezentující částku.");
                }
            }
            List selectionValues = jList1.getSelectedValuesList();
            Set<VlastnickaKarta> vymazatKone = new HashSet<>();
            Set<Kun> vymazatDostihy = new HashSet<>();
            for (Object o : selectionValues) {
                if (((String) o).contains("-")) {
                    for (Map.Entry<String, Kun> entry : ProdejGUI.this.hracovyDostihy.entrySet()) {
                        if (entry.getKey().equals((String) o)) {
                            vymazatDostihy.add(entry.getValue());
                            break;
                        }
                    }
                } else {
                    VlastnickaKarta k = null;
                    for (VlastnickaKarta c : ProdejGUI.this.karty) {
                        if (c.toString().equals(o.toString())) {
                            k = c;
                            break;
                        }
                    }
                    vymazatKone.add(k);
                }
            }
            for (VlastnickaKarta k : vymazatKone) {
                if (k instanceof Kun) {
                    Kun kun = (Kun) k;
                    if (!overStaj(kun.getStaj())) {
                        JOptionPane.showMessageDialog((ProdejDialog) SwingUtilities.getWindowAncestor(this), "Nemůžeš prodat svého koně. Nejprve prodej dostihy stáje (" + kun.getStaj() + ")");
                        return;
                    }
                }
                Policko p = Hra.getInstance().getPolicka().get(k.getPozice());
                if (prodavaBance) {
                    p.setObsazeno(false);
                    p.setMajitel(null);
                    p.getObsazFigurka().setObsazeno(false);
                    k.setMajitel(null);
                } else {
                    p.setMajitel(kupec);
                    kupec.pridejKartu(k);
                }
                karty.remove(k);
            }
            for (Kun k : vymazatDostihy) {
                k.odeberDostih(hrac);
            }
            hrac.pricti(suma);
            if (!prodavaBance) {
                kupec.pricti(-suma);
            }
            jList1.clearSelection();
            nactiData();
            vypis.setText("");
            hrac.getJmenovka().aktualizujToolTip();
            repaint();
        }
    }//GEN-LAST:event_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HerniPlochaController.getInstance().odpalVzdatSe();
        SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jList1.clearSelection();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void komboPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_komboPropertyChange

    }//GEN-LAST:event_komboPropertyChange

    private void komboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_komboItemStateChanged

    }//GEN-LAST:event_komboItemStateChanged

    private void komboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_komboActionPerformed
        String value = ((ComboItem) kombo.getSelectedItem()).getValue();
        if (value.equals("--banka--")) {
            prodavaBance = true;
        } else {
            prodavaBance = false;
            for (Hrac h : Hra.getInstance().getHraci()) {
                if (value.equals(h.getJmeno())) {
                    kupec = h;
                    break;
                }
            }
        }
        int[] idxs = jList1.getSelectedIndices();
        jList1.clearSelection();
        jList1.setSelectedIndices(idxs);
    }//GEN-LAST:event_komboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button;
    private javax.swing.JLabel celkem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox kombo;
    private javax.swing.JTextPane vypis;
    // End of variables declaration//GEN-END:variables

    private void nactiData() {
        String[] tmp = new String[karty.size()];
        hracovyDostihy = new TreeMap<>();
        LinkedList<String> tmp2 = new LinkedList<>();
        int i = 0;
        for (VlastnickaKarta k : karty) {
            tmp[i++] = k.toString();
            if (k instanceof Kun) {
                Kun kun = (Kun) k;
                if (kun.getPocetDostihu() == 5) {
                    String key = kun.getJmeno() + " - hlavní dostih";
                    tmp2.add(key);
                    hracovyDostihy.put(key, kun);
                } else if (kun.getPocetDostihu() > 0) {
                    String key = kun.getJmeno() + " - dostih " + kun.getPocetDostihu();
                    tmp2.add(key);
                    hracovyDostihy.put(key, kun);
                }
            }
        }
        hracovyKarty = Arrays.copyOf(tmp, tmp.length + tmp2.size());
        for (String s : tmp2) {
            hracovyKarty[i++] = s;
        }
        Arrays.sort(hracovyKarty, 0, Math.max(0, hracovyKarty.length - 1), new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.contains("dostih")) {
                    if (b.contains("dostih")) {
                        return a.compareTo(b);
                    } else {
                        return 1;
                    }
                } else {
                    if (b.contains("dostih")) {
                        return -1;
                    } else {
                        return a.compareTo(b);
                    }
                }
            }
        });
        celkem.setText("");
    }

    private boolean overStaj(Staj staj) {
        for (VlastnickaKarta k : karty) {
            if (k instanceof Kun) {
                Kun kun = (Kun) k;
                if (kun.getStaj().equals(staj) && kun.getPocetDostihu() > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
