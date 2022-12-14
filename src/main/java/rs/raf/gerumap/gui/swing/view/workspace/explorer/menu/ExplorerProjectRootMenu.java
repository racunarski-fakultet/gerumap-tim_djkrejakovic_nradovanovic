package rs.raf.gerumap.gui.swing.view.workspace.explorer.menu;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.NewProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.RenameExplorerItemAction;
import rs.raf.gerumap.gui.swing.view.custom.GRMapMenuItem;

import javax.swing.JPopupMenu;

public class ExplorerProjectRootMenu extends JPopupMenu {

    public ExplorerProjectRootMenu() {
        add(new GRMapMenuItem(ActionManager.getAction(NewProjectAction.class)));
        add(new GRMapMenuItem(ActionManager.getAction(RenameExplorerItemAction.class)));
    }

}
