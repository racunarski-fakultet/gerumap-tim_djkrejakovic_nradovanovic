package rs.raf.gerumap.gui.util;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.net.URL;

public class IconUtils {

    public static Icon loadIcon(String iconName) {
        URL iconURL = ResourceUtils.getIconPath(iconName);

        if (iconURL != null)
            return new ImageIcon(iconURL);

        System.err.println("Icon not found: " + iconName);

        return null;
    }

}
