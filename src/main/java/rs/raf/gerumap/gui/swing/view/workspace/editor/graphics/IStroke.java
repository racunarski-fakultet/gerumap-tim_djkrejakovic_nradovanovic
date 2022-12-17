package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import java.awt.Color;

public interface IStroke {

    /**
     * Sets the stroke color.
     * @param color stroke color
     */
    void setStrokeColor(Color color);

    /**
     * Sets the stroke width.
     * @param width width
     */
    void setStrokeWidth(float width);

    /**
     * Sets the stroke width based on the scale factor.
     * @param width width
     */
    void setScaledStrokeWidth(float width);

    /**
     * Returns the stroke color.
     * @return stroke color
     */
    Color getStrokeColor();

    /**
     * Returns the stroke width.
     * @return stroke width
     */
    float getStrokeWidth();

    /**
     * Returns the stroke width based on the scale factor.
     * @return stroke width
     */
    float getScaledStrokeWidth();

}
