package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.controller.StateManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.model.state.RemoveState;

import java.awt.event.ActionEvent;

public class RemoveStateAction extends GRMapAction {

    public RemoveStateAction() {
        super(RemoveStateAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StateManager.setState(RemoveState.class);
    }

}
