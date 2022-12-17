package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.EditorValues;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorElement;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.List;

public class GraphicSelection extends RectangularGraphicElement {

    public GraphicSelection(Point2D location) {
        super("Selection");

        setLocation(location);

        setBackgroundColor(EditorValues.SELECTION_BACKGROUND_COLOR);
        setStrokeColor(EditorValues.SELECTION_STROKE_COLOR);
        setStrokeWidth(EditorValues.SELECTION_STROKE_WIDTH);
    }

    @Override
    public void render(Graphics2D graphics) {
        Rectangle2D conceptShape = new Rectangle2D.Double(getScaledX(), getScaledY(), getScaledWidth(), getScaledHeight());

        graphics.setColor(getBackgroundColor());
        graphics.fill(conceptShape);

        graphics.setColor(getStrokeColor());
        graphics.setStroke(new BasicStroke(getStrokeWidth()));

        graphics.draw(conceptShape);
    }

    @Override
    public void update(Point2D startLocation, Point2D mouseLocation) {
        super.update(startLocation, mouseLocation);

        List<GraphicElement> graphicElements = new LinkedList<>();

        for (EditorElement editorElement : MainWindow.window.getEditor().getActivePage().getEditorElements())
            if (contains(editorElement.getGraphicElement()))
                graphicElements.add(editorElement.getGraphicElement());

        if (graphicElements.size() == SelectionManager.size())
            return;

        if (graphicElements.size() < SelectionManager.size())
            SelectionManager.clear();

        for (GraphicElement graphicElement : graphicElements)
            SelectionManager.addSelection(graphicElement);
    }

    @Override
    public Shape getShapeArea() {
        configurations.saveConfigurations();
        configurations.resetConfigurations();

        double rectangleX = getX() - getStrokeWidth() / 2;
        double rectangleY = getY() - getStrokeWidth() / 2;

        double rectangleWidth  = getWidth()  + getStrokeWidth();
        double rectangleHeight = getHeight() + getStrokeWidth();

        configurations.restoreConfigurations();

        return new Rectangle2D.Double(rectangleX, rectangleY, rectangleWidth, rectangleHeight);
    }

    @Override
    public int getCode() {
        return 0x0;
    }

}
