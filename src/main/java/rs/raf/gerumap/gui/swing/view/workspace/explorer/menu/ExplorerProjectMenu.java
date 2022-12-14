package rs.raf.gerumap.gui.swing.view.workspace.explorer.menu;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.LoadProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.NewMindMapAction;
import rs.raf.gerumap.gui.swing.controller.action.RemoveExplorerItemAction;
import rs.raf.gerumap.gui.swing.controller.action.RenameExplorerItemAction;
import rs.raf.gerumap.gui.swing.view.custom.GRMapMenuItem;

import javax.swing.JPopupMenu;

public class ExplorerProjectMenu extends JPopupMenu {

    public ExplorerProjectMenu() {
        add(new GRMapMenuItem(ActionManager.getAction(NewMindMapAction.class)));
        add(new GRMapMenuItem(ActionManager.getAction(LoadProjectAction.class)));
        add(new GRMapMenuItem(ActionManager.getAction(RenameExplorerItemAction.class)));
        add(new GRMapMenuItem(ActionManager.getAction(RemoveExplorerItemAction.class)));
    }

}
