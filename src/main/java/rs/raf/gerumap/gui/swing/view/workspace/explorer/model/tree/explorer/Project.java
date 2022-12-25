package rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer;

import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.BaseNode;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.Node;

import java.util.UUID;

public class Project extends Node {

    private static final String id = Project.class.getSimpleName();

    private String fileLocation;

    public Project(String name, BaseNode parent) {
        this(name, parent, UUID.randomUUID());
    }

    public Project(String name, BaseNode parent, UUID identifier) {
        this(name, parent, identifier, null);
    }

    public Project(String name, BaseNode parent, String fileLocation) {
        this(name, parent, UUID.randomUUID(), fileLocation);
    }

    public Project(String name, BaseNode parent, UUID identifier, String fileLocation) {
        super(name, parent, identifier);

        this.fileLocation = fileLocation;
    }

    @Override
    public void addChild(BaseNode child) {
        if (!(child instanceof MindMap))
            return;

        if (getChildren().contains(child))
            return;

        getChildren().add(child);
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    /**
     * Returns the class identifier.
     * @return id
     */
    public static String getId() {
        return id;
    }

}
