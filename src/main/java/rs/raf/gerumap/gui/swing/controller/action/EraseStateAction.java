package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.controller.StateManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.state.EraseState;

import java.awt.event.ActionEvent;

public class EraseStateAction extends GRMapAction {

    public EraseStateAction() {
        super(EraseStateAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StateManager.setState(EraseState.class);
    }

}
