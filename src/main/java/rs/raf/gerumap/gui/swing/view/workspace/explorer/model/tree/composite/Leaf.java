package rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite;

import java.util.UUID;

public abstract class Leaf extends BaseNode {

    public Leaf(String name, BaseNode parent, UUID identifier) {
        super(name, parent, identifier);
    }

}
