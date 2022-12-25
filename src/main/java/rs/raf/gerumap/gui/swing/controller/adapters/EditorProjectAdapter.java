package rs.raf.gerumap.gui.swing.controller.adapters;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorPage;
import rs.raf.gerumap.gui.swing.view.workspace.editor.view.EditorProject;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.ExplorerProjectItem;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.Project;

import java.io.IOException;
import java.util.UUID;

public class EditorProjectAdapter extends BaseTypeAdapter<EditorProject> {

    public EditorProjectAdapter(Gson gson) {
        super(gson);
    }

    @Override
    public void write(JsonWriter writer, EditorProject editorProject) throws IOException {
        writer.beginObject();

        writer.name("name");
        writer.value(editorProject.getProject().getName());

        writer.name("id");
        writer.value(editorProject.getProject().getIdentifier().toString());

        writer.name("file");
        writer.value(editorProject.getProject().getFileLocation());

        writer.name("pages");

        writer.beginArray();

        for (EditorPage editorPage : editorProject.getPages())
            gson.getAdapter(EditorPage.class).write(writer, editorPage);

        writer.endArray();

        writer.endObject();
    }

    @Override
    public EditorProject read(JsonReader reader) throws IOException {
        reader.beginObject();

        reader.nextName();
        String name = reader.nextString();

        reader.nextName();
        String id = gson.getAdapter(String.class).read(reader);

        reader.nextName();
        String fileLocation = gson.getAdapter(String.class).read(reader);

        Project project = new Project(name, explorer.getRoot().getNode(), UUID.fromString(id), fileLocation);

        ExplorerProjectItem explorerProjectItem = new ExplorerProjectItem(project);

        if (!explorer.addItem(explorerProjectItem))
            return null;

        reader.nextName();
        reader.beginArray();

        while (reader.peek() == JsonToken.BEGIN_OBJECT)
            gson.getAdapter(EditorPage.class).read(reader);

        reader.endArray();

        reader.endObject();

        return (EditorProject) explorerProjectItem.getComponent();
    }

}
