package rs.raf.gerumap.log;

import rs.raf.gerumap.log.model.Message;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MessageGenerator {

    public static String getMessage(Message message) {
        return MessageFormat.format("[{0}] [{1}] {2}", getTime(), message.getSeverity(), message. getMessage());
    }

    public static String getMessage(Message message, String extend) {
        return MessageFormat.format("{0} ({1})", getMessage(message), extend);
    }

    public static String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
    }

}
