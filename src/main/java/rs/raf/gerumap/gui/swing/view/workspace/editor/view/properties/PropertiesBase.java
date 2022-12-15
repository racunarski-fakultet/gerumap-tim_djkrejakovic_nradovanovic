package rs.raf.gerumap.gui.swing.view.workspace.editor.view.properties;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;

public abstract class PropertiesBase extends JPanel {

    protected static final IEditor editor = MainWindow.window.getEditor();

    public PropertiesBase() {
        setLayout(new GridBagLayout());
    }

    protected String colorToHex(Color color) {
        if (color == null)
            return "";

        int red   = color.getRed();
        int green = color.getGreen();
        int blue  = color.getBlue();

        return String.format("#%02X%02X%02X", red, green, blue);
    }

    /**
     * Setups component values.
     */
    public abstract void setup();

    /**
     * Gives focus to the component.
     */
    public abstract void getFocus();

}
