package rs.raf.gerumap.gui.swing.view.custom.menu;

import javax.swing.JMenu;
import java.awt.Dimension;

public class Menu extends JMenu {

    public Menu(String s) {
        super(s);
        setHorizontalAlignment(JMenu.CENTER);
        setVerticalAlignment(JMenu.CENTER);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension dimension = super.getPreferredSize();

        dimension.width += 2;

        return dimension;
    }

}
