package rs.raf.gerumap.core;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.UIManager;
import rs.raf.gerumap.gui.swing.util.PreferenceUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;

public class Application {

    public static void run(String[] args) {
        PreferenceUtils.clear(); //TODO Remove on release

        UIManager.setup();
        ActionManager.setup();

        MainWindow.window.setVisible(true);
    }

}
