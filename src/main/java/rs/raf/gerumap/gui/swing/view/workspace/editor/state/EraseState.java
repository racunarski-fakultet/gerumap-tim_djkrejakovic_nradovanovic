package rs.raf.gerumap.gui.swing.view.workspace.editor.state;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicEraser;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class EraseState extends State {

    public static final String ID = EraseState.class.getSimpleName();

    private Point2D startLocation = null;

    private GraphicEraser graphicEraser = null;

    @Override
    public void mousePressed(MouseEvent event) {
        super.mousePressed(event);

        startLocation = event.getPoint();
        graphicEraser = new GraphicEraser(startLocation);

        GraphicElement graphicElement = editor.getDiagram().getGraphicElementAt(startLocation);

        if (graphicElement != null)
            SelectionManager.addSelection(graphicElement);

        editor.getDiagram().setGraphicElement(graphicEraser);
        editor.render();
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        if (graphicEraser == null)
            return;

        graphicEraser.update(startLocation, event.getPoint());
        editor.render();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        SelectionManager.erase();

        editor.getDiagram().removeGraphicElement();
        editor.render();

        clear();
    }

    @Override
    public void clear() {
        startLocation = null;
        graphicEraser = null;
    }

}
