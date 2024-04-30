import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import java.util.*;
import java.util.stream.*;

public class Create_a_map_based_on_a_stream {
        // Create a Map based on a Stream / Buat Peta berdasarkan Aliran

        // Simple case without duplicate keys / Kasing sederhana tanpa kunci duplikat

        /*
         * Stream<String> characters = Stream.of("A", "B", "C");
         * Map<Integer, String> map = characters
         * .collect(Collectors.toMap(element -> element.hashCode(), element ->
         * element));
         * // map = {65=A, 66=B, 67=C}
         * 
         */

        /*
         * Untuk membuatnya lebih deklaratif, kita dapat menggunakan metode statis di
         * antarmuka Fungsi - Function.identity(). Kita dapat
         * ganti lambda elemen-> elemen ini dengan Function.identity().
         */

        // Case where there might be duplicate keys / Kasus di mana mungkin ada kunci
        // duplikat

        // Javadoc untuk Collectors.toMap menyatakan:

        /*
         * Jika kunci yang dipetakan berisi duplikat (menurut Object.equals(Object)),
         * IllegalStateException akan dilempar saat operasi pengumpulan dilakukan. Jika
         * kunci yang dipetakan mungkin memiliki duplikat, gunakan toMap(Function,
         * Function, BinaryOperator) sebagai gantinya.
         */

        /*
         * Stream<String> characters = Stream.of("A", "B", "B", "C");
         * Map<Integer, String> map = characters
         * .collect(Collectors.toMap(
         * element -> element.hashCode(),
         * element -> element,
         * (existingVal, newVal) -> (existingVal + newVal)));
         * // map = {65=A, 66=BB, 67=C}
         */

        /*
         * BinaryOperator diteruskan ke Collectors.toMap(...) menghasilkan nilai untuk
         * disimpan jika terjadi tabrakan. Bisa:
         * 1. mengembalikan nilai lama, sehingga nilai pertama dalam aliran diutamakan,
         * 2. mengembalikan nilai baru, sehingga nilai terakhir dalam aliran diutamakan,
         * atau menggabungkan nilai-nilai lama dan baru
         */

        // Grouping by value/Pengelompokan berdasarkan nilai
        /*
         * Anda dapat menggunakan Collectors.groupingBy ketika Anda perlu melakukan hal
         * yang setara dengan database yang mengalirkan "kelompokkan menurut"
         * operasi. Sebagai gambaran, berikut ini dibuat peta yang mana nama orang
         * dipetakan menjadi nama keluarga:
         * 
         * List<Person> people = Arrays.asList(
         * new Person("Sam", "Rossi"),
         * new Person("Sam", "Verdi"),
         * new Person("John", "Bianchi"),
         * new Person("John", "Rossi"),
         * new Person("John", "Verdi")
         * );
         * Map<String, List<String>> map = people.stream()
         * .collect(
         * // function mapping input elements to keys
         * Collectors.groupingBy(Person::getName,
         * // function mapping input elements to values,
         * // how to store values
         * Collectors.mapping(Person::getSurname, Collectors.toList()))
         * );
         * // map = {John=[Bianchi, Rossi, Verdi], Sam=[Rossi, Verdi]}
         */

        public static void main(String[] args) {
                // Stream<String> characters = Stream.of("A", "B", "C");
                // Map<Integer, String> map = characters
                // .collect(Collectors.toMap(element -> element.hashCode(), element ->
                // element));
                // System.out.println("map = " + map);
                // output:
                // map = {65=A, 66=B, 67=C}

                // --------------------
                // Stream<String> characters = Stream.of("A", "B", "B", "C");
                // Map<Integer, String> map = characters
                // .collect(Collectors.toMap(
                // element -> element.hashCode(),
                // element -> element,
                // (existingVal, newVal) -> (existingVal + newVal)));

                // // Print the result
                // map.forEach((key, value) -> System.out.println(key + " -> " + value));
                /*
                 * output:
                 * 65 -> A
                 * 66 -> BB
                 * 67 -> C
                 */
                // --------------------
                // List<Person> people = Arrays.asList(
                // new Person("Sam", "Rossi"),
                // new Person("Sam", "Verdi"),
                // new Person("John", "Bianchi"),
                // new Person("John", "Rossi"),
                // new Person("John", "Verdi"));

                // Map<String, List<String>> map = people.stream()
                // .collect(
                // // function mapping input elements to keys
                // groupingBy(Person::getName,
                // // function mapping input elements to values,
                // // how to store values
                // mapping(Person::getSurname, toList()))

                // );
                // map = {John=[Bianchi, Rossi, Verdi], Sam=[Rossi, Verdi]}

                // System.out.println(map);
                /*
                 * output:
                 * {John=[Bianchi, Rossi, Verdi], Sam=[Rossi, Verdi]}
                 */
        }
}
