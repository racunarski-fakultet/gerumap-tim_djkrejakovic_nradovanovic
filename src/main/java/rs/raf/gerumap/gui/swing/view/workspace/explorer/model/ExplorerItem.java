package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.view.ExplorerTree;
import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Node;

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
        if (!(node instanceof Node))
            return; //TODO Error message - Element cannot have a child

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
