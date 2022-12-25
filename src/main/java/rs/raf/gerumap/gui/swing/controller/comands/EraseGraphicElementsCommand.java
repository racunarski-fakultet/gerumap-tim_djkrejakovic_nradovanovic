package rs.raf.gerumap.gui.swing.controller.comands;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorElement;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerElementItem;

import java.util.List;

public class EraseGraphicElementsCommand extends BaseCommand {

    private final List<GraphicElement> removedElements;

    public EraseGraphicElementsCommand(List<GraphicElement> removedElements) {
        this.removedElements = removedElements;
    }

    @Override
    public void perform() {
        redoCommand();

        SelectionManager.clear();
    }

    @Override
    public void redoCommand() {
        for (GraphicElement element : removedElements)
            explorer.remove(explorer.getItem(element));

        editor.render();
    }

    @Override
    public void undoCommand() {
        for (GraphicElement element : removedElements) {
            explorer.addItem(new ExplorerElementItem(element, new EditorElement(element)));
        }

        editor.render();
    }

}
