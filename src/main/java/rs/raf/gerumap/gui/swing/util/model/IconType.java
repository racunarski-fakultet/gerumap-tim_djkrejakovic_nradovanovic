package rs.raf.gerumap.gui.swing.util.model;

public enum IconType {

    /**
     * Dark icon type.
     */
    DARK ("dark"),
    /**
     * Light icon type.
     */
    LIGHT("light"),
    COLOR("color");

    private final String id;

    IconType(String id) {
        this.id = id;
    }

    /**
     * Returns IconType based on identifier.
     * @param iconTypeId icon type id
     * @return icon type
     */
    public static IconType getIconType(String iconTypeId) {
        for (IconType iconType : IconType.values())
            if (iconType.getId().equals(iconTypeId))
                return iconType;

        System.err.println("Image type not found: " + iconTypeId);

        return DARK;
    }

    /**
     * Returns the icon identifier.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the icon type directory.
     * @return id
     */
    public String getIconDir() {
        return id;
    }

}

