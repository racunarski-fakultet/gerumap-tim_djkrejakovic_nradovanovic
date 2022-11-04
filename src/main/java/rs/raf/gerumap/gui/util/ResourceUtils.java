package rs.raf.gerumap.gui.util;

import rs.raf.gerumap.gui.model.KeyStrokes;
import rs.raf.gerumap.gui.model.Language;

import java.io.InputStream;
import java.net.URL;

public class ResourceUtils {

    private static final String separator = "/";

    private static final String propertiesFile = ".properties";
    private static final String pngFile = ".png";
    private static final String jpgFile = ".jpg";

    private static final String imagesRoot = "images";
    private static final String keyStrokeRoot = "keystrokes";
    private static final String languageRoot  = "languages";

    //region Auxiliary Methods

    private static URL getResource(String resource) {
        URL url = ResourceUtils.class.getResource(resource);

        if (url == null)
            System.err.println("Resource not found: " + resource);

        return url;
    }

    private static InputStream getStream(String resource) {
        InputStream inputStream = ResourceUtils.class.getResourceAsStream(resource);

        if (inputStream == null)
            System.err.println("Resource could not be loaded: " + resource);

        return inputStream;
    }

    private static String getIconDir() {
        return PreferenceUtils.getIconType().getIconDir();
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

}
