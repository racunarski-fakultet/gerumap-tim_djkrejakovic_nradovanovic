package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import java.awt.event.ActionEvent;

public class RedoAction extends GRMapAction {

    public RedoAction() {
        super(RedoAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        MainWindow.window.getEditor().getCommandManager().redoCommand();
    }

}
