package rs.raf.gerumap.gui.swing.controller.adapters;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConcept;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConnection;

import java.io.IOException;
import java.util.UUID;

public class GraphicConnectionAdapter extends BaseTypeAdapter<GraphicConnection> {

    public GraphicConnectionAdapter(Gson gson) {
        super(gson);
    }

    @Override
    public void write(JsonWriter writer, GraphicConnection graphicConnection) throws IOException {
        writer.beginObject();

        writer.name("id");
        writer.value(graphicConnection.getIdentifier().toString());

        writer.name("name");
        writer.value(graphicConnection.getName());

        writer.name("firstId");
        writer.value(graphicConnection.getFirst().getIdentifier().toString());

        writer.name("secondId");
        writer.value(graphicConnection.getSecond().getIdentifier().toString());

        writer.endObject();
    }

    @Override
    public GraphicConnection read(JsonReader reader) throws IOException {
        reader.beginObject();

        reader.nextName();
        String id = reader.nextString();

        reader.nextName();
        String name = reader.nextString();

        reader.nextName();
        String firstId = reader.nextString();

        reader.nextName();
        String secondId = reader.nextString();

        reader.endObject();

        GraphicConcept firstConcept  = (GraphicConcept) editor.getActivePage().getGraphicElement(UUID.fromString(firstId));
        GraphicConcept secondConcept = (GraphicConcept) editor.getActivePage().getGraphicElement(UUID.fromString(secondId));

        GraphicConnection graphicConnection = new GraphicConnection(firstConcept, UUID.fromString(id));
        graphicConnection.setSecond(secondConcept);
        graphicConnection.setName(name);

        return graphicConnection;
    }

}
