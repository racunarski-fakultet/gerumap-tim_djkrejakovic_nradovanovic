package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Node;

import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;

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

        ExplorerItem childItem = createChild();
        add(childItem);
    }

    protected abstract ExplorerItem createChild();

    public abstract void showContextMenu(int x, int y);

    public abstract Icon getIcon();

}
