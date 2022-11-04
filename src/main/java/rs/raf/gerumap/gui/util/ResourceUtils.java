package rs.raf.gerumap.gui.util;

import java.io.InputStream;
import java.net.URL;

public class ResourceUtils {

    private static final String separator = "/";

    private static final String pngFile = ".png";
    private static final String jpgFile = ".jpg";

    private static final String imagesRoot = "images";

    //region Auxiliary Methods

    private static URL getResource(String resource) {
        URL url = ResourceUtils.class.getResource(resource);

        if (url == null)
            System.err.println("Resource not found: " + resource);

        return url;
    }

    private static String getIconDir() {
        return PreferenceUtils.getIconType().getIconDir();
    }

    //endregion

    //region Icon Utilities

    private static String getIconResourceDirectory() {
        return separator + imagesRoot + separator + getIconDir() + separator;
    }

    public static URL getIconPath(String iconName) {
        return getResource(getIconResourceDirectory() + iconName + pngFile);
    }

    //endregion

}
