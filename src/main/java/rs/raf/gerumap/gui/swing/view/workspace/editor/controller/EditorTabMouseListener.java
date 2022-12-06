package rs.raf.gerumap.gui.swing.view.workspace.editor.controller;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditorTabMouseListener extends MouseAdapter {

    @Override
    public void mousePressed(MouseEvent event) {
        if (event.getButton() == MouseEvent.BUTTON2)
           MainWindow.window.getEditor().closeTabAt(event.getPoint());
    }

}
