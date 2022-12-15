package rs.raf.gerumap.gui.swing.view.workspace.editor.view.properties;

import rs.raf.gerumap.gui.swing.controller.SelectionManager;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.custom.GRMapSpinner;
import rs.raf.gerumap.gui.swing.view.workspace.editor.EditorValues;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConcept;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ConceptProperties extends PropertiesBase {

    private JLabel labelWidth;
    private JLabel labelHeight;
    private JLabel labelContent;
    private JLabel labelContentColor;
    private JLabel labelContentHex;
    private JLabel labelFillColor;
    private JLabel labelFillHex;
    private JLabel labelStrokeColor;
    private JLabel labelStrokeHex;
    private JLabel labelStrokeWidth;

    private JTextField textContent;
    private JTextField textForegroundHex;
    private JTextField textBackgroundHex;
    private JTextField textStrokeHex;

    private JPanel paneForeground;
    private JPanel paneBackground;
    private JPanel paneStroke;

    private JSpinner spinnerWidth;
    private JSpinner spinnerHeight;
    private JSpinner spinnerStrokeWidth;

    private final List<GraphicConcept> concepts = new ArrayList<>();

    public ConceptProperties() {
        initialize();
        setup();
        addListeners();

        add(labelWidth,    new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(16, 12, 8,  4), 0, 0));
        add(spinnerWidth,  new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,   GridBagConstraints.NONE, new Insets(16,  4, 8,  5), 0, 0));
        add(labelHeight,   new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(16,  5, 8,  4), 0, 0));
        add(spinnerHeight, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,   GridBagConstraints.NONE, new Insets(16,  4, 8, 12), 0, 0));

        add(labelContent, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,     GridBagConstraints.NONE,       new Insets(8, 12, 8,  4), 0, 0));
        add(textContent,  new GridBagConstraints(1, 1, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, new Insets(8,  4, 8, 12), 0, 0));

        add(labelContentColor, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(8, 12, 8,  4), 0, 0));
        add(paneForeground,    new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,   GridBagConstraints.NONE, new Insets(8,  4, 8,  5), 0, 0));
        add(labelContentHex,   new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(8,  5, 8,  4), 0, 0));
        add(textForegroundHex, new GridBagConstraints(3, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,   GridBagConstraints.NONE, new Insets(8,  4, 8, 12), 0, 0));

        add(labelFillColor,    new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(8, 12, 8,  4), 0, 0));
        add(paneBackground,    new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,   GridBagConstraints.NONE, new Insets(8,  4, 8,  5), 0, 0));
        add(labelFillHex,      new GridBagConstraints(2, 3, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(8,  5, 8,  4), 0, 0));
        add(textBackgroundHex, new GridBagConstraints(3, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,   GridBagConstraints.NONE, new Insets(8,  4, 8, 12), 0, 0));

        add(labelStrokeColor, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(8, 12, 8,  4), 0, 0));
        add(paneStroke,       new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,   GridBagConstraints.NONE, new Insets(8,  4, 8,  5), 0, 0));
        add(labelStrokeHex,   new GridBagConstraints(2, 4, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(8,  5, 8,  4), 0, 0));
        add(textStrokeHex,    new GridBagConstraints(3, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,   GridBagConstraints.NONE, new Insets(8,  4, 8, 12), 0, 0));

        add(labelStrokeWidth,   new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(8, 12, 16, 4), 0, 0));
        add(spinnerStrokeWidth, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,   GridBagConstraints.NONE, new Insets(8,  4, 16, 5), 0, 0));
    }

    /**
     * Initializes components of the properties.
     */
    private void initialize() {
        labelWidth        = new JLabel(EditorValues.PROPERTIES_WIDTH_IDENTIFIER);
        labelHeight       = new JLabel(EditorValues.PROPERTIES_HEIGHT_IDENTIFIER);
        labelContent      = new JLabel(EditorValues.PROPERTIES_NAME_IDENTIFIER);
        labelContentColor = new JLabel(EditorValues.PROPERTIES_FOREGROUND_IDENTIFIER);
        labelContentHex   = new JLabel(EditorValues.PROPERTIES_HEXADECIMAL_IDENTIFIER);
        labelFillColor    = new JLabel(EditorValues.PROPERTIES_BACKGROUND_IDENTIFIER);
        labelFillHex      = new JLabel(EditorValues.PROPERTIES_HEXADECIMAL_IDENTIFIER);
        labelStrokeColor  = new JLabel(EditorValues.PROPERTIES_STROKE_IDENTIFIER);
        labelStrokeHex    = new JLabel(EditorValues.PROPERTIES_HEXADECIMAL_IDENTIFIER);
        labelStrokeWidth  = new JLabel(EditorValues.PROPERTIES_STROKE_WIDTH_IDENTIFIER);

        textContent       = new JTextField();
        textForegroundHex = new JTextField();
        textBackgroundHex = new JTextField();
        textStrokeHex     = new JTextField();

        textForegroundHex.setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);
        textBackgroundHex.setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);
        textStrokeHex    .setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);

        paneForeground = new JPanel();
        paneBackground = new JPanel();
        paneStroke     = new JPanel();

        paneForeground.setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);
        paneBackground.setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);
        paneStroke    .setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);

        paneForeground.setBorder(BorderFactory.createLineBorder(new Color(97, 99, 101)));
        paneBackground.setBorder(BorderFactory.createLineBorder(new Color(97, 99, 101)));
        paneStroke    .setBorder(BorderFactory.createLineBorder(new Color(97, 99, 101)));

        spinnerWidth       = new GRMapSpinner(EditorValues.GRAPHIC_ELEMENT_WIDTH_MULTIPLIER);
        spinnerHeight      = new GRMapSpinner(EditorValues.GRAPHIC_ELEMENT_HEIGHT_MULTIPLIER);
        spinnerStrokeWidth = new GRMapSpinner(EditorValues.GRAPHIC_ELEMENT_STROKE_MULTIPLIER);

        spinnerWidth      .setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);
        spinnerHeight     .setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);
        spinnerStrokeWidth.setPreferredSize(EditorValues.PROPERTIES_INPUT_COMPONENT_DIMENSION);
    }

    /**
     * Assigns listeners to components
     */
    private void addListeners() {
        textContent.addCaretListener(new ContentCaretListener());

        paneForeground.addMouseListener(new ForegroundMouseListener());
        paneBackground.addMouseListener(new BackgroundMouseListener());
        paneStroke    .addMouseListener(new StrokeColorMouseListener());

        spinnerWidth      .addChangeListener(new WidthChangeListener());
        spinnerHeight     .addChangeListener(new HeightChangeListener());
        spinnerStrokeWidth.addChangeListener(new StrokeWidthChangeListener());
    }

    @Override
    public void getFocus() {
        if (concepts.get(0).equals(editor.getDiagram().getGraphicElement()))
            textContent.requestFocus();
    }

    //region Setup

    @Override
    public void setup() {
        setupSelectedElements();

        if (concepts.isEmpty())
            return; //TODO - Error - cannot be empty

        setupWidth();
        setupHeight();
        setupContent();
        setupForeground();
        setupBackground();
        setupStroke();
        setupStrokeWidth();
    }

    private void setupSelectedElements() {
        concepts.clear();
        concepts.addAll(SelectionManager.getSelectedConcepts());
    }

    private void setupWidth() {
        Integer value = null;

        for (GraphicConcept concept : concepts) {
            Integer width = (int) concept.getWidth();

            if (value != null && !width.equals(value)) {
                value = null;
                break;
            }

            if (value == null)
                value = width;
        }

        spinnerWidth.setValue(value != null ? value : EditorValues.CONCEPT_WIDTH);
    }

    private void setupHeight() {
        Integer value = null;

        for (GraphicConcept concept : concepts) {
            Integer height = (int) concept.getHeight();

            if (value != null && !height.equals(value)) {
                value = null;
                break;
            }

            if (value == null)
                value = height;
        }

        spinnerHeight.setValue(value != null ? value : EditorValues.CONCEPT_HEIGHT);
    }

    private void setupContent() {
        String text = null;

        for (GraphicConcept concept : concepts) {
            String content = concept.getText();

            if (text != null && !content.equals(text)) {
                text = null;
                break;
            }

            if (text == null)
                text = content;
        }

        textContent.setText(text != null ? text : EditorValues.CONCEPT_TEXT_CONTENT);
    }

    private void setupForeground() {
        Color color = null;

        for (GraphicConcept concept : concepts) {
            Color foreground = concept.getForegroundColor();

            if (color != null && !foreground.equals(color)) {
                color = null;
                break;
            }

            if (color == null)
                color = foreground;
        }

        color = color != null ? color : EditorValues.CONCEPT_FOREGROUND_COLOR;

        paneForeground.setBackground(color);
        textForegroundHex.setText(colorToHex(color));
    }

    private void setupBackground() {
        Color color = null;

        for (GraphicConcept concept : concepts) {
            Color background = concept.getBackgroundColor();

            if (color != null && !background.equals(color)) {
                color = null;
                break;
            }

            if (color == null)
                color = background;
        }

        color = color != null ? color : EditorValues.CONCEPT_BACKGROUND_COLOR;

        paneBackground.setBackground(color);
        textBackgroundHex.setText(colorToHex(color));
    }

    private void setupStroke() {
        Color color = null;

        for (GraphicConcept concept : concepts) {
            Color stroke = concept.getStrokeColor();

            if (color != null && !stroke.equals(color)) {
                color = null;
                break;
            }

            if (color == null)
                color = stroke;
        }

        color = color != null ? color : EditorValues.CONCEPT_STROKE_COLOR;

        paneStroke.setBackground(color);
        textStrokeHex.setText(colorToHex(color));
    }

    private void setupStrokeWidth() {
        Integer value = null;

        for (GraphicConcept concept : concepts) {
            Integer width = (int) concept.getStrokeWidth();

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

    //region Listeners

    private class WidthChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent event) {
            Integer value = (Integer) spinnerWidth.getValue();

            for (GraphicConcept concept : concepts)
                concept.setWidth(value);

            editor.getDiagram().reconnect();
            editor.render();
        }
    }

    private class HeightChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent event) {
            Integer value = (Integer) spinnerHeight.getValue();

            for (GraphicConcept concept : concepts)
                concept.setHeight(value);

            editor.getDiagram().reconnect();
            editor.render();
        }

    }

    private class ContentCaretListener implements CaretListener {

        @Override
        public void caretUpdate(CaretEvent event) {
            String content = textContent.getText();

            for (GraphicConcept concept : concepts)
                concept.setText(content);

            editor.render();
        }

    }

    private class ForegroundMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent event) {
            Color color = JColorChooser.showDialog(MainWindow.window, "Select a color", paneForeground.getBackground());

            if (color == null)
                return;

            for (GraphicConcept concept : concepts)
                concept.setForegroundColor(color);

            paneForeground.setBackground(color);
            textForegroundHex.setText(colorToHex(color));

            editor.render();
        }

    }

    private class BackgroundMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent event) {
            Color color = JColorChooser.showDialog(MainWindow.window, "Select a color", paneBackground.getBackground());

            if (color == null)
                return;

            for (GraphicConcept concept : concepts)
                concept.setBackgroundColor(color);

            paneBackground.setBackground(color);
            textBackgroundHex.setText(colorToHex(color));

            editor.render();
        }

    }

    private class StrokeColorMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent event) {
            Color color = JColorChooser.showDialog(MainWindow.window, "Select a color", paneStroke.getBackground());

            if (color == null)
                return;

            for (GraphicConcept concept : concepts)
                concept.setStrokeColor(color);

            paneStroke.setBackground(color);
            textStrokeHex.setText(colorToHex(color));

            editor.render();
        }

    }

    private class StrokeWidthChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent event) {
            int value = (int) spinnerStrokeWidth.getValue();

            for (GraphicConcept concept : concepts)
                concept.setStrokeWidth(value);

            editor.render();
        }

    }

    //endregion

}
