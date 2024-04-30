import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

public class Using_lambda_expressions_to_sort_a_collection {
    // Using Lambda Expressions to Sort a Collection/Menggunakan Ekspresi Lambda
    // untuk Mengurutkan Koleksi

    // Sorting lists/Daftar penyortiran

    /*
     * Sebelum Java 8, antarmuka java.util.Comparator perlu diimplementasikan dengan
     * kelas anonim (atau bernama) saat mengurutkan list1:
     * Version ≥ Java SE 1.2
     * 
     * List<Person> people = ...
     * Collections.sort(
     * people,
     * new Comparator<Person>() {
     * public int compare(Person p1, Person p2){
     * return p1.getFirstName().compareTo(p2.getFirstName());
     * }
     * }
     * );
     * 
     */

    /*
     * Dimulai dengan Java 8, kelas anonim bisa diganti dengan ekspresi lambda.
     * Perhatikan bahwa tipe untuk parameter p1 dan p2 dapat diabaikan, karena
     * kompiler akan menyimpulkannya secara otomatis:
     * Collections.sort(
     * people,
     * (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName())
     * );
     */

    /*
     * Contohnya dapat disederhanakan dengan menggunakan Comparator.comparing dan
     * referensi metode dinyatakan dengan menggunakan simbol :: (titik dua).
     * 
     * Collections.sort(
     * people,
     * Comparator.comparing(Person::getFirstName)
     * );
     */

    /*
     * Impor statis memungkinkan kami mengungkapkan hal ini dengan lebih ringkas,
     * namun masih diperdebatkan apakah hal ini meningkatkan keterbacaan secara
     * keseluruhan:
     * import static java.util.Collections.sort;
     * import static java.util.Comparator.comparing;
     * //...
     * sort(people, comparing(Person::getFirstName));
     */

    /*
     * Pembanding yang dibuat dengan cara ini juga dapat dirangkai bersama.
     * Misalnya, setelah membandingkan orang berdasarkan nama depannya,
     * jika ada orang dengan nama depan yang sama, maka metode perbandingan juga
     * membandingkan berdasarkan nama belakang:
     * sort(people,
     * comparing(Person::getFirstName).thenComparing(Person::getLastName));
     */

    /*
     * 1 - Perhatikan bahwa Collections.sort(...) hanya berfungsi pada koleksi yang
     * merupakan subtipe list. Set dan Collection API tidak menyiratkan pengurutan
     * elemen apa pun.
     */

    // Sorting maps/Menyortir peta
    /*
     * Anda dapat mengurutkan entri HashMap berdasarkan nilai dengan cara yang sama.
     * (Perhatikan bahwa LinkedHashMap harus digunakan sebagai target. Kunci dalam
     * HashMap biasa tidak berurutan.)
     * 
     * Map<String, Integer> map = new HashMap(); // ... or any other Map class
     * // populate the map
     * map = map.entrySet()
     * .stream()
     * .sorted(Map.Entry.<String, Integer>comparingByValue())
     * .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue(),
     * (k, v) -> k, LinkedHashMap::new));
     */

    public static void main(String[] args) {
        // Membuat daftar orang
        // List<Person4> people = new ArrayList<>();
        // people.add(new Person4("John"));
        // people.add(new Person4("Alice"));
        // people.add(new Person4("Bob"));

        // Menggunakan Comparator tradisional dengan anonymous class
        // Collections.sort(
        // people,
        // new Comparator<Person4>() {
        // public int compare(Person4 p1, Person4 p2) {
        // return p1.getFirstName3().compareTo(p2.getFirstName3());
        // }
        // });

        // Menampilkan hasil pengurutan
        // System.out.println("Hasil pengurutan menggunakan anonymous class:");
        // for (Person4 person : people) {
        // System.out.println(person.getFirstName3());
        // }

        /*
         * output:
         * Hasil pengurutan menggunakan anonymous class:
         * Alice
         * Bob
         * John
         */

        // Menggunakan Comparator dengan ekspresi lambda
        // Collections.sort(
        // people,
        // Comparator.comparing(Person4::getFirstName3));

        // Menampilkan hasil pengurutan
        // System.out.println("\nHasil pengurutan menggunakan ekspresi lambda:");
        // for (Person4 person : people) {
        // System.out.println(person.getFirstName3());
        // }
        /*
         * output:
         * Hasil pengurutan menggunakan ekspresi lambda:
         * Alice
         * Bob
         * John
         */
        // ------------------------------
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 90);
        map.put("Python", 95);
        map.put("C++", 80);
        map.put("JavaScript", 88);

        // Menyortir map berdasarkan nilai (value)
        map = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (k, v) -> k,
                        LinkedHashMap::new));

        // Menampilkan hasil setelah disortir
        System.out.println("Map setelah disortir berdasarkan nilai (value): " + map);
        /*
         * output:
         * Map setelah disortir berdasarkan nilai (value): {C++=80, JavaScript=88,
         * Java=90, Python=95}
         */
    }
}
