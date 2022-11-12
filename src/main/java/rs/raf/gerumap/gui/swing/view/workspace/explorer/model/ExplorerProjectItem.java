package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Node;
import rs.raf.gerumap.tree.explorer.MindMap;

import javax.swing.Icon;

public class ExplorerProjectItem extends ExplorerItem {

    private static Icon icon = ImageUtils.loadIcon(StringUtils.removeTrailing(ExplorerProjectItem.class.getSimpleName(), "Item"));

    public ExplorerProjectItem(BaseNode node) {
        super(node);//TODO Error message if not ProjectItem
    }

    @Override
    protected ExplorerItem createChild() {
        Node parent = (Node)getNode();

        BaseNode mindMap = new MindMap(parent);
        parent.addChild(mindMap);

        return new ExplorerMindMapItem(mindMap);
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

}
