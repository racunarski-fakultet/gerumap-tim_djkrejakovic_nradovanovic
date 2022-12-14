package rs.raf.gerumap.gui.swing.view.workspace.editor.graphics;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.Element;

import java.awt.Graphics2D;

public abstract class GraphicElement extends Element {

    public GraphicElement(String name) {
        super(name, MainWindow.window.getEditor().getActivePage().getMindMap());
    }

    /**
     * Renders a graphic element within a component graphics.
     * @param graphics graphics
     */
    public abstract void render(Graphics2D graphics);

}
