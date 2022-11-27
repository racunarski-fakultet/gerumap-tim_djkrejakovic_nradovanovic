package rs.raf.gerumap.log.logger;

/**
 * Logger that handles logging to the console
 */
public class ConsoleLogger extends LoggerBase {

    /**
     * Creates a logger that prints a message to the console.
     */
    public ConsoleLogger() {
        super(System.out);
    }

}
