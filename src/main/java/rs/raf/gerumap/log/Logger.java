package rs.raf.gerumap.log;

import rs.raf.gerumap.log.logger.ILogger;
import rs.raf.gerumap.log.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * A general logger that notifies all subscribers to process the message.
 */
public class Logger {

    private static final List<ILogger> loggers = new ArrayList<>();

    /**
     * Subscribes the logger to the list. When a message is logged, all subscribers are notified.
     * @param logger ILogger specifying the logger type
     */
    public static void addLogger(ILogger logger){
        if(logger == null || loggers.contains(logger))
            return;

        loggers.add(logger);
    }

    /**
     * Unsubscribes a logger from the list.
     * @param logger ILogger specifying the logger type
     */
    public static void removeLogger(ILogger logger){
        if(logger == null || !loggers.contains(logger))
            return;

        logger.close();
        loggers.remove(logger);
    }

    /**
     * Unsubscribes all loggers from the list.
      */
    public static void clear() {
        for (ILogger logger : loggers)
            logger.close();

        loggers.clear();
    }

    /**
     * Notifies all subscribers to process the message.
     * @param message message content
     */
    public static void log(Message message){
        for (ILogger logger : loggers)
            logger.log(message);
    }

    /**
     * Notifies all subscribers to process the message.
     * @param message message content
     * @param extend additional message
     */
    public static void log(Message message, String extend){
        for (ILogger logger : loggers)
            logger.log(message, extend);
    }

}
