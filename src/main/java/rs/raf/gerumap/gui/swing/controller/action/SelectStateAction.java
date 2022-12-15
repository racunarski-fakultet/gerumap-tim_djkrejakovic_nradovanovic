package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.controller.StateManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.state.SelectState;

import java.awt.event.ActionEvent;

public class SelectStateAction extends GRMapAction {

    public SelectStateAction() {
        super(SelectStateAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StateManager.setState(SelectState.class);
    }

}
