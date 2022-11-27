package rs.raf.gerumap.gui.swing.controller;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.controller.action.ExitAction;
import rs.raf.gerumap.gui.swing.controller.action.GRMapAction;
import rs.raf.gerumap.gui.swing.controller.action.LoadDocumentAction;
import rs.raf.gerumap.gui.swing.controller.action.LoadProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.NewElementAction;
import rs.raf.gerumap.gui.swing.controller.action.NewMindMapAction;
import rs.raf.gerumap.gui.swing.controller.action.NewProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.OpenProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.RemoveExplorerItemAction;
import rs.raf.gerumap.gui.swing.controller.action.RenameExplorerItemAction;

import java.util.List;

/**
 * Manages all the actions in the program.
 */
public class ActionManager {

    private static final List<GRMapAction> actions = List.of(
            new LoadDocumentAction(),
            new LoadProjectAction(),
            new NewElementAction(),
            new NewMindMapAction(),
            new NewProjectAction(),
            new OpenProjectAction(),
            new RemoveExplorerItemAction(),
            new RenameExplorerItemAction(),
            new ExitAction()
    );

    //region Setup

    /**
     * Setups all the actions.
     */
    public static void setup() {
        setupKeyStrokes();
        setupIcons();
        setupNames();
        setupTooltips();
    }

    /**
     * Setups all action icons.
     */
    public static void setupIcons() {
        for (GRMapAction action : actions) {
            action.setIcon();
        }
    }

    /**
     * Setups all action keystrokes/
     */
    public static void setupKeyStrokes() {
        for (GRMapAction action : actions) {
            action.setAcceleratorKey();
        }
    }

    /**
     * Setups all action names.
     */
    public static void setupNames() {
        for (GRMapAction action : actions) {
            action.setName();
        }
    }

    /**
     * Setups all action tooltips.
     */
    public static void setupTooltips() {
        for (GRMapAction action : actions) {
            action.setTooltip();
        }
    }

    //endregion

    /**
     * Returns the action from the list if it exists, otherwise returns null.
     * @param actionClass action class
     * @return action if exists, otherwise null
     */
    public static GRMapAction getAction(Class actionClass) {
        String actionName = StringUtils.removeTrailing(actionClass.getSimpleName(), "Action");
        for (GRMapAction action : actions)
            if (action.getId().equals(actionName))
                return action;

        return null;
    }

}
