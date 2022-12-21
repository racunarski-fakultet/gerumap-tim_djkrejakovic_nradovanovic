package rs.raf.gerumap.gui.swing.controller.comands;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorElement;

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
        editor.getActivePage().addElement(new EditorElement(addedElement));
        explorer.addChild(explorer.getItem(editor.getActivePage().getMindMap()));

        editor.render();
    }

    @Override
    public void undoCommand() {
        explorer.remove(explorer.getItem(addedElement));

        editor.render();
    }

}
