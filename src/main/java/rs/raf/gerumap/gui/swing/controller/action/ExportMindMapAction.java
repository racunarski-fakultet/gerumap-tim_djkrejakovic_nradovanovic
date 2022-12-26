package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.util.FileUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.dialog.ExportMinMapDialog;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorPage;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;

import java.awt.event.ActionEvent;

public class ExportMindMapAction extends GRMapAction {

    public ExportMindMapAction() {
        super(ExportMindMapAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        ExplorerItem explorerItem = MainWindow.window.getExplorer().getSelectedItem();

        EditorPage editorPage = (EditorPage) explorerItem.getComponent();

        if (editorPage == null)
            return;

        ExportMinMapDialog.showDialog(editorPage.getMindMap());

        FileUtils.saveMindMapToPNGFile(editorPage, ExportMinMapDialog.getSelectedFile());
    }

}
