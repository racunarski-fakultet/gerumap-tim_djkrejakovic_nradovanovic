package rs.raf.gerumap.gui.swing.view.toolbar;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.NewProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.OpenProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.ResetZoomAction;

import javax.swing.JToolBar;

public class Toolbar extends JToolBar {

    public Toolbar() {
        add(ActionManager.getAction(NewProjectAction.class));
        add(ActionManager.getAction(OpenProjectAction.class));
        addSeparator();
        add(ActionManager.getAction(ResetZoomAction.class));
    }

}
