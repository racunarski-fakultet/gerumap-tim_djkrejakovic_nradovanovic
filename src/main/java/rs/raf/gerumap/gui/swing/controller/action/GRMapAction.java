package rs.raf.gerumap.gui.swing.controller.action;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.util.ImageUtils;
import rs.raf.gerumap.gui.swing.util.KeyStrokesUtils;
import rs.raf.gerumap.gui.swing.util.LanguageUtils;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public abstract class GRMapAction extends AbstractAction {

    private final String id;

    public GRMapAction(Class<? extends GRMapAction> actionClass) {
        id = StringUtils.removeTrailing(actionClass.getSimpleName(), "Action");
    }

    /**
     * Sets the keyboard shortcut for the component
     */
    public void setAcceleratorKey() {
        putValue(Action.ACCELERATOR_KEY, KeyStrokesUtils.getProperty(id));
    }

    /**
     * Sets a small icon for the component
     */
    public void setIcon() {
        putValue(Action.SMALL_ICON, ImageUtils.loadIcon(id));
    }

    /**
     * Sets the text contained in the component
     */
    public void setName() {
        putValue(Action.NAME, LanguageUtils.getNameProperty(id));
    }

    /**
     * Sets the short description of the component
     */
    public void setTooltip() {
        putValue(Action.SHORT_DESCRIPTION, LanguageUtils.getTooltipProperty(id));
    }

    /**
     * Returns the keyboard shortcut for the component
     */
    public KeyStroke getAcceleratorKey() {
        return (KeyStroke) getValue(Action.ACCELERATOR_KEY);
    }

    /**
     * Returns a small icon for the component
     */
    public ImageIcon getIcon() {
        return (ImageIcon) getValue(Action.SMALL_ICON);
    }

    /**
     * Returns the text contained in the component
     */
    public String getName() {
        return (String) getValue(Action.NAME);
    }

    /**
     * Returns the short description of the component
     */
    public String getTooltip() {
        return (String) getValue(Action.SHORT_DESCRIPTION);
    }

    /**
     * Returns the identification tag of the inheritor
     */
    public String getId() {
        return id;
    }

}
