package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.controller.StateManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.state.ConceptState;

import java.awt.event.ActionEvent;

public class ConceptStateAction extends GRMapAction {

    public ConceptStateAction() {
        super(ConceptStateAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StateManager.setState(ConceptState.class);
    }

}
