import java.util.*;

public class Sorting_a_list_using_comparable_t_or_a_comparator {
    // Sorting a List using Comparable<T> or a Comparator<T> / Mengurutkan Daftar
    // menggunakan Comparable<T> atau Comparator<T>

    /*
     * Katakanlah kita sedang mengerjakan sebuah kelas yang mewakili Seseorang
     * dengan nama depan dan belakangnya. Kami telah membuat kelas dasar untuk
     * melakukan hal ini dan menerapkan metode equals dan hashCode yang tepat.
     */

    /*
     * public class Person {
     * private final String lastName; //invariant - nonnull
     * private final String firstName; //invariant - nonnull
     * public Person(String firstName, String lastName){
     * this.firstName = firstName != null ? firstName : "";
     * this.lastName = lastName != null ? lastName : "";
     * }
     * public String getFirstName() {
     * return firstName;
     * }
     * public String getLastName() {
     * return lastName;
     * }
     * public String toString() {
     * return lastName + ", " + firstName;
     * }
     * 
     * @Override
     * public boolean equals(Object o) {
     * if (! (o instanceof Person)) return false;
     * Person p = (Person)o;
     * return firstName.equals(p.firstName) && lastName.equals(p.lastName);
     * }
     * 
     * @Override
     * public int hashCode() {
     * return Objects.hash(firstName, lastName);
     * }
     * }
     */

    // Sekarang kita ingin mengurutkan daftar objek Person berdasarkan namanya,
    // seperti dalam skenario berikut:

    /*
     * public static void main(String[] args) {
     * List<Person> people = Arrays.asList(new Person("John", "Doe"),
     * new Person("Bob", "Dole"),
     * new Person("Ronald", "McDonald"),
     * new Person("Alice", "McDonald"),
     * new Person("Jill", "Doe"));
     * Collections.sort(people); //This currently won't work.
     * }
     */

    /*
     * Sayangnya, seperti yang ditandai, hal di atas saat ini tidak dapat
     * dikompilasi. Collections.sort(..) hanya mengetahui cara mengurutkan daftar
     * jika elemen dalam daftar tersebut sebanding, atau metode perbandingan khusus
     * diberikan.
     * 
     * Jika Anda diminta untuk mengurutkan daftar berikut : 1,3,5,4,2, Anda tidak
     * akan kesulitan mengatakan jawabannya adalah 1,2,3,4,5. Hal ini karena Integer
     * (baik dalam Java dan matematis) memiliki pengurutan alami, pengurutan dasar
     * perbandingan standar dan default. Untuk memberikan pengurutan alami pada
     * kelas Person, kami menerapkan Comparable<Person>, yang memerlukan penerapan
     * metode compareTo(Person p):
     */

    /*
     * public class Person implements Comparable<Person> {
     * private final String lastName; //invariant - nonnull
     * private final String firstName; //invariant - nonnull
     * public Person(String firstName, String lastName) {
     * this.firstName = firstName != null ? firstName : "";
     * this.lastName = lastName != null ? lastName : "";
     * }
     * public String getFirstName() {
     * return firstName;
     * }
     * public String getLastName() {
     * return lastName;
     * }
     * public String toString() {
     * return lastName + ", " + firstName;
     * }
     * 
     * @Override
     * public boolean equals(Object o) {
     * if (! (o instanceof Person)) return false;
     * Person p = (Person)o;
     * return firstName.equals(p.firstName) && lastName.equals(p.lastName);
     * }
     * 
     * @Override
     * public int hashCode() {
     * return Objects.hash(firstName, lastName);
     * }
     * 
     * @Override
     * public int compareTo(Person other) {
     * // If this' lastName and other's lastName are not comparably equivalent,
     * // Compare this to other by comparing their last names.
     * // Otherwise, compare this to other by comparing their first names
     * int lastNameCompare = lastName.compareTo(other.lastName);
     * if (lastNameCompare != 0) {
     * return lastNameCompare;
     * } else {
     * return firstName.compareTo(other.firstName);
     * }
     * }
     * }
     * 
     */

    // Sekarang, metode utama yang diberikan akan berfungsi dengan benar
    /*
     * public static void main(String[] args) {
     * List<Person> people = Arrays.asList(new Person("John", "Doe"),
     * new Person("Bob", "Dole"),
     * new Person("Ronald", "McDonald"),
     * new Person("Alice", "McDonald"),
     * new Person("Jill", "Doe"));
     * Collections.sort(people); //Now functions correctly
     * //people is now sorted by last name, then first name:
     * // --> Jill Doe, John Doe, Bob Dole, Alice McDonald, Ronald McDonald
     * }
     * 
     */

    /*
     * Namun, jika Anda tidak ingin atau tidak dapat mengubah kelas Person, Anda
     * dapat menyediakan Comparator<T> khusus
     * yang menangani perbandingan dua objek Person. Jika Anda diminta untuk
     * mengurutkan daftar berikut: circle,
     * square, rectangle, triangle, hexagon Anda tidak bisa, tetapi jika
     * Anda diminta untuk mengurutkan daftar itu berdasarkan jumlah sudutnya, Anda
     * bisa. Demikian pula, menyediakan komparator menginstruksikan Java bagaimana
     * membandingkan dua objek yang biasanya tidak sebanding.
     */

    /*
     * public class PersonComparator implements Comparator<Person> {
     * public int compare(Person p1, Person p2) {
     * // If p1's lastName and p2's lastName are not comparably equivalent,
     * // Compare p1 to p2 by comparing their last names.
     * // Otherwise, compare p1 to p2 by comparing their first names
     * if (p1.getLastName().compareTo(p2.getLastName()) != 0) {
     * return p1.getLastName().compareTo(p2.getLastName());
     * } else {
     * return p1.getFirstName().compareTo(p2.getFirstName());
     * }
     * }
     * }
     * 
     * //Assume the first version of Person (that does not implement Comparable) is
     * used here
     * public static void main(String[] args) {
     * List<Person> people = Arrays.asList(new Person("John", "Doe"),
     * new Person("Bob", "Dole"),
     * new Person("Ronald", "McDonald"),
     * new Person("Alice", "McDonald"),
     * new Person("Jill", "Doe"));
     * Collections.sort(people); //Illegal, Person doesn't implement Comparable.
     * Collections.sort(people, new PersonComparator()); //Legal
     * //people is now sorted by last name, then first name:
     * // --> Jill Doe, John Doe, Bob Dole, Alice McDonald, Ronald McDonald
     * }
     */

    // Pembanding juga dapat dibuat/digunakan sebagai kelas dalam anonim

    /*
     * //Assume the first version of Person (that does not implement Comparable) is
     * used here
     * public static void main(String[] args) {
     * List<Person> people = Arrays.asList(new Person("John", "Doe"),
     * new Person("Bob", "Dole"),
     * new Person("Ronald", "McDonald"),
     * new Person("Alice", "McDonald"),
     * new Person("Jill", "Doe"));
     * Collections.sort(people); //Illegal, Person doesn't implement Comparable.
     * Collections.sort(people, new PersonComparator()); //Legal
     * //people is now sorted by last name, then first name:
     * // --> Jill Doe, John Doe, Bob Dole, Alice McDonald, Ronald McDonald
     * //Anonymous Class
     * Collections.sort(people, new Comparator<Person>() { //Legal
     * public int compare(Person p1, Person p2) {
     * //Method code...
     * }
     * });
     * }
     */

    // Version ≥ Java SE 8
    // Lambda expression based comparators / Pembanding berbasis ekspresi Lambda

    /*
     * Pada Java 8, pembanding juga dapat dinyatakan sebagai ekspresi lambda
     * //Lambda
     * Collections.sort(people, (p1, p2) -> { //Legal
     * //Method code....
     * });
     */

    // Comparator default methods/Metode default komparator
    /*
     * Selain itu, ada metode default yang menarik pada antarmuka Comparator untuk
     * membuat komparator: berikut ini membuat komparator yang membandingkan
     * berdasarkan lastName dan kemudian firstName.
     * Collections.sort(people, Comparator.comparing(Person::getLastName)
     * .thenComparing(Person::getFirstName));
     */

    // Inversing the order of a comparator/Membalikkan urutan pembanding

    // Komparator apa pun juga dapat dengan mudah dibalik menggunakan reversedMethod
    // yang akan mengubah urutan dari menaik menjadi menurun.

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // List<Person7> people = Arrays.asList(new Person7("John", "Doe"),
        // new Person7("Bob", "Dole"),
        // new Person7("Ronald", "McDonald"),
        // new Person7("Alice", "McDonald"),
        // new Person7("Jill", "Doe"));
        // Collections.sort(people,
        // Comparator.comparing(Person7::getLastName).thenComparing(Person7::getFirstName));
        // // This
        // // currently
        // // won't
        // // work.

        // for (Person7 person : people) {
        // System.out.println(person);
        // }
        /*
         * output:
         * Doe, Jill
         * Doe, John
         * Dole, Bob
         * McDonald, Alice
         * McDonald, Ronald
         */
        // ------------------
        // List<Person7> people = Arrays.asList(new Person7("John", "Doe"),
        // new Person7("Bob", "Dole"),
        // new Person7("Ronald", "McDonald"),
        // new Person7("Alice", "McDonald"),
        // new Person7("Jill", "Doe"));
        // Collections.sort(people); // Now functions correctly //people is now sorted
        // by last name, then first name:
        // // --> Jill Doe, John Doe, Bob Dole, Alice McDonald, Ronald McDonald

        // for (Person7 person : people) {
        // System.out.println(person);
        // }
        /*
         * output:
         * Doe, Jill
         * Doe, John
         * Dole, Bob
         * McDonald, Alice
         * McDonald, Ronald
         */

        // ---------------
        // List<Person7> people = Arrays.asList(new Person7("John", "Doe"),
        // new Person7("Bob", "Dole"),
        // new Person7("Ronald", "McDonald"),
        // new Person7("Alice", "McDonald"),
        // new Person7("Jill", "Doe"));
        // Collections.sort(people); // Illegal, Person doesn't implement Comparable.
        // Collections.sort(people, new PersonComparator()); // Legal
        // // people is now sorted by last name, then first name:
        // // --> Jill Doe, John Doe, Bob Dole, Alice McDonald, Ronald McDonald

        // for (Person7 person : people) {
        // System.out.println(person);
        // }
        /*
         * output:
         * Doe, Jill
         * Doe, John
         * Dole, Bob
         * McDonald, Alice
         * McDonald, Ronald
         */

        // ---------------
        List<Person7> people = Arrays.asList(new Person7("John", "Doe"),
                new Person7("Bob", "Dole"),
                new Person7("Ronald", "McDonald"),
                new Person7("Alice", "McDonald"),
                new Person7("Jill", "Doe"));
        Collections.sort(people); // Illegal, Person doesn't implement Comparable.
        Collections.sort(people, new PersonComparator()); // Legal
        // people is now sorted by last name, then first name:
        // --> Jill Doe, John Doe, Bob Dole, Alice McDonald, Ronald McDonald
        for (Person7 person : people) {
            System.out.println(person);
        }
        /*
         * output:
         * Doe, Jill
         * Doe, John
         * Dole, Bob
         * McDonald, Alice
         */

        // Anonymous Class
        // Collections.sort(people, new Comparator<Person7>() { // Legal
        // public int compare(Person7 p1, Person7 p2) {
        // // Method code...
        // }
        // });
    }
}
