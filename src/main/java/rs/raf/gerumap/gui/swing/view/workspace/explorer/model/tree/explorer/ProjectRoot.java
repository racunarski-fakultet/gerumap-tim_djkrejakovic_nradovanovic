package rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer;

import rs.raf.gerumap.gui.swing.util.LanguageUtils;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.BaseNode;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.Node;

import java.util.UUID;

public class ProjectRoot extends Node {

    private static final String id = ProjectRoot.class.getSimpleName();

    public ProjectRoot() {
        this(LanguageUtils.getNameProperty(ProjectRoot.getId()));
    }

    public ProjectRoot(String name) {
        this(name, UUID.randomUUID());
    }

    public ProjectRoot(String name, UUID identifier) {
        super(name, null, identifier);
    }

    @Override
    public void addChild(BaseNode child) {
        if (!(child instanceof Project))
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
