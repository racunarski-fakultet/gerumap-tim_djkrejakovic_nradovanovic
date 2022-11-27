package rs.raf.gerumap.gui.swing.util.model;

/**
 * Keystrokes type
 */
public enum KeyStrokes {

    /**
     * Default GeRuMap keystrokes.
     */
    DEFAULT("Default");

    private final String id;

    KeyStrokes(String id) {
        this.id = id;
    }

    /**
     * Returns KeyStrokes based on identifier.
     * @param keyStrokesId keystrokes id
     * @return keystrokes
     */
    public static KeyStrokes getKeyStrokes(String keyStrokesId) {
        for (KeyStrokes keyStrokes : KeyStrokes.values())
            if (keyStrokes.getId().equals(keyStrokesId))
                return keyStrokes;

        System.err.println("Keystrokes not found: " + keyStrokesId);

        return DEFAULT;
    }

    /**
     * Returns the keystrokes identifier.
     * @return id
     */
    public String getId() {
        return id;
    }

}
