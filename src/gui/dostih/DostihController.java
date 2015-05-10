/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dostih;

import grafika.RozmeryPlochy;
import java.io.Serializable;

/**
 *
 * @author wentsa
 */
public class DostihController extends DostihyController implements Serializable {

    private static final long serialVersionUID = 1L;

    public DostihController(int pozice, int poradi) {
        super(pozice, poradi, false);
    }

    @Override
    protected void nactiY() {
        model.setSouradniceY((int) ((RozmeryPlochy.getPlochaVyska() / 2 - (int) (43 * RozmeryPlochy.getScalingFactor())) //polomer
                * Math.sin(Math.toRadians((model.pozice + 5) * 9 + (model.poradi * 2)))) //uhel
                + RozmeryPlochy.getPlochaVyska() / 2 - (int) (6 * RozmeryPlochy.getScalingFactor())); //y stredu
    }

    @Override
    protected void nactiX() {
        model.setSouradniceX((int) ((RozmeryPlochy.getPlochaSirka() / 2 - (int) (43 * RozmeryPlochy.getScalingFactor())) //polomer
                * Math.cos(Math.toRadians((model.pozice + 5) * 9 + (model.poradi * 2)))) //uhel
                + RozmeryPlochy.getPlochaSirka() / 2 - (int) (8 * RozmeryPlochy.getScalingFactor())); //x stredu
    }

}
