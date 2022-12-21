package rs.raf.gerumap.gui.swing.view.workspace.editor.controller;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.controller.StateManager;
import rs.raf.gerumap.gui.swing.controller.comands.EraseGraphicElementsCommand;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class EditorKeyListener extends KeyAdapter {

    private static final IEditor editor = MainWindow.window.getEditor();

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_DELETE) {
            List<GraphicElement> elementsToErase = SelectionManager.getElementsToErase();
            if (elementsToErase.size() != 0)
                editor.getCommandManager().addCommand(new EraseGraphicElementsCommand(elementsToErase));
        }
        if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
            StateManager.getState().clear();
            SelectionManager.clear();
            editor.render();
        }

    }

}
