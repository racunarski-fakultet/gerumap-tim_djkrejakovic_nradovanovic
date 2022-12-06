package rs.raf.gerumap.gui.swing.view.workspace;

import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.IExplorer;

public interface IWorkspace {

    /**
     * Returns the explorer interface.
     * @return explorer
     */
    IExplorer getExplorer();

    /**
     * Returns the editor interface.
     * @return editor
     */
    IEditor getEditor();

    /**
     * Creates a project.
     */
    void createProject();

    /**
     * Creates a mind map.
     */
    void createMindMap();

    /**
     * Loads a project.
     */
    void loadProject();

    /**
     * Loads a mind map.
     */
    void loadMindMap();

    /**
     * Renames the explorer item.
     */
    void remove();

    /**
     * Removes the explorer item.
     */
    void rename();

}
