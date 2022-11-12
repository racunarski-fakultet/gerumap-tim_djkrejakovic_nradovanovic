package rs.raf.gerumap.tree.explorer;

import rs.raf.gerumap.gui.swing.util.LanguageUtils;
import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Node;

public class ProjectRoot extends Node {

    private static final String id = ProjectRoot.class.getSimpleName();

    public ProjectRoot() {
        this(LanguageUtils.getNameProperty(ProjectRoot.getId()));
    }

    public ProjectRoot(String name) {
        super(name, null);
    }

    @Override
    public void addChild(BaseNode child) {
        if (child == null || !(child instanceof Project))
            return; //TODO Error message - ProjectRoot can only have child of type Project

        if (getChildren().contains(child))
            return; //TODO Warning message - Child already exist

        getChildren().add(child);
    }

    public static String getId() {
        return id;
    }

}
