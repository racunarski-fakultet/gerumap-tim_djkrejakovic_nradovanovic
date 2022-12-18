package rs.raf.gerumap.gui.swing.view.custom;

import rs.raf.gerumap.gui.swing.view.workspace.editor.EditorValues;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class GRMapColorButton extends JButton {

    private Color backgroundColor;
    private Color crossedLineColor;

    private Insets crossedLineInsets;

    public GRMapColorButton() {
        setColor(new Color(246, 202, 204));
        setBorderColor(new Color(97, 99, 101));
        setCrossedLineColor(new Color(208, 34, 36));
        setCrossedInsets(new Insets(3, 3, 4, 4));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        Rectangle2D rectangleBackground = new Rectangle2D.Double(0, 0, getWidth(), getHeight());

        graphics2D.setColor(backgroundColor != null ? backgroundColor : new Color(255, 255, 255));
        graphics2D.fill(rectangleBackground);

        if (backgroundColor != null)
            return;

        Line2D lineCrossed = new Line2D.Double(crossedLineInsets.left,               crossedLineInsets.top,
                                               getWidth() - crossedLineInsets.right, getHeight() - crossedLineInsets.bottom);

        graphics2D.setColor(crossedLineColor);
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.draw(lineCrossed);
    }

    /**
     * Sets the color that this button represents, which is also its background color.
     * @param color color
     */
    public void setColor(Color color) {
        backgroundColor = color;
        repaint();
    }

    /**
     * Sets the crossed line color that is displayed when the color this button represents is unknown.
     * @param color line color
     */
    public void setCrossedLineColor(Color color) {
        crossedLineColor = color;
        repaint();
    }

    /**
     * Sets the border color around the button with a width of 1.
     * @param color border color
     */
    public void setBorderColor(Color color) {
        setBorder(BorderFactory.createLineBorder(color));
        repaint();
    }

    /**
     * Sets the crossed line insets.
     * @param insets insets
     */
    public void setCrossedInsets(Insets insets) {
        crossedLineInsets = insets;
        repaint();
    }

    /**
     * Returns the color that this button represents
     * @return color
     */
    public Color getColor() {
        return backgroundColor != null ? backgroundColor : EditorValues.CONCEPT_BACKGROUND_COLOR;
    }

}
