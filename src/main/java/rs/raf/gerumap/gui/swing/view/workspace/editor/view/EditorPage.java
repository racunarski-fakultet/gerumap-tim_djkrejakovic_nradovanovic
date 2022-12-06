package rs.raf.gerumap.gui.swing.view.workspace.editor.view;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.tree.explorer.MindMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.Objects;

/**
 * Mindmap editor view.
 */
public class EditorPage extends JScrollPane implements IEditorComponent {

    private static final IEditor editor = MainWindow.window.getEditor();

    private MindMap mindMap;

    private JPanel content;

    private boolean isOpen = false;

    /**
     * Creates a mindmap document.
     * @param mindMap mind map
     */
    public EditorPage(MindMap mindMap) {
        this(mindMap, new JPanel());
    }

    /**
     * Creates a mindmap document.
     * @param mindMap mind map
     * @param content editor
     */
    public EditorPage(MindMap mindMap, JPanel content) {
        this.mindMap = mindMap;
        this.content = content;

        int width = 600; //TODO remove - prototype - constructor argument
        int height = 400; //TODO remove - prototype - constructor argument

        JPanel container = new JPanel(new GridBagLayout());
        container.setBackground(new Color(66, 69, 72));
        container.setPreferredSize(new Dimension(width + 200, height + 200));

        content.setPreferredSize(new Dimension(width, height));
        content.setBackground(new Color(255, 255, 255));

        container.add(content);

        setBorder(BorderFactory.createEmptyBorder());
        setViewportView(container);
    }

    @Override
    public void load() {
        EditorProject activeProject = editor.getActiveProject();

        if (!mindMap.getParent().equals(activeProject.getProject())) {
            editor.closePages();
            editor.setActiveProject((EditorProject) MainWindow.window.getExplorer().getItem(mindMap.getParent()).getComponent());
        }

        editor.setActivePage(this);
    }

    @Override
    public void rename(String oldName) {
        if (!isOpen)
            return;

        editor.renameTab(getTitle(), oldName);
    }

    public String getTitle() {
        return mindMap.getName();
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof EditorPage))
            return false;

        EditorPage page = (EditorPage) obj;
        return Objects.equals(page.mindMap, this.mindMap);
    }

}
