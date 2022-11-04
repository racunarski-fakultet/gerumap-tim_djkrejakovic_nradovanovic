package rs.raf.gerumap.gui.swing.controller.action;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.util.IconUtils;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public abstract class GRMapAction extends AbstractAction {

    private String id;

    public GRMapAction(Class actionClass) {
        id = StringUtils.removeTrailing(actionClass.getSimpleName(), "Action");
    }

    /**
     * Sets the keyboard shortcut for the component
     */
    public GRMapAction setAcceleratorKey() {
        putValue(Action.ACCELERATOR_KEY, null);
        return this;
    }

    /**
     * Sets a small icon for the component
     */
    public GRMapAction setIcon() {
        putValue(Action.SMALL_ICON, IconUtils.loadIcon(id));
        return this;
    }

    /**
     * Sets the text contained in the component
     */
    public GRMapAction setName() {
        putValue(Action.NAME, null);
        return this;
    }

    /**
     * Sets the short description of the component
     */
    public GRMapAction setTooltip() {
        putValue(Action.SHORT_DESCRIPTION, null);
        return this;
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
