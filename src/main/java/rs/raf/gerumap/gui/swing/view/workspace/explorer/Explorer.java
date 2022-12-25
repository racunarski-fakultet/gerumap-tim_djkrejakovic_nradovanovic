package rs.raf.gerumap.gui.swing.view.workspace.explorer;

import rs.raf.gerumap.gui.swing.view.workspace.editor.Editor;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.IEditorComponent;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerModel;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerProjectRootItem;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.BaseNode;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.Node;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.view.ExplorerTree;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Queue;

public class Explorer extends JScrollPane implements IExplorer {

    private final ExplorerTree explorerTree;

    private Queue<TreePath> expandedStates;

    /**
     * Creates the project explorer.
     */
    public Explorer(Editor editor) {
        explorerTree = new ExplorerTree(editor);
        setPreferredSize(new Dimension(200, 0));
        setViewportView(explorerTree);
        setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, new Color(52, 53, 54)));
    }

    @Override
    public void addChild(ExplorerItem item) {
        item.addChild();
    }

    @Override
    public boolean addItem(ExplorerItem item) {
        if (item instanceof ExplorerProjectRootItem)
            return false; //TODO Error - Project Root item cannot be added (Project Root has no parent)

        BaseNode node = item.getNode();
        Node parentNode = (Node) node.getParent();

        if (!parentNode.getChildren().contains(node))
            parentNode.addChild(node);

        return getItem(parentNode).addItem(item);
    }

    @Override
    public void remove(ExplorerItem item) {
        ((ExplorerItem) item.getParent()).removeChild(item);
    }

    @Override
    public void rename(ExplorerItem item) {
        item.rename();
    }

    @Override
    public void setSelectedItem(ExplorerItem item) {
        explorerTree.setSelectionPath(item.getTreePath());
    }

    @Override
    public ExplorerItem getSelectedItem() {
        return (ExplorerItem) explorerTree.getLastSelectedPathComponent();
    }

    @Override
    public ExplorerItem getItem(TreePath path) {
        Enumeration<TreeNode> enumeration = getRoot().breadthFirstEnumeration();

        while (enumeration.hasMoreElements()) {
            ExplorerItem item = (ExplorerItem) enumeration.nextElement();
            if (item.getTreePath().toString().equals(path.toString()))
                return item;
        }

        return null;
    }

    @Override
    public ExplorerItem getItem(BaseNode node) {
        List<BaseNode> nodes = new ArrayList<>();
        BaseNode current = node;

        nodes.add(current);

        while ((current = current.getParent()) != null)
            nodes.add(0, current);

        return getItem(new TreePath(nodes.toArray()));
    }

    @Override
    public IEditorComponent getComponent(BaseNode node) {
        return getItem(node).getComponent();
    }

    @Override
    public ExplorerItem getItemAtLocation(int x, int y) {
        TreePath path = explorerTree.getPathAtLocation(y);
        return path != null ? getItem(path) : null;
    }

    @Override
    public ExplorerItem getRoot() {
        return (ExplorerItem) explorerTree.getModel().getRoot();
    }

    @Override
    public ExplorerModel getModel() {
        return (ExplorerModel) explorerTree.getModel();
    }

    @Override
    public ExplorerTree getTree() {
        return explorerTree;
    }

    @Override
    public void reload(ExplorerItem item) {
        getModel().reload(item);
    }

    @Override
    public void saveExpandedStates() {
        expandedStates = explorerTree.getExpansionStates();
    }

    @Override
    public void saveExpandedStatesInclude(TreePath path) {
        expandedStates = explorerTree.getExpansionStates();
        expandedStates.add(path);
    }

    @Override
    public void saveExpandedStatesExclude(TreePath path) {
        expandedStates = explorerTree.getExpansionStates(path);
    }

    @Override
    public void applyExpandedStates() {
        explorerTree.setExpansionStates(expandedStates);
        expandedStates.clear();
    }

}
