package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.menu.ExplorerProjectMenu;
import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Node;
import rs.raf.gerumap.tree.explorer.MindMap;

import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class ExplorerProjectItem extends ExplorerItem {

    private static Icon icon = ImageUtils.loadIcon(StringUtils.removeTrailing(ExplorerProjectItem.class.getSimpleName(), "Item"));

    public static final JPopupMenu menu = new ExplorerProjectMenu();

    public ExplorerProjectItem(BaseNode node) {
        super(node);//TODO Error message if not ProjectItem
    }

    @Override
    protected ExplorerItem createChild() {
        Node parent = (Node)getNode();

        BaseNode mindMap = new MindMap(parent);
        parent.addChild(mindMap);

        return new ExplorerMindMapItem(mindMap);
    }

    @Override
    public void showContextMenu(int x, int y) {
        menu.show(MainWindow.window.getWorkspace().getExplorer().getExplorerTree(), x, y);
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

}
