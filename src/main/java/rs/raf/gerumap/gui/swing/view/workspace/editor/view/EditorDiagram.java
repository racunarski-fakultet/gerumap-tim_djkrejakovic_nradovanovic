package rs.raf.gerumap.gui.swing.view.workspace.editor.view;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.EditorValues;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorDiagramMouseListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorDiagramMouseMotionListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorFocusMouseListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

public class EditorDiagram extends JPanel {

    private static final IEditor editor = MainWindow.window.getEditor();

    private GraphicElement graphicElement = null;

    public EditorDiagram() {
        setPreferredSize(EditorValues.DIAGRAM_DIMENSION);
        setBackground(EditorValues.DIAGRAM_BACKGROUND_COLOR);

        addMouseListener(new EditorFocusMouseListener());
        addMouseListener(new EditorDiagramMouseListener());
        addMouseMotionListener(new EditorDiagramMouseMotionListener());
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
     * Sets the diagram width.
     * @param width width
     */
    public void setWidth(int width) {
        setPreferredSize(new Dimension(width, getHeight()));
        editor.updatePageDimension();
        revalidate();
        repaint();
    }

    /**
     * Sets the diagram height.
     * @param height height
     */
    public void setHeight(int height) {
        setPreferredSize(new Dimension(getWidth(), height));
        editor.updatePageDimension();
        revalidate();
        repaint();
    }

    /**
     * Sets the diagram dimension.
     * @param width width
     * @param height height
     */
    public void setDimension(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    /**
     * Sets the graphic element. Is used to display the graphic element during its creation.
     * @param graphicElement graphic element
     */
    public void setGraphicElement(GraphicElement graphicElement) {
        this.graphicElement = graphicElement;
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
     * Removes the graphic element.
     */
    public void removeGraphicElement() {
        graphicElement = null;
        repaint();
    }

}
