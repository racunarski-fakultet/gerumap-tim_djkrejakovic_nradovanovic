package rs.raf.gerumap.gui.swing.controller.adapters;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorDiagram;

import java.awt.Color;
import java.io.IOException;

public class EditorDiagramAdapter extends BaseTypeAdapter<EditorDiagram> {

    public EditorDiagramAdapter(Gson gson) {
        super(gson);
    }

    @Override
    public void write(JsonWriter writer, EditorDiagram diagram) throws IOException {
        writer.beginObject();

        writer.name("width");
        writer.value(diagram.getActualWidth());

        writer.name("height");
        writer.value(diagram.getActualHeight());

        writer.name("backgroundColor");
        gson.getAdapter(Color.class).write(writer, diagram.getBackground());

        writer.endObject();
    }

    @Override
    public EditorDiagram read(JsonReader reader) throws IOException {
        reader.beginObject();

        reader.nextName();
        int width = reader.nextInt();

        reader.nextName();
        int height = reader.nextInt();

        reader.nextName();
        Color backgroundColor = gson.getAdapter(Color.class).read(reader);

        reader.endObject();

        EditorDiagram editorDiagram = new EditorDiagram();
        editorDiagram.setActualWidth(width);
        editorDiagram.setActualHeight(height);
        editorDiagram.setBackground(backgroundColor);

        return editorDiagram;
    }

}
