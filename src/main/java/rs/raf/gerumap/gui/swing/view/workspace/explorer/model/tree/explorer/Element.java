package rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer;

import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.BaseNode;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.Leaf;

import java.util.UUID;


public class Element extends Leaf {

    private static final String id = Element.class.getSimpleName();

    public Element(String name, BaseNode parent) {
        this(name, parent, UUID.randomUUID());
    }

    public Element(String name, BaseNode parent, UUID identifier) {
        super(name, parent, identifier);
    }

    /**
     * Returns the class identifier.
     * @return id
     */
    public static String getId() {
        return id;
    }

}
