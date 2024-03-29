package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.Element;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.util.UUID;

public abstract class GraphicElement extends Element implements ISelectable {

    protected final GraphicConfigurations configurations = MainWindow.window.getEditor().getGraphicConfigurations();

    protected boolean selected = false;

    protected GraphicElement(String name, UUID identifier) {
        super(name, MainWindow.window.getEditor().getActivePage().getMindMap(), identifier);
    }

    //region ISelectable Methods

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    //endregion

    //region Containing Methods

    /**
     * Returns true if the graphic element contains x and y coordinates, false otherwise.
     * @param x coordinate x
     * @param y coordinate y
     * @return true if contains, false otherwise
     */
    public boolean contains(double x, double y) {
        return getShapeArea().contains(x, y);
    }
    /**
     * Returns true if the graphic element contains point coordinates, false otherwise.
     * @param point point
     * @return true if contains, false otherwise
     */
    public boolean contains(Point2D point) {
        return contains(point.getX(), point.getY());
    }

    /**
     * Returns true if the graphic element intersects another graphics element, false otherwise.
     * @param element graphic element
     * @return true if contains, false otherwise
     */
    public boolean contains(GraphicElement element) {
        if (element == null)
            return false;

        Area intersection = new Area(getShapeArea());
        intersection.intersect(new Area(element.getShapeArea()));
        return !intersection.isEmpty();
    }

    //endregion

    /**
     * Renders a graphic element within a component graphics.
     * @param graphics graphics
     */
    public abstract void render(Graphics2D graphics);

    /**
     * Updates an element based on the current location.
     * @param start start location
     * @param current current location
     */
    public abstract void update(Point2D start, Point2D current);

    /**
     * Returns the shape of the area it occupies.
     * @return shape
     */
    protected abstract Shape getShapeArea();

    /**
     * Returns the identification type of the graphic element.
     * @return type
     */
    public abstract int getType();

}
