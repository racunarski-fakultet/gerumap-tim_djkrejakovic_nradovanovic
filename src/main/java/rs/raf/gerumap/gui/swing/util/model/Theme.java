package rs.raf.gerumap.gui.swing.util.model;

public enum Theme {

    /**
     * FlatLaF Dark theme.
     */
    FLAT_LAF_DARK ("Dark", "swing", "flatlaf", "com.formdev.flatlaf.FlatDarkLaf"),
    /**
     * FlatLaF Light theme.
     */
    FLAT_LAF_LIGHT("Light", "swing", "flatlaf" , "com.formdev.flatlaf.FlatLightLaf");

    private final String widget;
    private final String lookAndFeel;
    private final String name;
    private final String className;

    Theme(String name, String widget, String lookAndFeel, String className) {
        this.name = name;
        this.widget = widget;
        this.lookAndFeel = lookAndFeel;
        this.className = className;
    }

    /**
     * Returns Theme based on identifier.
     * @param themeId theme id
     * @return theme
     */
    public static Theme getTheme(String themeId) {
        for (Theme theme : Theme.values())
            if (theme.getId().equals(themeId))
                return theme;

        System.err.println("Theme not found: " + themeId);

        return FLAT_LAF_DARK;
    }

    /**
     * Returns a theme widget.
     * @return widget
     */
    public String getWidget() {
        return widget;
    }

    /**
     * Returns the theme identifier.
     * @return id
     */
    public String getId() {
        return lookAndFeel + "-" + name.toLowerCase();
    }

    /**
     * Returns the theme's display name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the theme class name.
     * @return class name
     */
    public String getClassName() {
        return className;
    }

    /**
     * Returns the theme directory.
     * @return directory
     */
    public String getThemeDir() {
        return widget + "/" + lookAndFeel;
    }

}
