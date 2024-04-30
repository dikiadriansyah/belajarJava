import java.util.Optional;

public class Map {
    // Map

    /*
     * Gunakan metode map() dari Opsional untuk bekerja dengan nilai yang mungkin
     * nol tanpa melakukan pemeriksaan nol secara eksplisit:
     * 
     * (Perhatikan bahwa operasi map() dan filter() dievaluasi segera, tidak seperti
     * operasi Stream yang hanya dievaluasi pada operasi terminal.)
     */

    /*
     * Sintaks:
     * public <U> Optional<U> map(Function<? super T,? extends U> mapper)
     */

    // contoh kode:
    /*
     * String value = null;
     * return Optional.ofNullable(value).map(String::toUpperCase).orElse("NONE");
     * // returns "NONE"
     * String value = "something";
     * return Optional.ofNullable(value).map(String::toUpperCase).orElse("NONE");
     * // returns "SOMETHING"
     * 
     */

    /*
     * Karena Optional.map() mengembalikan opsional kosong ketika fungsi pemetaannya
     * mengembalikan null, Anda dapat merangkai beberapa operasi map() sebagai
     * bentuk dereferensi yang aman untuk null. Ini juga dikenal sebagai rangkaian
     * Null-safe.
     */

    // Perhatikan contoh berikut:
    // String value = foo.getBar().getBaz().toString();

    // GetBar, getBaz, dan toString mana pun berpotensi memunculkan
    // NullPointerException.

    // Berikut ini cara alternatif untuk mendapatkan nilai dari toString()
    // menggunakan Opsional:

    /*
     * String value = Optional.ofNullable(foo)
     * .map(Foo::getBar)
     * .map(Bar::getBaz)
     * .map(Baz::toString)
     * .orElse("");
     */

    /*
     * Ini akan mengembalikan string kosong jika salah satu fungsi pemetaan
     * mengembalikan null.
     * 
     * Di bawah ini adalah contoh lain, namun sedikit berbeda. Ini akan mencetak
     * nilai hanya jika tidak ada fungsi pemetaan yang mengembalikan null.
     */

    /*
     * Optional.ofNullable(foo)
     * .map(Foo::getBar)
     * .map(Bar::getBaz)
     * .map(Baz::toString)
     * .ifPresent(System.out::println);
     */

    public static final String Entry = null;

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        String value = "something";
        String result = transformString(value);
        System.out.println(result); // Something
    }

    public static String transformString(String value) {
        return Optional.ofNullable(value)
                .map(String::toUpperCase)
                .orElse("NONE");
    }

}
