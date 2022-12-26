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
import java.awt.font.TextAttribute;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GraphicConcept extends RectangularGraphicElement implements IForeground, ISelectionStroke {

    private Color  foregroundColor;
    private String text;
    private Font   font;

    private Color selectionStrokeColor;
    private float selectionStrokeWidth;

    private boolean isCentral;

    public GraphicConcept(Point2D location) {
        this(location, UUID.randomUUID());
    }

    public GraphicConcept(Point2D location, UUID identifier) {
        super("Concept", identifier);

        isCentral = false;

        setLocation(location);

        setBackgroundColor(EditorValues.CONCEPT_BACKGROUND_COLOR);
        setForegroundColor(EditorValues.CONCEPT_FOREGROUND_COLOR);
        setStrokeColor(EditorValues.CONCEPT_STROKE_COLOR);
        setSelectionStrokeColor(EditorValues.CONCEPT_SELECTION_COLOR);

        setStrokeWidth(EditorValues.CONCEPT_STROKE_WIDTH);
        setSelectionStrokeWidth(EditorValues.CONCEPT_SELECTION_WIDTH);

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
        Ellipse2D conceptShape = new Ellipse2D.Double(getScaledX(), getScaledY(), getScaledWidth(), getScaledHeight());

        graphics.setColor(getBackgroundColor());
        graphics.fill(conceptShape);

        graphics.setStroke(new BasicStroke(getScaledStrokeWidth()));
        graphics.setColor(getStrokeColor());

        graphics.draw(conceptShape);
    }

    /**
     * Renders the text content.
     * @param graphics graphics
     */
    private void renderText(Graphics2D graphics) {
        if (getText().length() == 0)
            return;

        Font scaledFont = getScaledFont();

        FontMetrics fontMetrics = graphics.getFontMetrics(scaledFont);

        float stringX = (float) (getScaledX() + (getScaledWidth() - fontMetrics.stringWidth(getText())) / 2);
        float stringY = (float) (getScaledY() + ((getScaledHeight() - fontMetrics.getHeight()) / 2) + fontMetrics.getAscent());

        graphics.setFont(scaledFont);
        graphics.setColor(getForegroundColor());

        graphics.drawString(getText(), stringX, stringY);
    }

    /**
     * Renders the selection around the element.
     * @param graphics graphics
     */
    private void renderSelection(Graphics2D graphics) {
        double rectangleX = getScaledX() - ((int) (getScaledStrokeWidth()) / 2) - 1;
        double rectangleY = getScaledY() - ((int) (getScaledStrokeWidth()) / 2) - 1;

        double rectangleWidth  = getScaledWidth()  + getScaledStrokeWidth() + 2 - ((int) getScaledStrokeWidth()) % 2;
        double rectangleHeight = getScaledHeight() + getScaledStrokeWidth() + 2 - ((int) getScaledStrokeWidth()) % 2;

        Rectangle2D selectionShape = new Rectangle2D.Double(rectangleX, rectangleY, rectangleWidth, rectangleHeight);

        graphics.setStroke(new BasicStroke(getSelectionStrokeWidth()));
        graphics.setColor(getSelectionStrokeColor());

        graphics.draw(selectionShape);
    }

    @Override
    public boolean contains(GraphicElement element) {
        if (!(element instanceof GraphicConnection))
            return super.contains(element);

        return element.contains(this);
    }

    @Override
    public Shape getShapeArea() {
        configurations.saveConfigurations();
        configurations.resetConfigurations();

        double ellipseX = getX() - getStrokeWidth() / 2;
        double ellipseY = getY() - getStrokeWidth() / 2;

        double ellipseWidth  = getWidth()  + getStrokeWidth();
        double ellipseHeight = getHeight() + getStrokeWidth();

        configurations.restoreConfigurations();

        return new Ellipse2D.Double(ellipseX, ellipseY, ellipseWidth, ellipseHeight);
    }

    @Override
    public int getType() {
        return 1;
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

    /**
     * Sets a value representing whether the concept is central or not.
     * @param central is central
     */
    public void setCentral(boolean central) {
        isCentral = central;
    }

    /**
     * Returns a value representing whether the concept is central or not.
     * @return true if it is central, false otherwise
     */
    public boolean isCentral() {
        return isCentral;
    }

    //region IForeground Methods

    @Override
    public void setForegroundColor(Color color) {
        this.foregroundColor = color;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void setFont(Font font) {
        this.font = font;
    }

    @Override
    public void setScaledFont(Font font) {
        Map<TextAttribute, Object> attributes = new HashMap<>();

        attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_REGULAR);
        attributes.put(TextAttribute.SIZE, font.getSize() / configurations.getScaleFactor());

        this.font = font.deriveFont(attributes);
    }

    @Override
    public Color getForegroundColor() {
        return foregroundColor;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Font getFont() {
        return font;
    }

    @Override
    public Font getScaledFont() {
        Map<TextAttribute, Object> attributes = new HashMap<>();

        attributes.put(TextAttribute.WEIGHT, isCentral ? TextAttribute.WEIGHT_ULTRABOLD : TextAttribute.WEIGHT_BOLD);
        attributes.put(TextAttribute.SIZE, (isCentral ? 17 : 14) * configurations.getScaleFactor());

        return getFont().deriveFont(attributes);
    }

    //endregion

    //region ISelectionStroke Methods

    @Override
    public void setSelectionStrokeColor(Color color) {
        this.selectionStrokeColor = color;
    }

    @Override
    public void setSelectionStrokeWidth(float width) {
        this.selectionStrokeWidth = width;
    }

    @Override
    public void setScaledSelectedStrokeWidth(float width) {
        this.selectionStrokeWidth = (float) (width / configurations.getScaleFactor());
    }

    @Override
    public Color getSelectionStrokeColor() {
        return selectionStrokeColor;
    }

    @Override
    public float getSelectionStrokeWidth() {
        return selectionStrokeWidth;
    }

    @Override
    public float getScaledSelectedStrokeWidth() {
        return (float) (selectionStrokeWidth * configurations.getScaleFactor());
    }

    //endregion

    //region ISelectable Code

    @Override
    public int getCode() {
        return 0x100;
    }

    //endregion

}
