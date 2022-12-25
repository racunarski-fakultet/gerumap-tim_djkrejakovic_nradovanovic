package rs.raf.gerumap.gui.swing.controller.adapters;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.awt.Color;
import java.io.IOException;

public class ColorAdapter extends  BaseTypeAdapter<Color> {

    public ColorAdapter(Gson gson) {
        super(gson);
    }

    @Override
    public void write(JsonWriter writer, Color color) throws IOException {
        writer.beginObject();

        writer.name("red");
        writer.value(color.getRed());

        writer.name("green");
        writer.value(color.getGreen());

        writer.name("blue");
        writer.value(color.getBlue());

        writer.name("alpha");
        writer.value(color.getAlpha());

        writer.endObject();
    }

    @Override
    public Color read(JsonReader reader) throws IOException {
        reader.beginObject();

        reader.nextName();
        int red = reader.nextInt();

        reader.nextName();
        int green = reader.nextInt();

        reader.nextName();
        int blue = reader.nextInt();

        reader.nextName();
        int alpha = reader.nextInt();

        reader.endObject();

        return new Color(red, green, blue, alpha);
    }

}
