package rs.raf.gerumap.gui.swing.view.workspace.explorer.menu;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.LoadMindMapAction;
import rs.raf.gerumap.gui.swing.controller.action.RemoveExplorerItemAction;
import rs.raf.gerumap.gui.swing.controller.action.RenameExplorerItemAction;
import rs.raf.gerumap.gui.swing.view.custom.GRMapMenuItem;

import javax.swing.JPopupMenu;

public class ExplorerMindMapMenu extends JPopupMenu {

    public ExplorerMindMapMenu() {
        add(new GRMapMenuItem(ActionManager.getAction(LoadMindMapAction.class)));
        add(new GRMapMenuItem(ActionManager.getAction(RenameExplorerItemAction.class)));
        add(new GRMapMenuItem(ActionManager.getAction(RemoveExplorerItemAction.class)));
    }

}
