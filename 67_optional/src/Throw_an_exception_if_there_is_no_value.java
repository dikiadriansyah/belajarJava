import java.util.Optional;

public class Throw_an_exception_if_there_is_no_value {
    // Throw an exception, if there is no value/Lemparkan pengecualian, jika tidak
    // ada nilai

    /*
     * Gunakan metode orElseThrow() dari Opsional untuk mendapatkan nilai yang
     * terkandung atau memberikan pengecualian, jika belum disetel.
     * Ini mirip dengan pemanggilan get(), hanya saja ia memperbolehkan tipe
     * pengecualian arbitrer. Metode ini membutuhkan pemasok yang harus
     * mengembalikan pengecualian untuk dilempar.
     * 
     * Pada contoh pertama, metode ini hanya mengembalikan nilai yang ada di
     * dalamnya:
     * Optional optional = Optional.of("something");
     * return optional.orElseThrow(IllegalArgumentException::new);
     * // returns "something" string
     */

    /*
     * Pada contoh kedua, metode ini memunculkan pengecualian karena nilai belum
     * ditetapkan:
     * Optional optional = Optional.empty();
     * return optional.orElseThrow(IllegalArgumentException::new);
     * // throws IllegalArgumentException
     */

    /*
     * Anda juga dapat menggunakan sintaks lambda jika diperlukan pengecualian
     * dengan pesan:
     * optional.orElseThrow(() -> new IllegalArgumentException("Illegal"));
     */

    public static void main(String[] args) {
        String result = getValue().orElseThrow(IllegalArgumentException::new);
        System.out.println(result); // something
    }

    private static Optional<String> getValue() {
        Optional<String> optional = Optional.of("something");
        return optional;
    }

}
