package rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog;

import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.event.ExplorerCaretListener;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.event.ExplorerDialogKeyListener;

import java.awt.Frame;
import java.util.List;

public class RenameItemDialog extends ExplorerDialogBase {

    /**
     * Creates a dialog for renaming an item.
     * @param owner owner
     * @param childrenNames children
     */
    public RenameItemDialog(Frame owner, List<String> childrenNames, String itemName) {
        super(owner, "Rename", childrenNames);

        nameField.setText(itemName);
        nameField.addKeyListener(new ExplorerDialogKeyListener(this));
        nameField.addCaretListener(new ExplorerCaretListener(this));
    }

}
