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
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

public class Editor extends JTabbedPane {

    private Project project;

    private List<Pair<String, Boolean>> openedTabs = new ArrayList<>();

    private       User   author      = new User("Unregistered");
    private final JLabel authorLabel = new JLabel();

    private final JToolBar trailingTools = new JToolBar();
    private final JToolBar leadingTools  = new JToolBar();


    public Editor() {
        setup();
    }
    //region Setup

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

    private void setupLeadingTools() { }

    private void setupTrailingTools() {
        authorLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        authorLabel.setText(author.getName());

        trailingTools.add(Box.createHorizontalGlue());
        trailingTools.add(authorLabel);
    }

    //endregion

    //region Load

    public void loadProject(List<MindMapDocument> documents, Project project) {
        boolean sameProject = project.equals(this.project);

        Component lastSelected = getSelectedComponent();

        for (MindMapDocument document : documents)
            loadDocument(document, project);

        if (!sameProject)
            this.project = project;

        if (documents.size() == 0) {
            openedTabs.clear();
            removeAll();
        }

        if (lastSelected != null && sameProject)
            setSelectedComponent(lastSelected);
    }

    public void loadDocument(MindMapDocument document, Project project) {
        if (!project.equals(this.project)) {
            this.project = project;
            openedTabs.clear();
            removeAll();
        }

        Pair<String, Boolean> pair = new Pair<>(document.getName(), false);

        if (openedTabs.contains(pair))
            pair = openedTabs.get(openedTabs.indexOf(pair));
        else
            openedTabs.add(pair);

        if (!pair.getSecond())
            addTab(document.getName(), document.getContent());

        pair.setSecond(true);
        setSelectedIndex(getTabIndexWithTitle(document.getName()));
    }

    //endregion

    //region Add

    public void projectAdded(Project project) {
        loadProject(List.of(), project);
    }

    public void documentAdded(MindMapDocument document, Project project) {
        if (!project.equals(this.project))
            return;

        loadDocument(document, project);
    }

    //endregion

    //region Remove

    public void projectRemoved(Project project) {
        if (!project.equals(this.project))
            return;

        this.project = null;
        openedTabs.clear();
        removeAll();
    }

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

    public void projectRenamed(Project oldProject, Project newProject) {
        if (oldProject.equals(project))
            project.setName(newProject.getName());
    }

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

    private int getTabIndexWithTitle(String title) {
        for (int i = 0; i < getTabCount(); ++i)
            if (getTitleAt(i).equals(title))
                return i;

        return -1;
    }


    public void setAuthor(User author) {
        this.author = author;

        authorLabel.setText(author.getName());
    }

    public User getAuthor() {
        return author;
    }

    public Project getProject() {
        return project;
    }

}

