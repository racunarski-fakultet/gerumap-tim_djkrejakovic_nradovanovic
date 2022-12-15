package rs.raf.gerumap.gui.swing.view.workspace.editor.state;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConcept;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorElement;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class ConceptState extends State {

    public static final String ID = ConceptState.class.getSimpleName();

    private Point2D startLocation = null;

    private GraphicConcept graphicConcept = null;

    @Override
    public void mousePressed(MouseEvent event) {
        super.mousePressed(event);

        startLocation = event.getPoint();
        graphicConcept = new GraphicConcept(startLocation);

        editor.getDiagram().setGraphicElement(graphicConcept);
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        graphicConcept.update(startLocation, event.getPoint());
        editor.render();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if (!graphicConcept.isDiscarded()) {
            editor.getActivePage().addElement(new EditorElement(graphicConcept));
            explorer.addChild(explorer.getItem(editor.getActivePage().getMindMap()));

            SelectionManager.addSelection(graphicConcept);
        }

        clear();
    }

    @Override
    public void clear() {
        editor.getDiagram().removeGraphicElement();
        editor.render();

        startLocation = null;
        graphicConcept = null;
    }

}
