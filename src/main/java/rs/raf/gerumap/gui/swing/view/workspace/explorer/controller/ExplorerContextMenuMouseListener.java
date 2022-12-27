package rs.raf.gerumap.gui.swing.view.workspace.explorer.controller;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.IExplorer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExplorerContextMenuMouseListener extends MouseAdapter {

    @Override
    public void mouseReleased(MouseEvent event) {
        if (event.getButton() != MouseEvent.BUTTON3)
            return;

        IExplorer explorer = MainWindow.window.getExplorer();

        if (!explorer.selectItemAtLocation(event.getX(), event.getY()))
            return;

        if (explorer.getSelectedItem() != null)
            explorer.getSelectedItem().showContextMenu(event.getX(), event.getY());
    }

}
