package rs.raf.gerumap.gui.swing.view.workspace.explorer.menu;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.RemoveExplorerItemAction;
import rs.raf.gerumap.gui.swing.controller.action.RenameExplorerItemAction;
import rs.raf.gerumap.gui.swing.view.custom.menu.MenuItem;

import javax.swing.JPopupMenu;

public class ExplorerElementMenu extends JPopupMenu {

    public ExplorerElementMenu() {
        add(new MenuItem(ActionManager.getAction(RenameExplorerItemAction.class)));
        add(new MenuItem(ActionManager.getAction(RemoveExplorerItemAction.class)));
    }

}
