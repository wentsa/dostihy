/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.figurka;

import grafika.RozmeryPlochy;
import pomocne.Barva;

/**
 *
 * @author wentsa
 */
public class FigurkaController extends FigurkyController {

    private static final long serialVersionUID = 6495948149988063846L;

    public FigurkaController(Barva barva, int cislo) {
        super(barva, 0, cislo, true);
    }

    public Barva getBarva() {
        return model.getBarva();
    }

    public void popojdi(int kolik) {
        model.setPozice((model.getPozice() + kolik) % 40);
        if (model.getPozice() < 0) {
            model.setPozice(model.getPozice() + 40);
        }
        nastavSouradnice();
        view.repaint();
    }

    public int getPozice() {
        return model.getPozice();
    }

    @Override
    protected void nastavX() {
        int cislo = model.getCislo();
        model.setSouradniceX((int) (((int) (150 * RozmeryPlochy.getScalingFactor()) + (cislo <= 5 ? cislo : cislo - 5) * (int) (10 * RozmeryPlochy.getScalingFactor())) //polomer
                * Math.cos(Math.toRadians((getPozice() + 5) * 9 //uhel
                                + (cislo <= 5 ? (int) (2 * RozmeryPlochy.getScalingFactor()) : (int) (7 * RozmeryPlochy.getScalingFactor()))))) //dorovnani uhlu podle pozice
                + (int) (340 * RozmeryPlochy.getScalingFactor())); //x stredu
    }

    @Override
    protected void nastavY() {
        int cislo = model.getCislo();
        model.setSouradniceY((int) (((int) (150 * RozmeryPlochy.getScalingFactor()) + (cislo <= 5 ? cislo : cislo - 5) * (int) (10 * RozmeryPlochy.getScalingFactor())) //polomer
                * Math.sin(Math.toRadians((getPozice() + 5) * 9 //uhel
                                + (cislo <= 5 ? (int) (2 * RozmeryPlochy.getScalingFactor()) : (int) (7 * RozmeryPlochy.getScalingFactor()))))) //dorovnani uhlu podle pozice
                + (int) (345 * RozmeryPlochy.getScalingFactor())); //x stredu
    }
}
