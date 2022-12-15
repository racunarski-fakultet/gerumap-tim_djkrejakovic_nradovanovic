package rs.raf.gerumap.gui.swing.view.workspace.editor.controller;

import rs.raf.gerumap.gui.swing.controller.StateManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EditorDiagramMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent event) {
        StateManager.getState().mouseClicked(event);
    }

    @Override
    public void mousePressed(MouseEvent event) {
        StateManager.getState().mousePressed(event);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        StateManager.getState().mouseReleased(event);
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        StateManager.getState().mouseEntered(event);
    }

    @Override
    public void mouseExited(MouseEvent event) {
        StateManager.getState().mouseExited(event);
    }

}
