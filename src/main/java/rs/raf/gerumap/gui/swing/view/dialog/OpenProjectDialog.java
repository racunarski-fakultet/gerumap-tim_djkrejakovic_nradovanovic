package rs.raf.gerumap.gui.swing.view.dialog;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import javax.swing.JFileChooser;
import java.awt.Dimension;
import java.io.File;

public class OpenProjectDialog {

    private static File selectedFile;

    /**
     * Displays a dialog to select which project to open.
     */
    public static void showDialog() {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setPreferredSize(new Dimension(650, 400));
        fileChooser.getActionMap().get("viewTypeDetails").actionPerformed(null);
        fileChooser.setFileFilter(new GeRuMapProjectFileFilter());
        fileChooser.showOpenDialog(MainWindow.window);

        selectedFile = fileChooser.getSelectedFile();
    }

    /**
     * Returns the selected file location.
     * @return selected file
     */
    public static File getSelectedFile() {
        return selectedFile;
    }

}
