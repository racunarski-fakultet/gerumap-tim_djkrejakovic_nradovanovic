package rs.raf.gerumap.gui.swing.view;

import rs.raf.gerumap.gui.swing.controller.ActionManager;
import rs.raf.gerumap.gui.swing.controller.action.ExitAction;
import rs.raf.gerumap.gui.swing.controller.action.NewProjectAction;
import rs.raf.gerumap.gui.swing.controller.action.OpenProjectAction;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem newProjectItem  = new JMenuItem("New Project");
        JMenuItem openProjectItem = new JMenuItem("Open Project");
        JMenuItem exitItem        = new JMenuItem("Exit");

        JMenuItem undoItem = new JMenuItem("Undo");
        JMenuItem redoItem = new JMenuItem("Redo");

        JMenuItem registerItem = new JMenuItem("Register");
        JMenuItem aboutItem    = new JMenuItem("About");

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
