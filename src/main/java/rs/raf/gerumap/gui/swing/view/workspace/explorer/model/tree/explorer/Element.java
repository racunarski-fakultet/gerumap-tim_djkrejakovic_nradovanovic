package rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer;

import rs.raf.gerumap.gui.swing.util.LanguageUtils;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.BaseNode;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.Leaf;


public class Element extends Leaf {

    private static final String id = Element.class.getSimpleName();

    /**
     * Creates an element node.
     * @param parent parent
     */
    public Element(BaseNode parent) {
        this(LanguageUtils.getNameProperty(id), parent);
    }

    public Element(String name, BaseNode parent) {
        super(name, parent);
    }

    /**
     * Returns the class identifier.
     * @return id
     */
    public static String getId() {
        return id;
    }

}
