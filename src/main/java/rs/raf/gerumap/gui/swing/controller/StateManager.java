package rs.raf.gerumap.gui.swing.controller;

import rs.raf.gerumap.gui.swing.view.workspace.editor.model.IState;
import rs.raf.gerumap.gui.swing.view.workspace.editor.model.state.ConceptState;
import rs.raf.gerumap.gui.swing.view.workspace.editor.model.state.ConnectState;
import rs.raf.gerumap.gui.swing.view.workspace.editor.model.state.MoveState;
import rs.raf.gerumap.gui.swing.view.workspace.editor.model.state.RemoveState;
import rs.raf.gerumap.gui.swing.view.workspace.editor.model.state.SelectState;
import rs.raf.gerumap.gui.swing.view.workspace.editor.model.state.ZoomState;

import java.util.Map;

public class StateManager {

    private static final Map<String, IState> states = Map.of(
            ConceptState.ID, new ConceptState(),
            ConnectState.ID, new ConnectState(),
            RemoveState.ID , new RemoveState(),
            MoveState.ID   , new MoveState(),
            SelectState.ID , new SelectState(),
            ZoomState.ID   , new ZoomState()
    );

    private static IState current = states.get(SelectState.ID);

    /**
     * Setups the initial state.
     */
    public static void setup() {
        reset();
    }

    /**
     * Sets the current state.
     * @param stateClass state
     */
    public static void setState(Class stateClass) {
        current = states.get(stateClass.getSimpleName());
    }

    /**
     * Returns the current state.
     * @return state
     */
    public static IState getState() {
        return current;
    }

    /**
     * Resets to initial state.
     */
    public static void reset() {
        setState(SelectState.class);
    }

}
