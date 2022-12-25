package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import rs.raf.gerumap.gui.swing.view.workspace.editor.EditorValues;

import java.awt.geom.Point2D;

public class GraphicEraser extends GraphicSelection {

    public GraphicEraser(Point2D location) {
        super(location);

        setBackgroundColor(EditorValues.ERASER_BACKGROUND_COLOR);
        setStrokeColor(EditorValues.ERASER_STROKE_COLOR);
        setStrokeWidth(EditorValues.ERASER_STROKE_WIDTH);
    }

    @Override
    public int getType() {
        return 0;
    }

}
