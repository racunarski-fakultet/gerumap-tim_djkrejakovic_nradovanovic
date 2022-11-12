package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Node;
import rs.raf.gerumap.tree.explorer.Element;

import javax.swing.Icon;

public class ExplorerMindMapItem extends ExplorerItem {

    private static Icon icon = ImageUtils.loadIcon(StringUtils.removeTrailing(ExplorerMindMapItem.class.getSimpleName(), "Item"));

    public ExplorerMindMapItem(BaseNode node) {
        super(node); //TODO Error message if not MindMapItem
    }

    @Override
    protected ExplorerItem createChild() {
        Node parent = (Node)getNode();

        BaseNode child = new Element(parent);
        parent.addChild(child);

        return new ExplorerElementItem(child);
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

}
