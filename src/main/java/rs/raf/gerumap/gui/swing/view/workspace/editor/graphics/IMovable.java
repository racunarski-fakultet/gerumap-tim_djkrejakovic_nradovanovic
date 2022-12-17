package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import java.awt.geom.Point2D;

public interface IMovable {

    /**
     * Sets the x coordinate.
     * @param x coordinate x
     */
    void setX(double x);

    /**
     * Sets the x coordinate based on the scale factor.
     * @param x coordinate x
     */
    void setScaledX(double x);

    /**
     * Sets the y coordinate.
     * @param y coordinate y
     */
    void setY(double y);

    /**
     * Sets the y coordinate based on the scale factor.
     * @param y coordinate y
     */
    void setScaledY(double y);

    /**
     * Sets the location.
     * @param x coordinate x
     * @param y coordinate y
     */
    void setLocation(double x, double y);

    /**
     * Sets the location based on the scale factor.
     * @param x coordinate x
     * @param y coordinate y
     */
    void setScaledLocation(double x, double y);

    /**
     * Sets the location.
     * @param location location
     */
    void setLocation(Point2D location);

    /**
     * Sets the location based on the scale factor.
     * @param location location
     */
    void setScaledLocation(Point2D location);

    /**
     * Returns the x coordinate.
     * @return coordinate x
     */
    double getX();

    /**
     * Returns the x coordinate based on the scale factor.
     * @return coordinate x
     */
    double getScaledX();

    /**
     * Returns the y coordinate.
     * @return coordinate y
     */
    double getY();

    /**
     * Returns the y coordinate based on the scale factor.
     * @return coordinate y
     */
    double getScaledY();

    /**
     * Returns the location.
     * @return location
     */
    Point2D getLocation();

    /**
     * Returns the location based on the scale factor.
     * @return location
     */
    Point2D getScaledLocation();

}
