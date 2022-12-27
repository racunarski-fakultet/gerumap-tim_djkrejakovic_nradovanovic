package rs.raf.gerumap.log.logger;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.log.model.Message;

public class EditorLogger implements ILogger {

    private final IEditor editor = MainWindow.window.getEditor();

    @Override
    public void log(Message message) {
        log(message, "");
    }

    @Override
    public void log(Message message, String extend) {
        if (!message.isEditorMessage() || editor.getActivePage() == null)
            return;

        editor.getStatusBar().addMessage(message.getMessage());
    }

    @Override
    public void close() { }

}
