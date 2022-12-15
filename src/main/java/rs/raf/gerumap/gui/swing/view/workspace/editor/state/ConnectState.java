package rs.raf.gerumap.gui.swing.view.workspace.editor.state;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConcept;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConnection;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorElement;

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

        GraphicElement graphicElement = editor.getDiagram().getGraphicElementAt(event.getPoint());

        if (graphicElement == null || !(graphicElement instanceof GraphicConcept))
            return;

        GraphicConcept concept = (GraphicConcept) graphicElement;

        if (graphicConnection == null) {
            graphicConnection = new GraphicConnection(concept);
            startLocation = event.getPoint();
        }
        else if (!concept.equals(graphicConnection.getFirst())) {
            graphicConnection.setSecond(concept);

            editor.getActivePage().addElement(new EditorElement(graphicConnection));
            explorer.addChild(explorer.getItem(editor.getActivePage().getMindMap()));

            SelectionManager.addSelection(graphicConnection);

            editor.getDiagram().removeGraphicElement();
            editor.render();

            clear();
        }

    }

    @Override
    public void mouseMoved(MouseEvent event) {
        if (graphicConnection == null)
            return;

        if (graphicConnection.getFirst().contains(event.getPoint()))
            editor.getDiagram().removeGraphicElement();
        else
            editor.getDiagram().setGraphicElement(graphicConnection);

        GraphicElement graphicElement = editor.getDiagram().getGraphicElementAt(event.getPoint());

        if (graphicElement != null && graphicElement instanceof GraphicConcept && !graphicElement.equals(graphicConnection.getFirst())) {
            graphicConnection.setSecond((GraphicConcept) graphicElement);
        }
        else {
            graphicConnection.setSecond(null);
            graphicConnection.update(startLocation, event.getPoint());
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
        editor.render();

        graphicConnection = null;
        startLocation = null;
    }

}
