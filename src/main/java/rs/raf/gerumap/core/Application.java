package rs.raf.gerumap.core;

import rs.raf.gerumap.gui.Gui;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.logger.ApplicationLogger;
import rs.raf.gerumap.log.logger.ConsoleLogger;
import rs.raf.gerumap.log.logger.EditorLogger;
import rs.raf.gerumap.log.logger.FileLogger;

public class Application {

    public static void run(String[] args, Gui gui) {
        Logger.addLogger(new ConsoleLogger());
        Logger.addLogger(new FileLogger("GeRuMap"));

        gui.start();

        Logger.addLogger(new EditorLogger());
        Logger.addLogger(new ApplicationLogger());
    }

}
