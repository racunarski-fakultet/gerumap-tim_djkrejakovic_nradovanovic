package rs.raf.gerumap.gui.swing.view.workspace.editor.view;

import rs.raf.gerumap.gui.swing.view.workspace.editor.controller.EditorFocusMouseListener;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.properties.DiagramProperties;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.properties.PropertiesBase;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

public class EditorProperties extends JPanel {

    private final JLabel labelTitle = new JLabel("Properties");
    private PropertiesBase activeProperties;

    public EditorProperties() {
        setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(52, 53, 54)));
        setPreferredSize(new Dimension(240, 0));

        labelTitle.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(52, 53, 54)),
                                                                BorderFactory.createEmptyBorder(0, 0, 5, 0)));
        labelTitle.setPreferredSize(new Dimension(240, 28));
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);

        add(labelTitle);

        addMouseListener(new EditorFocusMouseListener());
    }

    /**
     * Sets the current properties view.
     * @param properties properties
     */
    public void setProperties(PropertiesBase properties) {
        if (activeProperties != null)
            remove(activeProperties);

        add(activeProperties = properties);

        validate();
        repaint();
    }

    /**
     * Gives focus to the component.
     */
    public void getFocus() {
        activeProperties.getFocus();
    }

    /**
     * Reloads the properties.
     */
    public void reload() {
        activeProperties.setup();
    }

    /**
     * Resets the properties.
     */
    public void reset() {
        setProperties(new DiagramProperties());
    }

}
