package rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer;

import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.BaseNode;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.Node;

import java.util.UUID;

public class MindMap extends Node {

    private static final String id = MindMap.class.getSimpleName();

    private String fileLocation;

    public MindMap(String name, BaseNode parent) {
        this(name, parent, UUID.randomUUID());
    }

    public MindMap(String name, BaseNode parent, UUID identifier) {
        this(name, parent, identifier, null);
    }

    public MindMap(String name, BaseNode parent, String fileLocation) {
        this(name, parent, UUID.randomUUID(), fileLocation);
    }

    public MindMap(String name, BaseNode parent, UUID identifier, String fileLocation) {
        super(name, parent, identifier);

        this.fileLocation = fileLocation;
    }

    @Override
    public void addChild(BaseNode child) {
        if (!(child instanceof Element))
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
