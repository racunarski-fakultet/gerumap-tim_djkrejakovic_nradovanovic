package rs.raf.gerumap.gui.swing.view.workspace.editor;

import javax.swing.JPanel;
import java.awt.Color;

public class MindMapDocument {

    private String name;
    private JPanel content;

    public MindMapDocument(String name) {
        this(name, new JPanel());
        content.setBackground(new Color(52, 53, 54));
    }

    public MindMapDocument(String name, JPanel editor) {
        this.name    = name;
        this.content = editor;
    }

    public void setContent(JPanel content) {
        this.content = content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JPanel getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

}
