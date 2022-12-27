package rs.raf.gerumap.log.model;

import javax.swing.JOptionPane;

/**
 * Message severity.
 */
public enum Severity {

    /**
     * Represents the severity of the error type.
     */
    ERROR      ("Error",   JOptionPane.ERROR_MESSAGE      ),
    /**
     * Represents the severity of the warning type.
     */
    WARNING    ("Warning", JOptionPane.WARNING_MESSAGE    ),
    /**
     * Represents the severity of the information type.
     */
    INFORMATION("Info",    JOptionPane.INFORMATION_MESSAGE);

    private final String type;
    private final int    swingMessageType;

    Severity(String type, int swingMessageType) {
        this.type = type;

        this.swingMessageType = swingMessageType;
    }

    /**
     * Returns the message type.
     * @return message type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the value associated with the swing message type.
     * @return swing message type
     */
    public int getSwingMessageType() {
        return swingMessageType;
    }

    @Override
    public String toString() {
        return type;
    }

}
