package rs.raf.gerumap.tree.explorer;

import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Node;

public class MindMap extends Node {

    private static final String id = MindMap.class.getSimpleName();

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

    public static String getId() {
        return id;
    }

}
