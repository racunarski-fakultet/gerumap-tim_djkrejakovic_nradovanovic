package rs.raf.gerumap.gui.swing.controller;

import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.ISelectable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectionManager {

    private static final List<ISelectable> selected = new ArrayList<>();

    /**
     * Adds an element to the selection.
     * @param select element
     */
    public static void addSelection(ISelectable select) {
        if (selected.contains(select))
            return;

        selected.add(select);
        select.setSelected(true);
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
    }

    /**
     * Returns the number of selected elements.
     * @return size
     */
    public static int size() {
        return selected.size();
    }

}
