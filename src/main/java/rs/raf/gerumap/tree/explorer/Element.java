package rs.raf.gerumap.tree.explorer;

import rs.raf.gerumap.gui.swing.util.LanguageUtils;
import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Leaf;


/**
 * The element represents a leaf in the explorer structure.
 */
public class Element extends Leaf {

    private static final String id = Element.class.getSimpleName();

    private static Integer count = 0;

    /**
     * Creates an element node.
     * @param parent parent
     */
    public Element(BaseNode parent) {
        this(LanguageUtils.getNameProperty(id) + ' ' + ++count, parent);
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
