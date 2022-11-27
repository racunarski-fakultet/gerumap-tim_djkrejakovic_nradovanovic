package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.ExplorerDialogBase;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.RenameItemDialog;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.view.ExplorerTree;
import rs.raf.gerumap.tree.composite.BaseNode;

import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Project explorer tree item base.
 */
public abstract class ExplorerItem extends DefaultMutableTreeNode {

    private BaseNode node;

    /**
     * Create the explorer item.
     * @param node node
     */
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

        ExplorerTree explorer = MainWindow.window.getWorkspace().getExplorer().getExplorerTree();
        ExplorerModel explorerModel = (ExplorerModel)explorer.getModel();

        //Creates a snapshot
        Queue<TreePath> expansionState = explorer.getExpansionState();
        expansionState.add(getTreePath());

        add(child);
        explorerModel.reload(this);
        explorer.setSelectionPath(child.getTreePath());

        //Restores a snapshot
        explorer.setExpansionState(expansionState);
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
        ExplorerTree explorer = MainWindow.window.getWorkspace().getExplorer().getExplorerTree();
        ExplorerModel explorerModel = (ExplorerModel)explorer.getModel();

        //Creates a snapshot
        Queue<TreePath> expansionState = explorer.getExpansionState(child.getTreePath());

        remove(child);

        explorerModel.reload(this);
        explorer.setSelectionPath(getTreePath());

        //Restores a snapshot
        explorer.setExpansionState(expansionState);
    }

    /**
     * Renames the explorer item.
     */
    public void rename() {
        ExplorerItem parent = (ExplorerItem) getParent();
        String nodeName = getNode().getName();

        //Displays rename dialog
        ExplorerDialogBase dialog = new RenameItemDialog(MainWindow.window, parent.getChildrenNames(nodeName), nodeName);
        dialog.setVisible(true);
        //Retrieves the value after interaction
        String name = (String) dialog.getValue();

        if (name == null)
            return;

        ExplorerTree explorer = MainWindow.window.getWorkspace().getExplorer().getExplorerTree();
        ExplorerModel explorerModel = (ExplorerModel)explorer.getModel();

        //Saves expanded state
        boolean isExpanded = explorer.isExpanded(this.getTreePath());

        node.setName(name);

        explorerModel.reload(this);
        explorer.setSelectionPath(this.getTreePath());
        explorer.setExpandedState(this.getTreePath(), isExpanded);
    }

    /**
     * Returns the tree path of item.
     * @return tree path
     */
    public TreePath getTreePath() {
        List<TreeNode> nodes = new ArrayList<>();
        TreeNode current = this;

        nodes.add(this);

        //Makes a full path (This item name, parent name, ... , ProjectRoot name)
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
     * Returns the icon of item.
     * @return
     */
    public abstract Icon getIcon();

}
