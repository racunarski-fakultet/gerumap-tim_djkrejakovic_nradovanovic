package rs.raf.gerumap.gui.swing.view.workspace.editor;

import com.formdev.flatlaf.FlatClientProperties;
import rs.raf.gerumap.model.Pair;
import rs.raf.gerumap.model.User;
import rs.raf.gerumap.tree.explorer.Project;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class Editor extends JTabbedPane {

    private Project project;

    private List<Pair<String, Boolean>> openedTabs = new ArrayList<>();

    private       User   author      = new User("Unregistered");
    private final JLabel authorLabel = new JLabel();

    private final JToolBar trailingTools = new JToolBar();
    private final JToolBar leadingTools  = new JToolBar();


    /**
     * Create the editor.
     */
    public Editor() {
        setup();
    }
    //region Setup

    /**
     * Setups basic editor functionalities.
     */
    private void setup() {
        setupLeadingTools();
        setupTrailingTools();

        setBorder(BorderFactory.createLineBorder(new Color(52, 53, 54), 1)); //TODO move
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        putClientProperty(FlatClientProperties.TABBED_PANE_TAB_CLOSABLE, true);
        putClientProperty(FlatClientProperties.TABBED_PANE_TAB_CLOSE_TOOLTIPTEXT, "Close" );
        putClientProperty(FlatClientProperties.TABBED_PANE_TAB_CLOSE_CALLBACK, (BiConsumer<JTabbedPane, Integer>) (tabbedPane, tabIndex) -> {
            openedTabs.get(openedTabs.indexOf(new Pair<>(tabbedPane.getTitleAt(tabIndex), true))).setSecond(false);
            removeTabAt(tabIndex);
        });
        putClientProperty(FlatClientProperties.TABBED_PANE_LEADING_COMPONENT, leadingTools.getComponentCount() > 0 ? leadingTools : null);
        putClientProperty(FlatClientProperties.TABBED_PANE_TRAILING_COMPONENT, trailingTools.getComponentCount() > 0 ? trailingTools : null);
    }

    /**
     * Setups leading tools.
     */
    private void setupLeadingTools() { }

    /**
     * Setups trailing tools.
     */
    private void setupTrailingTools() {
        authorLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        authorLabel.setText(author.getName());

        trailingTools.add(Box.createHorizontalGlue());
        trailingTools.add(authorLabel);
    }

    //endregion

    //region Load

    /**
     * Loads project documents in the editor.
     * @param documents documents
     * @param project project
     */
    public void loadProject(List<MindMapDocument> documents, Project project) {
        //Checks if the project is changing
        boolean sameProject = project.equals(this.project);

        //Saves the last selected tab
        Component lastSelected = getSelectedComponent();

        //Loads project documents
        for (MindMapDocument document : documents)
            loadDocument(document, project);

        //If project was changed, new project is marked
        if (!sameProject)
            this.project = project;

        //If the project has no documents, clear all tabs
        if (documents.size() == 0) {
            openedTabs.clear();
            removeAll();
        }

        //Sets the saved tab as selected, if the project has not been changed
        if (lastSelected != null && sameProject)
            setSelectedComponent(lastSelected);
    }

    /**
     * Loads a document in the editor.
     * @param document document
     * @param project project
     */
    public void loadDocument(MindMapDocument document, Project project) {
        //If the project is changed, clear all tabs
        if (!project.equals(this.project)) {
            this.project = project;
            openedTabs.clear();
            removeAll();
        }

        //The pairs are used to track whether the tab is opened or not
        //False is default because in case if new document has been created,
        //a tab for that document should be created
        Pair<String, Boolean> pair = new Pair<>(document.getName(), false);

        //If the pair is not in the list of open tabs, it means that the document has been
        //created and should be added to the list
        if (openedTabs.contains(pair))
            pair = openedTabs.get(openedTabs.indexOf(pair));
        else
            openedTabs.add(pair);

        //If tab for the pair is not open, a new tab is created
        if (!pair.getSecond())
            addTab(document.getName(), document.getContent());

        //Sets the open state and the tab is selected
        pair.setSecond(true);
        setSelectedIndex(getTabIndexWithTitle(document.getName()));
    }

    //endregion

    //region Add

    /**
     * Responds to the added project.
     * @param project project
     */
    public void projectAdded(Project project) {
        loadProject(List.of(), project);
    }

    /**
     * Responds to the added document.
     * @param document document
     * @param project project
     */
    public void documentAdded(MindMapDocument document, Project project) {
        if (!project.equals(this.project))
            return;

        loadDocument(document, project);
    }

    //endregion

    //region Remove

    /**
     * Responds to the removed project.
     * @param project project
     */
    public void projectRemoved(Project project) {
        if (!project.equals(this.project))
            return;

        this.project = null;
        openedTabs.clear();
        removeAll();
    }

    /**
     * Responds to the removed document.
     * @param document document
     * @param project project
     */
    public void documentRemoved(MindMapDocument document, Project project) {
        if (!project.equals(this.project))
            return;

        int openedTabIndex = openedTabs.indexOf(new Pair<>(document.getName(), true));

        if (openedTabs.get(openedTabIndex).getSecond())
            remove(getTabIndexWithTitle(document.getName()));

        openedTabs.remove(openedTabIndex);
    }

    //endregion

    //region Rename

    /**
     * Responds to the renaming of the project.
     * @param oldProject old project
     * @param newProject new project
     */
    public void projectRenamed(Project oldProject, Project newProject) {
        if (oldProject.equals(project))
            project.setName(newProject.getName());
    }

    /**
     * Responds to the renaming of the document.
     * @param oldDocument old document
     * @param newDocument new document
     * @param project project
     */
    public void documentRenamed(MindMapDocument oldDocument, MindMapDocument newDocument, Project project) {
        if (!project.equals(this.project))
            return;

        if (!openedTabs.contains(new Pair<>(oldDocument.getName(), true)))
            return;

        int openedTabIndex = openedTabs.indexOf(new Pair<>(oldDocument.getName(), true));
        openedTabs.get(openedTabIndex).setFirst(newDocument.getName());

        if (openedTabs.get(openedTabIndex).getSecond())
            setTitleAt(getTabIndexWithTitle(oldDocument.getName()), newDocument.getName());
    }

    //endregion

    /**
     * Returns the tab index if tab with title is opened, otherwise returns -1.
     * @param title tab title
     * @return tab index if opened, otherwise -1
     */
    private int getTabIndexWithTitle(String title) {
        for (int i = 0; i < getTabCount(); ++i)
            if (getTitleAt(i).equals(title))
                return i;

        return -1;
    }

    /**
     * Sets the author.
     * @param author author
     */
    public void setAuthor(User author) {
        this.author = author;

        authorLabel.setText(author.getName());
    }

    /**
     * Returns the author.
     * @return author
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Returns the project.
     * @return project
     */
    public Project getProject() {
        return project;
    }

}

