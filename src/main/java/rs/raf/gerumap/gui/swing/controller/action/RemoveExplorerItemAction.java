package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;
import rs.raf.gerumap.tree.composite.BaseNode;

import java.awt.event.ActionEvent;

/**
 * The action that handles the removal of an item (Project, MindMap or Element).
 */
public class RemoveExplorerItemAction extends GRMapAction {

    public RemoveExplorerItemAction() {
        super(RemoveExplorerItemAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ExplorerItem node = MainWindow.window.getExplorer().getSelectedNode();

        if (!(node.getUserObject() instanceof BaseNode))
            return;

        MainWindow.window.getExplorer().remove(node);
    }

}
