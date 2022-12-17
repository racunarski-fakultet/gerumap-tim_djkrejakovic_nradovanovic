package rs.raf.gerumap.gui.swing.view.workspace.editor.view;

import javax.swing.JLabel;
import javax.swing.JToolBar;
import java.awt.Point;
import java.text.MessageFormat;

public class EditorStatusBar extends JToolBar {

    private JLabel labelCoordinates = new JLabel("0, 0");

    public EditorStatusBar() {
        add(labelCoordinates);
    }

    public void setCoordinates(Point coordinates) {
        labelCoordinates.setText(MessageFormat.format("{0}, {1}", coordinates.getX(), coordinates.getY()));
    }

}
