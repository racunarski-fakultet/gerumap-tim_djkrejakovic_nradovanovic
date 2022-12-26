package rs.raf.gerumap.gui.swing.view.workspace.explorer.menu;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.ExportMindMapAction;
import rs.raf.gerumap.gui.swing.controller.action.LoadMindMapAction;
import rs.raf.gerumap.gui.swing.controller.action.RemoveAction;
import rs.raf.gerumap.gui.swing.controller.action.RenameAction;
import rs.raf.gerumap.gui.swing.controller.action.SaveMindMapAsAction;
import rs.raf.gerumap.gui.swing.view.custom.GRMapMenuItem;

import javax.swing.JPopupMenu;

public class ExplorerMindMapMenu extends JPopupMenu {

    public ExplorerMindMapMenu() {
        add(new GRMapMenuItem(ActionManager.getAction(LoadMindMapAction.class)));
        add(new GRMapMenuItem(ActionManager.getAction(SaveMindMapAsAction.class)));
        add(new GRMapMenuItem(ActionManager.getAction(RenameAction.class)));
        add(new GRMapMenuItem(ActionManager.getAction(ExportMindMapAction.class)));
        add(new GRMapMenuItem(ActionManager.getAction(RemoveAction.class)));
    }

}
