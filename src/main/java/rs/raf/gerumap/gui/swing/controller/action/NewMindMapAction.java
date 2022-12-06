package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import java.awt.event.ActionEvent;

public class NewMindMapAction extends GRMapAction {

    public NewMindMapAction() {
        super(NewMindMapAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.window.getWorkspace().createMindMap();
    }

}
