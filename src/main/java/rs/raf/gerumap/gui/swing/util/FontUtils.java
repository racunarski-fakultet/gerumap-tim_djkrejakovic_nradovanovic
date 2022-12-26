package rs.raf.gerumap.gui.swing.util;

import rs.raf.gerumap.gui.swing.util.model.GFont;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

public class FontUtils {

    public static void loadFonts() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();

        for (GFont font : GFont.values()) {
            try {
                graphicsEnvironment.registerFont(Font.createFont(Font.TRUETYPE_FONT, ResourceUtils.getFontStream(font)));
            }
            catch (FontFormatException | IOException exception) {
                exception.printStackTrace();
            }
        }
    }

}
