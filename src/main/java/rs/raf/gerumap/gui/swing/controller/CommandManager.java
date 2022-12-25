package rs.raf.gerumap.gui.swing.controller;

import rs.raf.gerumap.gui.swing.controller.comands.BaseCommand;
import rs.raf.gerumap.gui.swing.view.MainWindow;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private final List<BaseCommand> commands = new ArrayList<>();

    private int currentCommand = 0;

    public CommandManager() { }

    /**
     * Adds a command to the command manager.
     * @param command command
     */
    public void addCommand(BaseCommand command) {
        while(currentCommand < commands.size())
            commands.remove(currentCommand);

        commands.add(command);
        performCommand();
    }

    /**
     * Performs the command.
     */
    private void performCommand() {
        commands.get(currentCommand++).perform();

        updateButtons();
    }

    /**
     * Handles the redo command.
     */
    public void redoCommand() {
        if (currentCommand == commands.size())
            return; //TODO Error - The Redo command should not be available to call

        commands.get(currentCommand++).redoCommand();

        updateButtons();
    }

    /**
     * Handles the undo command.
     */
    public void undoCommand() {
        if (currentCommand == 0)
            return; //TODO Error - The Undo command should not be available to call

        commands.get(--currentCommand).undoCommand();

        updateButtons();
    }

    /**
     * Updates whether buttons are enabled or not.
     */
    public void updateButtons() {
        MainWindow.window.setUndoEnabled(currentCommand != 0);
        MainWindow.window.setRedoEnabled(currentCommand != commands.size());
    }

}
