package rs.raf.gerumap.gui.swing.view.dialog;

import rs.raf.gerumap.gui.swing.util.FileUtils;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class GeRuMapPNGFileFilter extends FileFilter {

    @Override
    public boolean accept(File file) {
        if (file.isDirectory())
            return true;

        return FileUtils.isFileExtension(file, "png");
    }

    @Override
    public String getDescription() {
        return "PNG Files (*.png)";
    }

}
