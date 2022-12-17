package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import java.awt.geom.Dimension2D;

public interface IResizable {

    /**
     * Sets the width.
     * @param width width
     */
    void setWidth(double width);


    /**
     * Sets the width based on the scale factor.
     * @param width width
     */
    void setScaledWidth(double width);

    /**
     * Sets the height.
     * @param height height
     */
    void setHeight(double height);

    /**
     * Sets the height based on the scale factor.
     * @param height height
     */
    void setScaledHeight(double height);

    /**
     * Sets the size.
     * @param width width
     * @param height height
     */
    void setSize(double width, double height);

    /**
     * Sets the size based on the scale factor.
     * @param width width
     * @param height height
     */
    void setScaledSize(double width, double height);

    /**
     * Sets the size.
     * @param dimension size
     */
    void setSize(Dimension2D dimension);

    /**
     * Sets the size based on the scale factor.
     * @param dimension size
     */
    void setScaledSize(Dimension2D dimension);

    /**
     * Returns the width.
     * @return width
     */
    double getWidth();

    /**
     * Returns the width based on the scale factor.
     * @return width
     */
    double getScaledWidth();

    /**
     * Returns the height.
     * @return height
     */
    double getHeight();

    /**
     * Returns the height based on the scale factor.
     * @return height
     */
    double getScaledHeight();

    /**
     * Returns the size.
     * @return size
     */
    Dimension2D getSize();

    /**
     * Returns the size based on the scale factor.
     * @return size
     */
    Dimension2D getScaledSize();

}
