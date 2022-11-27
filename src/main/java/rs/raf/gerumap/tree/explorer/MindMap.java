package rs.raf.gerumap.tree.explorer;

import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Node;

/**
 * A mindmap represents a node in the explorer structure.
 */
public class MindMap extends Node {

    private static final String id = MindMap.class.getSimpleName();

    /**
     * Creates a mindmap node.
     * @param name name
     * @param parent parent
     */
    public MindMap(String name, BaseNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(BaseNode child) {
        if (child == null || !(child instanceof Element))
            return;

        if (getChildren().contains(child))
            return;

        getChildren().add(child);
    }

    /**
     * Returns the class identifier.
     * @return id
     */
    public static String getId() {
        return id;
    }

}
