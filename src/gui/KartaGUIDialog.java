/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import grafika.RozmeryPlochy;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JDialog;
import javax.swing.JRootPane;
import karty.Karta;

/**
 *
 * @author wentsa
 */
public class KartaGUIDialog extends JDialog {

    private static final long serialVersionUID = 7775305374264322276L;

    public KartaGUIDialog(Karta karta) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setModal(true);
        KartaGUI gui = new KartaGUI(karta);
        setContentPane(gui);
        pack();
        setShape(new RoundRectangle2D.Double(0, 0, gui.getSirkaObrazku(), gui.getVyskaObrazku(), (int) (30 * RozmeryPlochy.getScalingFactor()), (int) (30 * RozmeryPlochy.getScalingFactor())));
        setLocationRelativeTo(null);
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
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
        });
        setVisible(true);
    }
}
