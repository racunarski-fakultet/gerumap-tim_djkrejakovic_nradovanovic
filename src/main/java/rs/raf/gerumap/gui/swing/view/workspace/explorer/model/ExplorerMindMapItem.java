package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorPage;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.IEditorComponent;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.menu.ExplorerMindMapMenu;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.BaseNode;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.MindMap;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;

import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class ExplorerMindMapItem extends ExplorerItem {

    private static Icon icon = ImageUtils.loadIcon(StringUtils.removeTrailing(ExplorerMindMapItem.class.getSimpleName(), "Item"));

    private static final JPopupMenu menu = new ExplorerMindMapMenu();

    private final EditorPage editorPage;

    public ExplorerMindMapItem(MindMap node) {
        this(node, new EditorPage(node));
    }

    public ExplorerMindMapItem(BaseNode node, EditorPage editorPage) {
        super(node);

        this.editorPage = editorPage;
    }

    @Override
    protected ExplorerItem createChild() {
        //TODO Error - this method is used to create items through the item popup menu
        return null;
    }

    @Override
    protected void createComponent(ExplorerItem explorerItem) {
        Logger.log(Message.ADDED_ELEMENT, explorerItem.getNode().getName());

        editorPage.addElement((EditorElement) explorerItem.getComponent());
    }

    @Override
    public void removeChild(ExplorerItem child) {
        editorPage.removeElement((EditorElement) child.getComponent());

        super.removeChild(child);
    }

    @Override
    public void rename() {
        String oldName = editorPage.getTitle();

        super.rename();

        editorPage.rename(oldName);
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
        return editorPage;
    }

}
