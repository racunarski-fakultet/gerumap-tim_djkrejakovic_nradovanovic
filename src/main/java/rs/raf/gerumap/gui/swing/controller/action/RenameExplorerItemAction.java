package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;
import rs.raf.gerumap.tree.composite.BaseNode;

import java.awt.event.ActionEvent;

public class RenameExplorerItemAction extends GRMapAction {

    public RenameExplorerItemAction() {
        super(RenameExplorerItemAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ExplorerItem node = MainWindow.window.getExplorer().getSelectedNode();

        if (!(node.getUserObject() instanceof BaseNode))
            return; //TODO Error message

        MainWindow.window.getExplorer().rename(node);
    }

}
