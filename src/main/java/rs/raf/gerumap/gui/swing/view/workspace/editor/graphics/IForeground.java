package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import java.awt.Color;
import java.awt.Font;

public interface IForeground {

    /**
     * Sets the text color.
     * @param color color
     */
    void setForegroundColor(Color color);

    /**
     * Sets the text content.
     * @param text text
     */
    void setText(String text);

    /**
     * Sets the font.
     * @param font font
     */
    void setFont(Font font);

    /**
     * Returns the text color.
     * @return color
     */
    Color getForegroundColor();

    /**
     * Returns the text content.
     * @return text
     */
    String getText();

    /**
     * Returns the font.
     * @return font
     */
    Font getFont();

}
