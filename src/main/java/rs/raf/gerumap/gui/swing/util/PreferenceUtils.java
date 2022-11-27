package rs.raf.gerumap.gui.swing.util;

import rs.raf.gerumap.gui.swing.util.model.IconType;
import rs.raf.gerumap.gui.swing.util.model.KeyStrokes;
import rs.raf.gerumap.gui.swing.util.model.Theme;
import rs.raf.gerumap.gui.swing.util.model.Language;
import rs.raf.gerumap.gui.swing.util.prefs.PreferenceDefaultValues;
import rs.raf.gerumap.gui.swing.util.prefs.PreferenceKeys;
import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;

import java.awt.Dimension;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * A utility that handles preferences.
 */
public class PreferenceUtils {

    private static final Preferences preferences = Preferences.userRoot().node(PreferenceUtils.class.getName());

    //region Put Values

    /**
     * Puts the size in the preferences.
     * @param size window size
     */
    public static void putWindowSize(Dimension size) {
        putWindowSize(size.height, size.width);
    }

    /**
     * Puts the size in the preferences.
     * @param height window height
     * @param width window width
     */
    public static void putWindowSize(int height, int width) {
        putWindowHeight(height);
        putWindowWidth(width);
    }

    /**
     * Puts the window height in the preferences.
     * @param height window height
     */
    public static void putWindowHeight(int height) {
        preferences.putInt(PreferenceKeys.WINDOW_HEIGHT, height);
    }

    /**
     * Puts the window width in the preferences.
     * @param width window width
     */
    public static void putWindowWidth(int width) {
        preferences.putInt(PreferenceKeys.WINDOW_WIDTH, width);
    }

    /**
     * Puts the maximized state in the preferences.
     * @param isMaximized maximized state
     */
    public static void putWindowMaximized(boolean isMaximized) {
        preferences.putBoolean(PreferenceKeys.MAXIMIZED, isMaximized);
    }

    /**
     * Puts the icon type in the preferences.
     * @param iconType icon type
     */
    public static void putIconType(IconType iconType) {
        preferences.put(PreferenceKeys.IMAGE_TYPE, iconType.getId());
    }

    /**
     * Puts the keystrokes in the preferences.
     * @param keyStrokes keystrokes
     */
    public static void putKeyStrokes(KeyStrokes keyStrokes) {
        preferences.put(PreferenceKeys.KEYSTROKES, keyStrokes.getId());
    }

    /**
     * Puts the language in the preferences.
     * @param language language
     */
    public static void putLanguage(Language language) {
        preferences.put(PreferenceKeys.LANGUAGE, language.getId());
    }

    /**
     * Puts the theme in the preferences.
     * @param theme theme
     */
    public static void putTheme(Theme theme) {
        preferences.put(PreferenceKeys.THEME, theme.getId());
    }

    //endregion

    //region Get Values

    /**
     * Returns the window size from the preferences.
     * @return window size
     */
    public static Dimension getWindowSize() {
        return new Dimension(getWindowWidth(), getWindowHeight());
    }

    /**
     * Returns the window height from the preferences.
     * @return window height
     */
    public static int getWindowHeight() {
        return preferences.getInt(PreferenceKeys.WINDOW_HEIGHT, PreferenceDefaultValues.WINDOW_HEIGHT);
    }

    /**
     * Returns the window width from the preferences.
     * @return window width
     */
    public static int getWindowWidth() {
        return preferences.getInt(PreferenceKeys.WINDOW_WIDTH, PreferenceDefaultValues.WINDOW_WIDTH);
    }

    /**
     * Returns whether window state is maximized from the preferences.
     * @return maximized state
     */
    public static boolean getWindowMaximized() {
        return preferences.getBoolean(PreferenceKeys.MAXIMIZED, PreferenceDefaultValues.MAXIMIZED);
    }

    /**
     * Returns the icon type from the preferences.
     * @return icon type
     */
    public static IconType getIconType() {
        return IconType.getIconType(preferences.get(PreferenceKeys.IMAGE_TYPE, PreferenceDefaultValues.ICON_TYPE));
    }

    /**
     * Returns the keystrokes from the preferences.
     * @return keystorkes
     */
    public static KeyStrokes getKeyStrokes() {
        return KeyStrokes.getKeyStrokes(preferences.get(PreferenceKeys.KEYSTROKES, PreferenceDefaultValues.KEYSTROKES));
    }

    /**
     * Returns the language from the preferences.
     * @return language
     */
    public static Language getLanguage() {
        return Language.getLanguage(preferences.get(PreferenceKeys.LANGUAGE, PreferenceDefaultValues.LANGUAGE));
    }

    /**
     * Returns the theme from the preferences.
     * @return theme
     */
    public static Theme getTheme() {
        return Theme.getTheme(preferences.get(PreferenceKeys.THEME, PreferenceDefaultValues.THEME));
    }

    //endregion

    /**
     * Removes all the preferences.
     */
    public static void clear() {
        try {
            preferences.clear();
        }
        catch (BackingStoreException e) {
            Logger.log(Message.UTILITY_PREFERENCES_CLEARED);
        }
    }

}
