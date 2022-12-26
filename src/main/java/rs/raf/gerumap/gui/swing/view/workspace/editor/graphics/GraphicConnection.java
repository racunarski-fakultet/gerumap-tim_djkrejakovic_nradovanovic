package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import rs.raf.gerumap.gui.swing.view.workspace.editor.EditorValues;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.UUID;

public class GraphicConnection extends ConnectiveGraphicElement implements ISelectionStroke {

    public GraphicConcept graphicConceptFirst;
    public GraphicConcept graphicConceptSecond;

    private Color selectionStrokeColor;
    private float selectionStrokeWidth;

    public GraphicConnection(GraphicConcept first) {
        this(first, UUID.randomUUID());
    }

    public GraphicConnection(GraphicConcept first, UUID identifier) {
        super("Connection", identifier);

        setFirst(first);

        setSelectionStrokeColor(EditorValues.CONNECTION_SELECTION_COLOR);
        setSelectionStrokeWidth(EditorValues.CONNECTION_SELECTION_WIDTH);
    }

    @Override
    public void render(Graphics2D graphics) {
        if (getFirst().equals(getSecond()))
            return;

        Point2D firstPoint = calculateFirstPoint();
        Point2D secondPoint = calculateSecondPoint();

        Line2D connectionShape = new Line2D.Double(firstPoint.getX(), firstPoint.getY(), secondPoint.getX(), secondPoint.getY());

        graphics.setColor(getStrokeColor());
        graphics.setStroke(new BasicStroke(getScaledStrokeWidth()));

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

        double ratio = (getScaledSecondX() - getScaledFirstX()) / (getScaledSecondY() - getScaledFirstY());
        int sign = getScaledSecondY() - getScaledFirstY() > 0 ? 1 : - 1;

        double conceptWidth  = concept.getScaledWidth()  + concept.getScaledStrokeWidth() / 2;
        double conceptHeight = concept.getScaledHeight() + concept.getScaledStrokeWidth() / 2;

        double majorVertex = conceptWidth  / 2;
        double minorVertex = conceptHeight / 2;

        double minorPoint = sign * majorVertex * minorVertex / (Math.sqrt(majorVertex * majorVertex + minorVertex * minorVertex * ratio * ratio));
        double majorPoint = ratio * minorPoint;

        double conceptMajorPoint = getScaledFirstX() + majorPoint;
        double conceptMinorPoint = getScaledFirstY() + minorPoint;

        return new Point2D.Double(conceptMajorPoint, conceptMinorPoint);
    }

    /**
     * Calculates the second point based on the position of the connected concept connectors.
     * @return location
     */
    private Point2D calculateSecondPoint() {
        GraphicConcept concept = getSecond();

        if (concept == null)
            return new Point2D.Double(getScaledSecondX(), getScaledSecondY());

        double ratio = (getScaledSecondX() - getScaledFirstX()) / (getScaledSecondY() - getScaledFirstY());
        int sign = getScaledFirstY() - getScaledSecondY() > 0 ? 1 : - 1;

        double conceptWidth  = concept.getScaledWidth()  + concept.getScaledStrokeWidth() / 2;
        double conceptHeight = concept.getScaledHeight() + concept.getScaledStrokeWidth() / 2;

        double majorVertex = conceptWidth  / 2;
        double minorVertex = conceptHeight / 2;

        double minorPoint = sign * majorVertex * minorVertex / (Math.sqrt(majorVertex * majorVertex + minorVertex * minorVertex * ratio * ratio));
        double majorPoint = ratio * minorPoint;

        double conceptMajorPoint = getScaledSecondX() + majorPoint;
        double conceptMinorPoint = getScaledSecondY() + minorPoint;

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

        double verticalX = height * (getScaledStrokeWidth()) / (2 * length);
        double verticalY = width  * (getScaledStrokeWidth()) / (2 * length);

        double rectangleX = Math.min(point1.getX(), point2.getX()) - verticalX;
        double rectangleY = Math.min(point1.getY(), point2.getY()) - verticalY;

        double rectangleWidth  = width + 2 * verticalX;
        double rectangleHeight = height + 2 * verticalY;

        Rectangle2D selectionShape = new Rectangle2D.Double(rectangleX, rectangleY, rectangleWidth, rectangleHeight);

        graphics.setStroke(new BasicStroke(getSelectionStrokeWidth()));
        graphics.setColor(getSelectionStrokeColor());

        graphics.draw(selectionShape);
    }

    @Override
    public boolean contains(GraphicElement element) {
        boolean isFirst  = getFirst().getIdentifier().equals(element.getIdentifier());
        boolean isSecond = getSecond().getIdentifier().equals(element.getIdentifier());

        return super.contains(element) && !(isFirst || isSecond);
    }

    @Override
    public void update(Point2D startLocation, Point2D mouseLocation) {
        setSecondX(mouseLocation.getX());
        setSecondY(mouseLocation.getY());
    }

    @Override
    public Shape getShapeArea() {
        configurations.saveConfigurations();
        configurations.resetConfigurations();

        Point2D startLocation = calculateFirstPoint();
        Point2D endLocation = calculateSecondPoint();

        double width  = endLocation.getX() + startLocation.getX();
        double height = endLocation.getY() + startLocation.getY();

        double length = Math.sqrt(width * width + height * height);

        double verticalX = - height * (getStrokeWidth() + 1) / (2 * length);
        double verticalY =   width  * (getStrokeWidth() + 1) / (2 * length);

        Path2D path = new Path2D.Double();

        path.moveTo(startLocation.getX() + verticalX, startLocation.getY() + verticalY);
        path.lineTo(endLocation.getX()   + verticalX, endLocation.getY()   + verticalY);
        path.lineTo(endLocation.getX()   - verticalX, endLocation.getY()   - verticalY);
        path.lineTo(startLocation.getX() - verticalX, startLocation.getY() - verticalY);
        path.closePath();

        configurations.restoreConfigurations();

        return path;
    }

    @Override
    public int getType() {
        return 2;
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

    //region ISelectionStroke Methods

    @Override
    public void setSelectionStrokeColor(Color color) {
        this.selectionStrokeColor = color;
    }

    @Override
    public void setSelectionStrokeWidth(float width) {
        this.selectionStrokeWidth = width;
    }

    @Override
    public void setScaledSelectedStrokeWidth(float width) {
        this.selectionStrokeWidth = (float) (width / configurations.getScaleFactor());
    }

    @Override
    public Color getSelectionStrokeColor() {
        return selectionStrokeColor;
    }

    @Override
    public float getSelectionStrokeWidth() {
        return selectionStrokeWidth;
    }

    @Override
    public float getScaledSelectedStrokeWidth() {
        return (float) (selectionStrokeWidth * configurations.getScaleFactor());
    }

    //endregion

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
