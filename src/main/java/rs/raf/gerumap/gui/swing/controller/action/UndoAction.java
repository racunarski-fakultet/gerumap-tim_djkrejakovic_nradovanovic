package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import java.awt.event.ActionEvent;

public class UndoAction extends GRMapAction {

    public UndoAction() {
        super(UndoAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        MainWindow.window.getEditor().getCommandManager().undoCommand();
    }

}
