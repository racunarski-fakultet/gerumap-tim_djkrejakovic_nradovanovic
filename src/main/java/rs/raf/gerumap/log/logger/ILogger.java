package rs.raf.gerumap.log.logger;

import rs.raf.gerumap.log.model.Message;

/**
 * Logger interface
 */
public interface ILogger {

    /**
     * Notifies all subscribers to process the message.
     * @param message message content
     */
    void log(Message message);

    /**
     * Notifies all subscribers to process the message.
     * @param message message content
     * @param extend additional message
     */
    void log(Message message, String extend);

    /**
     * closes the stream and disposes the object from memory
     */
    void close();

}
