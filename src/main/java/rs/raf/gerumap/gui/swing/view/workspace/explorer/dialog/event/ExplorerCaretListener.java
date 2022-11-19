package rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.event;

import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.ExplorerDialogBase;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class ExplorerCaretListener implements CaretListener {

    private final ExplorerDialogBase window;

    public ExplorerCaretListener(ExplorerDialogBase window) {
        this.window = window;
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        window.update();
    }

}
