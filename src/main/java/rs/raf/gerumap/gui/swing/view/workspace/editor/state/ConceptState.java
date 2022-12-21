package rs.raf.gerumap.gui.swing.view.workspace.editor.state;

import rs.raf.gerumap.gui.swing.controller.comands.AddGraphicElementCommand;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConcept;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class ConceptState extends State {

    public static final String ID = ConceptState.class.getSimpleName();

    private Point2D startLocation = null;

    private GraphicConcept graphicConcept = null;

    @Override
    public void mousePressed(MouseEvent event) {
        super.mousePressed(event);

        startLocation = new Point2D.Double(event.getX() / editor.getGraphicConfigurations().getScaleFactor(),
                                           event.getY() / editor.getGraphicConfigurations().getScaleFactor());

        graphicConcept = new GraphicConcept(startLocation);

        editor.getDiagram().setGraphicElement(graphicConcept);
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        Point2D mouseLocation = new Point2D.Double(event.getX() / editor.getGraphicConfigurations().getScaleFactor(),
                                                   event.getY() / editor.getGraphicConfigurations().getScaleFactor());

        graphicConcept.update(startLocation, mouseLocation);
        editor.render();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if (!graphicConcept.isDiscarded())
            editor.getCommandManager().addCommand(new AddGraphicElementCommand(graphicConcept));

        clear();
    }

    @Override
    public void clear() {
        editor.getDiagram().removeGraphicElement();

        startLocation = null;
        graphicConcept = null;
    }

}
