package rs.raf.gerumap.gui.swing.view.workspace.editor;

import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorDiagram;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorPage;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorProject;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.IEditorComponent;
import rs.raf.gerumap.gui.swing.view.user.model.User;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.properties.PropertiesBase;

import java.awt.Point;

public interface IEditor {

    /**
     * Loads the component into the editor.
     * @param component component
     */
    void load(IEditorComponent component);

    /**
     * Renders a diagram of the page.
     */
    void render();

    /**
     * Sets the properties tab.
     * @param properties properties
     */
    void setProperties(PropertiesBase properties);

    /**
     * Sets the page as the active page for editing.
     * @param activePage page
     */
    void setActivePage(EditorPage activePage);

    /**
     * Sets the project as the active project that is being edited.
     * @param activeProject project
     */
    void setActiveProject(EditorProject activeProject);

    /**
     * Sets the author of the project.
     * @param author author
     */
    void setAuthor(User author);

    /**
     * Updates the active page. it should be called whenever there is a change to the tab, which includes adding, selecting and removing.
     */
    void updateActivePage();

    /**
     * Updates the active page size of the container.
     */
    void updatePageDimension();

    /**
     * Returns the active page.
     * @return page
     */
    EditorPage getActivePage();

    /**
     * Returns the active project.
     * @return project
     */
    EditorProject getActiveProject();

    /**
     * Returns the author of the project
     * @return author
     */
    User getAuthor();

    /**
     * Opens the page in editor view.
     * @param page page
     */
    void openPage(EditorPage page);

    /**
     * Returns the open page at the index.
     * @param index index
     * @return page
     */
    EditorPage getOpenPage(int index);

    /**
     * Returns the open page with the title.
     * @param title title
     * @return page
     */
    EditorPage getOpenPage(String title);

    /**
     * Returns a diagram of the active page.
     * @return diagram
     */
    EditorDiagram getDiagram();

    /**
     * Closes the open page at the index.
     * @param index index
     */
    void closePage(int index);

    /**
     * Closes the open page with the title.
     * @param title title
     */
    void closePage(String title);

    /**
     * Closes all open pages.
     */
    void closePages();

    /**
     * Closes the page that corresponds to the tab at the location.
     * @param location location
     */
    void closeTabAt(Point location);

    /**
     * Renames a tab.
     * @param newName new name
     * @param oldName old name
     */
    void renameTab(String newName, String oldName);

    /**
     * Closes the active project.
     */
    void closeProject();

}
