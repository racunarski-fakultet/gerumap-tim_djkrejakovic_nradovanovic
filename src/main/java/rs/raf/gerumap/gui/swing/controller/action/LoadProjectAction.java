package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import java.awt.event.ActionEvent;

public class LoadProjectAction extends GRMapAction {

    public LoadProjectAction() {
        super(LoadProjectAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        MainWindow.window.getWorkspace().loadProject();
    }

}
