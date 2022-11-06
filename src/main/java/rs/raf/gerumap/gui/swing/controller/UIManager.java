package rs.raf.gerumap.gui.swing.controller;

import rs.raf.gerumap.gui.model.KeyStrokes;
import rs.raf.gerumap.gui.model.Language;
import rs.raf.gerumap.gui.model.Theme;
import rs.raf.gerumap.gui.util.KeyStrokesUtils;
import rs.raf.gerumap.gui.util.LanguageUtils;
import rs.raf.gerumap.gui.util.PreferenceUtils;
import rs.raf.gerumap.gui.util.ThemeUtils;

public class UIManager {

    //region Setup

    public static void setup() {
        setupTheme(PreferenceUtils.getTheme());
        setupLanguage(PreferenceUtils.getLanguage());
        setupKeyStrokes(PreferenceUtils.getKeyStrokes());
    }

    public static void setupKeyStrokes(KeyStrokes keyStrokes) {
        KeyStrokesUtils.LoadKeyStrokes(keyStrokes);

        PreferenceUtils.putKeyStrokes(keyStrokes);
    }

    public static void setupLanguage(Language language) {
        LanguageUtils.loadLanguage(language);

        PreferenceUtils.putLanguage(language);

        ActionManager.setupNames();
        ActionManager.setupTooltips();
    }

    //TODO FlatLaf setup
    public static void setupTheme(Theme theme) {
        ThemeUtils.setupTheme(theme);

        PreferenceUtils.putTheme(theme);
    }

    //endregion

    public static Language getLanguage() {
        return PreferenceUtils.getLanguage();
    }

    public static Theme getTheme() {
        return PreferenceUtils.getTheme();
    }

    public static KeyStrokes getKeyStrokes() {
        return PreferenceUtils.getKeyStrokes();
    }

}
