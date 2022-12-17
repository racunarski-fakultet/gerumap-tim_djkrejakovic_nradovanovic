package rs.raf.gerumap.gui.swing.view.workspace.editor.view.properties;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.custom.GRMapSpinner;
import rs.raf.gerumap.gui.swing.view.workspace.editor.EditorValues;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DiagramProperties extends PropertiesBase {

    private JLabel labelWidth;
    private JLabel labelHeight;
    private JLabel labelBackground;
    private JLabel labelHex;

    private JTextField textHex;

    private JPanel paneBackground;

    private JSpinner spinnerWidth;
    private JSpinner spinnerHeight;

    public DiagramProperties() {
        initialize();
        setup();
        addListeners();

        add(labelWidth,    new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(16, 12, 8,  4), 0, 0));
        add(spinnerWidth,  new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(16,  4, 8,  5), 0, 0));
        add(labelHeight,   new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(16,  5, 8,  4), 0, 0));
        add(spinnerHeight, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(16,  4, 8, 12), 0, 0));

        add(labelBackground, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(8, 12, 16,  4), 0, 0));
        add(paneBackground,  new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(8,  4, 16,  5), 0, 0));
        add(labelHex,        new GridBagConstraints(2, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(8,  5, 16,  4), 0, 0));
        add(textHex,         new GridBagConstraints(3, 1, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(8,  4, 16, 12), 0, 0));
    }

    /**
     * Initializes components of the properties.
     */
    private void initialize() {
        labelWidth      = new JLabel(EditorValues.PROPERTIES_WIDTH_IDENTIFIER);
        labelHeight     = new JLabel(EditorValues.PROPERTIES_HEIGHT_IDENTIFIER);
        labelBackground = new JLabel(EditorValues.PROPERTIES_BACKGROUND_IDENTIFIER);
        labelHex        = new JLabel(EditorValues.PROPERTIES_HEXADECIMAL_IDENTIFIER);

        textHex = new JTextField();
        textHex.setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);

        paneBackground = new JPanel();
        paneBackground.setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);
        paneBackground.setBorder(BorderFactory.createLineBorder(new Color(97, 99, 101)));

        spinnerWidth  = new GRMapSpinner(EditorValues.PROPERTIES_DIAGRAM_WIDTH_MULTIPLIER);
        spinnerHeight = new GRMapSpinner(EditorValues.PROPERTIES_DIAGRAM_HEIGHT_MULTIPLIER);

        spinnerWidth .setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);
        spinnerHeight.setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);
    }

    /**
     * Assigns listeners to components
     */
    private void addListeners() {
        paneBackground.addMouseListener(new BackgroundMouseListener());

        spinnerWidth .addChangeListener(new WidthChangeListener());
        spinnerHeight.addChangeListener(new HeightChangeListener());
    }

    @Override
    public void setup() {
        int diagramWidth  = editor.getDiagram().getActualWidth();
        int diagramHeight = editor.getDiagram().getActualHeight();

        Color diagramBackground = editor.getDiagram().getBackground();

        paneBackground.setBackground(diagramBackground);
        textHex.setText(colorToHex(diagramBackground));
        spinnerWidth.setValue(diagramWidth);
        spinnerHeight.setValue(diagramHeight);
    }

    @Override
    public void getFocus() { }

    //region Listeners

    private class WidthChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent event) {
            editor.getDiagram().setActualWidth((Integer) spinnerWidth.getValue());
        }

    }

    private class HeightChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent event) {
            editor.getDiagram().setActualHeight((Integer) spinnerHeight.getValue());
        }

    }

    private class BackgroundMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent event) {
            Color color = JColorChooser.showDialog(MainWindow.window, "Select a color", paneBackground.getBackground());

            if (color == null)
                return;

            editor.getDiagram().setBackground(color);
            paneBackground.setBackground(color);
            textHex.setText(colorToHex(color));
        }

    }

    //endregion

}
