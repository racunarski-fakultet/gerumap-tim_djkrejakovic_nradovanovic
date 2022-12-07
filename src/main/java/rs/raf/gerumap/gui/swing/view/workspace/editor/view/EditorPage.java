package rs.raf.gerumap.gui.swing.view.workspace.editor.view;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.MindMap;

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

    private final MindMap mindMap;

    private final JPanel content;

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

        this.content.setPreferredSize(new Dimension(width, height));
        this.content.setBackground(new Color(255, 255, 255));

        container.add(this.content);

        setBorder(BorderFactory.createEmptyBorder());
        setViewportView(container);
    }

    @Override
    public void load() {
        if (!editor.getActiveProject().contains(this))
            editor.setActiveProject((EditorProject) MainWindow.window.getExplorer().getComponent(mindMap.getParent()));

        editor.setActivePage(this);
    }

    @Override
    public void rename(String oldName) {
        if (!isOpen)
            return;

        editor.renameTab(getTitle(), oldName);
    }

    /**
     * Sets whether the page is open.
     * @param open open state
     */
    public void setOpen(boolean open) {
        isOpen = open;
    }

    /**
     * Returns whether the page is open.
     * @return true if open, otherwise false
     */
    public boolean isOpen() {
        return isOpen;
    }

    /**
     * Returns the title of the page.
     * @return title
     */
    public String getTitle() {
        return mindMap.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof EditorPage))
            return false;

        EditorPage page = (EditorPage) obj;
        return Objects.equals(page.mindMap, this.mindMap);
    }

}
