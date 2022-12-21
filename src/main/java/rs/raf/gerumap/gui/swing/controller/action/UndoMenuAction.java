package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.controller.ActionManager;

import java.awt.event.ActionEvent;

public class UndoMenuAction extends GRMapAction {

    public UndoMenuAction() {
        super(UndoMenuAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        ActionManager.getAction(UndoAction.class).actionPerformed(event);
    }

}
