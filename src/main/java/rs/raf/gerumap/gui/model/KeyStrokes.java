package rs.raf.gerumap.gui.model;

public enum KeyStrokes {

    DEFAULT("Default");

    private final String id;

    KeyStrokes(String id) {
        this.id = id;
    }

    public static KeyStrokes getKeyStrokes(String keyStrokesId) {
        for (KeyStrokes keyStrokes : KeyStrokes.values())
            if (keyStrokes.getId().equals(keyStrokesId))
                return keyStrokes;

        System.err.println("Keystrokes not found: " + keyStrokesId);

        return DEFAULT;
    }

    public String getId() {
        return id;
    }

}
