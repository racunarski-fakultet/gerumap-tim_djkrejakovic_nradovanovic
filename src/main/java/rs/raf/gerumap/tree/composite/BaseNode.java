package rs.raf.gerumap.tree.composite;

import java.util.Objects;

/**
 * The base of the tree-like structure.
 */
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

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof BaseNode))
            return false;

        BaseNode component = (BaseNode) object;
        return Objects.equals(component.getName(), this.getName());
    }

    @Override
    public String toString() {
        return getName();
    }

}
