/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import grafika.GraphicsHandler;
import grafika.RozmeryPlochy;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import karty.Karta;
import karty.finance.Finance;
import karty.nahoda.Nahoda;
import karty.vlastnicke.Kun;
import karty.vlastnicke.PrepravaStaje;
import karty.vlastnicke.Trener;
import pomocne.Konstanty;

/**
 *
 * @author wentsa
 */
public class KartaGUI extends javax.swing.JPanel {

    private static final long serialVersionUID = 8705997785882573312L;
    private static final ResourceBundle bundle = ResourceBundle.getBundle("languages/game/Cards", Konstanty.defaultLocale);

    private final Image pozadi = GraphicsHandler.get("karta");
    private final Font fontPopis;
    private final Font fontNadpis;
    private final Karta karta;
    private String nadpisText = null;
    private String popisText = null;

    /**
     * Creates new form KartaGUI2
     *
     * @param karta
     */
    public KartaGUI(Karta karta) {
        this.karta = karta;
        if (karta instanceof Kun) {
            fontPopis = new Font(Konstanty.fontName, Font.PLAIN, (int) (13 * RozmeryPlochy.getScalingFactor()));
            fontNadpis = new Font(Konstanty.fontName, Font.BOLD, (int) (15 * RozmeryPlochy.getScalingFactor()));
        } else {
            fontPopis = new Font(Konstanty.fontName, Font.PLAIN, (int) (16 * RozmeryPlochy.getScalingFactor()));
            fontNadpis = new Font(Konstanty.fontName, Font.BOLD, (int) (18 * RozmeryPlochy.getScalingFactor()));
        }
        initComponents();
        nactiText();
        nadpis.setText(nadpisText);
        popis.setText(popisText);
        System.out.println(this.getBorder().getBorderInsets(this).toString());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(pozadi, 0, 0, this);
    }

    private void nactiText() {
        int sirkaTabulky = this.getPreferredSize().width - 2 * this.getBorder().getBorderInsets(this).left;
        if (this.karta instanceof Finance) {
            nadpisText = bundle.getString("FINANCES");
            popisText = "<html><body><p><center>" + this.karta.toString() + "</center></p></body></html>";
        } else if (this.karta instanceof Nahoda) {
            nadpisText = bundle.getString("LUCK");
            popisText = "<html><body><p><center>" + this.karta.toString() + "</center></p></body></html>";
        } else if (this.karta instanceof Kun) {
            Kun tmp = (Kun) this.karta;
            nadpisText = tmp.getJmeno().toUpperCase();
            popisText
                    = "<html><body><table width=" + sirkaTabulky + "><tr><td align=left>"
                    + bundle.getString("COST")
                    + "</td><td align=right>" + tmp.getPorizovaciCena() + ",-</td></tr>"
                    + "<tr><td align=left>"
                    + bundle.getString("STABLE_WATCH")
                    + "</td><td align=right>" + tmp.getProhlidkaStaje() + ",-</td></tr></table><br>"
                    + bundle.getString("PROFIT_FROM")
                    + "<br>"
                    + "<table width=" + sirkaTabulky + "><tr><td align=left>&nbsp;&nbsp;&nbsp;"
                    + bundle.getString("FROM_1_RACE")
                    + "</td><td align=right>" + tmp.getDostih1() + ",-</td></tr>"
                    + "<tr><td align=left>&nbsp;&nbsp;&nbsp;"
                    + bundle.getString("FROM_2_RACES")
                    + "</td><td align=right>" + tmp.getDostih2() + ",-</td></tr>"
                    + "<tr><td align=left>&nbsp;&nbsp;&nbsp;"
                    + bundle.getString("FROM_3_RACES")
                    + "</td><td align=right>" + tmp.getDostih3() + ",-</td></tr>"
                    + "<tr><td align=left>&nbsp;&nbsp;&nbsp;"
                    + bundle.getString("FROM_4_RACES")
                    + "</td><td align=right>" + tmp.getDostih4() + ",-</td></tr>"
                    + "<tr><td align=left>&nbsp;&nbsp;&nbsp;"
                    + bundle.getString("FROM_MAIN_RACE")
                    + "</td><td align=right>" + tmp.getHlDostih() + ",-</td></tr></table>"
                    + bundle.getString("PREPARE_COST")
                    + "<br>"
                    + "<table width=" + sirkaTabulky + "><tr><td>&nbsp;&nbsp;&nbsp;"
                    + bundle.getString("FOR_NEW_RACE")
                    + "</td><td align=right>" + tmp.getPripravaDostihu() + ",-</td></tr>"
                    + "<tr><td align=left>&nbsp;&nbsp;&nbsp;"
                    + bundle.getString("FOR_MAIN_RACE")
                    + "</td><td align=right>" + tmp.getPripravaHlavnihoDostihu() + ",-</td></tr>"
                    + "<tr><td align=left>"
                    + bundle.getString("OWNER")
                    + " </td><td align=right>" + (tmp.getMajitel() == null ? "nikdo" : tmp.getMajitel().getJmeno()) + "</td></tr>"
                    + "<tr><td align=left>"
                    + bundle.getString("CURRENT_BET")
                    + " </td><td align=right>" + tmp.getSazka() + ",-</td></tr>"
                    + "</table></body></html>";
        } else if (this.karta instanceof Trener) {
            Trener tmp = (Trener) this.karta;
            nadpisText = "TRENÉR" + " " + tmp.getCislo();
            popisText
                    = "<html><body><br><table width=" + sirkaTabulky + "><tr><td align=left>"
                    + bundle.getString("LICENSE_COST")
                    + "</td><td align=right>" + tmp.getPorizovaciCena() + ",-</td></tr></table><br><br>"
                    + bundle.getString("OWNER_GATHERS")
                    + "<br>"
                    + "<table width=" + sirkaTabulky + "><tr><td align=left>"
                    + "&nbsp;&nbsp;&nbsp;"
                    + bundle.getString("1ST_LICENSE")
                    + "</td><td align=right>1.000,-</td></tr>"
                    + "&nbsp;&nbsp;&nbsp;"
                    + bundle.getString("2ND_LICENSE")
                    + "</td><td align=right>2.000,-</td></tr>"
                    + "&nbsp;&nbsp;&nbsp;"
                    + bundle.getString("3RD_LICENSE")
                    + "</td><td align=right>3.000,-</td></tr>"
                    + "&nbsp;&nbsp;&nbsp;"
                    + bundle.getString("4TH_LICENSE")
                    + "</td><td align=right>4.000,-</td></tr></table>"
                    + "<br><br><table width=" + sirkaTabulky + "><tr><td align=left>"
                    + bundle.getString("OWNER")
                    + " </td><td align=right>" + (tmp.getMajitel() == null ? "nikdo" : tmp.getMajitel().getJmeno()) + "</td></tr></table>"
                    + "</body></html>";
        } else if (this.karta instanceof PrepravaStaje) {
            PrepravaStaje tmp = (PrepravaStaje) this.karta;
            nadpisText = tmp.getJmeno().toUpperCase();
            popisText = "<html><body><br><table width=" + sirkaTabulky + "><tr><td align=left>"
                    + bundle.getString("COST")
                    + "</td><td align=right>" + tmp.getPorizovaciCena() + ",-</td></tr></table><br><br><p>" + tmp.getPopis() + "</p><br>"
                    + "<br><br><br><br><table width=" + sirkaTabulky + "><tr><td align=left>"
                    + bundle.getString("OWNER")
                    + " </td><td align=right>" + (tmp.getMajitel() == null ? "nikdo" : tmp.getMajitel().getJmeno()) + "</td></tr></table><br><br>"
                    + "                    </body></html>";
        }
    }

    public int getSirkaObrazku() {
        return pozadi.getWidth(this);
    }

    public int getVyskaObrazku() {
        return pozadi.getHeight(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nadpis = new javax.swing.JLabel("a",JLabel.CENTER);
        popis = new javax.swing.JLabel("a",JLabel.CENTER);

        setBackground(new java.awt.Color(255, 0, 0));
        setBorder(BorderFactory.createEmptyBorder((int)(10*RozmeryPlochy.getScalingFactor()), (int)(30*RozmeryPlochy.getScalingFactor()), (int)(40*RozmeryPlochy.getScalingFactor()), (int)(30*RozmeryPlochy.getScalingFactor())));
        setMaximumSize(new Dimension(pozadi.getWidth(this),pozadi.getHeight(this)));
        setMinimumSize(new Dimension(pozadi.getWidth(this),pozadi.getHeight(this)));
        setPreferredSize(new Dimension(pozadi.getWidth(this),pozadi.getHeight(this)));

        nadpis.setFont(fontNadpis);
        nadpis.setForeground(GraphicsHandler.getBarvaFontu());
        nadpis.setText("wqewq");
        nadpis.setBorder(null);
        nadpis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        popis.setFont(fontPopis);
        popis.setText("jLabel1");
        popis.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(popis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nadpis, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nadpis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(popis, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nadpis;
    private javax.swing.JLabel popis;
    // End of variables declaration//GEN-END:variables
}
