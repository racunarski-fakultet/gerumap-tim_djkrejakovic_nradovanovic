package rs.raf.gerumap.tree.explorer;

import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Node;

public class Project extends Node {

    private static final String id = Project.class.getSimpleName();

    public Project(String name, BaseNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(BaseNode child) {
        if (child == null || !(child instanceof MindMap))
            return; //TODO Error message - Project can only have child of type MindMap

        if (getChildren().contains(child))
            return; //TODO Warning message - Child already exist

        getChildren().add(child);
    }

    public static String getId() {
        return id;
    }

}
