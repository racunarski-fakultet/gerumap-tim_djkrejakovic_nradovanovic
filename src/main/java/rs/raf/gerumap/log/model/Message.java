package rs.raf.gerumap.log.model;

public enum Message {

    ADDED_ELEMENT(Severity.INFORMATION, "New element was added."),
    ADDED_MINDMAP(Severity.INFORMATION, "New mindmap was added."),
    ADDED_PROJECT(Severity.INFORMATION, "New project was added."),

    RENAMED_ELEMENT(Severity.INFORMATION, "Element was renamed."),
    RENAMED_MINDMAP(Severity.INFORMATION, "Mindmap was renamed."),
    RENAMED_PROJECT(Severity.INFORMATION, "Project was renamed."),

    REMOVED_ELEMENT(Severity.INFORMATION, "Element was removed."),
    REMOVED_MINDMAP(Severity.INFORMATION, "Mindmap was removed."),
    REMOVED_PROJECT(Severity.INFORMATION, "Project was removed."),

    UTILITY_ICON_NOT_FOUND      (Severity.WARNING, "Icon could not be loaded."),
    UTILITY_IMAGE_NOT_FOUND     (Severity.WARNING, "Image could not be loaded."),
    UTILITY_KEYSTROKES_NOT_FOUND(Severity.WARNING, "Keystrokes could not be loaded."),
    UTILITY_LANGUAGE_NOT_FOUND  (Severity.WARNING, "Language could not be loaded."),
    UTILITY_PREFERENCES_CLEARED (Severity.WARNING, "Preferences could not be cleared."),

    EXPLORER_CANNOT_HAVE_CHILD  (Severity.ERROR, "ExplorerElementItem cannot have a child."),
    EXPLORER_INCORRECT_CHILD    (Severity.ERROR, "ExplorerItem received an inappropriate child."),
    EXPLORER_INCORRECT_NODE     (Severity.ERROR, "ExplorerItem received an inappropriate node."),
    EXPLORER_INCORRECT_TREE_NODE(Severity.ERROR, "The explorer tree has item that is not of type ExplorerItem."),

    ;

    private Severity severity;
    private String message;

    Message(Severity severity, String message) {
        this.severity = severity;
        this.message = message;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "[" + severity + "] " + message;
    }

}
