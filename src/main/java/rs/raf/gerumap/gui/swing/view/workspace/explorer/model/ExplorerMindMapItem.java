package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorPage;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.IEditorComponent;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.menu.ExplorerMindMapMenu;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.Element;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.MindMap;

import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class ExplorerMindMapItem extends ExplorerItem {

    private static Icon icon = ImageUtils.loadIcon(StringUtils.removeTrailing(ExplorerMindMapItem.class.getSimpleName(), "Item"));

    private static final JPopupMenu menu = new ExplorerMindMapMenu();

    private EditorPage mindMapEditor;

    public ExplorerMindMapItem(MindMap node) {
        super(node);

        mindMapEditor = new EditorPage(node);

        if (!(node instanceof MindMap))
            Logger.log(Message.EXPLORER_INCORRECT_NODE, getClass().getSimpleName());
    }

    @Override
    protected ExplorerItem createChild() {
        MindMap mindMap = (MindMap) getNode();

        Element element = new Element(mindMap);
        mindMap.addChild(element);

        Logger.log(Message.ADDED_ELEMENT, element.getName());

        return new ExplorerElementItem(element);
    }

    @Override
    public void rename() {
        String oldName = mindMapEditor.getTitle();

        super.rename();

        mindMapEditor.rename(oldName);
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
        return mindMapEditor;
    }

}
