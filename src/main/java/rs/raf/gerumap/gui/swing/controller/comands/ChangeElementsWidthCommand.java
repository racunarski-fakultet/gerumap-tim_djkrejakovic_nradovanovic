package rs.raf.gerumap.gui.swing.controller.comands;

import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.IResizable;

import java.util.ArrayList;
import java.util.List;

public class ChangeElementsWidthCommand extends BaseCommand {

    private final List<IResizable> resizableElements;
    private final int              newWidth;
    private final List<Double>     oldWidths = new ArrayList<>();

    public ChangeElementsWidthCommand(List<IResizable> resizableElements, int newWidth) {
        this.resizableElements = resizableElements;
        this.newWidth = newWidth;

        for (IResizable element : this.resizableElements)
            oldWidths.add(element.getWidth());
    }

    @Override
    public void perform() {
        redoCommand();
    }

    @Override
    public void redoCommand() {
        for (IResizable element : resizableElements)
            element.setWidth(newWidth);

        editor.updateProperties();
        editor.render();
    }

    @Override
    public void undoCommand() {
        for (int i = 0; i < resizableElements.size(); ++i)
            resizableElements.get(i).setWidth(oldWidths.get(i));

        editor.updateProperties();
        editor.render();
    }

}
