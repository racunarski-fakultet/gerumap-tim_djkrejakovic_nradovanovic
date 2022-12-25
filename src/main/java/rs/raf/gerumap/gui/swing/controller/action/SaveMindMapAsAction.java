package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.util.FileUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.dialog.SaveMindMapDialog;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorPage;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;

import java.awt.event.ActionEvent;
import java.io.File;

public class SaveMindMapAsAction extends GRMapAction {

    public SaveMindMapAsAction() {
        super(SaveMindMapAsAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        ExplorerItem explorerItem = MainWindow.window.getExplorer().getSelectedItem();
        explorerItem.getComponent().load();

        EditorPage editorPage = MainWindow.window.getEditor().getActivePage();

        if (editorPage == null)
            return; //TODO Warning - There is no page to save

        SaveMindMapDialog.showDialog(editorPage.getMindMap());

        File file = SaveMindMapDialog.getSelectedFile();

        if (file == null)
            return; //NOTE: no file is selected

        editorPage.getMindMap().setFileLocation(file.getAbsolutePath());
        editorPage.generateNewIdentifiers();

        FileUtils.saveToMindMapFile(editorPage);
    }

}
