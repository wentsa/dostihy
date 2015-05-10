/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.figurka;

import grafika.RozmeryPlochy;
import java.io.Serializable;
import pomocne.Barva;

/**
 *
 * @author wentsa
 */
public class ObsazovaciFigurkaController extends FigurkyController implements Serializable {

    private static final long serialVersionUID = -9051609781469768708L;

    public ObsazovaciFigurkaController(Barva barva, int pozice, int cislo) {
        super(barva, pozice, cislo, false);
    }

    @Override
    protected void nastavX() {
        model.setSouradniceX((int) ((int) (280 * RozmeryPlochy.getScalingFactor())
                * Math.cos(Math.toRadians((model.getPozice() + 5) * 9 + 5)))
                + (int) (339 * RozmeryPlochy.getScalingFactor()));
    }

    @Override
    protected void nastavY() {
        model.setSouradniceY((int) ((int) (280 * RozmeryPlochy.getScalingFactor())
                * Math.sin(Math.toRadians((model.getPozice() + 5) * 9 + 5)))
                + (int) (342 * RozmeryPlochy.getScalingFactor()));
    }

}
