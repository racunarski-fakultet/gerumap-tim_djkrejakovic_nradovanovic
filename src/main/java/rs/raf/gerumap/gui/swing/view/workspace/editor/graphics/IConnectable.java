package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import java.awt.geom.Point2D;

public interface IConnectable {

    /**
     * Reconnects to connector.
     */
    void reconnect();

    /**
     * Sets the x coordinate for the first connector.
     * @param x x coordinate
     */
    void setFirstX(double x);

    /**
     * Sets the y coordinate for the first connector.
     * @param y y coordinate
     */
    void setFirstY(double y);

    /**
     * Sets the location of the first connector.
     * @param x x coordinate
     * @param y y coordinate
     */
    void setFirstLocation(double x, double y);

    /**
     * Sets the location of the first connector.
     * @param location location
     */
    void setFirstLocation(Point2D location);

    /**
     * Sets the x coordinate for the second connector.
     * @param x x coordinate
     */
    void setSecondX(double x);

    /**
     * Sets the y coordinate for the second connector.
     * @param y y coordinate
     */
    void setSecondY(double y);

    /**
     * Sets the location of the second connector.
     * @param x x coordinate
     * @param y y coordinate
     */
    void setSecondLocation(double x, double y);

    /**
     * Sets the location of the second connector.
     * @param location location
     */
    void setSecondLocation(Point2D location);

    /**
     * Returns the x coordinate of the first connector.
     * @return x coordinate
     */
    double getFirstX();

    /**
     * Returns the y coordinate of the first connector.
     * @return y coordinate
     */
    double getFirstY();

    /**
     * Returns the location of the first connector.
     * @return location
     */
    Point2D getFirstLocation();

    /**
     * Returns the x coordinate of the second connector.
     * @return x coordinate
     */
    double getSecondX();

    /**
     * Returns the y coordinate of the second connector.
     * @return y coordinate
     */
    double getSecondY();

    /**
     * Returns the location of the second connector.
     * @return location
     */
    Point2D getSecondLocation();

}
