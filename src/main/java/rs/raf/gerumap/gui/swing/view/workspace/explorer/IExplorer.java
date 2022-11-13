package rs.raf.gerumap.gui.swing.view.workspace.explorer;

import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;

public interface IExplorer {

    /**
     * adds a new child to the explorer for the passed node
     */
    void addChild(ExplorerItem parent);

    /**
     * remove the passed node
     */
    void remove(ExplorerItem node);

    /**
     * renames the passed node
     */
    void rename(ExplorerItem node);

    /**
     * returns the last selected node from the explorer
     */
    ExplorerItem getSelectedNode();

    /**
     * returns the explorer root item
     */
    ExplorerItem getRoot();

}
