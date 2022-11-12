package rs.raf.gerumap.gui.swing.view.workspace.explorer.menu;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.NewProjectAction;
import rs.raf.gerumap.gui.swing.view.custom.MenuItem;

import javax.swing.JPopupMenu;

public class ExplorerProjectRootMenu extends JPopupMenu {

    public ExplorerProjectRootMenu() {
        add(new MenuItem(ActionManager.getAction(NewProjectAction.class)));
    }

}
