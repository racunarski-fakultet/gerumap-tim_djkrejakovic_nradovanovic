package rs.raf.gerumap.gui.swing.view.workspace.editor;

import rs.raf.gerumap.gui.swing.controller.StateManager;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.user.model.User;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorFocusMouseListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConfigurations;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorDiagram;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorPage;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorProject;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorProperties;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorStatusBar;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorToolbar;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.IEditorComponent;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.properties.DiagramProperties;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.properties.PropertiesBase;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Editor extends JPanel implements IEditor {

    private final List<EditorProject> projects = new ArrayList<>();

    private User author = null;

    private EditorProject activeProject = null;

    private EditorPage activePage = null;

    private final EditorToolbar toolbar = new EditorToolbar();

    private final EditorProperties properties = new EditorProperties();

    public Editor() {
        super(new BorderLayout());
        setupComponents();
    }

    /**
     * Setups the editor components.
     */
    private void setupComponents() {
        setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, new Color(52, 53, 54)));

        toolbar.addMouseListener(new EditorFocusMouseListener());
    }

    @Override
    public void load(IEditorComponent component) {
        component.load();
    }

    @Override
    public void render() {
        getDiagram().setActualSize(getDiagram().getActualSize());
        getDiagram().repaint();
    }

    @Override
    public void setProperties(PropertiesBase properties) {
        this.properties.setProperties(properties);
        this.properties.getFocus();
    }

    @Override
    public void setActivePage(EditorPage page) {
        if (!page.isOpen()) {
            openPage(page);
            page.setOpen(true);
        }

        activePage = page;
        activeProject.setSelectedIndex(getTabIndexForTitle(page.getTitle()));
        activeProject.requestFocus();
    }

    @Override
    public void setActiveProject(EditorProject project) {
        if (activeProject != null)
            closeProject();

        activeProject = project;
        updateWindowTitle();
    }

    @Override
    public void setAuthor(User author) {
        this.author = author;

        if (activeProject != null)
            activeProject.setAuthor(author);
    }

    @Override
    public void updateActivePage() {
        activePage = activeProject.getSelectedIndex() >= 0 ? getOpenPage(activeProject.getSelectedIndex()) : null;

        if (activePage != null)
            properties.reset();
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
    public void openPage(EditorPage page) {
        String title = page.getTitle();

        activeProject.add(title, page);

        if (activeProject.getTabCount() == 1)
            addComponents();
    }

    @Override
    public EditorPage getOpenPage(int index) {
        return getOpenPage(activeProject.getTitleAt(index));
    }

    @Override
    public EditorPage getOpenPage(String title) {
        return activeProject.getPage(title);
    }

    @Override
    public EditorDiagram getDiagram() {
        return activePage.getDiagram();
    }

    @Override
    public EditorStatusBar getStatusBar() {
        return activePage.getStatusBar();
    }

    @Override
    public GraphicConfigurations getGraphicConfigurations() {
        return activePage.getDiagram().getConfigurations();
    }

    @Override
    public void closePage(int index) {
        EditorPage page = getOpenPage(index);

        page.setOpen(false);
        activeProject.remove(index);

        if (page.equals(this.activePage))
            setActivePage(getOpenPage(index - Boolean.compare(activeProject.getTabCount() < index, false)));

        if (activePage == null)
            removeComponents();
    }

    @Override
    public void closePage(String title) {
        closePage(getTabIndexForTitle(title));
    }

    @Override
    public void closePages() {
        while (activeProject.getTabCount() > 0)
            closePage(0);
    }

    @Override
    public void closeTabAt(Point location) {
        closePage(activeProject.getUI().tabForCoordinate(activeProject, location.x, location.y));
    }

    @Override
    public void renameTab(String newName, String oldName) {
        activeProject.setTitleAt(getTabIndexForTitle(oldName), newName);
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
        if (project.equals(this.activeProject)) {
            closeProject();
            updateWindowTitle();
        }

        projects.remove(project);
    }

    /**
     * Adds components to the editor.
     */
    private void addComponents() {
        add(activeProject, BorderLayout.CENTER);
        add(toolbar, BorderLayout.WEST);
        add(properties, BorderLayout.EAST);

        validate();
        repaint();

        setProperties(new DiagramProperties());
    }

    /**
     * Removes components from the editor.
     */
    private void removeComponents() {
        StateManager.reset();
        toolbar.reset();
        removeAll();

        validate();
        repaint();
    }

    /**
     * Returns the tab index if tab with title is opened, otherwise returns -1.
     * @param title tab title
     * @return tab index if opened, otherwise -1
     */
    private int getTabIndexForTitle(String title) {
        for (int i = 0; i < activeProject.getTabCount(); ++i)
            if (activeProject.getTitleAt(i).equals(title))
                return i;

        return -1;
    }

    /**
     * Updates the title of the window.
     */
    private void updateWindowTitle() {
        MainWindow.window.setTitle("GeRuMap" + (activeProject != null ? " - " + activeProject.getProject() : ""));
    }

}
