package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.menu.ExplorerElementMenu;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;
import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.explorer.Element;

import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class ExplorerElementItem extends ExplorerItem {

    private static Icon icon = ImageUtils.loadIcon(StringUtils.removeTrailing(ExplorerElementItem.class.getSimpleName(), "Item"));

    private static final JPopupMenu menu = new ExplorerElementMenu();

    public ExplorerElementItem(BaseNode node) {
        super(node);

        if (!(node instanceof Element))
            Logger.log(Message.EXPLORER_INCORRECT_NODE, getClass().getSimpleName());
    }

    @Override
    protected ExplorerItem createChild() {
        Logger.log(Message.EXPLORER_CANNOT_HAVE_CHILD);
        return null;
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
