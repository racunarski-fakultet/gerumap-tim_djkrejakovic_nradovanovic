package rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Node extends BaseNode {

    private final List<BaseNode> children = new ArrayList<>();

    public Node(String name, BaseNode parent, UUID identifier) {
        super(name, parent, identifier);
    }

    /**
     * Adds the child.
     * @param child child
     */
    public abstract void addChild(BaseNode child);

    /**
     * Returns the children.
     * @return children
     */
    public List<BaseNode> getChildren() {
        return children;
    }

}
