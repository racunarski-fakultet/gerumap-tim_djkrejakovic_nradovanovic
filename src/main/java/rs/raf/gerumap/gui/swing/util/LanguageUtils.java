package rs.raf.gerumap.gui.swing.util;

import rs.raf.gerumap.gui.swing.util.model.Language;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;

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
            Logger.log(Message.UTILITY_LANGUAGE_NOT_FOUND, language.getName());
        }
    }

    public static String getNameProperty(String key) {
        return properties.getProperty(key + DISPLAY_NAME, DEFAULT_VALUE);
    }

    public static String getTooltipProperty(String key) {
        return properties.getProperty(key + TOOLTIP, DEFAULT_VALUE);
    }

}