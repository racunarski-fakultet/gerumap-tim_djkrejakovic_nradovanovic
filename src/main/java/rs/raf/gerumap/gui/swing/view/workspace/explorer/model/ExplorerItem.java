package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.IEditorComponent;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.IExplorer;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.ExplorerDialogBase;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.RenameItemDialog;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.BaseNode;

import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class ExplorerItem extends DefaultMutableTreeNode {

    protected final BaseNode node;

    public ExplorerItem(BaseNode node) {
        super(node);
        this.node = node;
    }

    /**
     * Returns the node.
     * @return node
     */
    public BaseNode getNode() {
        return node;
    }

    /**
     * Adds a child.
     */
    public void addChild() {
        ExplorerItem child = createChild();

        if (child == null)
            return;

        IExplorer explorer = MainWindow.window.getExplorer();

        explorer.saveExpandedStatesInclude(getTreePath());

        add(child);
        explorer.reload(this);
        explorer.setSelectedItem(child);

        explorer.applyExpandedStates();
    }

    /**
     * Creates a child explorer item.
     * @return child
     */
    protected abstract ExplorerItem createChild();

    /**
     * Removes the child.
     * @param child child
     */
    public void removeChild(ExplorerItem child) {
        IExplorer explorer = MainWindow.window.getExplorer();

        explorer.saveExpandedStatesExclude(child.getTreePath());

        remove(child);

        explorer.reload(this);
        explorer.setSelectedItem(this);

        explorer.applyExpandedStates();
    }

    /**
     * Renames the explorer item.
     */
    public void rename() {
        ExplorerItem parent = (ExplorerItem) getParent();
        String nodeName = node.getName();
        List<String> childrenNames = parent != null ? parent.getChildrenNames(nodeName) : Collections.emptyList();

        ExplorerDialogBase dialog = new RenameItemDialog(MainWindow.window, childrenNames, nodeName);
        dialog.setVisible(true);
        String name = (String) dialog.getValue();

        if (name == null)
            return;

        IExplorer explorer = MainWindow.window.getExplorer();

        explorer.saveExpandedStates();

        node.setName(name);

        explorer.reload(this);
        explorer.setSelectedItem(this);

        explorer.applyExpandedStates();
    }

    /**
     * Returns the tree path of item.
     * @return tree path
     */
    public TreePath getTreePath() {
        List<TreeNode> nodes = new ArrayList<>();
        TreeNode current = this;

        nodes.add(this);

        while ((current = current.getParent()) != null)
            nodes.add(0, current);

        return new TreePath(nodes.toArray());
    }

    /**
     * Returns the names of the children.
     * @return children names
     */
    protected List<String> getChildrenNames() {
        List<String> names = new ArrayList<>();

        for (int i = 0; i < getChildCount(); ++i)
             names.add(((ExplorerItem) getChildAt(i)).getNode().getName().toLowerCase());

        return names;
    }

    /**
     * Returns the names of the children. It does not check "exclude" name.
     * @param exclude exclude
     * @return children names
     */
    protected List<String> getChildrenNames(String exclude) {
        List<String> names = getChildrenNames();

        names.remove(exclude.toLowerCase());

        return names;
    }

    /**
     * Displays the context menu for item.
     * @param x coordinate x
     * @param y coordinate y
     */
    public abstract void showContextMenu(int x, int y);

    /**
     * Returns the icon of the item.
     * @return icon
     */
    public abstract Icon getIcon();

    public abstract IEditorComponent getComponent();

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ExplorerItem item))
            return false;

        return Objects.equals(node, item.node);
    }

}
