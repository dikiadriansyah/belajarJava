import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Creating_a_comparator_using_comparing_method {
    // Creating a Comparator using comparing method/Membuat Komparator menggunakan
    // metode perbandingan

    // Comparator.comparing(Person::getName)

    /*
     * Ini menciptakan komparator untuk kelas Person yang menggunakan nama orang ini
     * sebagai sumber perbandingan. Juga dimungkinkan untuk menggunakan versi metode
     * untuk membandingkan long, int dan double. Misalnya:
     * 
     * Comparator.comparingInt(Person::getAge)
     */

    // Reversed order/Urutan terbalik
    // Untuk membuat pembanding yang menerapkan pengurutan terbalik, gunakan metode
    // reversed():
    // Comparator.comparing(Person::getName).reversed()

    // Chain of comparators/Rantai pembanding
    // Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName)
    /*
     * Ini akan membuat pembanding yang pertama dibandingkan dengan nama belakang
     * kemudian dibandingkan dengan nama depan. Anda dapat merangkai pembanding
     * sebanyak yang Anda inginkan.
     */

    public static void main(String[] args) {
        List<Person9> people = new ArrayList<>();
        people.add(new Person9("John", 30));
        people.add(new Person9("Alice", 25));
        people.add(new Person9("Bob", 35));

        // Menggunakan Comparator.comparing untuk membandingkan berdasarkan nama
        Collections.sort(people, Comparator.comparing(Person9::getName));

        // Menampilkan daftar orang yang sudah diurutkan
        System.out.println("Orang yang diurutkan berdasarkan nama:");
        for (Person9 person : people) {
            System.out.println(person);
        }
        /*
         * output:
         * Orang yang diurutkan berdasarkan nama:
         * Person{name='Alice', age=25}
         * Person{name='Bob', age=35}
         * Person{name='John', age=30}
         */
    }
}
