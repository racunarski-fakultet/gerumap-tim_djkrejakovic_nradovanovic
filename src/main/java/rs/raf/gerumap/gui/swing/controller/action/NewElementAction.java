package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;
import rs.raf.gerumap.tree.explorer.MindMap;

import java.awt.event.ActionEvent;

/**
 * The action that handles the creation of a new element.
 */
public class NewElementAction extends GRMapAction {

    public NewElementAction() {
        super(NewElementAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ExplorerItem lastSelected = MainWindow.window.getExplorer().getSelectedNode();

        if (lastSelected == null)
            return;

        if (!(lastSelected.getUserObject() instanceof MindMap))
            return;

        MainWindow.window.getExplorer().addChild(lastSelected);
    }

}
