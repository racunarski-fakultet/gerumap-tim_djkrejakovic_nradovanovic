package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.controller.StateManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.state.ConnectState;

import java.awt.event.ActionEvent;

public class ConnectStateAction extends GRMapAction {

    public ConnectStateAction() {
        super(ConnectStateAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StateManager.setState(ConnectState.class);
    }

}
