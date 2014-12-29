/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.slider;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wentsa
 */
public class SliderController {

    private final SliderModel model = new SliderModel();
    private final SliderView view = new SliderView(this);

    public SliderController() {
        view.setIcon(model.getObrazek());
    }

    public void setSouradniceY(final int y) {
        final int init = model.getSouradniceY();
        (new Thread(new Runnable() {

            @Override
            public void run() {
                posunSlider(init, y);
            }
        })).start();

    }

    protected int getSouradniceY() {
        return model.getSouradniceY();
    }

    public SliderView getView() {
        return view;
    }

    private void posunSlider(int start, int cil) {
        if (start < cil) {
            for (int i = start; i <= cil; i++) {
                model.setSouradniceY(i);
                view.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SliderController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            for (int i = start; i >= cil; i--) {
                model.setSouradniceY(i);
                view.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SliderController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
