package rs.raf.gerumap.gui.swing.view.workspace.editor.view;

import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;

public class EditorElement implements IEditorComponent {

    private final GraphicElement element;

    private final int type;

    public EditorElement(GraphicElement element) {
        this.element = element;
        this.type = element.getType();
    }

    @Override
    public void load() { }

    @Override
    public void rename(String oldName) { }

    /**
     * Returns a graphic element.
     * @return graphic element
     */
    public GraphicElement getGraphicElement() {
        return element;
    }

    /**
     * Returns the element type.
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * Generates new identifiers for this component and all descendants.
     */
    public void generateNewIdentifiers() {
        element.generateNewIdentifier();
    }

}
