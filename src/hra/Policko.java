/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hra;

import grafika.RozmeryPlochy;
import gui.figurka.obsazovaci.ObsazovaciFigurkaController;
import gui.plocha.HerniPlochaView;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import karty.vlastnicke.Kun;
import karty.vlastnicke.VlastnickaKarta;
import pomocne.Barva;
import pomocne.Konstanty;

/**
 *
 * @author wentsa
 */
public class Policko extends JButton implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final ResourceBundle bundle = ResourceBundle.getBundle("languages/game/Game", Konstanty.DEFAULT_LOCALE);

    private final int cislo;
    private final String nazev;
    private final boolean vlastnicka;
    private boolean obsazeno;
    private Hrac majitel;
    private final VlastnickaKarta karta;
    private final ObsazovaciFigurkaController obsazFigurka;
    private final JPopupMenu popup;
    private boolean muzeVsadit = false;

    public Policko(int cislo, String nazev, VlastnickaKarta karta) {
        System.out.print("   " + (cislo));
        this.obsazeno = false;
        this.majitel = null;
        this.karta = karta;
        this.nazev = nazev;
        this.vlastnicka = true;
        this.cislo = cislo - 1;
        System.out.print(" figurka");
        this.obsazFigurka = new ObsazovaciFigurkaController(Barva.RED, cislo - 1, 0);
        if (karta instanceof Kun) {
            popup = new JPopupMenu();
            popup.add(new AbstractAction(bundle.getString("BET_ON_HORSE")) {
                private static final long serialVersionUID = 1L;

                @Override
                public void actionPerformed(ActionEvent e) {
                    Policko.this.vsadit();
                }
            });
        } else {
            popup = null;
        }
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getKarta().zobraz();
                } catch (InterruptedException ex) {
                    Logger.getLogger(HerniPlochaView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        addMouseListener(rightClick());
        System.out.println("...done");
    }

    public Policko(int cislo, String nazev) {
        this.obsazeno = false;
        this.majitel = null;
        this.karta = null;
        this.nazev = nazev;
        this.vlastnicka = false;
        this.cislo = cislo - 1;
        this.obsazFigurka = new ObsazovaciFigurkaController(Barva.RED, cislo - 1, 0);
        this.popup = null;
    }

    @Override
    public String toString() {
        return "Policko{" + "nazev=" + getNazev() + ", karta=" + getKarta() + '}';
    }

    /**
     * @return the nazev
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * @return the vlastnik
     */
    public boolean isVlastnicka() {
        return vlastnicka;
    }

    /**
     * @return the obsazeno
     */
    public boolean isObsazeno() {
        return obsazeno;
    }

    /**
     * @param obsazeno the obsazeno to set
     */
    public void setObsazeno(boolean obsazeno) {
        this.obsazeno = obsazeno;
        obsazFigurka.setObsazeno(obsazeno);
    }

    /**
     * @return the majitel
     */
    public Hrac getMajitel() {
        return majitel;
    }

    /**
     * @param majitel the majitel to set
     */
    public void setMajitel(Hrac majitel) {
        this.majitel = majitel;
        if (majitel != null) {
            obsazFigurka.zmenBarvu(this.majitel.getFigurka().getBarva());
        }
    }

    /**
     * @return the karta
     */
    public VlastnickaKarta getKarta() {
        return karta;
    }

    public int souradniceX() {
        return (int) ((int) (255 * RozmeryPlochy.getScalingFactor())
                * Math.cos(Math.toRadians((getPozice() + 5) * 9 + 4.5)))
                + (int) (330 * RozmeryPlochy.getScalingFactor());
    }

    public int souradniceY() {
        return (int) ((int) (255 * RozmeryPlochy.getScalingFactor())
                * Math.sin(Math.toRadians((getPozice() + 5) * 9 + 4.5)))
                + (int) (330 * RozmeryPlochy.getScalingFactor());
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        setBounds(souradniceX(), souradniceY(), (int) (40 * RozmeryPlochy.getScalingFactor()), (int) (40 * RozmeryPlochy.getScalingFactor()));
    }

    /**
     * @return the obsazFigurka
     */
    public ObsazovaciFigurkaController getObsazFigurka() {
        return obsazFigurka;
    }

    public int getPozice() {
        return cislo;
    }

    private MouseListener rightClick() {
        MouseListener listener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
                    if (Policko.this.isEnabled() && popup != null && Policko.this.muzeVsadit) {
                        popup.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        return listener;
    }

    private void vsadit() {
        String castka = JOptionPane.showInputDialog(this, MessageFormat.format(bundle.getString("BET_ON"), new Object[]{karta.getJmeno()}));
        if (castka == null) {
            return;
        }
        try {
            int kolik = Integer.parseInt(castka);
            if (kolik > Hra.getInstance().getAktualniHrac().getRozpocet()) {
                JOptionPane.showMessageDialog(this, bundle.getString("NOT_ENOUGH_MONEY"));
                return;
            }
            if (kolik <= 0) {
                JOptionPane.showMessageDialog(this, MessageFormat.format(bundle.getString("MINIMUM_BET_IS"), new Object[]{1}));
                return;
            }
            if (karta instanceof Kun) {
                ((Kun) karta).vsad(kolik);
                Hra.getInstance().getAktualniHrac().pricti(-kolik);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, bundle.getString("BAD_BET_NUMBER_FORMAT"));
        }
    }

    public void setMuzeVsadit(boolean muzeVsadit) {
        this.muzeVsadit = muzeVsadit;
    }

    public void aktualizuj() {
        getObsazFigurka().aktualizuj();
        if (getKarta() instanceof Kun) {
            Kun kun = (Kun) getKarta();
            kun.aktualizujDostihy();
        }
    }

}
