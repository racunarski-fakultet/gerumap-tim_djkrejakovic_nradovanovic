package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.Editor;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerProjectItem;
import rs.raf.gerumap.tree.explorer.Project;

import java.awt.event.ActionEvent;

public class LoadProjectAction extends GRMapAction {

    public LoadProjectAction() {
        super(LoadProjectAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        ExplorerProjectItem project = (ExplorerProjectItem) MainWindow.window.getExplorer().getSelectedNode();
        Editor editor = MainWindow.window.getWorkspace().getEditor();

        editor.loadProject(project.getDocuments(), (Project) project.getNode());
    }

}
