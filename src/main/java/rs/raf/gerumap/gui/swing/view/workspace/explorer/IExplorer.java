package rs.raf.gerumap.gui.swing.view.workspace.explorer;

import rs.raf.gerumap.gui.swing.view.workspace.editor.view.IEditorComponent;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerModel;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.view.ExplorerTree;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.BaseNode;

import javax.swing.tree.TreePath;

public interface IExplorer {

    /**
     * Adds a new child to the explorer item.
     * @param item item
     */
    void addChild(ExplorerItem item);

    /**
     * Removes the explorer item.
     * @param item item
     */
    void remove(ExplorerItem item);

    /**
     * Renames the explorer item.
     * @param item item
     */
    void rename(ExplorerItem item);

    /**
     * Sets the selected explorer item.
     * @return true
     */
    boolean setSelectedItem(ExplorerItem item);

    /**
     * Returns the selected explorer item.
     */
    ExplorerItem getSelectedItem();

    /**
     * Returns the explorer item with the given path.
     * @param path path
     * @return explorer item
     */
    ExplorerItem getItem(TreePath path);


    /**
     * Returns the explorer item with the given node.
     * @param node node
     * @return explorer item
     */
    ExplorerItem getItem(BaseNode node);

    /**
     * Returns the editor component with the given node.
     * @param node node
     * @return editor component
     */
    IEditorComponent getComponent(BaseNode node);

    /**
     * Returns the explorer item with locations x and y.
     * @param x mouse x position
     * @param y mouse y position
     * @return item if exists, otherwise null.
     */
    ExplorerItem getItemAtLocation(int x, int y);

    /**
     * Returns the explorer root item.
     * @return explorer root
     */
    ExplorerItem getRoot();

    /**
     * Returns the explorer model.
     * @return explorer model
     */
    ExplorerModel getModel();

    /**
     * Returns the explorer tree.
     */
    ExplorerTree getTree();

    /**
     * Reloads all descendants below the item.
     * @param item item
     */
    void reload(ExplorerItem item);

    /**
     * Saves the current expanded states.
     */
    void saveExpandedStates();

    /**
     * Saves the current expanded states. Includes the path.
     */
    void saveExpandedStatesInclude(TreePath path);

    /**
     * Saves the current expanded states. Excludes the path and its children.
     */
    void saveExpandedStatesExclude(TreePath path);

    /**
     * Applies saved expanded states.
     */
    void applyExpandedStates();

}
