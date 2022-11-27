package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.MindMapDocument;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.menu.ExplorerMindMapMenu;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;
import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Node;
import rs.raf.gerumap.tree.explorer.Element;
import rs.raf.gerumap.tree.explorer.MindMap;
import rs.raf.gerumap.tree.explorer.Project;

import javax.swing.Icon;
import javax.swing.JPopupMenu;

/**
 * Project explorer tree mindmap item.
 */
public class ExplorerMindMapItem extends ExplorerItem {

    private static Icon icon = ImageUtils.loadIcon(StringUtils.removeTrailing(ExplorerMindMapItem.class.getSimpleName(), "Item"));

    private static final JPopupMenu menu = new ExplorerMindMapMenu();

    private final MindMapDocument document;

    public ExplorerMindMapItem(BaseNode node) {
        super(node);
        document = new MindMapDocument(node.getName());

        if (!(node instanceof MindMap))
            Logger.log(Message.EXPLORER_INCORRECT_NODE, getClass().getSimpleName());
    }

    @Override
    protected ExplorerItem createChild() {
        Node parent = (Node)getNode();

        Element child = new Element(parent);
        parent.addChild(child);

        Logger.log(Message.ADDED_ELEMENT, child.getName());

        return new ExplorerElementItem(child);
    }

    @Override
    public void rename() {
        MindMapDocument oldMindMap = new MindMapDocument(getDocument().getName(), getDocument().getContent());
        MindMapDocument newMindMap = getDocument();
        Project project = (Project) ((ExplorerProjectItem) getParent()).getNode();

        super.rename();
        newMindMap.setName(getNode().getName());

        MainWindow.window.getWorkspace().getEditor().documentRenamed(oldMindMap, newMindMap, project);
    }

    @Override
    public void showContextMenu(int x, int y) {
        menu.show(MainWindow.window.getWorkspace().getExplorer().getExplorerTree(), x, y);
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

    /**
     * Returns the document.
     * @return document
     */
    public MindMapDocument getDocument() {
        return document;
    }

}
