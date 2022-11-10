package rs.raf.gerumap.gui.swing.view.toolbar;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.ExitAction;
import rs.raf.gerumap.gui.swing.controller.action.NewProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.OpenProjectAction;

import javax.swing.JToolBar;

public class Toolbar extends JToolBar {

    public Toolbar() {
        add(ActionManager.getAction(NewProjectAction.class));
        add(ActionManager.getAction(OpenProjectAction.class));
        add(ActionManager.getAction(ExitAction.class));
    }

}
