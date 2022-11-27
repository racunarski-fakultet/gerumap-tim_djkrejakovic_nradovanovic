package rs.raf.gerumap.gui.swing.view.workspace;

import rs.raf.gerumap.gui.swing.view.workspace.editor.Editor;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.ProjectExplorer;

import javax.swing.JSplitPane;

public class Workspace extends JSplitPane {

    private Editor editor;

    private ProjectExplorer explorer;

    /**
     * Creates a workspace.
     */
    public Workspace() {
        editor = new Editor();
        explorer = new ProjectExplorer();

        setLeftComponent(explorer);
        setRightComponent(editor);

    }

    /**
     * Returns the editor.
     * @return editor
     */
    public Editor getEditor() {
        return editor;
    }

    /**
     * Returns the project explorer.
     * @return explorer
     */
    public ProjectExplorer getExplorer() {
        return explorer;
    }

}
