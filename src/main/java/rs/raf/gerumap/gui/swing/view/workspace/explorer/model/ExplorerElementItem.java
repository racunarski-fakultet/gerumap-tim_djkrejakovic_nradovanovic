package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.tree.composite.BaseNode;

import javax.swing.Icon;

public class ExplorerElementItem extends ExplorerItem {

    private static Icon icon = ImageUtils.loadIcon(StringUtils.removeTrailing(ExplorerElementItem.class.getSimpleName(), "Item"));

    public ExplorerElementItem(BaseNode node) {
        super(node); //TODO Error message if not ElementItem
    }

    @Override
    protected ExplorerItem createChild() { //TODO This method should never be called
        //TODO Error message
        return null;
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

}
