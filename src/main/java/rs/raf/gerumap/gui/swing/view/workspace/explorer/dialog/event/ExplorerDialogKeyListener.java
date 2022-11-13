package rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.event;

import rs.raf.gerumap.gui.swing.view.custom.dialog.UndecoratedDialog;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ExplorerDialogKeyListener extends KeyAdapter {

    private final UndecoratedDialog window;

    public ExplorerDialogKeyListener(UndecoratedDialog window) {
        this.window = window;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        boolean isEscape = event.getKeyCode() == KeyEvent.VK_ESCAPE;
        boolean isEnter  = event.getKeyCode() == KeyEvent.VK_ENTER;

        if (!(isEscape || isEnter))
            return;

        window.setDiscarded(isEscape);
        window.close();
    }

}
