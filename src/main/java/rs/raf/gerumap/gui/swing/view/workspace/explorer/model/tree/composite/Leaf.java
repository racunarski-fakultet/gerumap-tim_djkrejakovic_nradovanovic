package rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite;

/**
 * A tree-like structure that represents a leaf of a tree that has a parent.
 */
public abstract class Leaf extends BaseNode {

    /**
     * Creates a leaf node.
     * @param name name
     * @param parent parent
     */
    public Leaf(String name, BaseNode parent) {
        super(name, parent);
    }

}
