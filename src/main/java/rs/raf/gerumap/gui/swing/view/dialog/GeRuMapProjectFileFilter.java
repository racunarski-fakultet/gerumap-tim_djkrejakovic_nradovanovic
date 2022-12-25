package rs.raf.gerumap.gui.swing.view.dialog;

import rs.raf.gerumap.gui.swing.util.FileUtils;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class GeRuMapProjectFileFilter extends FileFilter {

    @Override
    public boolean accept(File file) {
        if (file.isDirectory())
            return true;

        return FileUtils.isFileExtension(file, "grp");
    }

    @Override
    public String getDescription() {
        return "GeRuMap Project Files (*.grp)";
    }

}
