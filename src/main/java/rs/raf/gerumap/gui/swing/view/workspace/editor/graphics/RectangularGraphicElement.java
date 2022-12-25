package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.UUID;

public abstract class RectangularGraphicElement extends GraphicElement implements IMovable, IResizable, IBackground, IStroke {

    protected double x;
    protected double y;

    protected double width;
    protected double height;

    protected Color backgroundColor;
    protected Color strokeColor;
    protected float strokeWidth;

    protected RectangularGraphicElement(String name, UUID identifier) {
        super(name, identifier);
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
    public void setScaledX(double x) {
        this.x = x / configurations.getScaleFactor();
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void setScaledY(double y) {
        this.y = y / configurations.getScaleFactor();
    }

    @Override
    public void setLocation(double x, double y) {
        setX(x);
        setY(y);
    }

    @Override
    public void setScaledLocation(double x, double y) {
        setScaledX(x);
        setScaledY(y);
    }

    @Override
    public void setLocation(Point2D location) {
        setLocation(location.getX(), location.getY());
    }

    @Override
    public void setScaledLocation(Point2D location) {
        setScaledLocation(location.getX(), location.getY());
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getScaledX() {
        return x * configurations.getScaleFactor();
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getScaledY() {
        return y * configurations.getScaleFactor();
    }

    @Override
    public Point2D getLocation() {
        return new Point2D.Double(getX(), getY());
    }

    @Override
    public Point2D getScaledLocation() {
        return new Point2D.Double(getScaledX(), getScaledY());
    }

    //endregion

    //region IResizable Methods

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void setScaledWidth(double width) {
        this.width = width / configurations.getScaleFactor();
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void setScaledHeight(double height) {
        this.height = height / configurations.getScaleFactor();
    }

    @Override
    public void setSize(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    @Override
    public void setScaledSize(double width, double height) {
        setScaledWidth(width);
        setScaledHeight(height);
    }

    @Override
    public void setSize(Dimension2D dimension) {
        setSize(dimension.getWidth(), dimension.getHeight());
    }

    @Override
    public void setScaledSize(Dimension2D dimension) {
        setScaledSize(dimension.getWidth(), dimension.getHeight());
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getScaledWidth() {
        return width * configurations.getScaleFactor();
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getScaledHeight() {
        return height * configurations.getScaleFactor();
    }

    @Override
    public Dimension2D getSize() {
        return new Dimension((int) getWidth(), (int) getHeight());
    }

    @Override
    public Dimension2D getScaledSize() {
        return new Dimension((int) getScaledWidth(), (int) getScaledHeight());
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
    public void setScaledStrokeWidth(float width) {
        this.strokeWidth = (float) (width / configurations.getScaleFactor());
    }

    @Override
    public Color getStrokeColor() {
        return strokeColor;
    }

    @Override
    public float getStrokeWidth() {
        return strokeWidth;
    }

    @Override
    public float getScaledStrokeWidth() {
        return (float) (strokeWidth * configurations.getScaleFactor());
    }

    //endregion

}
