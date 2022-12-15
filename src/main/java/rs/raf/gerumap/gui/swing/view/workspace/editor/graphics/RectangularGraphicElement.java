package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public abstract class RectangularGraphicElement extends GraphicElement implements IMovable, IResizable, IBackground, IStroke {

    protected double x;
    protected double y;

    protected double width;
    protected double height;

    protected Color backgroundColor;
    protected Color strokeColor;
    protected float strokeWidth;

    protected RectangularGraphicElement(String name) {
        super(name);
    }

    @Override
    public void update(Point2D start, Point2D current) {
        setLocation(Math.min(start.getX(), current.getX()), Math.min(start.getY(), current.getY()));
        setSize(Math.abs(start.getX() - current.getX()), Math.abs(start.getY() - current.getY()));
    }

    //region IMovable Methods

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void setLocation(double x, double y) {
        setX(x);
        setY(y);
    }

    @Override
    public void setLocation(Point2D location) {
        setLocation(location.getX(), location.getY());
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public Point2D getLocation() {
        return new Point2D.Double(getX(), getY());
    }

    //endregion

    //region IResizable Methods

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void setSize(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    @Override
    public void setSize(Dimension2D dimension) {
        setSize(dimension.getWidth(), dimension.getHeight());
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public Dimension2D getSize() {
        return new Dimension((int) getWidth(), (int) getHeight());
    }

    //endregion

    //region IBackground Methods

    @Override
    public void setBackgroundColor(Color color) {
        backgroundColor = color;
    }

    @Override
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    //endregion

    //region IStroke Methods

    @Override
    public void setStrokeColor(Color color) {
        this.strokeColor = color;
    }

    @Override
    public void setStrokeWidth(float width) {
        this.strokeWidth = width;
    }

    @Override
    public Color getStrokeColor() {
        return strokeColor;
    }

    @Override
    public float getStrokeWidth() {
        return strokeWidth;
    }

    //endregion

}
