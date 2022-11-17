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
            return;

        if (getChildren().contains(child))
            return;

        getChildren().add(child);
    }

    public static String getId() {
        return id;
    }

}
