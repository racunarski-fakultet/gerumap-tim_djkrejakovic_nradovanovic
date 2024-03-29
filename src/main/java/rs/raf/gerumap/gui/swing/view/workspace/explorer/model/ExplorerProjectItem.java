package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorPage;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorProject;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.IEditorComponent;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.ExplorerDialogBase;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.NewMindMapDialog;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.menu.ExplorerProjectMenu;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.MindMap;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.Project;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;

import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class ExplorerProjectItem extends ExplorerItem {

    private static Icon icon = ImageUtils.loadIcon(StringUtils.removeTrailing(ExplorerProjectItem.class.getSimpleName(), "Item"));

    private final JPopupMenu menu = new ExplorerProjectMenu();

    private final EditorProject editorProject;

    public ExplorerProjectItem(Project node) {
        super(node);

        editorProject = new EditorProject(node);
    }

    @Override
    protected ExplorerItem createChild() {
        ExplorerDialogBase dialog = new NewMindMapDialog(MainWindow.window, getChildrenNames());
        dialog.setVisible(true);
        String name = (String) dialog.getValue();

        if (name == null)
            return null;

        Logger.log(Message.ADDED_MINDMAP, name);

        Project project = (Project) getNode();

        MindMap mindMap = new MindMap(name, project);
        project.addChild(mindMap);

        return new ExplorerMindMapItem(mindMap);
    }

    @Override
    protected void createComponent(ExplorerItem explorerItem) {
        editorProject.addPage((EditorPage) explorerItem.getComponent());
    }

    @Override
    public void removeChild(ExplorerItem child) {
        editorProject.removePage((EditorPage) child.getComponent());

        super.removeChild(child);
    }

    @Override
    public void rename() {
        String oldName = editorProject.getProject().getName();

        super.rename();

        editorProject.rename(oldName);
    }

    @Override
    public void showContextMenu(int x, int y) {
        menu.show(MainWindow.window.getExplorer().getTree(), x, y);
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

    @Override
    public IEditorComponent getComponent() {
        return editorProject;
    }

}
