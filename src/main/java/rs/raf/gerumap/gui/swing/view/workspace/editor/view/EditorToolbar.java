package rs.raf.gerumap.gui.swing.view.workspace.editor.view;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.ConceptStateAction;
import rs.raf.gerumap.gui.swing.controller.action.ConnectStateAction;
import rs.raf.gerumap.gui.swing.controller.action.EraseStateAction;
import rs.raf.gerumap.gui.swing.controller.action.MoveStateAction;
import rs.raf.gerumap.gui.swing.controller.action.SelectStateAction;
import rs.raf.gerumap.gui.swing.controller.action.ZoomStateAction;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class EditorToolbar extends JToolBar {

    private final ButtonGroup group = new ButtonGroup();

    public EditorToolbar() {
        super(VERTICAL);

        setBorder(BorderFactory.createEmptyBorder(36, 0, 0, 0));

        group.add((AbstractButton) add(new JToggleButton(ActionManager.getAction(SelectStateAction.class))));
        group.add((AbstractButton) add(new JToggleButton(ActionManager.getAction(ConceptStateAction.class))));
        group.add((AbstractButton) add(new JToggleButton(ActionManager.getAction(ConnectStateAction.class))));
        group.add((AbstractButton) add(new JToggleButton(ActionManager.getAction(EraseStateAction.class))));
        group.add((AbstractButton) add(new JToggleButton(ActionManager.getAction(MoveStateAction.class))));
        group.add((AbstractButton) add(new JToggleButton(ActionManager.getAction(ZoomStateAction.class))));

        reset();
    }

    /**
     * Resets selected tool.
     */
    public void reset() {
        group.setSelected(group.getElements().nextElement().getModel(), true);
    }

}
