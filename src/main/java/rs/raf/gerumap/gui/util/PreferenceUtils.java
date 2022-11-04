package rs.raf.gerumap.gui.util;

import rs.raf.gerumap.gui.util.prefs.PreferenceDefaultValues;
import rs.raf.gerumap.gui.util.prefs.PreferenceKeys;

import java.awt.Dimension;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PreferenceUtils {

    private static final Preferences preferences = Preferences.userRoot().node(PreferenceUtils.class.getName());

    //region Put Values

    public static void putWindowSize(Dimension size) {
        putWindowSize(size.height, size.width);
    }

    public static void putWindowSize(int height, int width) {
        putWindowHeight(height);
        putWindowWidth(width);
    }

    public static void putWindowHeight(int height) {
        preferences.putInt(PreferenceKeys.WINDOW_HEIGHT, height);
    }

    public static void putWindowWidth(int width) {
        preferences.putInt(PreferenceKeys.WINDOW_WIDTH, width);
    }

    public static void putWindowMaximized(boolean isMaximized) {
        preferences.putBoolean(PreferenceKeys.MAXIMIZED, isMaximized);
    }

    public static void putImageType(String imageType) {
        preferences.put(PreferenceKeys.IMAGE_TYPE, imageType);
    }

    public static void putKeyStrokes(String keyStrokes) {
        preferences.put(PreferenceKeys.KEYSTROKES, keyStrokes);
    }

    public static void putLanguage(String language) {
        preferences.put(PreferenceKeys.LANGUAGE, language);
    }

    public static void putTheme(String theme) {
        preferences.put(PreferenceKeys.THEME, theme);
    }

    //endregion

    //region Get Values

    public static Dimension getWindowSize() {
        return new Dimension(getWindowWidth(), getWindowHeight());
    }

    public static int getWindowHeight() {
        return preferences.getInt(PreferenceKeys.WINDOW_HEIGHT, PreferenceDefaultValues.WINDOW_HEIGHT);
    }

    public static int getWindowWidth() {
        return preferences.getInt(PreferenceKeys.WINDOW_WIDTH, PreferenceDefaultValues.WINDOW_WIDTH);
    }

    public static boolean getWindowMaximized() {
        return preferences.getBoolean(PreferenceKeys.MAXIMIZED, PreferenceDefaultValues.MAXIMIZED);
    }

    public static String getImageType() {
        return preferences.get(PreferenceKeys.IMAGE_TYPE, PreferenceDefaultValues.IMAGE_TYPE);
    }

    public static String getKeyStrokes() {
        return preferences.get(PreferenceKeys.KEYSTROKES, PreferenceDefaultValues.KEYSTROKES);
    }

    public static String getLanguage() {
        return preferences.get(PreferenceKeys.LANGUAGE, PreferenceDefaultValues.LANGUAGE);
    }

    public static String getTheme() {
        return preferences.get(PreferenceKeys.THEME, PreferenceDefaultValues.THEME);
    }

    //endregion

    public static void clear() {
        try {
            preferences.clear();
        }
        catch (BackingStoreException e) {
            System.err.println("Preferences can not be cleared: " + e.getMessage());
        }
    }

}
