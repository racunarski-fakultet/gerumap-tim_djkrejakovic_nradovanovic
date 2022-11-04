package rs.raf.gerumap.gui.model;

public enum Theme {

    FLAT_LAF_DARK ("swing", "flatlaf" , "dark"),
    FLAT_LAF_LIGHT("swing", "flatlaf" , "light");

    private final String widget;
    private final String lookAndFeel;
    private final String name;

    Theme(String widget, String lookAndFeel, String name) {
        this.widget = widget;
        this.lookAndFeel = lookAndFeel;
        this.name = name;
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
        return lookAndFeel + "-" + name;
    }

    public String getThemeDir() {
        return widget + "/" + lookAndFeel;
    }

}
