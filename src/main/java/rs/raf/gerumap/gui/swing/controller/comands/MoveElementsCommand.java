package rs.raf.gerumap.gui.swing.controller.comands;

import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.IMovable;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class MoveElementsCommand extends BaseCommand {

    private final List<IMovable> movedElements;
    private final List<Point2D>  newLocations;
    private final List<Point2D>  oldLocations;

    public MoveElementsCommand(List<IMovable> movedElements, List<Point2D> oldLocations) {
        this.oldLocations = new ArrayList<>(oldLocations);
        this.movedElements = movedElements;

        this.newLocations = new ArrayList<>();

        for (IMovable element : movedElements)
            this.newLocations.add(element.getLocation());
    }

    @Override
    public void perform() {
        redoCommand();
    }

    @Override
    public void redoCommand() {
        for (int i = 0; i < movedElements.size(); ++i)
            movedElements.get(i).setLocation(newLocations.get(i));

        editor.updateProperties();
        editor.getDiagram().reconnect();
    }

    @Override
    public void undoCommand() {
        for (int i = 0; i < movedElements.size(); ++i)
            movedElements.get(i).setLocation(oldLocations.get(i));

        editor.updateProperties();
        editor.getDiagram().reconnect();
    }

}
