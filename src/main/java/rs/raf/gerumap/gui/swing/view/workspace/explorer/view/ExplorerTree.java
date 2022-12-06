package rs.raf.gerumap.gui.swing.view.workspace.explorer.view;

import rs.raf.gerumap.gui.swing.view.workspace.editor.Editor;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.controller.ExplorerContextMenuMouseListener;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.controller.ExplorerLoadItemMouseListener;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerModel;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerProjectRootItem;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import java.util.LinkedList;
import java.util.Queue;

public class ExplorerTree extends JTree {

    /**
     * Creates the explorer tree.
     */
    public ExplorerTree(Editor editor) {
        setModel(new ExplorerModel(new ExplorerProjectRootItem(editor)));
        DefaultTreeCellRenderer renderer = new ExplorerItemRenderer();
        setCellEditor(new DefaultTreeCellEditor(this, renderer));
        setCellRenderer(renderer);

        setRowHeight(20);

        addMouseListener(new ExplorerContextMenuMouseListener());
        addMouseListener(new ExplorerLoadItemMouseListener());
    }

    /**
     * Returns the TreePath of the item at y position if the item exist, otherwise null.
     * @param y coordinate y
     * @return path if item exist, otherwise null
     */
    public TreePath getPathAtLocation(int y) {
        int numberOfRows = getRowCount();
        int distance = y;
        int currentRow = -1;

        //Until the distance is less than 0 or until the number of rows is exceeded
        //the distance is reduced by the height of the current row.
        //If the loop is exited due to (distance < 0) the current row is the row at
        //position y, otherwise the position is outside the tree items
        while (distance > 0  && numberOfRows > ++currentRow)
            distance -= getRowBounds(currentRow).height;

        return (currentRow != numberOfRows) ? getPathForRow(currentRow) : null;
    }

    /**
     * Returns a snapshot of explorer tree.
     * @return expansion state
     */
    public Queue<TreePath> getExpansionStates() {
        Queue<TreePath> expandedPaths = new LinkedList<>();

        for (int i = 0; i < getRowCount(); ++i)
            if (isExpanded(i))
                expandedPaths.add(getPathForRow(i));

        return expandedPaths;
    }

    /**
     * Returns a snapshot of explorer tree. It does not check the "exclude" path.
     * @param exclude exclude
     * @return expansion state
     */
    public Queue<TreePath> getExpansionStates(TreePath exclude) {
        Queue<TreePath> expandedPaths = new LinkedList<>();

        for (int i = 0; i < getRowCount(); ++i) {
            TreePath path = getPathForRow(i);
            if (isExpanded(i) && !exclude.isDescendant(path))
                expandedPaths.add(path);
        }

        return expandedPaths;
    }

    /**
     * Sets the expansion states for explorer tree.
     * @param expansionState expansionState
     */
    public void setExpansionStates(Queue<TreePath> expansionState) {
        for (TreePath path : expansionState) {
            setExpandedState(path, true);
        }
    }

    @Override
    public void setExpandedState(TreePath path, boolean state) {
        super.setExpandedState(path, state);
    }

}
