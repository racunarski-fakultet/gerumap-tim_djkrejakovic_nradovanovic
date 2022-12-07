package rs.raf.gerumap.gui.swing.view.toolbar;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.NewProjectAction;

import javax.swing.JToolBar;

public class Toolbar extends JToolBar {

    public Toolbar() {
        add(ActionManager.getAction(NewProjectAction.class));
    }

}
