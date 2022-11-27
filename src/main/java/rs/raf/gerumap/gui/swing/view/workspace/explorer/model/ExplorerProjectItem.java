package rs.raf.gerumap.gui.swing.view.workspace.explorer.model;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.MindMapDocument;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.ExplorerDialogBase;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.NewMindMapDialog;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.menu.ExplorerProjectMenu;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;
import rs.raf.gerumap.tree.composite.BaseNode;
import rs.raf.gerumap.tree.composite.Node;
import rs.raf.gerumap.tree.explorer.MindMap;
import rs.raf.gerumap.tree.explorer.Project;

import javax.swing.Icon;
import javax.swing.JPopupMenu;
import java.util.ArrayList;
import java.util.List;

/**
 * Project explorer tree project item.
 */
public class ExplorerProjectItem extends ExplorerItem {

    private static Icon icon = ImageUtils.loadIcon(StringUtils.removeTrailing(ExplorerProjectItem.class.getSimpleName(), "Item"));

    public static final JPopupMenu menu = new ExplorerProjectMenu();

    public ExplorerProjectItem(BaseNode node) {
        super(node);

        if (!(node instanceof Project))
            Logger.log(Message.EXPLORER_INCORRECT_NODE, getClass().getSimpleName());
    }

    @Override
    protected ExplorerItem createChild() {
        ExplorerDialogBase dialog = new NewMindMapDialog(MainWindow.window, getChildrenNames());
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

        Logger.log(Message.ADDED_MINDMAP, child.getName());

        return mindMapItem;
    }

    @Override
    public void removeChild(ExplorerItem child) {
        MainWindow.window.getWorkspace().getEditor().documentRemoved(((ExplorerMindMapItem) child).getDocument(), (Project) getNode());

        super.removeChild(child);
    }

    @Override
    public void rename() {
        Project oldProject = new Project(getNode().getName(), getNode().getParent());
        oldProject.getChildren().addAll(((Node) getNode()).getChildren());

        super.rename();

        MainWindow.window.getWorkspace().getEditor().projectRenamed(oldProject, (Project) getNode());
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
     * Returns the list of documents within the project.
     * @return documents
     */
    public List<MindMapDocument> getDocuments() {
        List<MindMapDocument> documents = new ArrayList<>();

        for (int i = 0; i < getChildCount(); ++i)
             documents.add(((ExplorerMindMapItem)getChildAt(i)).getDocument());

        return documents;
    }

}
