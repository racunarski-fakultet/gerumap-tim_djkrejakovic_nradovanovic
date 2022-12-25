package rs.raf.gerumap.gui.swing.controller.adapters;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorDiagram;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorElement;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorPage;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerMindMapItem;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.MindMap;

import java.io.IOException;
import java.util.UUID;

public class EditorPageAdapter extends BaseTypeAdapter<EditorPage> {

    public EditorPageAdapter(Gson gson) {
        super(gson);
    }

    @Override
    public void write(JsonWriter writer, EditorPage editorPage) throws IOException {
        writer.beginObject();

        writer.name("name");
        writer.value(editorPage.getMindMap().getName());

        writer.name("id");
        writer.value(editorPage.getMindMap().getIdentifier().toString());

        writer.name("file");
        writer.value(editorPage.getMindMap().getFileLocation());

        writer.name("diagram");
        gson.getAdapter(EditorDiagram.class).write(writer, editorPage.getDiagram());

        writer.name("elements");
        writer.beginArray();

        for (EditorElement editorElement : editorPage.getEditorElements())
            gson.getAdapter(EditorElement.class).write(writer, editorElement);

        writer.endArray();

        writer.endObject();
    }

    @Override
    public EditorPage read(JsonReader reader) throws IOException {
        reader.beginObject();

        reader.nextName();
        String name = reader.nextString();

        reader.nextName();
        String id = gson.getAdapter(String.class).read(reader);

        reader.nextName();
        String fileLocation = gson.getAdapter(String.class).read(reader);

        MindMap mindMap = new MindMap(name, editor.getActiveProject().getProject(), UUID.fromString(id), fileLocation);

        reader.nextName();
        EditorDiagram editorDiagram = gson.getAdapter(EditorDiagram.class).read(reader);

        EditorPage editorPage = new EditorPage(mindMap, editorDiagram);

        if (!explorer.addItem(new ExplorerMindMapItem(mindMap, editorPage)))
            return null;

        editorPage.getDiagram().updateScaledSize();

        reader.nextName();
        reader.beginArray();

        while(reader.peek() == JsonToken.BEGIN_OBJECT)
            gson.getAdapter(EditorElement.class).read(reader);

        reader.endArray();

        reader.endObject();

        return editorPage;
    }

}
