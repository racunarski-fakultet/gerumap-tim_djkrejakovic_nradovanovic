package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.EditorValues;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorElement;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class GraphicConcept extends RectangularGraphicElement {

    private static int counter = 0;

    private Color  foregroundColor;
    private String text;
    private Font   font;

    public GraphicConcept(Point2D location) {
        super("Concept " + ++counter);

        setLocation(location);

        setBackgroundColor(EditorValues.CONCEPT_BACKGROUND_COLOR);
        setForegroundColor(EditorValues.CONCEPT_FOREGROUND_COLOR);
        setStrokeColor(EditorValues.CONCEPT_STROKE_COLOR);
        setStrokeWidth(EditorValues.CONCEPT_STROKE_WIDTH);

        setText(EditorValues.CONCEPT_TEXT_CONTENT);
        setFont(EditorValues.CONCEPT_TEXT_FONT);
    }

    @Override
    public void render(Graphics2D graphics) {
        renderShape(graphics);
        renderText(graphics);

        if (selected)
            renderSelection(graphics);
    }

    /**
     * Renders a shape.
     * @param graphics graphics
     */
    private void renderShape(Graphics2D graphics) {
        Ellipse2D conceptShape = new Ellipse2D.Double(x, y, width, height);

        graphics.setColor(backgroundColor);
        graphics.fill(conceptShape);

        graphics.setStroke(new BasicStroke(strokeWidth));
        graphics.setColor(strokeColor);

        graphics.draw(conceptShape);
    }

    /**
     * Renders the text content.
     * @param graphics graphics
     */
    private void renderText(Graphics2D graphics) {
        if (text.length() == 0)
            return;

        FontMetrics fontMetrics = graphics.getFontMetrics(font);

        float stringX = (float) (x + (width - fontMetrics.stringWidth(text)) / 2);
        float stringY = (float) (y + ((height - fontMetrics.getHeight()) / 2) + fontMetrics.getAscent());

        graphics.setFont(font);
        graphics.setColor(foregroundColor);

        graphics.drawString(text, stringX, stringY);
    }

    /**
     * Renders the selection around the element.
     * @param graphics graphics
     */
    private void renderSelection(Graphics2D graphics) {
        double displacement = (strokeWidth + 1) % 2;

        double rectangleX = this.x - strokeWidth / 2 - displacement;
        double rectangleY = this.y - strokeWidth / 2 - displacement;

        double rectangleWidth  = width + strokeWidth + 1 + displacement;
        double rectangleHeight = height + strokeWidth + 1 + displacement;

        Rectangle2D selectionShape = new Rectangle2D.Double(rectangleX, rectangleY, rectangleWidth, rectangleHeight);

        graphics.setStroke(new BasicStroke(EditorValues.SELECTION_STROKE_WIDTH));
        graphics.setColor(EditorValues.SELECTION_STROKE_COLOR);

        graphics.draw(selectionShape);
    }

    /**
     * Returns whether the creation of the concept is discarded.
     * @return true if discarded, false otherwise
     */
    public boolean isDiscarded() {
        return isIntersected();
    }

    private boolean isIntersected() {
        for (EditorElement editorElement : MainWindow.window.getEditor().getActivePage().getEditorElements())
            if (contains(editorElement.getGraphicElement()))
                return true;

        return false;
    }

    @Override
    public Shape getShapeArea() {
        double ellipseX = this.x - strokeWidth / 2;
        double ellipseY = this.y - strokeWidth / 2;

        double ellipseWidth  = width + strokeWidth;
        double ellipseHeight = height + strokeWidth;

        return new Ellipse2D.Double(ellipseX, ellipseY, ellipseWidth, ellipseHeight);
    }

    //region Setters and Getters

    /**
     * Sets the text color.
     * @param color color
     */
    public void setForegroundColor(Color color) {
        this.foregroundColor = color;
    }

    /**
     * Sets the text content.
     * @param text text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Sets the font.
     * @param font font
     */
    public void setFont(Font font) {
        this.font = font;
    }

    /**
     * Returns the text color.
     * @return color
     */
    public Color getForegroundColor() {
        return foregroundColor;
    }

    /**
     * Returns the text content.
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Returns the font.
     * @return font
     */
    public Font getFont() {
        return font;
    }

    //endregion

}
