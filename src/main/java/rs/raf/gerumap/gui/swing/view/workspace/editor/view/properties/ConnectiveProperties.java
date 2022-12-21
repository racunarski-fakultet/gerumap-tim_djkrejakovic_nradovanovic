package rs.raf.gerumap.gui.swing.view.workspace.editor.view.properties;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.controller.comands.ChangeElementsStrokeColorCommand;
import rs.raf.gerumap.gui.swing.controller.comands.ChangeElementsStrokeWidthCommand;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.custom.GRMapColorButton;
import rs.raf.gerumap.gui.swing.view.custom.GRMapSpinner;
import rs.raf.gerumap.gui.swing.view.workspace.editor.EditorValues;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.IStroke;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ConnectiveProperties extends PropertiesBase {

    private JLabel labelStrokeColor;
    private JLabel labelStrokeHex;
    private JLabel labelStrokeWidth;

    private JTextField textStrokeHex;

    private GRMapColorButton paneStrokeColor;

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

        paneStrokeColor = new GRMapColorButton();
        paneStrokeColor.setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);

        spinnerStrokeWidth = new GRMapSpinner(EditorValues.PROPERTIES_ELEMENT_STROKE_MULTIPLIER);
        spinnerStrokeWidth.setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);
    }

    /**
     * Assigns listeners to components
     */
    private void addListeners() {
        paneStrokeColor.addActionListener(new StrokeColorActionListener());

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

        paneStrokeColor.setColor(color);
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

    private class StrokeColorActionListener extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent event) {
            Color color = JColorChooser.showDialog(MainWindow.window, "Select a color", paneStrokeColor.getColor());

            if (color == null)
                return;

            editor.getCommandManager().addCommand(new ChangeElementsStrokeColorCommand(elements, color));

            paneStrokeColor.setColor(color);
            textStrokeHex.setText(colorToHex(color));
        }

    }

    private class StrokeWidthChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent event) {
            editor.getCommandManager().addCommand(new ChangeElementsStrokeWidthCommand(elements, (Integer) spinnerStrokeWidth.getValue()));
        }

    }

    //endregion

}
