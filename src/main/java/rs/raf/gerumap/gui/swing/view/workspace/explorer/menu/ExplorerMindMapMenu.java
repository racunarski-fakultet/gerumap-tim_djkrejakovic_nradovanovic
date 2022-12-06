package rs.raf.gerumap.gui.swing.view.workspace.explorer.menu;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.LoadMindMapAction;
import rs.raf.gerumap.gui.swing.controller.action.NewElementAction;
import rs.raf.gerumap.gui.swing.controller.action.RemoveExplorerItemAction;
import rs.raf.gerumap.gui.swing.controller.action.RenameExplorerItemAction;
import rs.raf.gerumap.gui.swing.view.custom.menu.MenuItem;

import javax.swing.JPopupMenu;

public class ExplorerMindMapMenu extends JPopupMenu {

    public ExplorerMindMapMenu() {
        add(new MenuItem(ActionManager.getAction(NewElementAction.class)));
        add(new MenuItem(ActionManager.getAction(LoadMindMapAction.class)));
        add(new MenuItem(ActionManager.getAction(RenameExplorerItemAction.class)));
        add(new MenuItem(ActionManager.getAction(RemoveExplorerItemAction.class)));
    }

}
