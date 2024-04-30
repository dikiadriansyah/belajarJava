import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Person {
    final String name, surname;

    public Person(String n, String s) {
        this.name = n;
        this.surname = s;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
