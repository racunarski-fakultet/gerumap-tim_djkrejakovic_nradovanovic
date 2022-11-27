package rs.raf.gerumap.gui.swing.controller;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import rs.raf.gerumap.gui.swing.util.model.KeyStrokes;
import rs.raf.gerumap.gui.swing.util.model.Language;
import rs.raf.gerumap.gui.swing.util.model.Theme;
import rs.raf.gerumap.gui.swing.util.KeyStrokesUtils;
import rs.raf.gerumap.gui.swing.util.LanguageUtils;
import rs.raf.gerumap.gui.swing.util.PreferenceUtils;
import rs.raf.gerumap.gui.swing.util.ThemeUtils;

/**
 * Manages UI components.
 */
public class UIManager {

    //region Setup

    /**
     * Setups the UI components.
     */
    public static void setup() {
        setupTheme(PreferenceUtils.getTheme());
        setupLanguage(PreferenceUtils.getLanguage());
        setupKeyStrokes(PreferenceUtils.getKeyStrokes());
    }

    /**
     * Setups keystrokes.
     * @param keyStrokes keyStrokes
     */
    public static void setupKeyStrokes(KeyStrokes keyStrokes) {
        KeyStrokesUtils.loadKeyStrokes(keyStrokes);

        PreferenceUtils.putKeyStrokes(keyStrokes);

        ActionManager.setupKeyStrokes();
    }

    /**
     * Setups language.
     * @param language language
     */
    public static void setupLanguage(Language language) {
        LanguageUtils.loadLanguage(language);

        PreferenceUtils.putLanguage(language);

        ActionManager.setupNames();
        ActionManager.setupTooltips();
    }

    /**
     * Setups theme.
     * @param theme theme
     */
    public static void setupTheme(Theme theme) {
        FlatAnimatedLafChange.showSnapshot();

        ThemeUtils.setupTheme(theme);
        FlatLaf.updateUI();

        FlatAnimatedLafChange.hideSnapshotWithAnimation();

        PreferenceUtils.putTheme(theme);
    }

    //endregion

    /**
     * Returns the current application language.
     * @return language
     */
    public static Language getLanguage() {
        return PreferenceUtils.getLanguage();
    }

    /**
     * Returns the current application theme.
     * @return theme
     */
    public static Theme getTheme() {
        return PreferenceUtils.getTheme();
    }

    /**
     * Returns the current application keystrokes.
     * @return keystrokes
     */
    public static KeyStrokes getKeyStrokes() {
        return PreferenceUtils.getKeyStrokes();
    }

}
