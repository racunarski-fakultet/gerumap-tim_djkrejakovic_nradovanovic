package rs.raf.gerumap.gui.swing.view.workspace.editor.controller;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EditorChangeListener implements ChangeListener {

    @Override
    public void stateChanged(ChangeEvent e) {
        MainWindow.window.getEditor().updateActivePage();
    }

}
