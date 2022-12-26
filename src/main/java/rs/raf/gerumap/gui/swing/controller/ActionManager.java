package rs.raf.gerumap.gui.swing.controller;

import com.formdev.flatlaf.util.StringUtils;
import rs.raf.gerumap.gui.swing.controller.action.ConceptStateAction;
import rs.raf.gerumap.gui.swing.controller.action.ConnectStateAction;
import rs.raf.gerumap.gui.swing.controller.action.EraseStateAction;
import rs.raf.gerumap.gui.swing.controller.action.ExitAction;
import rs.raf.gerumap.gui.swing.controller.action.ExportMindMapAction;
import rs.raf.gerumap.gui.swing.controller.action.GRMapAction;
import rs.raf.gerumap.gui.swing.controller.action.LoadMindMapAction;
import rs.raf.gerumap.gui.swing.controller.action.LoadProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.MindMapRootAction;
import rs.raf.gerumap.gui.swing.controller.action.MoveStateAction;
import rs.raf.gerumap.gui.swing.controller.action.NewMindMapAction;
import rs.raf.gerumap.gui.swing.controller.action.NewProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.OpenMindMapAction;
import rs.raf.gerumap.gui.swing.controller.action.OpenProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.RedoAction;
import rs.raf.gerumap.gui.swing.controller.action.RedoMenuAction;
import rs.raf.gerumap.gui.swing.controller.action.RemoveAction;
import rs.raf.gerumap.gui.swing.controller.action.RenameAction;
import rs.raf.gerumap.gui.swing.controller.action.ResetZoomAction;
import rs.raf.gerumap.gui.swing.controller.action.SaveMindMapAsAction;
import rs.raf.gerumap.gui.swing.controller.action.SaveProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.SaveProjectAsAction;
import rs.raf.gerumap.gui.swing.controller.action.SaveProjectMenuAction;
import rs.raf.gerumap.gui.swing.controller.action.SelectStateAction;
import rs.raf.gerumap.gui.swing.controller.action.UndoAction;
import rs.raf.gerumap.gui.swing.controller.action.UndoMenuAction;
import rs.raf.gerumap.gui.swing.controller.action.UserAction;
import rs.raf.gerumap.gui.swing.controller.action.ZoomInAction;
import rs.raf.gerumap.gui.swing.controller.action.ZoomOutAction;
import rs.raf.gerumap.gui.swing.controller.action.ZoomStateAction;

import java.util.List;

public class ActionManager {

    private static final List<GRMapAction> actions = List.of(
            new ConceptStateAction(),
            new ConnectStateAction(),
            new EraseStateAction(),
            new ExitAction(),
            new ExportMindMapAction(),
            new LoadMindMapAction(),
            new LoadProjectAction(),
            new MindMapRootAction(),
            new MoveStateAction(),
            new NewMindMapAction(),
            new NewProjectAction(),
            new RemoveAction(),
            new OpenMindMapAction(),
            new OpenProjectAction(),
            new RedoAction(),
            new RedoMenuAction(),
            new RenameAction(),
            new ResetZoomAction(),
            new SaveMindMapAsAction(),
            new SaveProjectAction(),
            new SaveProjectAsAction(),
            new SaveProjectMenuAction(),
            new SelectStateAction(),
            new UndoAction(),
            new UndoMenuAction(),
            new UserAction(),
            new ZoomInAction(),
            new ZoomOutAction(),
            new ZoomStateAction()
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
     * Setups all action keystrokes.
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
    public static GRMapAction getAction(Class<? extends GRMapAction> actionClass) {
        String actionName = StringUtils.removeTrailing(actionClass.getSimpleName(), "Action");
        for (GRMapAction action : actions)
            if (action.getId().equals(actionName))
                return action;

        return null;
    }

}
