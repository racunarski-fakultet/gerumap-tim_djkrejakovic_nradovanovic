package rs.raf.gerumap.gui.swing.view.workspace.explorer.menu;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.NewMindMapAction;
import rs.raf.gerumap.gui.swing.view.custom.menu.MenuItem;

import javax.swing.JPopupMenu;

public class ExplorerProjectMenu extends JPopupMenu {

    public ExplorerProjectMenu() {
        add(new MenuItem(ActionManager.getAction(NewMindMapAction.class)));
    }

}
