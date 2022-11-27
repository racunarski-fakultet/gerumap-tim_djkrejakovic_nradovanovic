package rs.raf.gerumap.gui.swing.controller.action;

import rs.raf.gerumap.gui.swing.view.MainWindow;

import java.awt.event.ActionEvent;

/**
 * The action that handles the closing of the program.
 */
public class ExitAction extends GRMapAction {

    public ExitAction() {
        super(ExitAction.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.window.close();
    }

}
