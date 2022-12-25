package rs.raf.gerumap.gui.swing.view.workspace.explorer.menu;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.LoadProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.NewMindMapAction;
import rs.raf.gerumap.gui.swing.controller.action.OpenMindMapAction;
import rs.raf.gerumap.gui.swing.controller.action.RemoveAction;
import rs.raf.gerumap.gui.swing.controller.action.RenameAction;
import rs.raf.gerumap.gui.swing.view.custom.GRMapMenuItem;

import javax.swing.JPopupMenu;

public class ExplorerProjectMenu extends JPopupMenu {

    public ExplorerProjectMenu() {
        add(new GRMapMenuItem(ActionManager.getAction(NewMindMapAction.class)));
        add(new GRMapMenuItem(ActionManager.getAction(OpenMindMapAction.class)));
        add(new GRMapMenuItem(ActionManager.getAction(LoadProjectAction.class)));
        add(new GRMapMenuItem(ActionManager.getAction(RenameAction.class)));
        add(new GRMapMenuItem(ActionManager.getAction(RemoveAction.class)));
    }

}
