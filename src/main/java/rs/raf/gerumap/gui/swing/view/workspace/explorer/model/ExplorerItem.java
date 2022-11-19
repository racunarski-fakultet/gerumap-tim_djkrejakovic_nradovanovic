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

public abstract class ExplorerItem extends DefaultMutableTreeNode {

    private BaseNode node;

    public ExplorerItem(BaseNode node) {
        super(node);
        this.node = node;
    }

    public BaseNode getNode() {
        return node;
    }

    public void addChild() {
        ExplorerItem child = createChild();

        if (child == null)
            return;

        ExplorerTree explorer = MainWindow.window.getWorkspace().getExplorer().getExplorerTree();
        ExplorerModel explorerModel = (ExplorerModel)explorer.getModel();

        Queue<TreePath> expansionState = explorer.getExpansionState();
        expansionState.add(getTreePath());

        add(child);
        explorerModel.reload(this);
        explorer.setSelectionPath(child.getTreePath());

        explorer.setExpansionState(expansionState);
    }

    protected abstract ExplorerItem createChild();

    public void removeChild(ExplorerItem child) {
        ExplorerTree explorer = MainWindow.window.getWorkspace().getExplorer().getExplorerTree();
        ExplorerModel explorerModel = (ExplorerModel)explorer.getModel();

        Queue<TreePath> expansionState = explorer.getExpansionState(child.getTreePath());

        remove(child);

        explorerModel.reload(this);
        explorer.setSelectionPath(getTreePath());

        explorer.setExpansionState(expansionState);
    }

    public void rename() {
        ExplorerItem parent = (ExplorerItem) getParent();
        String nodeName = getNode().getName();

        ExplorerDialogBase dialog = new RenameItemDialog(MainWindow.window, parent.getChildrenNames(nodeName), nodeName);
        dialog.setVisible(true);
        String name = (String) dialog.getValue();

        if (name == null)
            return;

        ExplorerTree explorer = MainWindow.window.getWorkspace().getExplorer().getExplorerTree();
        ExplorerModel explorerModel = (ExplorerModel)explorer.getModel();

        boolean isExpanded = explorer.isExpanded(this.getTreePath());

        node.setName(name);

        explorerModel.reload(this);
        explorer.setSelectionPath(this.getTreePath());
        explorer.setExpandedState(this.getTreePath(), isExpanded);
    }

    public TreePath getTreePath() {
        List<TreeNode> nodes = new ArrayList<>();
        TreeNode current = this;

        nodes.add(this);

        while ((current = current.getParent()) != null)
            nodes.add(0, current);

        return new TreePath(nodes.toArray());
    }

    protected List<String> getChildrenNames() {
        List<String> names = new ArrayList<>();

        for (int i = 0; i < getChildCount(); ++i)
             names.add(((ExplorerItem) getChildAt(i)).getNode().getName().toLowerCase());

        return names;
    }

    protected List<String> getChildrenNames(String exclude) {
        List<String> names = getChildrenNames();

        names.remove(exclude.toLowerCase());

        return names;
    }

    public abstract void showContextMenu(int x, int y);

    public abstract Icon getIcon();

}
