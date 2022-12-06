package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import java.awt.event.ActionEvent;

public class RenameExplorerItemAction extends GRMapAction {

    public RenameExplorerItemAction() {
        super(RenameExplorerItemAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.window.getWorkspace().rename();
    }

}
