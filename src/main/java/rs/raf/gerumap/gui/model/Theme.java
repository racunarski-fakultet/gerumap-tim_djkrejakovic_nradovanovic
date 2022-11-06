package rs.raf.gerumap.gui.model;

public enum Theme {

    FLAT_LAF_DARK ("Dark", "swing", "flatlaf", "com.formdev.flatlaf.FlatDarkLaf"),
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

    public static Theme getTheme(String themeId) {
        for (Theme theme : Theme.values())
            if (theme.getId().equals(themeId))
                return theme;

        System.err.println("Theme not found: " + themeId);

        return FLAT_LAF_DARK;
    }

    public String getWidget() {
        return widget;
    }

    public String getId() {
        return lookAndFeel + "-" + name.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public String getThemeDir() {
        return widget + "/" + lookAndFeel;
    }

}
