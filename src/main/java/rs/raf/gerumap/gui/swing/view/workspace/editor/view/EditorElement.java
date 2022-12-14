package rs.raf.gerumap.gui.swing.view.workspace.editor.view;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;

public class EditorElement implements IEditorComponent {

    private static final IEditor editor = MainWindow.window.getEditor();

    private final GraphicElement element;

    public EditorElement(GraphicElement element) {
        this.element = element;
    }

    @Override
    public void load() { }

    @Override
    public void rename(String oldName) { }

    public GraphicElement getGraphicElement() {
        return element;
    }

}
