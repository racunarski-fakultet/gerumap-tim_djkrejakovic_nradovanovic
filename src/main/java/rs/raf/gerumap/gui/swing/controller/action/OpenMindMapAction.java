package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.util.FileUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.dialog.OpenMindMapDialog;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorPage;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;

import java.awt.event.ActionEvent;

public class OpenMindMapAction extends GRMapAction {

    public OpenMindMapAction() {
        super(OpenMindMapAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        ExplorerItem explorerItem = MainWindow.window.getExplorer().getSelectedItem();
        explorerItem.getComponent().load();

        OpenMindMapDialog.showDialog();

        EditorPage editorPage = FileUtils.loadFromMindMapFile(OpenMindMapDialog.getSelectedFile());

        if (editorPage != null)
            editorPage.generateNewIdentifiers();
    }

}
