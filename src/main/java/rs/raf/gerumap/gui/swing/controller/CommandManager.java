package rs.raf.gerumap.gui.swing.controller;

import rs.raf.gerumap.gui.swing.controller.comands.BaseCommand;
import rs.raf.gerumap.gui.swing.view.MainWindow;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private final List<BaseCommand> commands = new ArrayList<>();

    private int currentCommand = 0;

    public CommandManager() { }

    public void addCommand(BaseCommand command) {
        while(currentCommand < commands.size())
            commands.remove(currentCommand);

        commands.add(command);
        performCommand();
    }

    private void performCommand() {
        commands.get(currentCommand++).perform();

        updateButtons();
    }

    public void redoCommand() {
        if (currentCommand == commands.size())
            return; //TODO Error - The Redo command should not be available to call

        commands.get(currentCommand++).redoCommand();

        updateButtons();
    }

    public void undoCommand() {
        if (currentCommand == 0)
            return; //TODO Error - The Undo command should not be available to call

        commands.get(--currentCommand).undoCommand();

        updateButtons();
    }

    public void updateButtons() {
        MainWindow.window.setUndoEnabled(currentCommand != 0);
        MainWindow.window.setRedoEnabled(currentCommand != commands.size());
    }

}
