package rs.raf.gerumap.gui.swing.view.workspace.editor.state;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicSelection;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class SelectState extends State {

    public static final String ID = SelectState.class.getSimpleName();

    private Point2D startLocation = null;

    private GraphicSelection graphicSelection = null;

    @Override
    public void mousePressed(MouseEvent event) {
        super.mousePressed(event);

        startLocation = new Point2D.Double(event.getX() / editor.getGraphicConfigurations().getScaleFactor(),
                                           event.getY() / editor.getGraphicConfigurations().getScaleFactor());

        graphicSelection = new GraphicSelection(startLocation);

        GraphicElement graphicElement = editor.getDiagram().getGraphicElementAt(startLocation);

        if (graphicElement != null)
            SelectionManager.addSelection(graphicElement);

        editor.getDiagram().setGraphicElement(graphicSelection);
        editor.render();
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        if (graphicSelection == null)
            return;

        Point2D mouseLocation = new Point2D.Double(event.getX() / editor.getGraphicConfigurations().getScaleFactor(),
                                                   event.getY() / editor.getGraphicConfigurations().getScaleFactor());

        graphicSelection.update(startLocation, mouseLocation);
        editor.render();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        clear();
    }

    @Override
    public void clear() {
        editor.getDiagram().removeGraphicElement();

        startLocation = null;
        graphicSelection = null;
    }

}
