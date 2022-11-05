package rs.raf.gerumap.gui.swing.view;

import javax.swing.JSplitPane;

public class Workspace extends JSplitPane {

    public Workspace() {
        super(HORIZONTAL_SPLIT, new ProjectExplorer(), new Editor());
    }

}
