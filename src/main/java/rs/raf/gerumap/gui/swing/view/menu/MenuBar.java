package rs.raf.gerumap.gui.swing.view.menu;

import com.formdev.flatlaf.extras.components.FlatButton;
import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.ExitAction;
import rs.raf.gerumap.gui.swing.controller.action.NewProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.OpenProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.RedoAction;
import rs.raf.gerumap.gui.swing.controller.action.RedoMenuAction;
import rs.raf.gerumap.gui.swing.controller.action.SaveProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.SaveProjectAsAction;
import rs.raf.gerumap.gui.swing.controller.action.SaveProjectMenuAction;
import rs.raf.gerumap.gui.swing.controller.action.UndoAction;
import rs.raf.gerumap.gui.swing.controller.action.UndoMenuAction;
import rs.raf.gerumap.gui.swing.controller.action.UserAction;
import rs.raf.gerumap.gui.swing.view.custom.GRMapMenu;
import rs.raf.gerumap.gui.swing.view.custom.GRMapMenuItem;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

    private final FlatButton undoButton = new FlatButton();
    private final FlatButton redoButton = new FlatButton();

    public MenuBar() {
        JMenu fileMenu = new GRMapMenu("File");
        JMenu editMenu = new GRMapMenu("Edit");
        JMenu helpMenu = new GRMapMenu("Help");

        JMenuItem aboutItem = new GRMapMenuItem("About");

        FlatButton saveButton = new FlatButton();
        saveButton.setButtonType(FlatButton.ButtonType.toolBarButton);
        saveButton.setAction(ActionManager.getAction(SaveProjectAction.class));
        saveButton.setFocusable(false);

        FlatButton userButton = new FlatButton();
        userButton.setButtonType(FlatButton.ButtonType.toolBarButton);
        userButton.setAction(ActionManager.getAction(UserAction.class));
        userButton.setFocusable(false);

        undoButton.setButtonType(FlatButton.ButtonType.toolBarButton);
        undoButton.setAction(ActionManager.getAction(UndoAction.class));
        undoButton.setFocusable(false);

        redoButton.setButtonType(FlatButton.ButtonType.toolBarButton);
        redoButton.setAction(ActionManager.getAction(RedoAction.class));
        redoButton.setFocusable(false);

        setUndoEnabled(false);
        setRedoEnabled(false);

        fileMenu.add(new GRMapMenuItem(ActionManager.getAction(NewProjectAction.class)));
        fileMenu.add(new GRMapMenuItem(ActionManager.getAction(OpenProjectAction.class)));
        fileMenu.add(new GRMapMenuItem(ActionManager.getAction(SaveProjectMenuAction.class)));
        fileMenu.add(new GRMapMenuItem(ActionManager.getAction(SaveProjectAsAction.class)));
        fileMenu.add(new GRMapMenuItem(ActionManager.getAction(ExitAction.class)));

        editMenu.add(new GRMapMenuItem(ActionManager.getAction(UndoMenuAction.class)));
        editMenu.add(new GRMapMenuItem(ActionManager.getAction(RedoMenuAction.class)));

        helpMenu.add(aboutItem);

        add(fileMenu);
        add(editMenu);
        add(helpMenu);
        add(saveButton);
        add(undoButton);
        add(redoButton);
        add(Box.createHorizontalGlue());
        add(userButton);
    }

    /**
     * Sets the value whether the undo button should be enabled or not.
     * @param newValue new value
     */
    public void setUndoEnabled(boolean newValue) {
        undoButton.setEnabled(newValue);
    }

    /**
     * Sets the value whether the redo button should be enabled or not.
     * @param newValue new value
     */
    public void setRedoEnabled(boolean newValue) {
        redoButton.setEnabled(newValue);
    }

}
