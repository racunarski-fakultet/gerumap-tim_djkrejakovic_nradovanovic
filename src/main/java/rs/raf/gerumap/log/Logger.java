package rs.raf.gerumap.log;

import rs.raf.gerumap.log.logger.ILogger;
import rs.raf.gerumap.log.model.Message;

import java.util.ArrayList;
import java.util.List;

public class Logger {

    private static final List<ILogger> loggers = new ArrayList<>();

    public static void addLogger(ILogger logger){
        if(logger == null || loggers.contains(logger))
            return;

        loggers.add(logger);
    }

    public static void removeLogger(ILogger logger){
        if(logger == null || !loggers.contains(logger))
            return;

        logger.close();
        loggers.remove(logger);
    }

    public static void clear() {
        for (ILogger logger : loggers)
            logger.close();

        loggers.clear();
    }

    public static void log(Message message){
        for (ILogger logger : loggers)
            logger.log(message);
    }

    public static void log(Message message, String extend){
        for (ILogger logger : loggers)
            logger.log(message, extend);
    }

}
