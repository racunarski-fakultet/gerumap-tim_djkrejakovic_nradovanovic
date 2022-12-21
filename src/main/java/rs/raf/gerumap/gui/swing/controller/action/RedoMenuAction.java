package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.controller.ActionManager;

import java.awt.event.ActionEvent;

public class RedoMenuAction extends GRMapAction {

    public RedoMenuAction() {
        super(RedoMenuAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        ActionManager.getAction(RedoAction.class).actionPerformed(event);
    }

}
