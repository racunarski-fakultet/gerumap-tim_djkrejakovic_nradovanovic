package rs.raf.gerumap.gui.swing.controller;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConcept;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.IMovable;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.ISelectable;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.IStroke;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.properties.ConceptProperties;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.properties.ConnectiveProperties;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.properties.DiagramProperties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectionManager {

    private static final IEditor editor = MainWindow.window.getEditor();

    private static final List<ISelectable> selected = new ArrayList<>();

    private static final int DIAGRAM = 0x1;
    private static final int CONCEPT = 0x101;

    /**
     * Adds an element to the selection.
     * @param select element
     */
    public static void addSelection(ISelectable select) {
        if (selected.contains(select))
            return;

        selected.add(select);
        select.setSelected(true);

        updateProperties();
    }

    /**
     * Returns the selected graphic elements.
     * @return graphic elements
     */
    public static List<GraphicElement> getSelectedElements() {
        List<GraphicElement> elements = new ArrayList<>();

        for (ISelectable element : selected)
            if (element instanceof GraphicElement gElement)
                elements.add(gElement);

        return elements;
    }

    /**
     * Returns the selected graphic concepts.
     * @return graphic concepts
     */
    public static List<GraphicConcept> getSelectedConcepts() {
        List<GraphicConcept> concepts = new ArrayList<>();

        for (ISelectable element : selected)
            if (element instanceof GraphicConcept concept)
                concepts.add(concept);

        return concepts;
    }

    /**
     * Returns the selected graphic elements with a stroke.
     * @return stroke elements
     */
    public static List<IStroke> getSelectedStrokes() {
        List<IStroke> strokes = new ArrayList<>();

        for (ISelectable element : selected)
            if (element instanceof IStroke stroke)
                strokes.add((stroke));

        return strokes;
    }

    /**
     * Returns the selected graphical elements that can be moved.
     * @return movable elements
     */
    public static List<IMovable> getSelectedMovables() {
        List<IMovable> movables = new ArrayList<>();

        for (ISelectable element : selected)
            if (element instanceof IMovable movable)
                movables.add(movable);

        return movables;
    }

    /**
     * Returns a list of elements to erase.
     * @return elements to erase
     */
    public static List<GraphicElement> getElementsToErase() {
        deselect();

        List<GraphicElement> elements = getSelectedElements();
        elements.addAll(editor.getDiagram().getHangingConnections());

        return elements;
    }

    /**
     * Deselects all selected elements.
     */
    private static void deselect() {
        for (ISelectable element : selected)
            element.setSelected(false);
    }

    /**
     * Removes all elements from the selection.
     */
    public static void clear() {
        Iterator<ISelectable> iterator = selected.iterator();

        while (iterator.hasNext()) {
            iterator.next().setSelected(false);
            iterator.remove();
        }

        updateProperties();
    }

    /**
     * Returns the number of selected elements.
     * @return size
     */
    public static int size() {
        return selected.size();
    }

    /**
     * Updates the properties tab based on the selected elements.
     */
    private static void updateProperties() {
        if (editor.getActivePage() == null)
            return;

        int value = 0x1;

        for (ISelectable element : selected)
            value |= element.getCode();

        editor.setProperties(value == DIAGRAM ? new DiagramProperties() :
                             value == CONCEPT ? new ConceptProperties() :
                                                new ConnectiveProperties());
    }

}
