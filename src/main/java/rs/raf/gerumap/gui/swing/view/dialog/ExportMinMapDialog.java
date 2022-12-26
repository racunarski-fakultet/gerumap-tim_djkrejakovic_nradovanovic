package rs.raf.gerumap.gui.swing.view.dialog;

import rs.raf.gerumap.gui.swing.util.FileUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.MindMap;

import javax.swing.JFileChooser;
import java.awt.Dimension;
import java.io.File;

public class ExportMinMapDialog {

    private static File selectedFile;

    /**
     * Displays a dialog for selecting a location to export the mind map.
     * @param mindMap mind map
     */
    public static void showDialog(MindMap mindMap) {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setPreferredSize(new Dimension(650, 400));
        fileChooser.getActionMap().get("viewTypeDetails").actionPerformed(null);
        fileChooser.setSelectedFile(new File(mindMap.getName() + ".png"));
        fileChooser.setFileFilter(new GeRuMapPNGFileFilter());

        int result = fileChooser.showSaveDialog(MainWindow.window);

        selectedFile = result == 0 ? fileChooser.getSelectedFile() : null;

        FileUtils.appendExtension(selectedFile, "png");
    }

    /**
     * Returns the selected file location.
     * @return selected file
     */
    public static File getSelectedFile() {
        return selectedFile;
    }

}
