package rs.raf.gerumap.gui.swing.controller.comands;

import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.IBackground;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ChangeElementsBackgroundCommand extends BaseCommand {

    private final List<IBackground> backgroundElements;
    private final Color             newBackground;
    private final List<Color>       oldBackgrounds = new ArrayList<>();

    public ChangeElementsBackgroundCommand(List<IBackground> backgroundElements, Color newBackground) {
        this.backgroundElements = backgroundElements;
        this.newBackground = newBackground;

        for (IBackground element : backgroundElements)
            oldBackgrounds.add(element.getBackgroundColor());
    }

    @Override
    public void perform() {
        redoCommand();
    }

    @Override
    public void redoCommand() {
        for (IBackground element : backgroundElements)
            element.setBackgroundColor(newBackground);

        editor.updateProperties();
        editor.render();
    }

    @Override
    public void undoCommand() {
        for (int i = 0; i < backgroundElements.size(); ++i)
            backgroundElements.get(i).setBackgroundColor(oldBackgrounds.get(i));

        editor.updateProperties();
        editor.render();
    }

}
