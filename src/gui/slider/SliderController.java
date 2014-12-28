/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.slider;

/**
 *
 * @author wentsa
 */
public class SliderController {
    private final SliderModel model=new SliderModel();
    private final SliderView view=new SliderView(this);
    public SliderController() {
        view.setIcon(model.getObrazek());
    }
    public void setSouradniceY(int y) {
        model.setSouradniceY(y);
        view.repaint();
    }

    protected int getSouradniceY() {
        return model.getSouradniceY();
    }
    public SliderView getView() {
        return view;
    }
}
