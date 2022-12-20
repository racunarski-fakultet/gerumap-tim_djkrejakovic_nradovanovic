package rs.raf.gerumap.log.model;

/**
 * Logging messages
 */
public enum Message {

    /**
     * Message of type information notifying that an element has been added.
     */
    ADDED_ELEMENT(Severity.INFORMATION, "New element was added."),
    /**
     * Message of type information notifying that the mind map document has been added.
     */
    ADDED_MINDMAP(Severity.INFORMATION, "New mindmap was added."),
    /**
     * Message of type information notifying that the project has been added.
     */
    ADDED_PROJECT(Severity.INFORMATION, "New project was added."),

    /**
     * Message of type information notifying that an element has been renamed.
     */
    RENAMED_ELEMENT(Severity.INFORMATION, "Element was renamed."),
    /**
     * Message of type information notifying that the mind map document has been renamed.
     */
    RENAMED_MINDMAP(Severity.INFORMATION, "Mindmap was renamed."),
    /**
     * Message of type information notifying that the project has been renamed.
     */
    RENAMED_PROJECT(Severity.INFORMATION, "Project was renamed."),

    /**
     * Message of type information notifying that an element has been removed.
     */
    REMOVED_ELEMENT(Severity.INFORMATION, "Element was removed."),
    /**
     * Message of type information notifying that the mind map document has been removed.
     */
    REMOVED_MINDMAP(Severity.INFORMATION, "Mindmap was removed."),
    /**
     * Message of type information notifying that the project has been removed.
     */
    REMOVED_PROJECT(Severity.INFORMATION, "Project was removed."),

    /**
     * Message of type warning notifying that the icon could not be loaded.
     */
    UTILITY_ICON_NOT_FOUND      (Severity.WARNING, "Icon could not be loaded."),
    /**
     * Message of type warning notifying that the image could not be loaded.
     */
    UTILITY_IMAGE_NOT_FOUND     (Severity.WARNING, "Image could not be loaded."),
    /**
     * Message of type warning notifying that the keystrokes could not be loaded.
     */
    UTILITY_KEYSTROKES_NOT_FOUND(Severity.WARNING, "Keystrokes could not be loaded."),
    /**
     * Message of type warning notifying that the language could not be loaded.
     */
    UTILITY_LANGUAGE_NOT_FOUND  (Severity.WARNING, "Language could not be loaded."),
    /**
     * Message of type warning notifying that the preferences could not be cleared.
     */
    UTILITY_PREFERENCES_CLEARED (Severity.WARNING, "Preferences could not be cleared."),

    /**
     * Message of type error notifying an attempt to add a child to an element item.
     */
    EXPLORER_CANNOT_HAVE_CHILD  (Severity.ERROR, "ExplorerElementItem cannot have a child."),
    /**
     * Message of type error notifying an attempt to add an inappropriate child to an item.
     */
    EXPLORER_INCORRECT_CHILD    (Severity.ERROR, "ExplorerItem received an inappropriate child."),
    /**
     * Message of type error notifying an attempt to add an inappropriate node child to a node.
     */
    EXPLORER_INCORRECT_NODE     (Severity.ERROR, "ExplorerItem received an inappropriate node."),
    /**
     * Message of type error notifying that the project explorer is composed of the wrong items.
     */
    EXPLORER_INCORRECT_TREE_NODE(Severity.ERROR, "The explorer tree has item that is not of type ExplorerItem.");

    private final Severity severity;
    private final String message;

    Message(Severity severity, String message) {
        this.severity = severity;
        this.message = message;
    }

    /**
     * Returns the severity of the message.
     * @return message severity
     */
    public Severity getSeverity() {
        return severity;
    }

    /**
     * Returns a message text.
     * @return message text
     */
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "[" + severity + "] " + message;
    }

}
