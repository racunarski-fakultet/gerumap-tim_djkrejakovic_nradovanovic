package rs.raf.gerumap.gui.swing.view.workspace.editor.view;

import com.formdev.flatlaf.FlatClientProperties;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.user.model.User;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorFocusMouseListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorKeyListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorTabChangeListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorTabMouseListener;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.composite.BaseNode;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.Project;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.IntConsumer;

public class EditorProject extends JTabbedPane implements IEditorComponent {

    private static final IEditor editor = MainWindow.window.getEditor();

    private final Project project;

    private final List<EditorPage> pages = new ArrayList<>();

    private final JLabel authorLabel = new JLabel();

    private final JToolBar trailingTools = new JToolBar();
    private final JToolBar leadingTools  = new JToolBar();

    public EditorProject(Project project) {
        this.project = project;

        addListeners();
        setupComponents();
    }

    //region Setup

    /**
     * Setups the project listeners.
     */
    private void addListeners() {
        addChangeListener(new EditorTabChangeListener());
        addMouseListener(new EditorTabMouseListener());
        addMouseListener(new EditorFocusMouseListener());
        addKeyListener(new EditorKeyListener());
    }

    /**
     * Setups the project components.
     */
    private void setupComponents() {
        setupLeadingComponents();
        setupTrailingComponents();

        setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(52, 53, 54)));
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        putClientProperty(FlatClientProperties.TABBED_PANE_TAB_CLOSABLE, true);
        putClientProperty(FlatClientProperties.TABBED_PANE_TAB_CLOSE_TOOLTIPTEXT, "Close" );
        putClientProperty(FlatClientProperties.TABBED_PANE_TAB_CLOSE_CALLBACK, (IntConsumer) editor::closePage);
        putClientProperty(FlatClientProperties.TABBED_PANE_LEADING_COMPONENT, leadingTools.getComponentCount() > 0 ? leadingTools : null);
        putClientProperty(FlatClientProperties.TABBED_PANE_TRAILING_COMPONENT, trailingTools.getComponentCount() > 0 ? trailingTools : null);
    }

    /**
     * Setups leading components.
     */
    private void setupLeadingComponents() { }

    /**
     * Setups trailing components.
     */
    private void setupTrailingComponents() {
        authorLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        authorLabel.setText(editor.getAuthor() != null ? editor.getAuthor().getName() : "Unregistered");

        trailingTools.add(Box.createHorizontalGlue());
        trailingTools.add(authorLabel);
    }

    //endregion

    @Override
    public void load() {
        boolean unchanged = equals(editor.getActiveProject());

        if (editor.getActiveProject() != null && !unchanged)
            editor.closePages();

        if (!unchanged)
            editor.setActiveProject(editor.getProject(getProject()));

        EditorPage activePage = editor.getActivePage();

        for (EditorPage page : pages)
            page.load();

        if (activePage != null && unchanged)
            editor.setActivePage(activePage);
    }

    @Override
    public void rename(String oldName) {
        if (!equals(editor.getActiveProject()))
            return;

        MainWindow.window.setTitle("GeRuMap - " + project);
    }

    /**
     * Adds a page to the project.
     * @param page page
     */
    public void addPage(EditorPage page) {
        if (!pages.contains(page))
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

    /**
     * Returns the editor page associated with the node.
     * @param node node
     * @return page
     */
    public EditorPage getPage(BaseNode node) {
        for (EditorPage page : pages)
            if (page.getMindMap().equals(node))
                return page;

        return null;
    }

    /**
     * Returns the pages of this project.
     * @return pages
     */
    public List<EditorPage> getPages() {
        return pages;
    }

    /**
     * Returns true if the project contains a page, otherwise false.
     * @param page page
     * @return true if contains, otherwise false
     */
    public boolean contains(EditorPage page) {
        return getPage(page.getTitle()) != null;
    }

    /**
     * Generates new identifiers for this component and all descendants.
     */
    public void generateNewIdentifiers() {
        project.generateNewIdentifier();

        for (EditorPage page : pages)
            page.generateNewIdentifiers();
    }

    /**
     * Sets the author of the project.
     * @param author author
     */
    public void setAuthor(User author) {
        authorLabel.setText(author.getName());
    }

    /**
     * Returns the project.
     * @return project
     */
    public Project getProject() {
        return project;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EditorProject editorProject))
            return false;

        return Objects.equals(editorProject.project, this.project);
    }

}
