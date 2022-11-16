package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.custom.dialog.UndecoratedDialog;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.NewProjectDialog;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.menu.ExplorerProjectRootMenu;
import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Node;
import rs.raf.gerumap.tree.explorer.Project;
import rs.raf.gerumap.tree.explorer.ProjectRoot;

import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class ExplorerProjectRootItem extends ExplorerItem {

    private static Icon icon = ImageUtils.loadIcon(StringUtils.removeTrailing(ExplorerProjectRootItem.class.getSimpleName(), "Item"));

    private static final JPopupMenu menu = new ExplorerProjectRootMenu();

    public ExplorerProjectRootItem() {
        super(new ProjectRoot());
    }

    @Override
    protected ExplorerItem createChild() {
        UndecoratedDialog dialog = new NewProjectDialog(MainWindow.window, "Project");
        dialog.setVisible(true);
        String name = (String) dialog.getValue();

        if (name == null)
            return null;

        Node parent = (Node)getNode();
        Project child = new Project(name, parent);
        parent.addChild(child);

        MainWindow.window.getWorkspace().getEditor().projectAdded(child);

        return new ExplorerProjectItem(child);
    }

    @Override
    public void showContextMenu(int x, int y) {
        menu.show(MainWindow.window.getWorkspace().getExplorer().getExplorerTree(), x, y);
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

}
