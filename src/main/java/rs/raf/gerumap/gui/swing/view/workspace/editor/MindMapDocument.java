package rs.raf.gerumap.gui.swing.view.workspace.editor;

import javax.swing.JPanel;
import java.awt.Color;

/**
 * Mindmap document.
 */
public class MindMapDocument {

    private String name;
    private JPanel content;

    /**
     * Creates a mindmap document.
     * @param name name
     */
    public MindMapDocument(String name) {
        this(name, new JPanel());
        content.setBackground(new Color(52, 53, 54));
    }

    /**
     * Creates a mindmap document.
     * @param name name
     * @param editor editor
     */
    public MindMapDocument(String name, JPanel editor) {
        this.name    = name;
        this.content = editor;
    }

    /**
     * Sets the content of the document.
     * @param content content
     */
    public void setContent(JPanel content) {
        this.content = content;
    }

    /**
     * Sets the name of the document.
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the content.
     * @return content
     */
    public JPanel getContent() {
        return content;
    }

    /**
     * Returns the name.
     * @return name
     */
    public String getName() {
        return name;
    }

}
