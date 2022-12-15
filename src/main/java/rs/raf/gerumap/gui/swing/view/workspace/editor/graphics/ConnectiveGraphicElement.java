package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import rs.raf.gerumap.gui.swing.view.workspace.editor.EditorValues;

import java.awt.Color;
import java.awt.geom.Point2D;

public abstract class ConnectiveGraphicElement extends GraphicElement implements IConnectable, IStroke {

    protected double firstX;
    protected double firstY;

    protected double secondX;
    protected double secondY;

    protected Color strokeColor;
    protected float strokeWidth;

    public ConnectiveGraphicElement(String name) {
        super(name);

        setStrokeColor(EditorValues.CONNECTION_STROKE_COLOR);
        setStrokeWidth(EditorValues.CONNECTION_STROKE_WIDTH);
    }

    //region IConnectable Methods

    @Override
    public void setFirstX(double firstX) {
        this.firstX = firstX;
    }

    @Override
    public void setFirstY(double firstY) {
        this.firstY = firstY;
    }

    @Override
    public void setFirstLocation(double x, double y) {
        setFirstX(x);
        setFirstY(y);
    }

    @Override
    public void setFirstLocation(Point2D location) {
        setFirstLocation(location.getX(), location.getY());
    }

    @Override
    public void setSecondX(double secondX) {
        this.secondX = secondX;
    }

    @Override
    public void setSecondY(double secondY) {
        this.secondY = secondY;
    }

    @Override
    public void setSecondLocation(double x, double y) {
        setSecondX(x);
        setSecondY(y);
    }

    @Override
    public void setSecondLocation(Point2D location) {
        setSecondLocation(location.getX(), location.getY());
    }

    @Override
    public double getFirstX() {
        return firstX;
    }

    @Override
    public double getFirstY() {
        return firstY;
    }

    @Override
    public Point2D getFirstLocation() {
        return new Point2D.Double(getFirstX(), getFirstY());
    }

    @Override
    public double getSecondX() {
        return secondX;
    }

    @Override
    public double getSecondY() {
        return secondY;
    }

    @Override
    public Point2D getSecondLocation() {
        return new Point2D.Double(getSecondX(), getSecondY());
    }

    //endregion

    //region IStroke Methods

    @Override
    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    @Override
    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
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
