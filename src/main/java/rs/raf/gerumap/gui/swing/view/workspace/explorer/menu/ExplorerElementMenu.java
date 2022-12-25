package rs.raf.gerumap.gui.swing.view.workspace.explorer.menu;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.RemoveAction;
import rs.raf.gerumap.gui.swing.controller.action.RenameAction;
import rs.raf.gerumap.gui.swing.view.custom.GRMapMenuItem;

import javax.swing.JPopupMenu;

public class ExplorerElementMenu extends JPopupMenu {

    public ExplorerElementMenu() {
        add(new GRMapMenuItem(ActionManager.getAction(RenameAction.class)));
        add(new GRMapMenuItem(ActionManager.getAction(RemoveAction.class)));
    }

}
