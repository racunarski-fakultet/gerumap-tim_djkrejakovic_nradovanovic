package rs.raf.gerumap.log.logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Logger that handles logging to a file
 */
public class FileLogger extends LoggerBase {

    private static final String separator   = "/";
    private static final String logRoot     = "log";
    private static final String workingRoot = System.getProperty("user.dir");
    private static final String logFileName = "GeRuMap";
    private static final String logFile     = ".log";

    /**
     * Creates a logger that writes a message to a file within the project
     */
    public FileLogger() {
        super(getResourceDirectoryStream());
    }

    /**
     * Creates a logger that writes a message to a file in the program's working directory.
     * @param fileName file name
     */
    public FileLogger(String fileName) {
        super(getWorkingDirectoryStream(fileName));
    }

    /**
     * Opens the file stream in the project's resources directory.
     * @return file stream
     */
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

    /**
     * Opens the file stream in the program's working directory.
     * @return file stream
     */
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

    /**
     * Returns true if the directory contains the file, otherwise returns false.
     * @param directory directory
     * @param fileName file name
     * @return true if file exist, otherwise false.
     */
    private static boolean hasFile(Path directory, String fileName) {
        for (String file : directory.toFile().list())
            if (file.equals(fileName))
                return true;

        return false;
    }

}
