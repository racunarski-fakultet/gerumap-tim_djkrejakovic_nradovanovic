package rs.raf.gerumap.gui.swing.util.prefs;

import rs.raf.gerumap.gui.swing.util.model.IconType;
import rs.raf.gerumap.gui.swing.util.model.KeyStrokes;
import rs.raf.gerumap.gui.swing.util.model.Language;
import rs.raf.gerumap.gui.swing.util.model.Theme;

import java.awt.Toolkit;

public class PreferenceDefaultValues {

    public static final boolean MAXIMIZED     = false;
    public static final int     WINDOW_HEIGHT = calculateWindowHeight();
    public static final int     WINDOW_WIDTH  = calculateWindowWidth();

    public static final String ICON_TYPE  = IconType.LIGHT.getId();
    public static final String KEYSTROKES = KeyStrokes.DEFAULT.getId();
    public static final String LANGUAGE   = Language.ENGLISH_US.getId();
    public static final String THEME      = Theme.FLAT_LAF_DARK.getId();

    private static int calculateWindowHeight() {
        return Toolkit.getDefaultToolkit().getScreenSize().height * 3 / 5;
    }

    private static int calculateWindowWidth() {
        return Toolkit.getDefaultToolkit().getScreenSize().width * 3 / 5;
    }

}
