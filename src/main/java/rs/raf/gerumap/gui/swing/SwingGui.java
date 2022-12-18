package rs.raf.gerumap.gui.swing;

import rs.raf.gerumap.gui.Gui;
import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.UIManager;
import rs.raf.gerumap.gui.swing.view.MainWindow;

public class SwingGui implements Gui {

    @Override
    public void start() {
        UIManager.setup();
        ActionManager.setup();

        MainWindow.window.setVisible(true);
    }

}
