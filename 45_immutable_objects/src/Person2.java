import java.util.*;

public final class Person2 {
    private final String name;
    private String surname;

    public Person2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
