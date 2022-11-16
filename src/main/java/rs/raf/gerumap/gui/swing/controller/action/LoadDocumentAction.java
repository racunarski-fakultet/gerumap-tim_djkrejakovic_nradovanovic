package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.Editor;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerMindMapItem;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerProjectItem;
import rs.raf.gerumap.tree.explorer.Project;

import java.awt.event.ActionEvent;

public class LoadDocumentAction extends GRMapAction {

    public LoadDocumentAction() {
        super(LoadDocumentAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ExplorerMindMapItem mindMap = (ExplorerMindMapItem) MainWindow.window.getExplorer().getSelectedNode();
        Editor editor = MainWindow.window.getWorkspace().getEditor();

        editor.loadDocument(mindMap.getDocument(), (Project) ((ExplorerProjectItem) mindMap.getParent()).getNode());
    }

}
