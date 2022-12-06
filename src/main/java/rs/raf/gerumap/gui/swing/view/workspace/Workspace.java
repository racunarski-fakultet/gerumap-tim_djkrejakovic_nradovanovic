package rs.raf.gerumap.gui.swing.view.workspace;

import rs.raf.gerumap.gui.swing.view.workspace.editor.Editor;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.Explorer;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.IExplorer;

import javax.swing.JSplitPane;

public class Workspace extends JSplitPane implements IWorkspace {

    private Editor editor;

    private Explorer explorer;

    /**
     * Creates a workspace.
     */
    public Workspace() {
        editor = new Editor();
        explorer = new Explorer(editor);

        setLeftComponent(explorer);
        setRightComponent(editor);
    }

    @Override
    public IEditor getEditor() {
        return editor;
    }

    @Override
    public IExplorer getExplorer() {
        return explorer;
    }

    @Override
    public void createProject() {
        explorer.addChild(explorer.getRoot());

    }

    @Override
    public void createMindMap() {
        explorer.addChild(explorer.getSelectedItem());
    }

    @Override
    public void loadProject() {
        editor.load(explorer.getSelectedItem().getComponent());
    }

    @Override
    public void loadMindMap() {
        editor.load(explorer.getSelectedItem().getComponent());
    }

    @Override
    public void remove() {
        explorer.remove(explorer.getSelectedItem());
    }

    @Override
    public void rename() {
        explorer.rename(explorer.getSelectedItem());
    }

}
