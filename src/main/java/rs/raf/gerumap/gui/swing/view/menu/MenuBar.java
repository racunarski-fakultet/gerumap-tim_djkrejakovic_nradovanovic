package rs.raf.gerumap.gui.swing.view.menu;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.ExitAction;
import rs.raf.gerumap.gui.swing.controller.action.NewProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.OpenProjectAction;
import rs.raf.gerumap.gui.swing.view.custom.Menu;
import rs.raf.gerumap.gui.swing.view.custom.MenuItem;

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

        JMenuItem registerItem = new MenuItem("Register");
        JMenuItem aboutItem    = new MenuItem("About");

        fileMenu.add(ActionManager.getAction(NewProjectAction.class));
        fileMenu.add(ActionManager.getAction(OpenProjectAction.class));
        fileMenu.add(ActionManager.getAction(ExitAction.class));

        editMenu.add(undoItem);
        editMenu.add(redoItem);

        helpMenu.add(aboutItem);
        helpMenu.add(registerItem);

        add(fileMenu);
        add(editMenu);
        add(helpMenu);
    }

}
