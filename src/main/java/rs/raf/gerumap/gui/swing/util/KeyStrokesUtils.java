package rs.raf.gerumap.gui.swing.util;

import rs.raf.gerumap.gui.swing.util.model.KeyStrokes;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;

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
            Logger.log(Message.UTILITY_KEYSTROKES_NOT_FOUND, keyStrokes.name());
        }
    }

    public static KeyStroke getProperty(String key) {
        return KeyStroke.getKeyStroke(properties.getProperty(key, DEFAULT_VALUE));
    }

}
