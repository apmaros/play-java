package parsers;

import org.junit.Test;
import parsers.model.Person;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonSerdeTest {

    @Test
    public void deserializeValidJson() throws IOException {
        JsonSerde<Person> serde = new JsonSerde<>();
        String json = "{\"firstname\": \"John\", \"lastname\":\"Doe\", \"age\":35}";
        Person person = serde.deserialize(json, Person.class);
        assertEquals("John", person.getFirstname());
        assertEquals("Doe", person.getLastname());
        assertEquals(36, person.getAge());
    }

    @Test
    public void deserializethrowsWhenInvalidJson() {
        IOException e = assertThrows(IOException.class, () -> {
            JsonSerde<Person> serde = new JsonSerde<>();
            String json = "{\"invalidName\": \"John\", \"lastname\":\"Doe\", \"age\":35}";
            serde.deserialize(json, Person.class);
        });
    }

    @Test
    public void serialize() throws IOException {
        JsonSerde<Person> serde = new JsonSerde<>();
        String json = "{\"firstname\":\"John\",\"lastname\":\"Doe\",\"age\":35}";
        Person p = new Person("John", "Doe", 35);
        String v = serde.serialize(p);
        assertEquals(json, v);
    }

}
