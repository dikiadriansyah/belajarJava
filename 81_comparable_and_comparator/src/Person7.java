import java.util.*;

public class Person7 implements Comparable<Person7> {

    // private final String lastName; // invariant - nonnull
    // private final String firstName; // invariant - nonnull

    // public Person7(String firstName, String lastName) {
    // this.firstName = firstName != null ? firstName : "";
    // this.lastName = lastName != null ? lastName : "";
    // }

    // public String getFirstName() {
    // return firstName;
    // }

    // public String getLastName() {
    // return lastName;
    // }

    // public String toString() {
    // return lastName + ", " + firstName;
    // }

    // @Override
    // public boolean equals(Object o) {
    // if (!(o instanceof Person7))
    // return false;
    // Person7 p = (Person7) o;
    // return firstName.equals(p.firstName) && lastName.equals(p.lastName);
    // }

    // @Override
    // public int hashCode() {
    // return Objects.hash(firstName, lastName);
    // }
    // ----------------------
    private final String lastName; // invariant - nonnull
    private final String firstName; // invariant - nonnull

    public Person7(String firstName, String lastName) {
        this.firstName = firstName != null ? firstName : "";
        this.lastName = lastName != null ? lastName : "";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return lastName + ", " + firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person7))
            return false;
        Person7 p = (Person7) o;
        return firstName.equals(p.firstName) && lastName.equals(p.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public int compareTo(Person7 other) {
        // If this' lastName and other's lastName are not comparably equivalent,
        // Compare this to other by comparing their last names.
        // Otherwise, compare this to other by comparing their first names
        int lastNameCompare = lastName.compareTo(other.lastName);
        if (lastNameCompare != 0) {
            return lastNameCompare;
        } else {
            return firstName.compareTo(other.firstName);
        }
    }

}
