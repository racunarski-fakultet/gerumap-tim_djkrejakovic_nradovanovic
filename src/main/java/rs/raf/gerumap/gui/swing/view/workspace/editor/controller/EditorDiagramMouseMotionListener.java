package rs.raf.gerumap.gui.swing.view.workspace.editor.controller;

import rs.raf.gerumap.gui.swing.controller.StateManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class EditorDiagramMouseMotionListener implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent event) {
        StateManager.getState().mouseDragged(event);
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        StateManager.getState().mouseMoved(event);
    }

}
