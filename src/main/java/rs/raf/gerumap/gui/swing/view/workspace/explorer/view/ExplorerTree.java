package rs.raf.gerumap.gui.swing.view.workspace.explorer.view;

import rs.raf.gerumap.gui.swing.view.workspace.explorer.controller.ExplorerMouseListener;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerProjectRootItem;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerModel;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import java.util.LinkedList;
import java.util.Queue;

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

    public Queue<TreePath> getExpansionState() {
        Queue<TreePath> expandedPaths = new LinkedList<>();

        for (int i = 0; i < getRowCount(); ++i)
            if (isExpanded(i))
                expandedPaths.add(getPathForRow(i));

        return expandedPaths;
    }

    public void setExpansionState(Queue<TreePath> expansionState) {
        for (TreePath path : expansionState) {
            setExpandedState(path, true);
        }
    }

}
