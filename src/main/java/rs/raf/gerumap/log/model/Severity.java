package rs.raf.gerumap.log.model;

/**
 * Message severity.
 */
public enum Severity {

    /**
     * Represents the severity of the error type.
     */
    ERROR      ("Error"),
    /**
     * Represents the severity of the warning type.
     */
    WARNING    ("Warning"),
    /**
     * Represents the severity of the information type.
     */
    INFORMATION("Info");

    private final String type;

    Severity(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

}
