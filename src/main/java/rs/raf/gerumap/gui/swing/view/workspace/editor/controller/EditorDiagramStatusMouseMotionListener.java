package rs.raf.gerumap.gui.swing.view.workspace.editor.controller;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class EditorDiagramStatusMouseMotionListener implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent event) {
        MainWindow.window.getEditor().getStatusBar().setCoordinates(event.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        MainWindow.window.getEditor().getStatusBar().setCoordinates(event.getPoint());
    }

}
