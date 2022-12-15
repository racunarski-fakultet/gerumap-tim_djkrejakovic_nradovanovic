package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

public interface ISelectable {

    /**
     * Sets the value of whether the graphic element is selected.
     * @param selected selected
     */
    void setSelected(boolean selected);

    /**
     * Returns the value of whether the graphic element is selected.
     * @return true if selected, false otherwise
     */
    boolean isSelected();

    /**
     * Returns the identification code of the class.
     * @return code
     */
    int getCode();

}
