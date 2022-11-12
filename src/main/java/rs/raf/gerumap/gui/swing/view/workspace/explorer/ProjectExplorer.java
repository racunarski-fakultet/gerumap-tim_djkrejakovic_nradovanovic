package rs.raf.gerumap.gui.swing.view.workspace.explorer;

import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.view.ExplorerTree;

import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;
import java.awt.Dimension;

public class ProjectExplorer extends JScrollPane implements IExplorer {

    ExplorerTree explorer;

    public ProjectExplorer() {
        explorer = new ExplorerTree();
        setPreferredSize(new Dimension(200, 0));
        setViewportView(explorer);
    }

    @Override
    public void addChild(ExplorerItem parent) {
        parent.addChild();
        ((DefaultTreeModel)explorer.getModel()).reload(parent);
    }

    @Override
    public ExplorerItem getSelectedNode() {
        return (ExplorerItem)explorer.getLastSelectedPathComponent();
    }

    @Override
    public ExplorerItem getRoot() {
        return (ExplorerItem)explorer.getModel().getRoot();
    }

    public ExplorerTree getExplorerTree() {
        return explorer;
    }

}
