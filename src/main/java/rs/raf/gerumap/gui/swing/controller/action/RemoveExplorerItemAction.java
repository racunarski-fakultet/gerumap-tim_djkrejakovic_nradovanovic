package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import java.awt.event.ActionEvent;

public class RemoveExplorerItemAction extends GRMapAction {

    public RemoveExplorerItemAction() {
        super(RemoveExplorerItemAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.window.getWorkspace().remove();
    }

}
