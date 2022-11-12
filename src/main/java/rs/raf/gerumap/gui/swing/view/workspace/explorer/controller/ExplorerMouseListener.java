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
        if (event.getButton() == MouseEvent.BUTTON3) {

            ExplorerTree explorer = MainWindow.window.getWorkspace().getExplorer().getExplorerTree();
            TreePath path = explorer.getPathAtLocation(event.getY());

            if (path == null)
                return;

            explorer.setSelectionPath(path);

            ExplorerItem item = (ExplorerItem) explorer.getLastSelectedPathComponent();
            item.showContextMenu(event.getX(), event.getY());

        }
    }

}
