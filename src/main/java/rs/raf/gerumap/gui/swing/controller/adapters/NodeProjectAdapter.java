package rs.raf.gerumap.gui.swing.controller.adapters;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.Project;

import java.io.IOException;

public class NodeProjectAdapter extends BaseTypeAdapter<Project> {

    public NodeProjectAdapter(Gson gson) {
        super(gson);
    }

    @Override
    public void write(JsonWriter writer, Project project) throws IOException {
        writer.beginObject();

        writer.name("name");
        writer.value(project.getName());

        writer.endObject();
    }

    @Override
    public Project read(JsonReader reader) throws IOException {
        reader.beginObject();

        reader.nextName();
        String name = reader.nextString();

        reader.endObject();

        return new Project(name, null);
    }

}
