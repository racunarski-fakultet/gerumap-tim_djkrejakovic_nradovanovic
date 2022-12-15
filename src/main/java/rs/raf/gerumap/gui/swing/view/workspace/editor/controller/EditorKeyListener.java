package rs.raf.gerumap.gui.swing.view.workspace.editor.controller;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.controller.StateManager;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditorKeyListener extends KeyAdapter {

    private static final IEditor editor = MainWindow.window.getEditor();

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_DELETE)
            SelectionManager.erase();

        if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
            StateManager.getState().clear();
            SelectionManager.clear();
            editor.render();
        }

    }

}
