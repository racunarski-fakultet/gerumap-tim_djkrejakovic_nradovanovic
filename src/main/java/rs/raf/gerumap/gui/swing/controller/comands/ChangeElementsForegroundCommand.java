package rs.raf.gerumap.gui.swing.controller.comands;

import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.IForeground;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ChangeElementsForegroundCommand extends BaseCommand {

    private final List<IForeground> foregroundElements;
    private final Color             newForeground;
    private final List<Color>       oldForegrounds = new ArrayList<>();

    public ChangeElementsForegroundCommand(List<IForeground> foregroundElements, Color newForeground) {
        this.foregroundElements = foregroundElements;
        this.newForeground = newForeground;

        for (IForeground element : foregroundElements)
            oldForegrounds.add(element.getForegroundColor());
    }

    @Override
    public void perform() {
        redoCommand();
    }

    @Override
    public void redoCommand() {
        for (IForeground element : foregroundElements)
            element.setForegroundColor(newForeground);

        editor.updateProperties();
        editor.render();
    }

    @Override
    public void undoCommand() {
        for (int i = 0; i < foregroundElements.size(); ++i)
            foregroundElements.get(i).setForegroundColor(oldForegrounds.get(i));

        editor.updateProperties();
        editor.render();
    }

}
