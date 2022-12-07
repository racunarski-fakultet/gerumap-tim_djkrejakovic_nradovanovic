package rs.raf.gerumap.gui.swing.view.menu;

import com.formdev.flatlaf.extras.components.FlatButton;
import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.ExitAction;
import rs.raf.gerumap.gui.swing.controller.action.NewProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.UserAction;
import rs.raf.gerumap.gui.swing.view.custom.menu.Menu;
import rs.raf.gerumap.gui.swing.view.custom.menu.MenuItem;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        JMenu fileMenu = new Menu("File");
        JMenu editMenu = new Menu("Edit");
        JMenu helpMenu = new Menu("Help");

        JMenuItem undoItem = new MenuItem("Undo");
        JMenuItem redoItem = new MenuItem("Redo");

        JMenuItem aboutItem = new MenuItem("About");

        FlatButton userButton = new FlatButton();
        userButton.setAction(ActionManager.getAction(UserAction.class));
        userButton.setButtonType(FlatButton.ButtonType.toolBarButton);
        userButton.setFocusable(false);

        fileMenu.add(ActionManager.getAction(NewProjectAction.class));
        fileMenu.add(ActionManager.getAction(ExitAction.class));

        editMenu.add(undoItem);
        editMenu.add(redoItem);

        helpMenu.add(aboutItem);

        add(fileMenu);
        add(editMenu);
        add(helpMenu);
        add(Box.createHorizontalGlue());
        add(userButton);
    }

}
