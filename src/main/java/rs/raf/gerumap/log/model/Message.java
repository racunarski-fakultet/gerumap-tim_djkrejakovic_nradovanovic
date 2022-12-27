package rs.raf.gerumap.log.model;

/**
 * Logging messages
 */
public enum Message {

    /**
     * Message of type information notifying that an element has been added.
     */
    ADDED_ELEMENT(Severity.INFORMATION, "New element was added", false, false),
    /**
     * Message of type information notifying that the mind map document has been added.
     */
    ADDED_MINDMAP(Severity.INFORMATION, "New mindmap was added", false, false),
    /**
     * Message of type information notifying that the project has been added.
     */
    ADDED_PROJECT(Severity.INFORMATION, "New project was added", false, false),

    /**
     * Message of type information notifying that an element has been renamed.
     */
    RENAMED_ELEMENT(Severity.INFORMATION, "Element was renamed", false, false),
    /**
     * Message of type information notifying that the mind map document has been renamed.
     */
    RENAMED_MINDMAP(Severity.INFORMATION, "Mindmap was renamed", false, false),
    /**
     * Message of type information notifying that the project has been renamed.
     */
    RENAMED_PROJECT(Severity.INFORMATION, "Project was renamed", false, false),

    /**
     * Message of type information notifying that an element has been removed.
     */
    REMOVED_ELEMENT(Severity.INFORMATION, "Element was removed", false, false),
    /**
     * Message of type information notifying that the mind map document has been removed.
     */
    REMOVED_MINDMAP(Severity.INFORMATION, "Mindmap was removed", false, false),
    /**
     * Message of type information notifying that the project has been removed.
     */
    REMOVED_PROJECT(Severity.INFORMATION, "Project was removed", false, false),

    /**
     * Message of type warning notifying that the icon could not be loaded.
     */
    UTILITY_ICON_NOT_FOUND      (Severity.WARNING, "Icon could not be loaded",         false, false),
    /**
     * Message of type warning notifying that the image could not be loaded.
     */
    UTILITY_IMAGE_NOT_FOUND     (Severity.WARNING, "Image could not be loaded",        false, false),
    /**
     * Message of type warning notifying that the keystrokes could not be loaded.
     */
    UTILITY_KEYSTROKES_NOT_FOUND(Severity.WARNING, "Keystrokes could not be loaded",   false, false),
    /**
     * Message of type warning notifying that the language could not be loaded.
     */
    UTILITY_LANGUAGE_NOT_FOUND  (Severity.WARNING, "Language could not be loaded",     false, false),
    /**
     * Message of type warning notifying that the preferences could not be cleared.
     */
    UTILITY_PREFERENCES_CLEARED (Severity.WARNING, "Preferences could not be cleared", false, false),

    /**
     * Message of type error notifying an attempt to add a child to an element item.
     */
    EXPLORER_CANNOT_HAVE_CHILD  (Severity.ERROR, "ExplorerElementItem cannot have a child",                     false, false),
    /**
     * Message of type error notifying an attempt to add an inappropriate child to an item.
     */
    EXPLORER_INCORRECT_CHILD    (Severity.ERROR, "ExplorerItem received an inappropriate child",                false, false),
    /**
     * Message of type error notifying an attempt to add an inappropriate node child to a node.
     */
    EXPLORER_INCORRECT_NODE     (Severity.ERROR, "ExplorerItem received an inappropriate node",                 false, false),
    /**
     * Message of type error notifying that the project explorer is composed of the wrong items.
     */
    EXPLORER_INCORRECT_TREE_NODE(Severity.ERROR, "The explorer tree has item that is not of type ExplorerItem", false, false),

    /**
     * Message of type information notifying that the graphic elements are intersecting.
     */
    EDITOR_GRAPHIC_ELEMENTS_INTERSECTED(Severity.INFORMATION, "Elements cannot intersect",       false, true),
    /**
     * Message of type information notifying that only one graphic element can be the central element.
     */
    EDITOR_ONE_CENTRAL_CONCEPT         (Severity.INFORMATION, "Only one element can be central", false, true),
    /**
     * Message of type information notifying that the graphic connection cannot become the central element.
     */
    EDITOR_CONNECTION_NOT_CENTRAL      (Severity.INFORMATION, "Connection cannot be central",    false, true),

    /**
     * Message of type error notifying that the project it is trying to load has a name that matches the name of an open project,
     * while the projects are not the same.
     */
    DESERIALIZATION_PROJECT_NAME_EXISTS (Severity.ERROR, "Project with same name already exists",  true, false),
    /**
     * Message of type error notifying that the mind map (template) it is trying to load has a name that matches the name of an open mind map,
     * while the mind maps are not the same.
     */
    DESERIALIZATION_TEMPLATE_NAME_EXISTS(Severity.ERROR, "Mind map with same name already exists", true, false);

    private final Severity severity;
    private final String   message;
    private final boolean  isEditorMessage;
    private final boolean  isApplicationMessage;

    Message(Severity severity, String message, boolean isApplicationMessage, boolean isEditorMessage) {
        this.severity = severity;
        this.message  = message;

        this.isEditorMessage      = isEditorMessage;
        this.isApplicationMessage = isApplicationMessage;
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

    /**
     * Returns true if the message should be logged in the editor, false otherwise.
     * @return true if it is editor message, false otherwise
     */
    public boolean isEditorMessage() {
        return isEditorMessage;
    }

    /**
     * Returns true if the message should be logged in the application, false otherwise.
     * @return true if it is application message, false otherwise
     */
    public boolean isApplicationMessage() {
        return isApplicationMessage;
    }

    @Override
    public String toString() {
        return "[" + severity + "] " + message;
    }

}
