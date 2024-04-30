public class Enum_polymorphism_pattern {
    // Enum Polymorphism Pattern / Pola Polimorfisme Enum

    /*
     * Ketika suatu metode perlu menerima kumpulan nilai enum yang
     * "dapat diperluas", pemrogram dapat menerapkan polimorfisme seperti pada kelas
     * normal dengan membuat antarmuka yang akan digunakan di mana pun enum akan
     * digunakan:
     */

    public interface ExtensibleEnum {
        String name();
    }

    /*
     * Dengan cara ini, setiap enum yang ditandai oleh (implementasi) antarmuka
     * dapat digunakan sebagai parameter, memungkinkan pemrogram untuk membuat
     * sejumlah variabel enum yang akan diterima oleh metode tersebut. Hal ini dapat
     * berguna, misalnya, pada API yang memiliki enum default (tidak dapat
     * dimodifikasi) dan pengguna API ini ingin "memperluas" enum dengan lebih
     * banyak nilai.
     */

    // Satu set nilai enum default dapat didefinisikan sebagai berikut:

    public enum DefaultValues implements ExtensibleEnum {
        VALUE_ONE, VALUE_TWO;
    }

    // Nilai tambahan kemudian dapat didefinisikan seperti ini:

    public enum ExtendedValues implements ExtensibleEnum {
        VALUE_THREE, VALUE_FOUR;
    }

    // Contoh yang menunjukkan cara menggunakan enum - perhatikan bagaimana
    // printEnum() menerima nilai dari kedua tipe enum:

    private void printEnum(ExtensibleEnum val) {
        System.out.println(val.name());
    }

    public static void main(String[] args) {
        Enum_polymorphism_pattern example = new Enum_polymorphism_pattern();

        example.printEnum(DefaultValues.VALUE_ONE); // VALUE_ONE
        example.printEnum(DefaultValues.VALUE_TWO); // VALUE_TWO
        example.printEnum(ExtendedValues.VALUE_THREE); // VALUE_THREE
        example.printEnum(ExtendedValues.VALUE_FOUR); // VALUE_FOUR

        /*
         * Catatan: Pola ini tidak menghalangi Anda untuk mendefinisikan ulang nilai
         * enum, yang sudah ditentukan dalam satu enum, di enum lain. Nilai enum ini
         * akan menjadi contoh yang berbeda. Selain itu, tidak mungkin menggunakan
         * switch-on-enum karena yang kita miliki hanyalah antarmuka, bukan enum
         * sebenarnya.
         */
    }
}
