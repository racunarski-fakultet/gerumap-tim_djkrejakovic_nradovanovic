package rs.raf.gerumap.gui.model;

public enum IconType {

    DARK ("dark"),
    LIGHT("light"),
    COLOR("color");

    private final String id;

    IconType(String id) {
        this.id = id;
    }

    public static IconType getIconType(String iconTypeId) {
        for (IconType iconType : IconType.values())
            if (iconType.getId().equals(iconTypeId))
                return iconType;

        System.err.println("Image type not found: " + iconTypeId);

        return DARK;
    }

    public String getId() {
        return id;
    }

    public String getIconDir() {
        return id;
    }

}

