package rs.raf.gerumap.gui.swing.controller.adapters;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.MindMap;

import java.io.IOException;

public class NodeMindMapAdapter extends BaseTypeAdapter<MindMap> {

    public NodeMindMapAdapter(Gson gson) {
        super(gson);
    }

    @Override
    public void write(JsonWriter writer, MindMap mindMap) throws IOException {
        writer.beginObject();
        writer.name("name");
        writer.value(mindMap.getName());
        writer.endObject();
    }

    @Override
    public MindMap read(JsonReader reader) throws IOException {
        reader.beginObject();

        reader.nextName();
        String name = reader.nextString();

        reader.endObject();

        return new MindMap(name, null);
    }

}
