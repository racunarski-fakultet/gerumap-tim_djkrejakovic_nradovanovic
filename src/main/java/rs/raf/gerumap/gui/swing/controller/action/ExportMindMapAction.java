package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.dialog.ExportMinMapDialog;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorDiagram;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorPage;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;

import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
        File selectedFile = ExportMinMapDialog.getSelectedFile();

        if (selectedFile == null)
            return;

        editorPage.load();

        EditorDiagram diagram = editorPage.getDiagram();

        BufferedImage image = new BufferedImage(diagram.getActualWidth(), diagram.getActualHeight(), BufferedImage.TYPE_INT_ARGB);

        double scaleFactor = diagram.getConfigurations().getScaleFactor();
        diagram.getConfigurations().resetConfigurations();

        diagram.paint(image.createGraphics());

        diagram.getConfigurations().setScaleFactor(scaleFactor);

        try {
            ImageIO.write(image, "png", selectedFile);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
