package rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.event;

import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.ExplorerDialogBase;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Handles the keyboard event of the dialog.
 */
public class ExplorerDialogKeyListener extends KeyAdapter {

    private final ExplorerDialogBase window;

    public ExplorerDialogKeyListener(ExplorerDialogBase window) {
        this.window = window;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        boolean isEnter  = event.getKeyCode() == KeyEvent.VK_ENTER;
        boolean isEscape = event.getKeyCode() == KeyEvent.VK_ESCAPE;
        boolean isValid  = window.isValidName();

        if (!isEscape && (!isEnter || !isValid))
            return;

        window.setDiscarded(isEscape);
        window.close();
    }

}
