package rs.raf.gerumap.gui.swing.util;

import rs.raf.gerumap.gui.swing.util.model.GFont;
import rs.raf.gerumap.gui.swing.util.model.KeyStrokes;
import rs.raf.gerumap.gui.swing.util.model.Language;

import java.io.InputStream;
import java.net.URL;

public class ResourceUtils {

    private static final String separator = "/";

    private static final String propertiesFile = ".properties";
    private static final String pngFile = ".png";
    private static final String ttfFile = ".ttf";

    private static final String fontsRoot     = "fonts";
    private static final String imagesRoot    = "images";
    private static final String keyStrokeRoot = "keystrokes";
    private static final String languageRoot  = "languages";
    private static final String themeRoot     = "themes";

    //region Auxiliary Methods

    /**
     * Returns the resource URL.
     * @param resource resource
     * @return resource URL
     */
    private static URL getResource(String resource) {
        return ResourceUtils.class.getResource(resource);
    }

    /**
     * Returns the resource stream.
     * @param resource resource
     * @return resource stream
     */
    private static InputStream getStream(String resource) {
        return ResourceUtils.class.getResourceAsStream(resource);
    }

    /**
     * Returns the icon directory based on type.
     * @return icon directory
     */
    private static String getIconDir() {
        return PreferenceUtils.getIconType().getIconDir();
    }

    /**
     * Returns the theme directory based on type.
     * @return theme directory
     */
    private static String getThemeDir() {
        return PreferenceUtils.getTheme().getThemeDir();
    }

    //endregion

    //region Icon Utilities

    /**
     * Returns the icon directory.
     * @return icon directory
     */
    private static String getIconResourceDirectory() {
        return separator + imagesRoot + separator + getIconDir() + separator;
    }

    /**
     * Returns the icon path.
     * @param iconName icon name
     * @return icon path
     */
    public static URL getIconPath(String iconName) {
        return getResource(getIconResourceDirectory() + iconName + pngFile);
    }

    //endregion

    //region KeyStrokes Utilities

    /**
     * Returns the keystroke's directory.
     * @return keystrokes directory
     */
    private static String getKeyStrokesResourceDirectory() {
        return separator + keyStrokeRoot + separator;
    }

    /**
     * Returns the keystrokes stream.
     * @param keyStrokes keystorkes
     * @return keystrokes stream
     */
    public static InputStream getKeyStrokesStream(KeyStrokes keyStrokes) {
        return getStream(getKeyStrokesResourceDirectory() + keyStrokes.getId() + propertiesFile);
    }

    //endregion

    //region Language Utilities

    /**
     * Returns the language directory.
     * @return language directory
     */
    private static String getLanguageResourceDirectory() {
        return separator + languageRoot + separator;
    }

    /**
     * Returns the language stream.
     * @param language language
     * @return language stream
     */
    public static InputStream getLanguageStream(Language language) {
        return getStream(getLanguageResourceDirectory() + language.getId() + propertiesFile);
    }

    //endregion

    //region Theme Utilities

    /**
     * Returns the theme directory.
     * @return theme directory
     */
    private static String getThemeResourceDirectory() {
        return separator + themeRoot + separator + getThemeDir() + separator;
    }

    /**
     * Returns the theme URL.
     * @return theme URL
     */
    public static URL getThemeDirectory() {
        return getResource(getThemeResourceDirectory());
    }

    //endregion

    //region Font Utilities

    /**
     * Returns the font directory.
     * @return font directory
     */
    private static String getFontsResourceDirectory() {
        return separator + fontsRoot + separator;
    }

    /**
     * Returns the font stream.
     * @param font font
     * @return font stream
     */
    public static InputStream getFontStream(GFont font) {
        return getStream(getFontsResourceDirectory() + font.getName() + ttfFile);
    }

    //endregion

}
