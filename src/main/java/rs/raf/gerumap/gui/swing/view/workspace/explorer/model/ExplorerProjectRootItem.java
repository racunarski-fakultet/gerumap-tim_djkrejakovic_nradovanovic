package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.Editor;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorProject;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.IEditorComponent;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.ExplorerDialogBase;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.NewProjectDialog;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.menu.ExplorerProjectRootMenu;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.Project;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.ProjectRoot;

import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class ExplorerProjectRootItem extends ExplorerItem {

    private static Icon icon = ImageUtils.loadIcon(StringUtils.removeTrailing(ExplorerProjectRootItem.class.getSimpleName(), "Item"));

    private final JPopupMenu menu = new ExplorerProjectRootMenu();

    private final Editor editor;

    public ExplorerProjectRootItem(Editor editor) {
        super(new ProjectRoot());
        this.editor = editor;
    }

    @Override
    protected ExplorerItem createChild() {
        ExplorerDialogBase dialog = new NewProjectDialog(MainWindow.window, getChildrenNames());
        dialog.setVisible(true);
        String name = (String) dialog.getValue();

        if (name == null)
            return null;

        Logger.log(Message.ADDED_PROJECT, name);

        ProjectRoot projectRoot = (ProjectRoot) getNode();

        Project project  = new Project(name, projectRoot);
        projectRoot.addChild(project);

        ExplorerProjectItem projectItem = new ExplorerProjectItem(project);
        editor.addProject((EditorProject) projectItem.getComponent());

        return projectItem;
    }

    @Override
    public void removeChild(ExplorerItem child) {
         editor.removeProject((EditorProject) child.getComponent());
         super.removeChild(child);
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
        return null; //TODO warning - project root is not an editor component
    }

}
