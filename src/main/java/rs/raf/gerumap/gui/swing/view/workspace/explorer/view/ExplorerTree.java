package rs.raf.gerumap.gui.swing.view.workspace.explorer.view;

import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerProjectRootItem;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerModel;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

public class ExplorerTree extends JTree {

    public ExplorerTree() {
        setModel(new ExplorerModel(new ExplorerProjectRootItem()));
        DefaultTreeCellRenderer renderer = new ExplorerItemRenderer();
        setCellEditor(new DefaultTreeCellEditor(this, renderer));
        setCellRenderer(renderer);
    }

}
