package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.controller.ActionManager;

import java.awt.event.ActionEvent;

public class SaveProjectMenuAction extends GRMapAction {

    public SaveProjectMenuAction() {
        super(SaveProjectMenuAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        ActionManager.getAction(SaveProjectAction.class).actionPerformed(event);
    }

}
