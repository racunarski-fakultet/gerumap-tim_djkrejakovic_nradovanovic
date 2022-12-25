package rs.raf.gerumap.gui.swing.view.dialog;

import rs.raf.gerumap.gui.swing.util.FileUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.MindMap;

import javax.swing.JFileChooser;
import java.awt.Dimension;
import java.io.File;

public class SaveMindMapDialog {

    private static File selectedFile;

    /**
     * Displays a dialog for selecting a location to save the mind map.
     * @param mindMap mind map
     */
    public static void showDialog(MindMap mindMap) {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setPreferredSize(new Dimension(650, 400));
        fileChooser.getActionMap().get("viewTypeDetails").actionPerformed(null);
        fileChooser.setSelectedFile(new File(mindMap.getName() + ".grm"));
        fileChooser.setFileFilter(new GeRuMapMindMapFileFilter());

        int result = fileChooser.showSaveDialog(MainWindow.window);

        selectedFile = result == 0 ? fileChooser.getSelectedFile() : null;

        FileUtils.appendExtension(selectedFile, "grm");
    }

    /**
     * Returns the selected file location.
     * @return selected file
     */
    public static File getSelectedFile() {
        return selectedFile;
    }

}
