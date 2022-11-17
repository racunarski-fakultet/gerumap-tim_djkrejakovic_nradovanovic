package rs.raf.gerumap.core;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.UIManager;
import rs.raf.gerumap.gui.swing.util.PreferenceUtils;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.logger.ConsoleLogger;
import rs.raf.gerumap.log.logger.FileLogger;

public class Application {

    public static void run(String[] args) {
        PreferenceUtils.clear(); //TODO Remove on release

        Logger.addLogger(new ConsoleLogger());
        Logger.addLogger(new FileLogger("GeRuMap"));

        UIManager.setup();
        ActionManager.setup();

        MainWindow.window.setVisible(true);
    }

}
