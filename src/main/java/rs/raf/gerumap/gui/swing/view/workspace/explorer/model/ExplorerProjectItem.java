package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.custom.dialog.UndecoratedDialog;
import rs.raf.gerumap.gui.swing.view.workspace.editor.MindMapDocument;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.NewMindMapDialog;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.menu.ExplorerProjectMenu;
import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Node;
import rs.raf.gerumap.tree.explorer.MindMap;
import rs.raf.gerumap.tree.explorer.Project;

import javax.swing.Icon;
import javax.swing.JPopupMenu;
import java.util.ArrayList;
import java.util.List;

public class ExplorerProjectItem extends ExplorerItem {

    private static Icon icon = ImageUtils.loadIcon(StringUtils.removeTrailing(ExplorerProjectItem.class.getSimpleName(), "Item"));

    public static final JPopupMenu menu = new ExplorerProjectMenu();

    public ExplorerProjectItem(BaseNode node) {
        super(node);//TODO Error message if not ProjectItem
    }

    @Override
    protected ExplorerItem createChild() {
        UndecoratedDialog dialog = new NewMindMapDialog(MainWindow.window, "MindMap");
        dialog.setVisible(true);
        String name = (String) dialog.getValue();

        if (name == null)
            return null;

        Node parent = (Node)getNode();
        MindMap child = new MindMap(name, parent);
        parent.addChild(child);

        ExplorerMindMapItem mindMapItem = new ExplorerMindMapItem(child);
        Project project = (Project) getNode();

        MainWindow.window.getWorkspace().getEditor().documentAdded(mindMapItem.getDocument(), project);

        return mindMapItem;
    }

    @Override
    public void removeChild(ExplorerItem child) {
        MainWindow.window.getWorkspace().getEditor().documentRemoved(((ExplorerMindMapItem) child).getDocument(), (Project) getNode());

        super.removeChild(child);
    }

    @Override
    public void showContextMenu(int x, int y) {
        menu.show(MainWindow.window.getWorkspace().getExplorer().getExplorerTree(), x, y);
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

    public List<MindMapDocument> getDocuments() {
        List<MindMapDocument> documents = new ArrayList<>();

        for (int i = 0; i < getChildCount(); ++i)
             documents.add(((ExplorerMindMapItem)getChildAt(i)).getDocument());

        return documents;
    }

}
