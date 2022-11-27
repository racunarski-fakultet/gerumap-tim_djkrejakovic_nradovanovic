package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;
import rs.raf.gerumap.tree.explorer.ProjectRoot;

import java.awt.event.ActionEvent;

/**
 * The action that handles the creation of a new project.
 */
public class NewProjectAction extends GRMapAction {

    public NewProjectAction() {
        super(NewProjectAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ExplorerItem root = MainWindow.window.getExplorer().getRoot();

        if (!(root.getUserObject() instanceof ProjectRoot))
            return;

        MainWindow.window.getExplorer().addChild(root);
    }

}
