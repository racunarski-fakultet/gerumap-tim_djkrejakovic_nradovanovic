package rs.raf.gerumap.log.logger;

import java.io.PrintStream;

public abstract class LoggerBase implements ILogger {

    protected PrintStream printStream;

    public LoggerBase(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void close() {
        printStream.close();
    }

}
