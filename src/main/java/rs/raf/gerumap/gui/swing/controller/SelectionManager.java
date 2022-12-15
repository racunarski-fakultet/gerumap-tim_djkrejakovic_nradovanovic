package rs.raf.gerumap.gui.swing.controller;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConcept;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.ISelectable;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.properties.ConceptProperties;
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
     * Returns the selected graphic concepts.
     * @return graphic concepts
     */
    public static List<GraphicConcept> getSelectedConcepts() {
        List<GraphicConcept> concepts = new ArrayList<>();

        for (ISelectable element : selected)
            if (element instanceof GraphicConcept)
                concepts.add((GraphicConcept) element);

        return concepts;
    }

    /**
     * Returns the number of selected elements.
     * @return size
     */
    public static int size() {
        return selected.size();
    }

    private static void updateProperties() {
        int value = 0x1;

        for (ISelectable element : selected)
            value |= element.getCode();

        editor.setProperties(value == DIAGRAM ? new DiagramProperties() :
                             value == CONCEPT ? new ConceptProperties() :
                                                new DiagramProperties());
    }

}
