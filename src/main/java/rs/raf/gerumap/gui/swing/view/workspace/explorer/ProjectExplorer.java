package rs.raf.gerumap.gui.swing.view.workspace.explorer;

import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.view.ExplorerTree;

import javax.swing.JScrollPane;
import java.awt.Dimension;

public class ProjectExplorer extends JScrollPane implements IExplorer {

    ExplorerTree explorer;

    /**
     * Creates the project explorer.
     */
    public ProjectExplorer() {
        explorer = new ExplorerTree();
        setPreferredSize(new Dimension(200, 0));
        setViewportView(explorer);
    }

    @Override
    public void addChild(ExplorerItem parent) {
        parent.addChild();
    }

    @Override
    public void remove(ExplorerItem node) {
        ((ExplorerItem) node.getParent()).removeChild(node);
    }

    @Override
    public void rename(ExplorerItem node) {
        node.rename();
    }

    @Override
    public ExplorerItem getSelectedNode() {
        return (ExplorerItem)explorer.getLastSelectedPathComponent();
    }

    @Override
    public ExplorerItem getRoot() {
        return (ExplorerItem)explorer.getModel().getRoot();
    }

    /**
     * Returns the explorer tree.
     * @return explorer tree
     */
    public ExplorerTree getExplorerTree() {
        return explorer;
    }

}
