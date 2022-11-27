package rs.raf.gerumap.log.logger;

import rs.raf.gerumap.log.MessageGenerator;
import rs.raf.gerumap.log.model.Message;

import java.io.PrintStream;

/**
 * Base logger
 */
public abstract class LoggerBase implements ILogger {

    protected PrintStream printStream;

    public LoggerBase(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void close() {
        printStream.close();
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
