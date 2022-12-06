package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import java.awt.event.ActionEvent;

public class LoadMindMapAction extends GRMapAction {

    public LoadMindMapAction() {
        super(LoadMindMapAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.window.getWorkspace().loadMindMap();
    }

}
