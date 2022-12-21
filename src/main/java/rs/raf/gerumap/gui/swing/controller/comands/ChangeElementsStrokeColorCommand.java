package rs.raf.gerumap.gui.swing.controller.comands;

import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.IStroke;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ChangeElementsStrokeColorCommand extends BaseCommand {

    private final List<IStroke> strokeElements;
    private final Color         newStrokeColor;
    private final List<Color>   oldStrokeColors = new ArrayList<>();

    public ChangeElementsStrokeColorCommand(List<IStroke> strokeElements, Color newStrokeColor) {
        this.strokeElements = strokeElements;
        this.newStrokeColor = newStrokeColor;

        for (IStroke element : this.strokeElements)
            oldStrokeColors.add(element.getStrokeColor());
    }

    @Override
    public void perform() {
        redoCommand();
    }

    @Override
    public void redoCommand() {
        for (IStroke element : strokeElements)
            element.setStrokeColor(newStrokeColor);

        editor.updateProperties();
        editor.render();
    }

    @Override
    public void undoCommand() {
        for (int i = 0; i < strokeElements.size(); ++i)
            strokeElements.get(i).setStrokeColor(oldStrokeColors.get(i));

        editor.updateProperties();
        editor.render();
    }

}
