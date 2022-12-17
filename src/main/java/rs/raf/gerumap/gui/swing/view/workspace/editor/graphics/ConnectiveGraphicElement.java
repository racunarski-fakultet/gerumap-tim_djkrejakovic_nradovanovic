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
    public void setFirstX(double x) {
        this.firstX = x;
    }

    @Override
    public void setScaledFirstX(double x) {
        this.firstX = x / configurations.getScaleFactor();
    }

    @Override
    public void setFirstY(double y) {
        this.firstY = y;
    }

    @Override
    public void setScaledFirstY(double y) {
        this.firstY = y / configurations.getScaleFactor();
    }

    @Override
    public void setFirstLocation(double x, double y) {
        setFirstX(x);
        setFirstY(y);
    }

    @Override
    public void setScaledFirstLocation(double x, double y) {
        setScaledFirstX(x);
        setScaledFirstY(y);
    }

    @Override
    public void setFirstLocation(Point2D location) {
        setFirstLocation(location.getX(), location.getY());
    }

    @Override
    public void setScaledFirstLocation(Point2D location) {
        setScaledFirstLocation(location.getX(), location.getY());
    }

    @Override
    public void setSecondX(double x) {
        this.secondX = x;
    }

    @Override
    public void setScaledSecondX(double x) {
        this.secondX = x / configurations.getScaleFactor();
    }

    @Override
    public void setSecondY(double y) {
        this.secondY = y;
    }

    @Override
    public void setScaledSecondY(double y) {
        this.secondY = y / configurations.getScaleFactor();
    }

    @Override
    public void setSecondLocation(double x, double y) {
        setSecondX(x);
        setSecondY(y);
    }

    @Override
    public void setScaledSecondLocation(double x, double y) {
        setScaledSecondX(x);
        setScaledSecondY(y);
    }

    @Override
    public void setSecondLocation(Point2D location) {
        setSecondLocation(location.getX(), location.getY());
    }

    @Override
    public void setScaledSecondLocation(Point2D location) {
        setScaledSecondLocation(location.getX(), location.getY());
    }

    @Override
    public double getFirstX() {
        return firstX;
    }

    @Override
    public double getScaledFirstX() {
        return firstX * configurations.getScaleFactor();
    }

    @Override
    public double getFirstY() {
        return firstY;
    }

    @Override
    public double getScaledFirstY() {
        return firstY * configurations.getScaleFactor();
    }

    @Override
    public Point2D getFirstLocation() {
        return new Point2D.Double(getFirstX(), getFirstY());
    }

    @Override
    public Point2D getScaledFirstLocation() {
        return new Point2D.Double(getScaledFirstX(), getScaledFirstY());
    }

    @Override
    public double getSecondX() {
        return secondX;
    }

    @Override
    public double getScaledSecondX() {
        return secondX * configurations.getScaleFactor();
    }

    @Override
    public double getSecondY() {
        return secondY;
    }

    @Override
    public double getScaledSecondY() {
        return secondY * configurations.getScaleFactor();
    }

    @Override
    public Point2D getSecondLocation() {
        return new Point2D.Double(getSecondX(), getSecondY());
    }

    @Override
    public Point2D getScaledSecondLocation() {
        return new Point2D.Double(getScaledSecondX(), getScaledSecondY());
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
    public void setScaledStrokeWidth(float width) {
        this.strokeWidth = (float) (strokeWidth / configurations.getScaleFactor());
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
