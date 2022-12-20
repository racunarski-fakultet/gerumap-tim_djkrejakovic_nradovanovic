package rs.raf.gerumap.gui.swing.view.workspace.editor;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class EditorValues {

    public static final Integer   DIAGRAM_WIDTH            = 1400;
    public static final Integer   DIAGRAM_HEIGHT           = 1000;
    public static final Dimension DIAGRAM_DIMENSION        = new Dimension(DIAGRAM_WIDTH, DIAGRAM_HEIGHT);
    public static final Color     DIAGRAM_BACKGROUND_COLOR = new Color(255, 255, 255);

    public static final Integer   PROPERTIES_DIAGRAM_WIDTH_MULTIPLIER  = 10;
    public static final Integer   PROPERTIES_DIAGRAM_HEIGHT_MULTIPLIER = 10;
    public static final Integer   PROPERTIES_ELEMENT_WIDTH_MULTIPLIER  = 1;
    public static final Integer   PROPERTIES_ELEMENT_HEIGHT_MULTIPLIER = 1;
    public static final Integer   PROPERTIES_ELEMENT_STROKE_MULTIPLIER = 1;
    public static final Dimension PROPERTIES_INPUT_COMPONENT_DIMENSION = new Dimension(68, 22);
    public static final String    PROPERTIES_WIDTH_IDENTIFIER          = "W";
    public static final String    PROPERTIES_HEIGHT_IDENTIFIER         = "H";
    public static final String    PROPERTIES_BACKGROUND_IDENTIFIER     = "Fill";
    public static final String    PROPERTIES_FOREGROUND_IDENTIFIER     = "Text";
    public static final String    PROPERTIES_STROKE_IDENTIFIER         = "Str";
    public static final String    PROPERTIES_STROKE_WIDTH_IDENTIFIER   = "SW";
    public static final String    PROPERTIES_HEXADECIMAL_IDENTIFIER    = "Hex";
    public static final String    PROPERTIES_NAME_IDENTIFIER           = "Name";

    public static final Float   SELECTION_STROKE_WIDTH     = 1F;
    public static final Integer SELECTION_ALPHA            = 20;
    public static final Color   SELECTION_STROKE_COLOR     = new Color(9, 166, 243);
    public static final Color   SELECTION_BACKGROUND_COLOR = new Color((SELECTION_STROKE_COLOR.getRGB() & 0xFFFFFF) | (SELECTION_ALPHA % 0x100 << 0x18), true);

    public static final Float   ERASER_STROKE_WIDTH     = SELECTION_STROKE_WIDTH;
    public static final Integer ERASER_ALPHA            = SELECTION_ALPHA;
    public static final Color   ERASER_STROKE_COLOR     = new Color(227, 6, 19);
    public static final Color   ERASER_BACKGROUND_COLOR = new Color((ERASER_STROKE_COLOR.getRGB() & 0xFFFFFF) | (ERASER_ALPHA % 0x100 << 0x18), true);

    public static final Color   CONCEPT_BACKGROUND_COLOR = new Color(96, 98, 100);
    public static final Color   CONCEPT_FOREGROUND_COLOR = new Color(200, 202, 204);
    public static final Color   CONCEPT_STROKE_COLOR     = new Color(75, 77, 79);
    public static final Color   CONCEPT_SELECTION_COLOR  = SELECTION_STROKE_COLOR;
    public static final Float   CONCEPT_STROKE_WIDTH     = 3F;
    public static final Float   CONCEPT_SELECTION_WIDTH  = SELECTION_STROKE_WIDTH;
    public static final Font    CONCEPT_TEXT_FONT        = new JLabel().getFont();
    public static final String  CONCEPT_TEXT_CONTENT     = "";
    public static final Integer CONCEPT_WIDTH            = 150;
    public static final Integer CONCEPT_HEIGHT           = 50;

    public static final Float CONNECTION_STROKE_WIDTH = 3F;
    public static final Color CONNECTION_STROKE_COLOR = new Color(75, 77, 79);
    public static final Float CONNECTION_SELECTION_WIDTH = SELECTION_STROKE_WIDTH;
    public static final Color CONNECTION_SELECTION_COLOR = SELECTION_STROKE_COLOR;

}
