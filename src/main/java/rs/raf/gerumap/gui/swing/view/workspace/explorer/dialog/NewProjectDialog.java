package rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog;

import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.event.ExplorerCaretListener;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.dialog.event.ExplorerDialogKeyListener;

import java.awt.Frame;
import java.util.List;

public class NewProjectDialog extends ExplorerDialogBase {

    public NewProjectDialog(Frame owner, List<String> childrenNames) {
        super(owner, "Create new project", childrenNames);

        nameField.addKeyListener(new ExplorerDialogKeyListener(this));
        nameField.addCaretListener(new ExplorerCaretListener(this));
    }

}
