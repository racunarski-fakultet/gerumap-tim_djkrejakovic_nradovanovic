package rs.raf.gerumap.gui.swing.view.workspace.explorer.view;

import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.Component;

/**
 * Item renderer for JTree.
 */
public class ExplorerItemRenderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row,
                                                  boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        if (!(value instanceof ExplorerItem)) {
            Logger.log(Message.EXPLORER_INCORRECT_TREE_NODE);
            return this;
        }

        ExplorerItem item = (ExplorerItem)value;

        setIcon(item.getIcon());

        return this;
    }

}
