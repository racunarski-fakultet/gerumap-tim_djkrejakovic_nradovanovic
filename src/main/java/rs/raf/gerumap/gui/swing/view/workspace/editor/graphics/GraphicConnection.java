package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import rs.raf.gerumap.gui.swing.view.workspace.editor.EditorValues;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class GraphicConnection extends ConnectiveGraphicElement {

    private static int counter = 0;

    public GraphicConcept graphicConceptFirst;
    public GraphicConcept graphicConceptSecond;

    public GraphicConnection(GraphicConcept first) {
        super("Connection " + ++counter);

        setFirst(first);
    }

    @Override
    public void render(Graphics2D graphics) {
        Point2D firstPoint = calculateFirstPoint();
        Point2D secondPoint = calculateSecondPoint();

        Line2D connectionShape = new Line2D.Double(firstPoint.getX(), firstPoint.getY(), secondPoint.getX(), secondPoint.getY());

        graphics.setColor(strokeColor);
        graphics.setStroke(new BasicStroke(strokeWidth));

        graphics.draw(connectionShape);

        if (selected)
            renderSelection(graphics);

    }

    /**
     * Calculates the first point based on the position of the connected concept connectors.
     * @return location
     */
    private Point2D calculateFirstPoint() {
        GraphicConcept concept = getFirst();

        double ratio = (getSecondX() - getFirstX()) / (getSecondY() - getFirstY());
        int sign = getSecondY() - getFirstY() > 0 ? 1 : - 1;

        double conceptWidth  = concept.getWidth()  + concept.getStrokeWidth() / 2;
        double conceptHeight = concept.getHeight() + concept.getStrokeWidth() / 2;

        double majorVertex = conceptWidth  / 2;
        double minorVertex = conceptHeight / 2;

        double minorPoint = sign * majorVertex * minorVertex / (Math.sqrt(majorVertex * majorVertex + minorVertex * minorVertex * ratio * ratio));
        double majorPoint = ratio * minorPoint;

        double conceptMajorPoint = getFirstX() + majorPoint;
        double conceptMinorPoint = getFirstY() + minorPoint;

        return new Point2D.Double(conceptMajorPoint, conceptMinorPoint);
    }

    /**
     * Calculates the second point based on the position of the connected concept connectors.
     * @return location
     */
    private Point2D calculateSecondPoint() {
        GraphicConcept concept = getSecond();

        if (concept == null)
            return new Point2D.Double(getSecondX(), getSecondY());

        double ratio = (getSecondX() - getFirstX()) / (getSecondY() - getFirstY());
        int sign = getFirstY() - getSecondY() > 0 ? 1 : - 1;

        double conceptWidth  = concept.getWidth()  + concept.getStrokeWidth() / 2;
        double conceptHeight = concept.getHeight() + concept.getStrokeWidth() / 2;

        double majorVertex = conceptWidth  / 2;
        double minorVertex = conceptHeight / 2;

        double minorPoint = sign * majorVertex * minorVertex / (Math.sqrt(majorVertex * majorVertex + minorVertex * minorVertex * ratio * ratio));
        double majorPoint = ratio * minorPoint;

        double conceptMajorPoint = getSecondX() + majorPoint;
        double conceptMinorPoint = getSecondY() + minorPoint;

        return new Point2D.Double(conceptMajorPoint, conceptMinorPoint);
    }

    /**
     * Renders the selection around the element.
     * @param graphics graphics
     */
    private void renderSelection(Graphics2D graphics) {
        Point2D point1 = calculateFirstPoint();
        Point2D point2 = calculateSecondPoint();

        double width  = Math.abs(point2.getX() - point1.getX());
        double height = Math.abs(point2.getY() - point1.getY());

        double length = Math.sqrt(width * width + height * height);

        double verticalX = height * (strokeWidth) / (2 * length);
        double verticalY = width  * (strokeWidth) / (2 * length);

        double rectangleX = Math.min(point1.getX(), point2.getX()) - verticalX;
        double rectangleY = Math.min(point1.getY(), point2.getY()) - verticalY;

        double rectangleWidth  = width + 2 * verticalX;
        double rectangleHeight = height + 2 * verticalY;

        Rectangle2D selectionShape = new Rectangle2D.Double(rectangleX, rectangleY, rectangleWidth, rectangleHeight);

        graphics.setStroke(new BasicStroke(EditorValues.SELECTION_STROKE_WIDTH));
        graphics.setColor(EditorValues.SELECTION_STROKE_COLOR);

        graphics.draw(selectionShape);
    }

    @Override
    public boolean contains(GraphicElement element) {
        return super.contains(element) && !(getFirst().equals(element) || getSecond().equals(element));
    }

    @Override
    public void update(Point2D startLocation, Point2D mouseLocation) {
        setSecondX(mouseLocation.getX());
        setSecondY(mouseLocation.getY());
    }

    @Override
    public Shape getShapeArea() {
        Point2D startLocation = calculateFirstPoint();
        Point2D endLocation = calculateSecondPoint();

        double width  = endLocation.getX() + startLocation.getX();
        double height = endLocation.getY() + startLocation.getY();

        double length = Math.sqrt(width * width + height * height);

        double verticalX = - height * (strokeWidth + 1) / (2 * length);
        double verticalY =   width  * (strokeWidth + 1) / (2 * length);

        Path2D path = new Path2D.Double();

        path.moveTo(startLocation.getX() + verticalX, startLocation.getY() + verticalY);
        path.lineTo(endLocation.getX()   + verticalX, endLocation.getY()   + verticalY);
        path.lineTo(endLocation.getX()   - verticalX, endLocation.getY()   - verticalY);
        path.lineTo(startLocation.getX() - verticalX, startLocation.getY() - verticalY);
        path.closePath();

        return path;
    }

    /**
     * Sets the first concept connector.
     * @param concept concept
     */
    public void setFirst(GraphicConcept concept) {
        if (concept != null) {
            setFirstX(concept.getX() + concept.getWidth() / 2);
            setFirstY(concept.getY() + concept.getHeight() / 2);
        }

        this.graphicConceptFirst = concept;
    }

    /**
     * Sets the second concept connector.
     * @param concept concept
     */
    public void setSecond(GraphicConcept concept) {
        if (concept != null) {
            setSecondX(concept.getX() + concept.getWidth() / 2);
            setSecondY(concept.getY() + concept.getHeight() / 2);
        }

        this.graphicConceptSecond = concept;
    }

    /**
     * Returns the first concept connector.
     * @return graphic concept
     */
    public GraphicConcept getFirst() {
        return graphicConceptFirst;
    }

    /**
     * Returns the second concept connector.
     * @return graphic concept
     */
    public GraphicConcept getSecond() {
        return graphicConceptSecond;
    }

    //region ISelectable code

    @Override
    public int getCode() {
        return 0x10;
    }

    //endregion

    //region IConnectable Methods

    @Override
    public void reconnect() {
        setFirst(getFirst());
        setSecond(getSecond());
    }

    //endregion

}
