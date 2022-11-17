package rs.raf.gerumap.log.logger;

import rs.raf.gerumap.log.MessageGenerator;
import rs.raf.gerumap.log.model.Message;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLogger extends LoggerBase {

    private static final String separator   = "/";
    private static final String logRoot     = "log";
    private static final String workingRoot = System.getProperty("user.dir");
    private static final String logFileName = "GeRuMap";
    private static final String logFile     = ".log";

    public FileLogger() {
        super(getResourceDirectoryStream());
    }

    public FileLogger(String fileName) {
        super(getWorkingDirectoryStream(fileName));
    }

    private static PrintStream getResourceDirectoryStream() {
        URL streamURL = FileLogger.class.getResource(separator + logRoot + separator + logFileName + logFile);

        if (streamURL == null)
            return null;

        PrintStream stream = null;
        try { stream = new PrintStream(new File(streamURL.toURI())); }
        catch (FileNotFoundException e) { System.out.println(e.getMessage()); }
        catch (URISyntaxException e) { System.out.println(e.getMessage()); }

        return stream;
    }

    private static PrintStream getWorkingDirectoryStream(String fileName) {
        Path jarDirectory = Paths.get(workingRoot);

        if (!hasFile(jarDirectory, fileName + logFile))
            try { Files.createFile(Path.of(jarDirectory.toAbsolutePath() + separator + fileName + logFile)); }
            catch (IOException e) { System.out.println(e.getMessage()); }

        Path filePath = Paths.get(workingRoot + separator + fileName + logFile);

        PrintStream stream;
        try {  stream = new PrintStream(new File(filePath.toUri())); }
        catch (FileNotFoundException e) { throw new RuntimeException(e); }

        return stream;
    }

    private static boolean hasFile(Path directory, String fileName) {
        for (String file : directory.toFile().list())
            if (file.equals(fileName))
                return true;

        return false;
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
