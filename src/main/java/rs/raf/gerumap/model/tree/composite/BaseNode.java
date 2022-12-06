package rs.raf.gerumap.model.tree.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BaseNode {

    String name;

    BaseNode parent;

    /**
     * Creates a base node.
     * @param name name
     * @param parent parent
     */
    public BaseNode(String name, BaseNode parent) {
        this.name   = name;
        this.parent = parent;
    }

    /**
     * Sets the name for the node.
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the parent for the node.
     * @param parent parent
     */
    public void setParent(BaseNode parent) {
        this.parent = parent;
    }

    /**
     * Returns the name of the node.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the parent of the node.
     * @return parent
     */
    public BaseNode getParent() {
        return parent;
    }

    /**
     * Returns the predecessor tree.
     * @return tree
     */
    public List<BaseNode> getTree() {
        List<BaseNode> nodes = new ArrayList<>();
        BaseNode current = this;

        nodes.add(this);

        while ((current = current.parent) != null)
            nodes.add(0, current);

        return nodes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BaseNode))
            return false;

        BaseNode node = (BaseNode) obj;
        return Objects.equals(node.getName(), this.getName()) && Objects.equals(getTree(), node.getTree());
    }

    @Override
    public String toString() {
        return getName();
    }

}
