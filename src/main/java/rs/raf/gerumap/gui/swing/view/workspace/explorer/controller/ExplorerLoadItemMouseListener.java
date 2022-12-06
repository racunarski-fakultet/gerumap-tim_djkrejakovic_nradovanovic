package rs.raf.gerumap.gui.swing.view.workspace.explorer.controller;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.IExplorer;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExplorerLoadItemMouseListener extends MouseAdapter {

    @Override
    public void mousePressed(MouseEvent event) {
        if (event.getButton() != MouseEvent.BUTTON1 || event.getClickCount() != 2)
            return;

        IExplorer explorer = MainWindow.window.getExplorer();
        IEditor editor = MainWindow.window.getEditor();

        ExplorerItem item = explorer.getItemAtLocation(event.getX(), event.getY());

        if (item.getComponent() == null)
            return;

        editor.load(item.getComponent());
    }

}
