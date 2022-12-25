package rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite;

import java.util.Objects;
import java.util.UUID;

public abstract class BaseNode {

    private UUID identifier;

    protected String name;

    protected BaseNode parent;

    /**
     * Creates a base node with the given identifier.
     * <ul>
     *     <li>The <code><b>name</b></code> is displayed in the project explorer.</li>
     *     <li>The <code><b>parent</b></code> is the node with which it is connected and whose rank is one higher.</li>
     *     <li><code><b>Identifier</b></code> is used to compare nodes for equality. Two different elements should not have the same identifier.</li>
     * </ul>
     * @param name name
     * @param parent parent
     * @param identifier identifier
     */
    public BaseNode(String name, BaseNode parent, UUID identifier) {
        this.identifier = identifier;
        this.name = name;
        this.parent = parent;
    }

    /**
     * Sets the name for the node. It is displayed as an item name in the project explorer.
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
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
     * Returns a unique node identifier. It is used to compare nodes for equality.
     * @return identifier
     */
    public UUID getIdentifier() {
        return identifier;
    }

    /**
     * Generates a new unique identifier. It is used to compare nodes for equality.
     */
    public void generateNewIdentifier() {
        identifier = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BaseNode node))
            return false;

        return getIdentifier().equals(node.getIdentifier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parent);
    }

    @Override
    public String toString() {
        return getName();
    }


}
