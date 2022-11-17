package rs.raf.gerumap.log.logger;

import rs.raf.gerumap.log.model.Message;

public interface ILogger {

    void log(Message message);

    void log(Message message, String extend);

    void close();

}
