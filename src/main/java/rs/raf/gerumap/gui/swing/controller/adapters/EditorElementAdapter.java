package rs.raf.gerumap.gui.swing.controller.adapters;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConcept;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConnection;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorElement;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerElementItem;

import java.io.IOException;

public class EditorElementAdapter extends BaseTypeAdapter<EditorElement> {

    public EditorElementAdapter(Gson gson) {
        super(gson);
    }

    @Override
    public void write(JsonWriter writer, EditorElement editorElement) throws IOException {
        writer.beginObject();

        writer.name("type");
        writer.value(editorElement.getType());

        writer.name("element");

        if (editorElement.getType() == 1)
            gson.getAdapter(GraphicConcept.class).write(writer, (GraphicConcept) editorElement.getGraphicElement());
        else
            gson.getAdapter(GraphicConnection.class).write(writer, (GraphicConnection) editorElement.getGraphicElement());

        writer.endObject();
    }

    @Override
    public EditorElement read(JsonReader reader) throws IOException {
        reader.beginObject();

        reader.nextName();
        int type = reader.nextInt();

        reader.nextName();

        GraphicElement graphicElement = type == 1 ? gson.getAdapter(GraphicConcept.class).read(reader) : gson.getAdapter(GraphicConnection.class).read(reader);

        reader.endObject();

        EditorElement editorElement = new EditorElement(graphicElement);
        explorer.addItem(new ExplorerElementItem(graphicElement, editorElement));

        return editorElement;
    }

}
