package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.controller.StateManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.model.state.ZoomState;

import java.awt.event.ActionEvent;

public class ZoomStateAction extends GRMapAction {

    public ZoomStateAction() {
        super(ZoomStateAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StateManager.setState(ZoomState.class);
    }

}
