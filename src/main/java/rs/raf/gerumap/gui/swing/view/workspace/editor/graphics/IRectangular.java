package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public interface IRectangular extends IResizable, IMovable {

    /**
     * Returns the x coordinate.
     * @return coordinate x
     */
    double getX();

    /**
     * Returns the y coordinate.
     * @return coordinate y
     */
    double getY();

    /**
     * Returns the location.
     * @return location
     */
    Point2D getLocation();

    /**
     * Returns the width.
     * @return width
     */
    double getWidth();

    /**
     * Returns the height.
     * @return height
     */
    double getHeight();

    /**
     * Returns the size.
     * @return size
     */
    Dimension2D getSize();

}
