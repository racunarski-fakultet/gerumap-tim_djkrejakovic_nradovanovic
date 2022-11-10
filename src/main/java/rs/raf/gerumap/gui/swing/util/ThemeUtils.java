package rs.raf.gerumap.gui.swing.util;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import rs.raf.gerumap.gui.swing.util.model.Theme;

import javax.swing.LookAndFeel;
import java.lang.reflect.InvocationTargetException;

public class ThemeUtils {

    static {
        FlatAnimatedLafChange.duration = 200;

        FlatLaf.registerCustomDefaultsSource(ResourceUtils.getThemeDirectory());
    }

    public static void setupTheme(Theme theme) {
        try {
            FlatLaf.setup((LookAndFeel) Class.forName(theme.getClassName()).getDeclaredConstructor().newInstance());
        }
        catch (ClassNotFoundException e) {
            System.err.println("Theme setup error: ClassNotFoundException");
        }
        catch (NoSuchMethodException e) {
            System.err.println("Theme setup error: NoSuchMethodException");
        }
        catch (InvocationTargetException e) {
            System.err.println("Theme setup error: InvocationTargetException");
        }
        catch (InstantiationException e) {
            System.err.println("Theme setup error: InstantiationException");
        }
        catch (IllegalAccessException e) {
            System.err.println("Theme setup error: IllegalAccessException");
        }
    }

}
