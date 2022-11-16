package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.MindMapDocument;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.menu.ExplorerMindMapMenu;
import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Node;
import rs.raf.gerumap.tree.explorer.Element;

import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class ExplorerMindMapItem extends ExplorerItem {

    private static Icon icon = ImageUtils.loadIcon(StringUtils.removeTrailing(ExplorerMindMapItem.class.getSimpleName(), "Item"));

    private static final JPopupMenu menu = new ExplorerMindMapMenu();

    private final MindMapDocument document;

    public ExplorerMindMapItem(BaseNode node) {
        super(node); //TODO Error message if not MindMapItem
        document = new MindMapDocument(node.getName());
    }

    @Override
    protected ExplorerItem createChild() {
        Node parent = (Node)getNode();

        BaseNode child = new Element(parent);
        parent.addChild(child);

        return new ExplorerElementItem(child);
    }

    @Override
    public void showContextMenu(int x, int y) {
        menu.show(MainWindow.window.getWorkspace().getExplorer().getExplorerTree(), x, y);
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

    public MindMapDocument getDocument() {
        return document;
    }

}
