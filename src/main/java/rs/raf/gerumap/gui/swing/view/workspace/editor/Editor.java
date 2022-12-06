package rs.raf.gerumap.gui.swing.view.workspace.editor;

import com.formdev.flatlaf.FlatClientProperties;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorChangeListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorTabMouseListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorPage;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorProject;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.IEditorComponent;
import rs.raf.gerumap.model.User;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class Editor extends JTabbedPane implements IEditor {

    private List<EditorProject> projects = new ArrayList<>();

    private EditorProject activeProject = null;

    private EditorPage activePage = null;

    private User author = new User("Unregistered");
    private final JLabel authorLabel = new JLabel();

    private final JToolBar trailingTools = new JToolBar();
    private final JToolBar leadingTools  = new JToolBar();
    private final JToolBar editorTools = new JToolBar(); //TODO prototype
    private final JLabel statusBar = new JLabel();
    private final JPanel propertiesPane = new JPanel();

    /**
     * Create the editor.
     */
    public Editor() {
        addListeners();
        initializeComponents();
    }

    //region Setup

    private void addListeners() {
        addChangeListener(new EditorChangeListener());
        addMouseListener(new EditorTabMouseListener());
    }

    /**
     * Setups basic editor functionalities.
     */
    private void initializeComponents() {
        setupLeadingComponents();
        setupTrailingComponents();
        setupPageViewComponents();

        setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, new Color(52, 53, 54))); //TODO move
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        putClientProperty(FlatClientProperties.TABBED_PANE_TAB_CLOSABLE, true);
        putClientProperty(FlatClientProperties.TABBED_PANE_TAB_CLOSE_TOOLTIPTEXT, "Close" );
        putClientProperty(FlatClientProperties.TABBED_PANE_TAB_CLOSE_CALLBACK, (BiConsumer<JTabbedPane, Integer>) (tabbedPane, tabIndex) -> closePage(tabIndex));
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
        authorLabel.setText(author.getName());

        trailingTools.add(Box.createHorizontalGlue());
        trailingTools.add(authorLabel);
    }

    /**
     * Setups the page view components.
     */
    private void setupPageViewComponents() { }

    //endregion

    @Override
    public void load(IEditorComponent component) {
        component.load();
    }

    @Override
    public void setActivePage(EditorPage page) {
        if (!page.isOpen()) {
            setPageView(page);
            page.setOpen(true);
        }

        setSelectedIndex(getTabIndexForTitle(page.getTitle()));
    }

    @Override
    public void setPageView(EditorPage page) {
        String title = page.getTitle();

        JPanel view = new JPanel(new BorderLayout());
        view.setBorder(BorderFactory.createEmptyBorder());

        view.add(page, BorderLayout.CENTER);

        add(title, view);
    }

    @Override
    public void setActiveProject(EditorProject activeProject) {
        this.activeProject = activeProject;
        updateWindowTitle();
    }

    @Override
    public void setAuthor(User author) {
        this.author = author;
        authorLabel.setText(author.getName());
    }

    @Override
    public void updateActivePage() {
        activePage = getSelectedIndex() >= 0 ? getOpenPage(getSelectedIndex()) : null;
    }

    @Override
    public EditorPage getActivePage() {
        return activePage;
    }

    @Override
    public EditorProject getActiveProject() {
        return activeProject;
    }

    @Override
    public User getAuthor() {
        return author;
    }

    @Override
    public EditorPage getOpenPage(int index) {
        return getOpenPage(getTitleAt(index));
    }

    @Override
    public EditorPage getOpenPage(String title) {
        return activeProject.getPage(title);
    }

    @Override
    public void closePage(int index) {
        EditorPage page = getOpenPage(index);

        page.setOpen(false);
        remove(index);

        if (!page.equals(activePage))
            return;

        if (getTabCount() > 0)
            setActivePage(getOpenPage(index - Boolean.compare(getTabCount() < index, false)));
        else
            activePage = null;
    }

    @Override
    public void closePage(String title) {
        closePage(getTabIndexForTitle(title));
    }

    @Override
    public void closePages() {
        while (getTabCount() > 0)
            closePage(0);
    }

    @Override
    public void closeTabAt(Point location) {
        closePage(getUI().tabForCoordinate(this, location.x, location.y));
    }

    @Override
    public void renameTab(String newName, String oldName) {
        setTitleAt(getTabIndexForTitle(oldName), newName);
    }

    @Override
    public void closeProject() {
        closePages();
        activeProject = null;
    }

    /**
     * Adds the project to the editor.
     * @param project project
     */
    public void addProject(EditorProject project) {
        projects.add(project);
        project.load();
    }

    /**
     * Removes the project from the editor.
     * @param project project
     */
    public void removeProject(EditorProject project) {
        if (project.equals(activeProject)) {
            closeProject();
            updateWindowTitle();
        }

        projects.remove(project);
    }

    private void updateWindowTitle() {
        MainWindow.window.setTitle("GeRuMap" + (activeProject != null ? " - " + activeProject.getProject() : ""));
    }

    /**
     * Returns the tab index if tab with title is opened, otherwise returns -1.
     * @param title tab title
     * @return tab index if opened, otherwise -1
     */
    public int getTabIndexForTitle(String title) {
        for (int i = 0; i < getTabCount(); ++i)
            if (getTitleAt(i).equals(title))
                return i;

        return -1;
    }

}

