import java.util.*;

public class Person8 implements Comparable<Person8> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person8 o) {
        return this.getAge() - o.getAge();
    }

    @Override
    public String toString() {
        return this.getAge() + "-" + this.getName();
    }
}
