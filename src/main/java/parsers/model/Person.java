package parsers.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private String firstname;
    private String lastname;
    private int age;

    public Person(
            @JsonProperty("firstname") String firstname,
            @JsonProperty("lastname") String lastname,
            @JsonProperty("age") int age
    ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }
}
