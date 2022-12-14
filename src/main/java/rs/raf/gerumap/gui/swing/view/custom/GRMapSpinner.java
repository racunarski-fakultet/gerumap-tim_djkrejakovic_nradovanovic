package rs.raf.gerumap.gui.swing.view.custom;

import javax.swing.JSpinner;

public class GRMapSpinner extends JSpinner {

    private final int multiplier;

    public GRMapSpinner(int multiplier) {
        this.multiplier = multiplier;

        addMouseWheelListener(event -> setValue((int) getValue() - this.multiplier * event.getWheelRotation()));
    }

}
