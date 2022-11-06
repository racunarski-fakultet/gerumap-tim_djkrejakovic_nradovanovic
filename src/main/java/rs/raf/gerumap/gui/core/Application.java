package rs.raf.gerumap.gui.core;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.UIManager;
import rs.raf.gerumap.gui.swing.view.MainWindow;

public class Application {

    public static void run(String[] args) {
        UIManager.setup();
        ActionManager.setup();

        MainWindow.instance.setVisible(true);
    }

}
