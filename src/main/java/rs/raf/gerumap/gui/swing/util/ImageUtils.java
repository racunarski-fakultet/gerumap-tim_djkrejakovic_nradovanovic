package rs.raf.gerumap.gui.swing.util;

import rs.raf.gerumap.log.Logger;
import rs.raf.gerumap.log.model.Message;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.net.URL;

public class ImageUtils {

    public static Icon loadIcon(String name) {
        URL iconURL = ResourceUtils.getIconPath(name);

        if (iconURL != null)
            return new ImageIcon(iconURL);

        Logger.log(Message.UTILITY_ICON_NOT_FOUND, name);

        return null;
    }

    public static Image loadImage(String name) {
        URL imageURL = ResourceUtils.getIconPath(name);

        if (imageURL != null)
            return new ImageIcon(imageURL).getImage();

        Logger.log(Message.UTILITY_IMAGE_NOT_FOUND, name);

        return null;
    }

}
