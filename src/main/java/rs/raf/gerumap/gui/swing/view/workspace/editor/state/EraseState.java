package rs.raf.gerumap.gui.swing.view.workspace.editor.state;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.controller.comands.EraseGraphicElementsCommand;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicEraser;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.List;

public class EraseState extends State {

    public static final String ID = EraseState.class.getSimpleName();

    private Point2D startLocation = null;

    private GraphicEraser graphicEraser = null;

    @Override
    public void mousePressed(MouseEvent event) {
        super.mousePressed(event);

        startLocation = new Point2D.Double(event.getX() / editor.getGraphicConfigurations().getScaleFactor(),
                                           event.getY() / editor.getGraphicConfigurations().getScaleFactor());

        graphicEraser = new GraphicEraser(startLocation);

        GraphicElement graphicElement = editor.getDiagram().getGraphicElementAt(startLocation);

        if (graphicElement != null)
            SelectionManager.addSelection(graphicElement);

        editor.getDiagram().setGraphicElement(graphicEraser);
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        if (graphicEraser == null)
            return;

        Point2D mouseLocation = new Point2D.Double(event.getX() / editor.getGraphicConfigurations().getScaleFactor(),
                                                   event.getY() / editor.getGraphicConfigurations().getScaleFactor());

        graphicEraser.update(startLocation, mouseLocation);
        editor.render();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if (startLocation == null)
            return;

        List<GraphicElement> elementsToErase = SelectionManager.getElementsToErase();

        if (elementsToErase.size() != 0)
            editor.getCommandManager().addCommand(new EraseGraphicElementsCommand(elementsToErase));

        clear();
    }

    @Override
    public void clear() {
        editor.getDiagram().removeGraphicElement();

        startLocation = null;
        graphicEraser = null;
    }

}
