package rs.raf.gerumap.gui.swing.controller.comands;

import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.IResizable;

import java.util.ArrayList;
import java.util.List;

public class ChangeElementsHeightCommand extends BaseCommand {

    private final List<IResizable> resizableElements;
    private final int              newHeight;
    private final List<Double>     oldHeights = new ArrayList<>();

    public ChangeElementsHeightCommand(List<IResizable> resizableElements, int newHeight) {
        this.resizableElements = resizableElements;
        this.newHeight = newHeight;

        for (IResizable element : this.resizableElements)
            oldHeights.add(element.getHeight());
    }

    @Override
    public void perform() {
        redoCommand();
    }

    @Override
    public void redoCommand() {
        for (IResizable element : resizableElements)
            element.setHeight(newHeight);

        editor.updateProperties();
        editor.getDiagram().reconnect();
        editor.render();
    }

    @Override
    public void undoCommand() {
        for (int i = 0; i < resizableElements.size(); ++i)
            resizableElements.get(i).setHeight(oldHeights.get(i));

        editor.updateProperties();
        editor.getDiagram().reconnect();
        editor.render();
    }

}
