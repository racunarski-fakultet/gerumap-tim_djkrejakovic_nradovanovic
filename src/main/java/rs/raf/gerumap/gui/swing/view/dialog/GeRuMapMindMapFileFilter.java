package rs.raf.gerumap.gui.swing.view.dialog;

import rs.raf.gerumap.gui.swing.util.FileUtils;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class GeRuMapMindMapFileFilter extends FileFilter {

    @Override
    public boolean accept(File file) {
        if (file.isDirectory())
            return true;

        return FileUtils.isFileExtension(file, "grm");
    }

    @Override
    public String getDescription() {
        return "GeRuMap Template Files (*.grm)";
    }

}
