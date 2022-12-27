package rs.raf.gerumap.gui.swing.view.workspace.editor.state;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.controller.comands.AddGraphicElementCommand;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConcept;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConnection;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class ConnectState extends State {

    public static final String ID = ConnectState.class.getSimpleName();

    private Point2D startLocation = null;

    private GraphicConnection graphicConnection = null;

    @Override
    public void mousePressed(MouseEvent event) {
        SelectionManager.clear();
        editor.render();

        Point2D mouseLocation = new Point2D.Double(event.getX() / editor.getGraphicConfigurations().getScaleFactor(),
                                                   event.getY() / editor.getGraphicConfigurations().getScaleFactor());

        GraphicElement graphicElement = editor.getDiagram().getGraphicElementAt(mouseLocation);

        if (!(graphicElement instanceof GraphicConcept concept))
            return;

        if (graphicConnection == null) {
            graphicConnection = new GraphicConnection(concept);
            startLocation = mouseLocation;
            return;
        }

        if (concept.equals(graphicConnection.getFirst()))
            return;

        graphicConnection.setSecond(concept);

        if (!graphicConnection.isDiscarded())
            editor.getCommandManager().addCommand(new AddGraphicElementCommand(graphicConnection));
        else
            Logger.log(Message.EDITOR_GRAPHIC_ELEMENTS_INTERSECTED);

        clear();
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        if (graphicConnection == null)
            return;

        Point2D mouseLocation = new Point2D.Double(event.getX() / editor.getGraphicConfigurations().getScaleFactor(),
                                                   event.getY() / editor.getGraphicConfigurations().getScaleFactor());

        if (graphicConnection.getFirst().contains(mouseLocation))
            editor.getDiagram().removeGraphicElement();
        else
            editor.getDiagram().setGraphicElement(graphicConnection);

        GraphicElement graphicElement = editor.getDiagram().getGraphicElementAt(mouseLocation);

        if (graphicElement instanceof GraphicConcept && !graphicElement.equals(graphicConnection.getFirst())) {
            graphicConnection.setSecond((GraphicConcept) graphicElement);
        }
        else {
            graphicConnection.setSecond(null);
            graphicConnection.update(startLocation, mouseLocation);
        }

        editor.render();
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        mouseMoved(event);
    }

    @Override
    public void clear() {
        editor.getDiagram().removeGraphicElement();

        graphicConnection = null;
        startLocation = null;
    }

}
