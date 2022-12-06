package rs.raf.gerumap.gui.swing.view.workspace.editor;

import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorPage;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorProject;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.IEditorComponent;
import rs.raf.gerumap.model.User;

import java.awt.Point;

public interface IEditor {

    /**
     * Loads the component into the editor.
     * @param component component
     */
    void load(IEditorComponent component);

    /**
     * Sets the page as the active page for editing.
     * @param page page
     */
    void setActivePage(EditorPage page);

    /**
     * Sets the page view.
     * @param page page
     */
    void setPageView(EditorPage page);

    /**
     * Sets the project as the active project that is being edited.
     * @param project
     */
    void setActiveProject(EditorProject project);

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
