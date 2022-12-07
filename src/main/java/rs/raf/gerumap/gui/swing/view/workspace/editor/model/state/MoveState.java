package rs.raf.gerumap.gui.swing.view.workspace.editor.model.state;

import rs.raf.gerumap.gui.swing.view.workspace.editor.model.IState;

public class MoveState implements IState {

    public static final String ID = MoveState.class.getSimpleName();

    @Override
    public void perform() {
        System.out.println("MoveState");
    }
}
