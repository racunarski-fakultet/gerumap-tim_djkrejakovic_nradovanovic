package rs.raf.gerumap.gui.swing.controller.adapters;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class StringAdapter extends BaseTypeAdapter<String> {

    public StringAdapter(Gson gson) {
        super(gson);
    }

    @Override
    public void write(JsonWriter writer, String string) throws IOException {
        writer.value(string);
    }

    @Override
    public String read(JsonReader reader) throws IOException {
        if (reader.peek() != JsonToken.NULL)
            return reader.nextString();

        reader.nextNull();
        return null;
    }

}
