package rs.raf.gerumap.gui.swing.controller;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.controller.action.ExitAction;
import rs.raf.gerumap.gui.swing.controller.action.GRMapAction;
import rs.raf.gerumap.gui.swing.controller.action.NewElementAction;
import rs.raf.gerumap.gui.swing.controller.action.NewMindMapAction;
import rs.raf.gerumap.gui.swing.controller.action.NewProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.OpenProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.RemoveExplorerItemAction;
import rs.raf.gerumap.gui.swing.controller.action.RenameExplorerItemAction;

import java.util.List;

public class ActionManager {

    private static final List<GRMapAction> actions = List.of(
            new NewElementAction(),
            new NewMindMapAction(),
            new NewProjectAction(),
            new OpenProjectAction(),
            new RemoveExplorerItemAction(),
            new RenameExplorerItemAction(),
            new ExitAction()
    );

    //region Setup

    public static void setup() {
        setupKeyStrokes();
        setupIcons();
        setupNames();
        setupTooltips();
    }

    public static void setupIcons() {
        for (GRMapAction action : actions) {
            action.setIcon();
        }
    }

    public static void setupKeyStrokes() {
        for (GRMapAction action : actions) {
            action.setAcceleratorKey();
        }
    }

    public static void setupNames() {
        for (GRMapAction action : actions) {
            action.setName();
        }
    }

    public static void setupTooltips() {
        for (GRMapAction action : actions) {
            action.setTooltip();
        }
    }

    //endregion

    public static GRMapAction getAction(Class actionClass) {
        String actionName = StringUtils.removeTrailing(actionClass.getSimpleName(), "Action");
        for (GRMapAction action : actions)
            if (action.getId().equals(actionName))
                return action;

        return null;
    }

}
