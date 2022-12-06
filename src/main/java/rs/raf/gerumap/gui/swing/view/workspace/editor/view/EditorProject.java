package rs.raf.gerumap.gui.swing.view.workspace.editor.view;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.tree.explorer.Project;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EditorProject implements IEditorComponent {

    private static final IEditor editor = MainWindow.window.getEditor();

    private Project project;

    private List<EditorPage> pages = new ArrayList<>();

    public EditorProject(Project project) {
        this.project = project;
    }

    @Override
    public void load() {
        boolean unchanged = equals(editor.getActiveProject());

        if (editor.getActiveProject() != null && !unchanged)
            editor.closePages();

        if (!unchanged)
            editor.setActiveProject(this);

        EditorPage activePage = editor.getActivePage();

        for (EditorPage page : pages)
            page.load();

        if (activePage != null && unchanged)
            editor.setActivePage(activePage);
    }

    /**
     * Adds a page to the project.
     * @param page page
     */
    public void addPage(EditorPage page) {
        pages.add(page);
        page.load();
    }

    /**
     * Removes a page from the project.
     * @param page page
     */
    public void removePage(EditorPage page) {
        if (page.isOpen())
            editor.closePage(page.getTitle());

        pages.remove(page);
    }

    /**
     * Returns the page with the title.
     * @param title title
     * @return page
     */
    public EditorPage getPage(String title) {
        for (EditorPage page : pages)
            if (page.getTitle().equals(title))
                return page;

        return null;
    }

    @Override
    public void rename(String oldName) {
        if (!equals(editor.getActiveProject()))
            return;

        MainWindow.window.setTitle("GeRuMap - " + project);
    }

    /**
     * Returns the project.
     * @return project
     */
    public Project getProject() {
        return project;
    }

    public Component getPageView(EditorPage page) { //TODO Move
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder());
        panel.setLayout(new BorderLayout());

        panel.add(page);
        return panel;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof EditorProject))
            return false;

        EditorProject editorProject = (EditorProject) obj;
        return Objects.equals(editorProject.project, this.project);
    }

}
