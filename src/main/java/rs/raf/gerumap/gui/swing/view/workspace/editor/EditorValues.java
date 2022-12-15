package rs.raf.gerumap.gui.swing.view.workspace.editor;

import java.awt.Color;
import java.awt.Dimension;

public class EditorValues {

    public static final Integer   DIAGRAM_WIDTH            = 1200;
    public static final Integer   DIAGRAM_HEIGHT           = 1000;
    public static final Dimension DIAGRAM_DIMENSION        = new Dimension(DIAGRAM_WIDTH, DIAGRAM_HEIGHT);
    public static final Color     DIAGRAM_BACKGROUND_COLOR = new Color(255, 255, 255);

    public static final Integer   PROPERTIES_DIAGRAM_WIDTH_MULTIPLIER  = 10;
    public static final Integer   PROPERTIES_DIAGRAM_HEIGHT_MULTIPLIER = 10;
    public static final Dimension PROPERTIES_INPUT_COMPONENT_DIMENSION = new Dimension(68, 22);
    public static final String    PROPERTIES_WIDTH_IDENTIFIER          = "W";
    public static final String    PROPERTIES_HEIGHT_IDENTIFIER         = "H";
    public static final String    PROPERTIES_BACKGROUND_IDENTIFIER     = "Fill";
    public static final String    PROPERTIES_HEXADECIMAL_IDENTIFIER    = "Hex";

    public static final Float   SELECTION_STROKE_WIDTH     = 1F;
    public static final Integer SELECTION_ALPHA            = 20;
    public static final Color   SELECTION_STROKE_COLOR     = new Color(9, 166, 243);
    public static final Color   SELECTION_BACKGROUND_COLOR = new Color((SELECTION_STROKE_COLOR.getRGB() & 0xFFFFFF) | (SELECTION_ALPHA % 0x100 << 0x18), true);

}
