package rs.raf.gerumap.gui.swing.controller.adapters;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.gui.swing.view.workspace.editor.IEditor;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.IExplorer;

public abstract class BaseTypeAdapter<Type> extends TypeAdapter<Type> {

    protected final IExplorer explorer = MainWindow.window.getExplorer();

    protected final IEditor editor = MainWindow.window.getEditor();

    protected final Gson gson;

    public BaseTypeAdapter(Gson gson) {
        this.gson = gson;
    }

}
