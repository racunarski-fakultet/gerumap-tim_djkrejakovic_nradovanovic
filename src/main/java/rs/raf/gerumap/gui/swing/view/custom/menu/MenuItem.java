package rs.raf.gerumap.gui.swing.view.custom.menu;

import javax.swing.Action;
import javax.swing.JMenuItem;
import java.awt.Dimension;

public class MenuItem extends JMenuItem {

    public MenuItem(Action a) {
        super(a);
    }

    public MenuItem(String text) {
        super(text);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension dimension = super.getPreferredSize();

        dimension.width += 10;

        return dimension;
    }

}
