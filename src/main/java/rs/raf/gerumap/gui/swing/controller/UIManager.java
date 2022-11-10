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

    public static void setupTheme(Theme theme) {
        FlatAnimatedLafChange.showSnapshot();

        ThemeUtils.setupTheme(theme);
        FlatLaf.updateUI();

        FlatAnimatedLafChange.hideSnapshotWithAnimation();

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
