package rs.raf.gerumap.gui.swing.util;

import rs.raf.gerumap.gui.swing.util.model.KeyStrokes;
import rs.raf.gerumap.gui.swing.util.model.Language;

import java.io.InputStream;
import java.net.URL;

public class ResourceUtils {

    private static final String separator = "/";

    private static final String propertiesFile = ".properties";
    private static final String pngFile = ".png";
    private static final String jpgFile = ".jpg";

    private static final String imagesRoot    = "images";
    private static final String keyStrokeRoot = "keystrokes";
    private static final String languageRoot  = "languages";
    private static final String themeRoot     = "themes";

    //region Auxiliary Methods

    private static URL getResource(String resource) {
        URL url = ResourceUtils.class.getResource(resource);

        return url;
    }

    private static InputStream getStream(String resource) {
        InputStream inputStream = ResourceUtils.class.getResourceAsStream(resource);

        return inputStream;
    }

    private static String getIconDir() {
        return PreferenceUtils.getIconType().getIconDir();
    }

    private static String getThemeDir() {
        return PreferenceUtils.getTheme().getThemeDir();
    }

    //endregion

    //region Icon Utilities

    private static String getIconResourceDirectory() {
        return separator + imagesRoot + separator + getIconDir() + separator;
    }

    public static URL getIconPath(String iconName) {
        return getResource(getIconResourceDirectory() + iconName + pngFile);
    }

    //endregion

    //region KeyStrokes Utilities

    private static String getKeyStrokesResourceDirectory() {
        return separator + keyStrokeRoot + separator;
    }

    public static InputStream getKeyStrokesStream(KeyStrokes keyStrokes) {
        return getStream(getKeyStrokesResourceDirectory() + keyStrokes.getId() + propertiesFile);
    }

    //endregion

    //region Language Utilities

    private static String getLanguageResourceDirectory() {
        return separator + languageRoot + separator;
    }

    public static InputStream getLanguageStream(Language language) {
        return getStream(getLanguageResourceDirectory() + language.getId() + propertiesFile);
    }

    //endregion

    //region Theme Utilities

    private static String getThemeResourceDirectory() {
        return separator + themeRoot + separator + getThemeDir() + separator;
    }

    public static URL getThemeDirectory() {
        return getResource(getThemeResourceDirectory());
    }

    //endregion

}