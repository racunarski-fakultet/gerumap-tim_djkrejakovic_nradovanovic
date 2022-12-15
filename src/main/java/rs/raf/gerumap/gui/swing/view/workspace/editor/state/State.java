package rs.raf.gerumap.gui.swing.view.workspace.editor.state;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.IExplorer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public abstract class State {

    protected static final IEditor editor = MainWindow.window.getEditor();

    protected static final IExplorer explorer = MainWindow.window.getExplorer();

    public void mouseClicked(MouseEvent event) { }

    public void mousePressed(MouseEvent event) {
        SelectionManager.clear();
    }

    public void mouseReleased(MouseEvent event) { }

    public void mouseEntered(MouseEvent event) { }

    public void mouseExited(MouseEvent event) { }

    public void mouseWheelMoved(MouseWheelEvent event) { }

    public void mouseDragged(MouseEvent event) { }

    public void mouseMoved(MouseEvent event) { }

    public void clear() { }

}
