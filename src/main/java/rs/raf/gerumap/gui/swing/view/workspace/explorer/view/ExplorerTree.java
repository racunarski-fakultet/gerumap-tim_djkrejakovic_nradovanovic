package rs.raf.gerumap.gui.swing.view.workspace.explorer.view;

import rs.raf.gerumap.gui.swing.view.workspace.explorer.controller.ExplorerMouseListener;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerProjectRootItem;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerModel;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

public class ExplorerTree extends JTree {

    public ExplorerTree() {
        setModel(new ExplorerModel(new ExplorerProjectRootItem()));
        DefaultTreeCellRenderer renderer = new ExplorerItemRenderer();
        setCellEditor(new DefaultTreeCellEditor(this, renderer));
        setCellRenderer(renderer);

        setRowHeight(20);

        addMouseListener(new ExplorerMouseListener());
    }

    public TreePath getPathAtLocation(int y) {
        int numberOfRows = getRowCount();
        int distance = y;
        int currentRow = -1;

        while (distance > 0  && numberOfRows > ++currentRow)
            distance -= getRowBounds(currentRow).height;

        return (currentRow != numberOfRows) ? getPathForRow(currentRow) : null;
    }

}
