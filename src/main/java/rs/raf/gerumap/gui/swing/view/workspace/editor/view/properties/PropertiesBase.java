package rs.raf.gerumap.gui.swing.view.workspace.editor.view.properties;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;

public abstract class PropertiesBase extends JPanel {

    public PropertiesBase() {
        setLayout(new GridBagLayout());
    }

    protected String colorToHex(Color color) {
        int red   = color.getRed();
        int green = color.getGreen();
        int blue  = color.getBlue();

        return String.format("#%02X%02X%02X", red, green, blue);
    }

    /**
     * Setups component values.
     */
    public abstract void setup();

}
