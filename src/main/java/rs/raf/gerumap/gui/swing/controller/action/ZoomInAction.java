package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import java.awt.event.ActionEvent;

public class ZoomInAction extends GRMapAction {

    public ZoomInAction() {
        super(ZoomInAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.window.getEditor().getStatusBar().updateZoomValueBy(5);
    }

}
