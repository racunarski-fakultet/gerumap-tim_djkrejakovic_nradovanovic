package rs.raf.gerumap.gui.swing.controller.comands;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorElement;

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

        editor.updateProperties();
        editor.render();
    }

    @Override
    public void redoCommand() {
        for (GraphicElement element : removedElements)
            explorer.remove(explorer.getItem(element));

        editor.updateProperties();
        editor.render();
    }

    @Override
    public void undoCommand() {
        for (GraphicElement element : removedElements) {
            editor.getActivePage().addElement(new EditorElement(element));
            explorer.addChild(explorer.getItem(editor.getActivePage().getMindMap()));
        }

        editor.updateProperties();
        editor.render();
    }

}
