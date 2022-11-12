package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;
import rs.raf.gerumap.tree.explorer.Project;

import java.awt.event.ActionEvent;

public class NewMindMapAction extends GRMapAction {

    public NewMindMapAction() {
        super(NewMindMapAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ExplorerItem lastSelected = MainWindow.window.getExplorer().getSelectedNode();

        if (lastSelected == null)
            return;

        if (!(lastSelected.getUserObject() instanceof Project))
            return; //TODO Error message

        MainWindow.window.getExplorer().addChild(lastSelected);
    }

}
