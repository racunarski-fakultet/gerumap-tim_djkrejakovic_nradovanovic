package rs.raf.gerumap.log;

import rs.raf.gerumap.log.model.Message;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Generates a logging message
 */
public class MessageGenerator {

    /**
     * Generates a message with the time at which its creation was requested.
     * <p>Message format is: [HH:mm:ss] [SEVERITY] Message</p>
     * @param message message content
     * @return formatted message
     */
    public static String getMessage(Message message) {
        return MessageFormat.format("[{0}] [{1}] {2}.", getTime(), message.getSeverity(), message.getMessage());
    }

    /**
     * Generates a message with the time at which its creation was requested.
     * <p>Message format is: [HH:mm:ss] [SEVERITY] Message (Additional Message)</p>
     * @param message message content
     * @param extend additional message
     * @return formatted message
     */
    public static String getMessage(Message message, String extend) {
        return MessageFormat.format("{0} ({1})", getMessage(message), extend);
    }

    /**
     * Returns current system time in HH:mm:ss format
     * @return current time
     */
    public static String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
    }

}
