package rs.raf.gerumap.tree.explorer;

import rs.raf.gerumap.gui.swing.util.LanguageUtils;
import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Node;

/**
 * The root of the project represents a node without a parent in the explorer structure.
 */
public class ProjectRoot extends Node {

    private static final String id = ProjectRoot.class.getSimpleName();

    /**
     * Creates a project root.
     */
    public ProjectRoot() {
        this(LanguageUtils.getNameProperty(ProjectRoot.getId()));
    }

    /**
     * Creates a project root.
     * @param name name
     */
    public ProjectRoot(String name) {
        super(name, null);
    }

    @Override
    public void addChild(BaseNode child) {
        if (child == null || !(child instanceof Project))
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
