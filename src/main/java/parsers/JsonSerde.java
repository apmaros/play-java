package parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class JsonSerde<T> implements Serde<T> {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String serialize(T o) throws IOException {
        return mapper.writeValueAsString(o);
    }

    @Override
    public T deserialize(String src, Class<T> c) throws IOException {
        return mapper.readValue(src, c);
    }
}
