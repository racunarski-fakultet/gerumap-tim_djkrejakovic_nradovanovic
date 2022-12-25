package rs.raf.gerumap.gui.swing.view.workspace.editor.view;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.EditorValues;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorDiagramStateMouseListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorDiagramStateMouseMotionListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorDiagramStatusMouseMotionListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorFocusMouseListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConfigurations;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConnection;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.IConnectable;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class EditorDiagram extends JPanel {

    private static final IEditor editor = MainWindow.window.getEditor();

    private final GraphicConfigurations configurations = new GraphicConfigurations();

    private int width;

    private int height;

    private GraphicElement graphicElement = null;

    public EditorDiagram() {
        setPreferredSize(EditorValues.DIAGRAM_DIMENSION);
        setBackground(EditorValues.DIAGRAM_BACKGROUND_COLOR);

        width = EditorValues.DIAGRAM_DIMENSION.width;
        height = EditorValues.DIAGRAM_DIMENSION.height;

        addMouseListener(new EditorFocusMouseListener());
        addMouseListener(new EditorDiagramStateMouseListener());
        addMouseMotionListener(new EditorDiagramStateMouseMotionListener());
        addMouseMotionListener(new EditorDiagramStatusMouseMotionListener());
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (EditorElement element : editor.getActivePage().getEditorElements())
            element.getGraphicElement().render(graphics2D);

        if (graphicElement != null)
            graphicElement.render(graphics2D);
    }


    /**
     * Sets the graphic element. Is used to display the graphic element during its creation.
     * @param graphicElement graphic element
     */
    public void setGraphicElement(GraphicElement graphicElement) {
        this.graphicElement = graphicElement;
        repaint();
    }

    /**
     * Gets the graphic element whose area contains the location.
     * @param location location
     * @return element if exists, null otherwise
     */
    public GraphicElement getGraphicElementAt(Point2D location) {
        for (EditorElement editorElement : editor.getActivePage().getEditorElements())
            if (editorElement.getGraphicElement().contains(location))
                return editorElement.getGraphicElement();

        return null;
    }

    /**
     * Returns the graphic element.
     * @return graphic element
     */
    public GraphicElement getGraphicElement() {
        return graphicElement;
    }

    /**
     * Returns the graphic configurations.
     * @return graphic configurations
     */
    public GraphicConfigurations getConfigurations() {
        return configurations;
    }

    /**
     * Reconnects all connectable elements.
     */
    public void reconnect() {
        for (EditorElement editorElement : editor.getActivePage().getEditorElements())
            if (editorElement.getGraphicElement() instanceof IConnectable connection)
                connection.reconnect();

        repaint();
    }

    /**
     * Returns the list of hanging connections.
     * @return hanging connections
     */
    public List<GraphicElement> getHangingConnections() {
        List<GraphicElement> elements = new ArrayList<>();

        for (EditorElement editorElement : editor.getActivePage().getEditorElements())
            if (editorElement.getGraphicElement() instanceof GraphicConnection connection &&
                (!onDiagram(connection.getFirst()) || !onDiagram(connection.getSecond())))
                elements.add(connection);

        return elements;
    }

    /**
     * Returns true if the graphic element is on the diagram, false otherwise.
     * @param element element
     * @return true if on diagram, false otherwise
     */
    public boolean onDiagram(GraphicElement element) {
        for (EditorElement editorElement : editor.getActivePage().getEditorElements())
            if (editorElement.getGraphicElement().equals(element))
                return true;

        return false;
    }

    /**
     * Removes the graphic element.
     */
    public void removeGraphicElement() {
        graphicElement = null;
        repaint();
    }

    //region Diagram Dimensions

    /**
     * Sets the actual width of the diagram (it is NOT affected by the scale factor).
     * @param width width
     */
    public void setActualWidth(int width) {
        this.width = width;
        updateScaledSize();
    }

    /**
     * Sets the actual height of the diagram (it is NOT affected by the scale factor).
     * @param height height
     */
    public void setActualHeight(int height) {
        this.height = height;
        updateScaledSize();
    }

    /**
     * Sets the size of the diagram in the editor based on the scale factor, then notifies the page about the change.
     */
    public void updateScaledSize() {
        if (editor.getActivePage() == null)
            return;

        setPreferredSize(new Dimension(getScaledWidth(), getScaledHeight()));
        editor.getActivePage().updateContainerDimensions();

        revalidate();
        repaint();
    }

    /**
     * Sets the actual size of the diagram (it is NOT affected by the scale factor).
     * @param width width
     * @param height height
     */
    public void setActualSize(int width, int height) {
        setActualWidth(width);
        setActualHeight(height);
    }

    /**
     * Sets the actual size of the diagram (it is NOT affected by the scale factor).
     * @param size size
     */
    public void setActualSize(Dimension size) {
        setActualSize(size.width, size.height);
    }

    /**
     * Returns the actual width of the diagram (it is NOT affected by the scale factor).
     * @return width
     */
    public int getActualWidth() {
        return width;
    }

    /**
     * Returns the actual height of the diagram (it is NOT affected by the scale factor).
     * @return height
     */
    public int getActualHeight() {
        return height;
    }

    /**
     * Returns the width of the diagram based on the scale factor.
     * @return scaled width
     */
    public int getScaledWidth() {
        return (int) Math.round(getActualWidth() * configurations.getScaleFactor());
    }

    /**
     * Returns the height of the diagram based on the scale factor.
     * @return scaled height
     */
    public int getScaledHeight() {
        return (int) Math.round(getActualHeight() * configurations.getScaleFactor());
    }

    /**
     * Returns the actual size of the diagram (it is NOT affected by the scale factor).
     * @return size
     */
    public Dimension getActualSize() {
        return new Dimension(getActualWidth(), getActualHeight());
    }

    /**
     * Returns the size of the diagram based on the scale factor.
     * @return scaled size
     */
    public Dimension getScaledSize() {
        return new Dimension(getScaledWidth(), getScaledHeight());
    }

    //endregion


}
