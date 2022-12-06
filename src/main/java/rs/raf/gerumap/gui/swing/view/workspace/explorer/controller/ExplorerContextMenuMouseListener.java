package rs.raf.gerumap.gui.swing.view.workspace.explorer.controller;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.IExplorer;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExplorerContextMenuMouseListener extends MouseAdapter {

    @Override
    public void mouseReleased(MouseEvent event) {
        if (event.getButton() != MouseEvent.BUTTON3)
            return;

        IExplorer explorer = MainWindow.window.getExplorer();

        ExplorerItem item = explorer.getItemAtLocation(event.getX(), event.getY());

        if (item == null)
            return;

        explorer.setSelectedItem(item);
        item.showContextMenu(event.getX(), event.getY());
    }

}
