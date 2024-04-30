import java.util.NoSuchElementException;
import java.util.OptionalInt;

public class Using_optional_containers_for_primitive_number_types {
    // Using Optional containers for primitive number types /Menggunakan wadah
    // opsional untuk tipe bilangan primitif

    /*
     * OptionalDouble, OptionalInt, dan OptionalLong berfungsi seperti Opsional,
     * tetapi dirancang khusus untuk membungkus tipe primitif:
     * 
     * OptionalInt presentInt = OptionalInt.of(value);
     * OptionalInt absentInt = OptionalInt.empty();
     */

    // Karena tipe numerik memang mempunyai nilai, maka tidak ada penanganan khusus
    // untuk null. Wadah kosong dapat diperiksa dengan:

    /*
     * presentInt.isPresent(); // Is true.
     * absentInt.isPresent(); // Is false.
     */

    // Demikian pula, ada singkatan untuk membantu manajemen nilai:
    /*
     * // Prints the value since it is provided on creation.
     * presentInt.ifPresent(System.out::println);
     * // Gives the other value as the original Optional is empty.
     * int finalValue = absentInt.orElseGet(this::otherValue);
     * // Will throw a NoSuchElementException.
     * int nonexistentValue = absentInt.getAsInt();
     */

    public static void main(String[] args) {
        // Membuat OptionalInt dengan nilai tertentu
        int value = 42;
        OptionalInt presentInt = OptionalInt.of(value);

        // Membuat OptionalInt kosong
        OptionalInt absentInt = OptionalInt.empty();

        // Mencetak nilai karena sudah disediakan saat pembuatan.
        presentInt.ifPresent(System.out::println); // 42

        // Memberikan nilai lain karena Optional asli kosong.
        int finalValue = absentInt.orElseGet(Using_optional_containers_for_primitive_number_types::otherValue);
        System.out.println("Final Value: " + finalValue); // Final Value: 10

        try {
            // Akan melempar NoSuchElementException karena OptionalInt kosong.
            int nonexistentValue = absentInt.getAsInt();
        } catch (NoSuchElementException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        // Exception: No value present

    }

    // Metode untuk digunakan sebagai nilai alternatif
    private static int otherValue() {
        return 10;
    }

}
