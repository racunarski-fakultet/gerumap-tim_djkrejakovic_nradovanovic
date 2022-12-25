package rs.raf.gerumap.gui.swing.controller.adapters;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import rs.raf.gerumap.gui.swing.view.workspace.explorer.model.tree.explorer.Element;

import java.io.IOException;

public class NodeElementAdapter extends BaseTypeAdapter<Element> {

    public NodeElementAdapter(Gson gson) {
        super(gson);
    }

    @Override
    public void write(JsonWriter jsonWriter, Element element) throws IOException {

    }

    @Override
    public Element read(JsonReader jsonReader) throws IOException {
        return null;
    }

}
