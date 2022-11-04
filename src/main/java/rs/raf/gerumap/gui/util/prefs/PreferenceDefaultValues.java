package rs.raf.gerumap.gui.util.prefs;

import java.awt.Toolkit;

public class PreferenceDefaultValues {

    public static final boolean MAXIMIZED     = false;
    public static final int     WINDOW_HEIGHT = calculateWindowHeight();
    public static final int     WINDOW_WIDTH  = calculateWindowWidth();

    public static final String IMAGE_TYPE = null;
    public static final String KEYSTROKES = null;
    public static final String LANGUAGE   = null;
    public static final String THEME      = null;

    private static int calculateWindowHeight() {
        return Toolkit.getDefaultToolkit().getScreenSize().height / 2;
    }

    private static int calculateWindowWidth() {
        return Toolkit.getDefaultToolkit().getScreenSize().width / 2;
    }

}
