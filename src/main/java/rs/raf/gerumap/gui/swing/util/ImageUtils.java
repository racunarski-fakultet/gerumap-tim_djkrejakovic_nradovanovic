package rs.raf.gerumap.gui.swing.util;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.net.URL;

public class ImageUtils {

    public static Icon loadIcon(String name) {
        URL iconURL = ResourceUtils.getIconPath(name);

        if (iconURL != null)
            return new ImageIcon(iconURL);

        System.err.println("Icon not found: " + name);

        return null;
    }

    public static Image loadImage(String name) {
        URL imageURL = ResourceUtils.getIconPath(name);

        if (imageURL != null)
            return new ImageIcon(imageURL).getImage();

        System.err.println("Image not found: " + name);

        return null;
    }

}
