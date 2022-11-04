package rs.raf.gerumap.gui.util;

import rs.raf.gerumap.gui.model.Language;

import java.io.IOException;
import java.util.Properties;

public class LanguageUtils {

    private static final String DEFAULT_VALUE = "NOT_FOUND";
    private static final String DISPLAY_NAME  = ".name";
    private static final String TOOLTIP       = ".tooltip";

    private static Properties properties = new Properties();

    public static void loadLanguage(Language language) {
        try {
            properties.load(ResourceUtils.getLanguageStream(language));
        }
        catch (IOException exception) {
            System.err.println("Error occurred when reading " + language.getName() + " language.");
        }
    }

    public static String getNameProperty(String key) {
        return properties.getProperty(key + DISPLAY_NAME, DEFAULT_VALUE);
    }

    public static String getTooltipProperty(String key) {
        return properties.getProperty(key + TOOLTIP, DEFAULT_VALUE);
    }

}
