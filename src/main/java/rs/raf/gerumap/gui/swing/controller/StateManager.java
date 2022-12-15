package rs.raf.gerumap.gui.swing.controller;

import rs.raf.gerumap.gui.swing.view.workspace.editor.state.ConceptState;
import rs.raf.gerumap.gui.swing.view.workspace.editor.state.ConnectState;
import rs.raf.gerumap.gui.swing.view.workspace.editor.state.MoveState;
import rs.raf.gerumap.gui.swing.view.workspace.editor.state.RemoveState;
import rs.raf.gerumap.gui.swing.view.workspace.editor.state.SelectState;
import rs.raf.gerumap.gui.swing.view.workspace.editor.state.State;
import rs.raf.gerumap.gui.swing.view.workspace.editor.state.ZoomState;

import java.util.Map;

public class StateManager {

    private static final Map<String, State> states = Map.of(
            ConceptState.ID, new ConceptState(),
            ConnectState.ID, new ConnectState(),
            RemoveState.ID , new RemoveState(),
            MoveState.ID   , new MoveState(),
            SelectState.ID , new SelectState(),
            ZoomState.ID   , new ZoomState()
                                                           );

    private static State current = states.get(SelectState.ID);

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
    public static State getState() {
        return current;
    }

    /**
     * Resets to initial state.
     */
    public static void reset() {
        setState(SelectState.class);
    }

}
