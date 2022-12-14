package rs.raf.gerumap.gui.swing.view.workspace.editor.view;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.EditorValues;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorDiagramMouseListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorDiagramMouseMotionListener;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

public class EditorDiagram extends JPanel {

    private static final IEditor editor = MainWindow.window.getEditor();

    public EditorDiagram() {
        setPreferredSize(EditorValues.DIAGRAM_DIMENSION);
        setBackground(EditorValues.DIAGRAM_BACKGROUND_COLOR);

        addMouseListener(new EditorDiagramMouseListener());
        addMouseMotionListener(new EditorDiagramMouseMotionListener());
    }

    @Override
    protected void paintComponent(Graphics graphics) { }

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

}
