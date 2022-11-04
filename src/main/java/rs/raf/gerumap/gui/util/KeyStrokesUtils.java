package rs.raf.gerumap.gui.util;

import rs.raf.gerumap.gui.model.KeyStrokes;

import javax.swing.KeyStroke;
import java.io.IOException;
import java.util.Properties;

public class KeyStrokesUtils {

    private static final String DEFAULT_VALUE = "NOT_FOUND";

    private static Properties properties = new Properties();

    public static void LoadKeyStrokes(KeyStrokes keyStrokes) {
        try {
            properties.load(ResourceUtils.getKeyStrokesStream(keyStrokes));
        }
        catch (IOException exception) {
            System.err.println("Error occurred when reading from: " + "KeyStrokes");
        }
    }

    public static KeyStroke getProperty(String key) {
        return KeyStroke.getKeyStroke(properties.getProperty(key, DEFAULT_VALUE));
    }

}
