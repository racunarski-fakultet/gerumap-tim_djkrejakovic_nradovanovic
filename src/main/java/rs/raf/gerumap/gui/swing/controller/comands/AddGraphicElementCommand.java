package rs.raf.gerumap.gui.swing.controller.comands;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorElement;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerElementItem;

public class AddGraphicElementCommand extends BaseCommand {

    private final GraphicElement addedElement;

    public AddGraphicElementCommand(GraphicElement element) {
        addedElement = element;
    }

    @Override
    public void perform() {
        redoCommand();

        SelectionManager.addSelection(addedElement);

        editor.render();
    }

    @Override
    public void redoCommand() {
        explorer.addItem(new ExplorerElementItem(addedElement, new EditorElement(addedElement)));

        editor.render();
    }

    @Override
    public void undoCommand() {
        explorer.remove(explorer.getItem(addedElement));

        SelectionManager.removeSelection(addedElement);

        editor.render();
    }

}
