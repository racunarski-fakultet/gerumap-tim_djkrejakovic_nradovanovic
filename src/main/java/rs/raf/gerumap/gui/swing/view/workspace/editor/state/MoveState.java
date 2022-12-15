package rs.raf.gerumap.gui.swing.view.workspace.editor.state;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.IMovable;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorElement;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class MoveState extends State {

    public static final String ID = MoveState.class.getSimpleName();

    private Point2D startLocation = null;

    private List<Point2D> startLocations = new ArrayList<>();

    @Override
    public void mousePressed(MouseEvent event) {
        startLocation = event.getPoint();

        for (IMovable movableElement : SelectionManager.getSelectedMovables())
            startLocations.add(movableElement.getLocation());
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        if (startLocation == null)
            return;

        double moveX = event.getX() - startLocation.getX();
        double moveY = event.getY() - startLocation.getY();

        List<IMovable> selected = SelectionManager.getSelectedMovables();

        for (int i = 0; i < selected.size(); ++i)
            selected.get(i).setLocation(startLocations.get(i).getX() + moveX, startLocations.get(i).getY() + moveY);

        editor.getDiagram().reconnect();

        editor.render();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        clear();
    }

    @Override
    public void clear() {
        if (elementsIntersect())
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
        for (EditorElement editorElement1 : editor.getActivePage().getEditorElements()) {
            for (EditorElement editorElement2 : editor.getActivePage().getEditorElements()) {
                GraphicElement element1 = editorElement1.getGraphicElement();
                GraphicElement element2 = editorElement2.getGraphicElement();

                if (element1.contains(element2) && !element1.equals(element2))
                    return true;
            }
        }

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
