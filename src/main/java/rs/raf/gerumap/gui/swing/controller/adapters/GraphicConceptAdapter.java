package rs.raf.gerumap.gui.swing.controller.adapters;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import rs.raf.gerumap.gui.swing.view.workspace.editor.graphics.GraphicConcept;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.UUID;

public class GraphicConceptAdapter extends BaseTypeAdapter<GraphicConcept> {

    public GraphicConceptAdapter(Gson gson) {
        super(gson);
    }

    @Override
    public void write(JsonWriter writer, GraphicConcept graphicConcept) throws IOException {
        writer.beginObject();

        writer.name("id");
        writer.value(graphicConcept.getIdentifier().toString());

        writer.name("name");
        writer.value(graphicConcept.getName());

        writer.name("isCentral");
        writer.value(graphicConcept.isCentral());

        writer.name("x");
        writer.value(graphicConcept.getX());

        writer.name("y");
        writer.value(graphicConcept.getY());

        writer.name("width");
        writer.value(graphicConcept.getWidth());

        writer.name("height");
        writer.value(graphicConcept.getHeight());

        writer.name("content");
        writer.value(graphicConcept.getText());

        writer.name("backgroundColor");
        gson.getAdapter(Color.class).write(writer, graphicConcept.getBackgroundColor());

        writer.name("foregroundColor");
        gson.getAdapter(Color.class).write(writer, graphicConcept.getForegroundColor());

        writer.name("strokeColor");
        gson.getAdapter(Color.class).write(writer, graphicConcept.getStrokeColor());

        writer.name("selectionStrokeColor");
        gson.getAdapter(Color.class).write(writer, graphicConcept.getSelectionStrokeColor());

        writer.name("strokeWidth");
        writer.value(graphicConcept.getStrokeWidth());

        writer.name("selectionStrokeWidth");
        writer.value(graphicConcept.getSelectionStrokeWidth());

        writer.endObject();
    }

    @Override
    public GraphicConcept read(JsonReader reader) throws IOException {
        reader.beginObject();

        reader.nextName();
        String id = reader.nextString();

        reader.nextName();
        String name = reader.nextString();

        reader.nextName();
        boolean isCentral = reader.nextBoolean();

        reader.nextName();
        double x = reader.nextDouble();

        reader.nextName();
        double y = reader.nextDouble();

        reader.nextName();
        double width = reader.nextDouble();

        reader.nextName();
        double height = reader.nextDouble();

        reader.nextName();
        String content = reader.nextString();

        reader.nextName();
        Color backgroundColor = gson.getAdapter(Color.class).read(reader);

        reader.nextName();
        Color foregroundColor = gson.getAdapter(Color.class).read(reader);

        reader.nextName();
        Color strokeColor = gson.getAdapter(Color.class).read(reader);

        reader.nextName();
        Color selectionStrokeColor = gson.getAdapter(Color.class).read(reader);

        reader.nextName();
        float strokeWidth = (float) reader.nextDouble();

        reader.nextName();
        float selectionStrokeWidth = (float) reader.nextDouble();

        reader.endObject();

        GraphicConcept graphicConcept = new GraphicConcept(new Point2D.Double(x, y), UUID.fromString(id));
        graphicConcept.setName(name);
        graphicConcept.setCentral(isCentral);
        graphicConcept.setSize(width, height);
        graphicConcept.setBackgroundColor(backgroundColor);
        graphicConcept.setForegroundColor(foregroundColor);
        graphicConcept.setStrokeColor(strokeColor);
        graphicConcept.setSelectionStrokeColor(selectionStrokeColor);
        graphicConcept.setStrokeWidth(strokeWidth);
        graphicConcept.setSelectionStrokeWidth(selectionStrokeWidth);
        graphicConcept.setText(content);

        return graphicConcept;
    }

}
