package rs.raf.gerumap.gui.swing.view.dialog;

import rs.raf.gerumap.gui.swing.util.FileUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.Project;

import javax.swing.JFileChooser;
import java.awt.Dimension;
import java.io.File;

public class SaveProjectDialog {

    private static File selectedFile;

    /**
     * Displays a dialog for selecting a location to save the project.
     * @param project project
     */
    public static void showDialog(Project project) {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setPreferredSize(new Dimension(650, 400));
        fileChooser.getActionMap().get("viewTypeDetails").actionPerformed(null);
        fileChooser.setSelectedFile(new File(project.getName() + ".grp"));
        fileChooser.setFileFilter(new GeRuMapProjectFileFilter());

        int result = fileChooser.showSaveDialog(MainWindow.window);

        selectedFile = result == 0 ? fileChooser.getSelectedFile() : null;

        FileUtils.appendExtension(selectedFile, "grp");
    }

    /**
     * Returns the selected file location.
     * @return selected file
     */
    public static File getSelectedFile() {
        return selectedFile;
    }

}
