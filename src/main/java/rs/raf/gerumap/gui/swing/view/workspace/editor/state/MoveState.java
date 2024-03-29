package rs.raf.gerumap.gui.swing.view.workspace.editor.state;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.controller.comands.MoveElementsCommand;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.IMovable;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class MoveState extends State {

    public static final String ID = MoveState.class.getSimpleName();

    private Point2D startLocation = null;

    private final List<Point2D> startLocations = new ArrayList<>();

    @Override
    public void mousePressed(MouseEvent event) {
        Point2D mouseLocation = new Point2D.Double(event.getX() / editor.getGraphicConfigurations().getScaleFactor(),
                                                   event.getY() / editor.getGraphicConfigurations().getScaleFactor());

        GraphicElement graphicElement = editor.getDiagram().getGraphicElementAt(mouseLocation);

        if (graphicElement == null || !SelectionManager.getSelectedElements().contains(graphicElement))
            return;

        startLocation = mouseLocation;

        for (IMovable movableElement : SelectionManager.getSelectedMovables())
            startLocations.add(movableElement.getLocation());
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        if (startLocation == null)
            return;

        double moveX = event.getX() / editor.getGraphicConfigurations().getScaleFactor() - startLocation.getX();
        double moveY = event.getY() / editor.getGraphicConfigurations().getScaleFactor() - startLocation.getY();

        List<IMovable> selected = SelectionManager.getSelectedMovables();

        for (int i = 0; i < selected.size(); ++i)
            selected.get(i).setLocation(startLocations.get(i).getX() + moveX, startLocations.get(i).getY() + moveY);

        editor.getDiagram().reconnect();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if (startLocation == null)
            return;

        if (elementsIntersect()) {
            restoreLocations();
            Logger.log(Message.EDITOR_GRAPHIC_ELEMENTS_INTERSECTED);
        }
        else
            editor.getCommandManager().addCommand(new MoveElementsCommand(SelectionManager.getSelectedMovables(), startLocations));

        startLocation = null;

        clear();
    }

    @Override
    public void clear() {
        if (startLocation != null)
            restoreLocations();

        startLocation = null;
        startLocations.clear();

        editor.render();
    }

    /**
     * Returns true if at least two elements are intersected, false otherwise.
     * @return true if intersects, false otherwise
     */
    private boolean elementsIntersect() {
        for (GraphicElement graphicElement1 : editor.getActivePage().getGraphicElements())
            for (GraphicElement graphicElement2 : editor.getActivePage().getGraphicElements())
                if (graphicElement1.contains(graphicElement2) && !graphicElement1.equals(graphicElement2))
                    return true;

        return false;
    }

    /**
     * Returns the starting locations of each graphic element.
     */
    private void restoreLocations() {
        List<IMovable> movables = SelectionManager.getSelectedMovables();

        for (int i = 0; i < startLocations.size(); ++i)
            movables.get(i).setLocation(startLocations.get(i));

        editor.getDiagram().reconnect();
    }

}
