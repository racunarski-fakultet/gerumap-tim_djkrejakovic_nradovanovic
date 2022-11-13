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
            return; //TODO Error message - MindMap can only have child of type Element

        if (getChildren().contains(child))
            return; //TODO Warning message - Child already exist

        getChildren().add(child);
    }

    public static String getId() {
        return id;
    }

}
