package rs.raf.gerumap.log.logger;

import rs.raf.gerumap.log.MessageGenerator;
import rs.raf.gerumap.log.model.Message;

public class ConsoleLogger extends LoggerBase {

    public ConsoleLogger() {
        super(System.out);
    }

    @Override
    public void log(Message message) {
        printStream.println(MessageGenerator.getMessage(message));
    }

    @Override
    public void log(Message message, String extend) {
        printStream.println(MessageGenerator.getMessage(message, extend));
    }

}
