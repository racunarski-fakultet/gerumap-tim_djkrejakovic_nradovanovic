package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import java.awt.Color;

public interface ISelectionStroke {

    /**
     * Sets the selected stroke color.
     * @param color stroke color
     */
    void setSelectionStrokeColor(Color color);

    /**
     * Sets the selected stroke width.
     * @param width stroke color
     */
    void setSelectionStrokeWidth(float width);

    /**
     * Sets the selected stroke width based on the scale factor.
     * @param width stroke color
     */
    void setScaledSelectedStrokeWidth(float width);

    /**
     * Sets the selected stroke color.
     * @return stroke color
     */
    Color getSelectionStrokeColor();

    /**
     * Sets the selected stroke width.
     * @return stroke width
     */
    float getSelectionStrokeWidth();

    /**
     * Returns the selected stroke width based on the scale factor.
     * @return stroke width
     */
    float getScaledSelectedStrokeWidth();

}
