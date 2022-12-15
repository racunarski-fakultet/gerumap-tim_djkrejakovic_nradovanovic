package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.controller.StateManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.state.MoveState;

import java.awt.event.ActionEvent;

public class MoveStateAction extends GRMapAction {

    public MoveStateAction() {
        super(MoveStateAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StateManager.setState(MoveState.class);
    }

}
