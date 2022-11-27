package rs.raf.gerumap.gui.swing.view.workspace.explorer.controller;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerItem;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.view.ExplorerTree;

import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExplorerMouseListener extends MouseAdapter {

    @Override
    public void mouseReleased(MouseEvent event) {
        //If the left click is pressed
        if (event.getButton() == MouseEvent.BUTTON3) {
            ExplorerTree explorer = MainWindow.window.getWorkspace().getExplorer().getExplorerTree();
            //Path based on where the mouse event occurred
            TreePath path = explorer.getPathAtLocation(event.getY());

            if (path == null)
                return;

            //Selects the item
            explorer.setSelectionPath(path);

            //Based on the item and mouse location, a context menu is displayed
            ExplorerItem item = (ExplorerItem) explorer.getLastSelectedPathComponent();
            item.showContextMenu(event.getX(), event.getY());
        }
    }

}
