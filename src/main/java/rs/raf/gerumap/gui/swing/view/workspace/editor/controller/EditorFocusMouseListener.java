package rs.raf.gerumap.gui.swing.view.workspace.editor.controller;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditorFocusMouseListener extends MouseAdapter {

    @Override
    public void mousePressed(MouseEvent e) {
        MainWindow.window.getEditor().getActiveProject().requestFocus();
    }

}
