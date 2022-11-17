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

    public static void putIconType(IconType iconType) {
        preferences.put(PreferenceKeys.IMAGE_TYPE, iconType.getId());
    }

    public static void putKeyStrokes(KeyStrokes keyStrokes) {
        preferences.put(PreferenceKeys.KEYSTROKES, keyStrokes.getId());
    }

    public static void putLanguage(Language language) {
        preferences.put(PreferenceKeys.LANGUAGE, language.getId());
    }

    public static void putTheme(Theme theme) {
        preferences.put(PreferenceKeys.THEME, theme.getId());
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

    public static IconType getIconType() {
        return IconType.getIconType(preferences.get(PreferenceKeys.IMAGE_TYPE, PreferenceDefaultValues.ICON_TYPE));
    }

    public static KeyStrokes getKeyStrokes() {
        return KeyStrokes.getKeyStrokes(preferences.get(PreferenceKeys.KEYSTROKES, PreferenceDefaultValues.KEYSTROKES));
    }

    public static Language getLanguage() {
        return Language.getLanguage(preferences.get(PreferenceKeys.LANGUAGE, PreferenceDefaultValues.LANGUAGE));
    }

    public static Theme getTheme() {
        return Theme.getTheme(preferences.get(PreferenceKeys.THEME, PreferenceDefaultValues.THEME));
    }

    //endregion

    public static void clear() {
        try {
            preferences.clear();
        }
        catch (BackingStoreException e) {
            Logger.log(Message.UTILITY_PREFERENCES_CLEARED);
        }
    }

}
