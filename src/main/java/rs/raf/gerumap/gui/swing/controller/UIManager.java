package rs.raf.gerumap.gui.swing.controller;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import rs.raf.gerumap.gui.swing.util.FontUtils;
import rs.raf.gerumap.gui.swing.util.KeyStrokesUtils;
import rs.raf.gerumap.gui.swing.util.LanguageUtils;
import rs.raf.gerumap.gui.swing.util.PreferenceUtils;
import rs.raf.gerumap.gui.swing.util.ThemeUtils;
import rs.raf.gerumap.gui.swing.util.model.KeyStrokes;
import rs.raf.gerumap.gui.swing.util.model.Language;
import rs.raf.gerumap.gui.swing.util.model.Theme;

public class UIManager {

    //region Setup

    /**
     * Setups the UI components.
     */
    public static void setup() {
        setupTheme(PreferenceUtils.getTheme());
        setupLanguage(PreferenceUtils.getLanguage());
        setupKeyStrokes(PreferenceUtils.getKeyStrokes());
        setupFonts();
        setupState();
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

        ActionManager.setupIcons();
    }

    /**
     * Setups the fonts.
     */
    public static void setupFonts() {
        FontUtils.loadFonts();
    }

    /**
     * Setups the editor state.
     */
    public static void setupState() {
        StateManager.setup();
    }

    //endregion

}
