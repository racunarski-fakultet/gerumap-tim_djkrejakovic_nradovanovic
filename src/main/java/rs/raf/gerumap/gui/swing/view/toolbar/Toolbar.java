package rs.raf.gerumap.gui.swing.view.toolbar;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.NewElementAction;
import rs.raf.gerumap.gui.swing.controller.action.NewMindMapAction;
import rs.raf.gerumap.gui.swing.controller.action.NewProjectAction;

import javax.swing.JToolBar;

public class Toolbar extends JToolBar {

    public Toolbar() {
        add(ActionManager.getAction(NewProjectAction.class));
        add(ActionManager.getAction(NewMindMapAction.class));
        add(ActionManager.getAction(NewElementAction.class));
    }

}
