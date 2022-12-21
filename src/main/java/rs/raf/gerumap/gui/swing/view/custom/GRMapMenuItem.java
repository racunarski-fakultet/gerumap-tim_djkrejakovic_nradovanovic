package rs.raf.gerumap.gui.swing.view.custom;

import javax.swing.Action;
import javax.swing.JMenuItem;
import java.awt.Dimension;

public class GRMapMenuItem extends JMenuItem {

    public GRMapMenuItem(Action action) {
        super(action);
    }

    public GRMapMenuItem(String text) {
        super(text);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension dimension = super.getPreferredSize();

        dimension.width += 10;

        return dimension;
    }

}
