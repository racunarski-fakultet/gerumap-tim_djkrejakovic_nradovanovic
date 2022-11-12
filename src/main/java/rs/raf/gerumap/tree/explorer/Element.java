package rs.raf.gerumap.tree.explorer;

import rs.raf.gerumap.gui.swing.util.LanguageUtils;
import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Leaf;

public class Element extends Leaf {

    private static final String id = Element.class.getSimpleName();;

    private static Integer count = 0;

    public Element(BaseNode parent) {
        this(LanguageUtils.getNameProperty(id) + ' ' + ++count, parent);
    }

    public Element(String name, BaseNode parent) {
        super(name, parent);
    }

    public static String getId() {
        return id;
    }

}
