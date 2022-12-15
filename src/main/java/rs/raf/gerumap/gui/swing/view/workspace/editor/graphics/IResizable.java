package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import java.awt.geom.Dimension2D;

public interface IResizable {

    /**
     * Sets the width.
     * @param width width
     */
    void setWidth(double width);

    /**
     * Sets the height.
     * @param height height
     */
    void setHeight(double height);

    /**
     * Sets the size.
     * @param width width
     * @param height height
     */
    void setSize(double width, double height);

    /**
     * Sets the size.
     * @param dimension size
     */
    void setSize(Dimension2D dimension);

}
