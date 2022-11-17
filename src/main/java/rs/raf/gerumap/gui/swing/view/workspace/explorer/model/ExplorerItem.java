package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.RenameItemDialog;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.view.ExplorerTree;
import rs.raf.gerumap.log.Logger;
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
        RenameItemDialog dialog = new RenameItemDialog(MainWindow.window, node.getName());
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

    public abstract void showContextMenu(int x, int y);

    public abstract Icon getIcon();

}
