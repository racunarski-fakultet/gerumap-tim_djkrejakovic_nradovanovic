package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.IEditorComponent;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.menu.ExplorerElementMenu;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.BaseNode;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;

import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class ExplorerElementItem extends ExplorerItem {

    private static Icon icon = ImageUtils.loadIcon(StringUtils.removeTrailing(ExplorerElementItem.class.getSimpleName(), "Item"));

    private static final JPopupMenu menu = new ExplorerElementMenu();

    private final EditorElement editorElement;

    public ExplorerElementItem(BaseNode node, EditorElement editorElement) {
        super(node);

        this.editorElement = editorElement;
    }

    @Override
    protected ExplorerItem createChild() {
        Logger.log(Message.EXPLORER_CANNOT_HAVE_CHILD);
        return null;
    }

    @Override
    protected void createComponent(ExplorerItem explorerItem) { }

    @Override
    public void removeChild(ExplorerItem child) {
        super.removeChild(child);
    }

    @Override
    public void rename() {
        String oldName = editorElement.getGraphicElement().getName();

        super.rename();

        editorElement.rename(oldName);
    }

    @Override
    public void showContextMenu(int x, int y) {
        menu.show(MainWindow.window.getExplorer().getTree(), x, y);
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

    @Override
    public IEditorComponent getComponent() {
        return editorElement;
    }

}
