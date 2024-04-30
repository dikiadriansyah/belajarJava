import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Method_references {
    // Method References/Referensi Metode

    /*
     * Referensi metode memungkinkan metode statis atau instan yang telah ditentukan
     * sebelumnya yang mematuhi antarmuka fungsional yang kompatibel untuk
     * diteruskan sebagai argumen, bukan ekspresi lambda anonim.
     * 
     * Asumsikan kita mempunyai model:
     * class Person {
     * private final String name;
     * private final String surname;
     * public Person(String name, String surname){
     * this.name = name;
     * this.surname = surname;
     * }
     * public String getName(){ return name; }
     * public String getSurname(){ return surname; }
     * }
     * List<Person> people = getSomePeople();
     */

    /*
     * Instance method reference (to an arbitrary instance)/Referensi metode instan
     * (ke instans arbitrer)
     * people.stream().map(Person::getName)
     * 
     * Lambda yang setara:
     * people.stream().map(person -> person.getName())
     * 
     * Dalam contoh ini, referensi metode ke metode instan getName() bertipe Person,
     * sedang diteruskan. Karena diketahui tipe koleksinya, metode pada instance
     * (dikenal nanti) akan dipanggil.
     */

    /*
     * Instance method reference (to a specific instance)/Referensi metode instance
     * (ke instance tertentu)
     * people.forEach(System.out::println);
     * 
     * Karena System.out adalah turunan dari PrintStream, referensi metode ke contoh
     * khusus ini diteruskan sebagai argumen.
     * 
     * Lambda yang setara:
     * people.forEach(person -> System.out.println(person));
     */

    /*
     * Static method reference/Referensi metode statis
     * Juga untuk mentransformasikan aliran kita dapat menerapkan referensi ke
     * metode statis:
     * List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
     * numbers.stream().map(String::valueOf)
     * 
     * Contoh ini meneruskan referensi ke metode statis valueOf() pada tipe String.
     * Oleh karena itu, objek instance dalam koleksi diteruskan sebagai argumen ke
     * valueOf().
     * Lambda yang setara:
     * numbers.stream().map(num -> String.valueOf(num))
     */

    /*
     * Reference to a constructor/Referensi ke konstruktor
     * List<String> strings = Arrays.asList("1", "2", "3");
     * strings.stream().map(Integer::new)
     * 
     * Baca Mengumpulkan Elemen Aliran ke dalam Koleksi untuk melihat cara
     * mengumpulkan elemen ke dalam koleksi.
     * 
     * 
     * Konstruktor argumen String tunggal bertipe Integer digunakan di sini, untuk
     * membuat bilangan bulat berdasarkan string yang disediakan sebagai argumen.
     * Dalam hal ini, selama string mewakili angka, aliran akan dipetakan ke
     * Integer. Lambda yang setara:
     * strings.stream().map(s -> new Integer(s));
     */

    /*
     * Cheat-Sheet
     * Method Reference Format | Code | Equivalent Lambda
     * Static method | TypeName::method (args) -> TypeName.method(args)
     * Non-static method (on instance*) | instance::method (args) ->
     * instance.method(args)
     * Non-static method (no instance) | TypeName::method (instance, args) ->
     * instance.method(args)
     * Constructor** | TypeName::new (args) -> new TypeName(args)
     * Array constructor | TypeName[]::new (int size) -> new TypeName[size]
     * 
     * 
     * * instance dapat berupa ekspresi apa pun yang mengevaluasi referensi ke suatu
     * instance, mis. getInstance()::metode, this::method
     * 
     * ** Jika TypeName adalah kelas dalam non-statis, referensi konstruktor hanya
     * valid dalam lingkup kelas luar contoh
     */

    public static void main(String[] args) {
        // List<Person5> people = getSomePeople();

        // Menggunakan stream dan map untuk mendapatkan list nama dari people
        // List<String> names = people.stream()
        // .map(Person5::getName)
        // .collect(Collectors.toList());

        // Menampilkan hasil
        // System.out.println("List Nama:");
        // names.forEach(System.out::println);
        /*
         * output:
         * List Nama:
         * John
         * Jane
         * Alice
         */
        // -----------------------
        // List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Menggunakan Stream dan map untuk mengubah Integer menjadi String
        // List<String> stringNumbers = numbers.stream()
        // .map(String::valueOf)
        // .collect(Collectors.toList());

        // Menampilkan hasil
        // System.out.println("List of Strings: " + stringNumbers);
        /*
         * output:
         * List of Strings: [1, 2, 3, 4, 5, 6]
         */
        // -----------------------
        List<String> strings = Arrays.asList("1", "2", "3");

        // Mengubah List<String> menjadi List<Integer> menggunakan Stream API
        List<Integer> integers = strings.stream()
                .map(Integer::new)
                .collect(Collectors.toList());

        // Menampilkan hasil konversi
        System.out.println("List<String>: " + strings); // List<String>: [1, 2, 3]
        System.out.println("List<Integer>: " + integers); // List<Integer>: [1, 2, 3]
    }

    // Fungsi untuk mendapatkan beberapa objek Person
    private static List<Person5> getSomePeople() {
        List<Person5> people = new ArrayList<>();
        people.add(new Person5("John", "Doe"));
        people.add(new Person5("Jane", "Doe"));
        people.add(new Person5("Alice", "Smith"));
        return people;
    }

}
