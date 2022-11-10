package rs.raf.gerumap.gui.swing.view.workspace;

import rs.raf.gerumap.gui.swing.view.workspace.editor.Editor;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.ProjectExplorer;

import javax.swing.JSplitPane;

public class Workspace extends JSplitPane {

    public Workspace() {
        super(HORIZONTAL_SPLIT, new ProjectExplorer(), new Editor());
    }

}
