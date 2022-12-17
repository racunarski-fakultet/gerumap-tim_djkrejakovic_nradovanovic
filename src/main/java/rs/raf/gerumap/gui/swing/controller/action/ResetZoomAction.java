package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConfigurations;

import java.awt.event.ActionEvent;

public class ResetZoomAction extends GRMapAction {

    public ResetZoomAction() {
        super(ResetZoomAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.window.getEditor().getGraphicConfigurations().setScaleFactor(GraphicConfigurations.DEFAULT_SCALE_FACTOR);
    }

}
