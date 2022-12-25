package rs.raf.gerumap.gui.swing.controller.comands;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.IExplorer;

public abstract class BaseCommand {

    protected IExplorer explorer = MainWindow.window.getExplorer();

    protected IEditor editor = MainWindow.window.getEditor();

    /**
     * Performs the initial command.
     */
    public abstract void perform();

    /**
     * Implementation of the redo command.
     */
    public abstract void redoCommand();

    /**
     * Implementation of  the undo command.
     */
    public abstract void undoCommand();

}
