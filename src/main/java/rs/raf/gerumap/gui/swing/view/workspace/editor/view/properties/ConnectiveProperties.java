package rs.raf.gerumap.gui.swing.view.workspace.editor.view.properties;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.custom.GRMapSpinner;
import rs.raf.gerumap.gui.swing.view.workspace.editor.EditorValues;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.IStroke;

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
import java.util.ArrayList;
import java.util.List;

public class ConnectiveProperties extends PropertiesBase {

    private JLabel labelStrokeColor;
    private JLabel labelStrokeHex;
    private JLabel labelStrokeWidth;

    private JTextField textStrokeHex;

    private JPanel paneStrokeColor;

    private JSpinner spinnerStrokeWidth;

    private final List<IStroke> elements = new ArrayList<>();

    public ConnectiveProperties() {
        initialize();
        setup();
        addListeners();

        add(labelStrokeColor, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(12, 12, 8,  4), 0, 0));
        add(paneStrokeColor,  new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(12,  4, 8,  5), 0, 0));
        add(labelStrokeHex,   new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(12,  5, 8,  4), 0, 0));
        add(textStrokeHex,    new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(12,  4, 8, 12), 0, 0));

        add(labelStrokeWidth,   new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(8, 12, 12, 4), 0, 0));
        add(spinnerStrokeWidth, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(8,  4, 12, 5), 0, 0));
    }

    /**
     * Initializes components of the properties.
     */
    private void initialize() {
        labelStrokeColor = new JLabel(EditorValues.PROPERTIES_STROKE_IDENTIFIER);
        labelStrokeHex   = new JLabel(EditorValues.PROPERTIES_HEXADECIMAL_IDENTIFIER);
        labelStrokeWidth = new JLabel(EditorValues.PROPERTIES_STROKE_WIDTH_IDENTIFIER);

        textStrokeHex = new JTextField();
        textStrokeHex.setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);

        paneStrokeColor = new JPanel();
        paneStrokeColor.setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);

        spinnerStrokeWidth = new GRMapSpinner(EditorValues.GRAPHIC_ELEMENT_STROKE_MULTIPLIER);
        spinnerStrokeWidth.setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);
    }

    /**
     * Assigns listeners to components
     */
    private void addListeners() {
        paneStrokeColor.addMouseListener(new StrokeColorMouseListener());

        spinnerStrokeWidth.addChangeListener(new StrokeWidthChangeListener());
    }

    //region Setup

    @Override
    public void setup() {
        setupSelectedElements();

        if (elements.isEmpty())
            return; //TODO - Error - cannot be empty

        setupStroke();
        setupStrokeWidth();
    }

    private void setupSelectedElements() {
        elements.clear();
        elements.addAll(SelectionManager.getSelectedStrokes());
    }

    private void setupStroke() {
        Color color = null;

        for (IStroke element : elements) {
            Color stroke = element.getStrokeColor();

            if (color != null && !stroke.equals(color)) {
                color = null;
                break;
            }

            if (color == null)
                color = stroke;
        }

        color = color != null ? color : EditorValues.CONCEPT_STROKE_COLOR;

        paneStrokeColor.setBackground(color);
        textStrokeHex.setText(colorToHex(color));
    }

    private void setupStrokeWidth() {
        Integer value = null;

        for (IStroke element : elements) {
            Integer width = (int) element.getStrokeWidth();

            if (value != null && !width.equals(value)) {
                value = null;
                break;
            }

            if (value == null)
                value = width;
        }

        spinnerStrokeWidth.setValue(value != null ? value : EditorValues.CONCEPT_STROKE_WIDTH.intValue());
    }

    //endregion

    @Override
    public void getFocus() { }

    //region Listeners

    private class StrokeColorMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent event) {
            Color color = JColorChooser.showDialog(MainWindow.window, "Select a color", paneStrokeColor.getBackground());

            if (color == null)
                return;

            for (IStroke element : elements)
                element.setStrokeColor(color);

            paneStrokeColor.setBackground(color);
            textStrokeHex.setText(colorToHex(color));

            editor.render();
        }

    }

    private class StrokeWidthChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent event) {
            int value = (int) spinnerStrokeWidth.getValue();

            for (IStroke element : elements)
                element.setStrokeWidth(value);

            editor.render();
        }

    }

    //endregion

}
