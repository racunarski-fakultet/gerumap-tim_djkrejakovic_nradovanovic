package rs.raf.gerumap.gui.swing.view.workspace.editor.view;

public interface IEditorComponent {

    /**
     * Loads the component into the editor.
     */
    void load();

    /**
     * Perform a rename operation for the component.
     * @param oldName old name
     */
    void rename(String oldName);

}
