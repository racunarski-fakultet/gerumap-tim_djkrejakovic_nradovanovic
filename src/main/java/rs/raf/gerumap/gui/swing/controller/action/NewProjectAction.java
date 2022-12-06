package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import java.awt.event.ActionEvent;

public class NewProjectAction extends GRMapAction {

    public NewProjectAction() {
        super(NewProjectAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.window.getWorkspace().createProject();
    }

}
