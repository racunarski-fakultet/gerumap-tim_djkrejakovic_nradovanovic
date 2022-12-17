package rs.raf.gerumap.gui.swing.view.custom;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConfigurations;

import javax.swing.JSlider;
import java.awt.Dimension;

public class GRMapZoomSlider extends JSlider {

    public GRMapZoomSlider() {
        super(GraphicConfigurations.MIN_ZOOM_PERCENT, GraphicConfigurations.MAX_ZOOM_PERCENT, GraphicConfigurations.DEFAULT_ZOOM_PERCENT);

        setMaximumSize(new Dimension(150, 26));
        setPreferredSize(new Dimension(150, 26));

        addChangeListener(event -> MainWindow.window.getEditor().getGraphicConfigurations().setScaleFactor(getValue() / 100d));
        addMouseWheelListener(event -> setValue(getValue() - 5 * event.getWheelRotation()));
    }

}
