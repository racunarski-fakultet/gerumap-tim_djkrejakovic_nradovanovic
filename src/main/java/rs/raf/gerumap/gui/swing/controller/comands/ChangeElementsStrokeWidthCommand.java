package rs.raf.gerumap.gui.swing.controller.comands;

import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.IStroke;

import java.util.ArrayList;
import java.util.List;

public class ChangeElementsStrokeWidthCommand extends BaseCommand {

    private final List<IStroke> strokeElements;
    private final int           newStrokeWidth;
    private final List<Float>   oldStrokeWidths = new ArrayList<>();

    public ChangeElementsStrokeWidthCommand(List<IStroke> strokeElements, int newStrokeWidth) {
        this.strokeElements = strokeElements;
        this.newStrokeWidth = newStrokeWidth;

        for (IStroke element : this.strokeElements)
            oldStrokeWidths.add(element.getStrokeWidth());
    }

    @Override
    public void perform() {
        redoCommand();
    }

    @Override
    public void redoCommand() {
        for (IStroke element : strokeElements)
            element.setStrokeWidth(newStrokeWidth);

        editor.updateProperties();
        editor.render();
    }

    @Override
    public void undoCommand() {
        for (int i = 0; i < strokeElements.size(); ++i)
            strokeElements.get(i).setStrokeWidth(oldStrokeWidths.get(i));

        editor.updateProperties();
        editor.render();
    }

}
