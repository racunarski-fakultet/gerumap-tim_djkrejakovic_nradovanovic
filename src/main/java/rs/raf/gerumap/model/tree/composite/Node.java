package rs.raf.gerumap.model.tree.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * A tree-like structure that represents a tree node that has a parent and is composed of other nodes.
 */
public abstract class Node extends BaseNode {

    private List<BaseNode> children = new ArrayList<>();

    /**
     * Create a node.
     * @param name name
     * @param parent parent
     */
    public Node(String name, BaseNode parent) {
        super(name, parent);
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
