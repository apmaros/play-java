package parsers;

import java.io.IOException;

public interface Serde<T> {
    public String serialize(T o) throws IOException;
    T deserialize(String src, Class<T> c) throws IOException;
}
