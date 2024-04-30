import java.util.Optional;

public class Lazily_provide_a_default_value_using_a_supplier {
    // Lazily provide a default value using a Supplier/Dengan malas memberikan nilai
    // default menggunakan Pemasok

    /*
     * Metode orElse normal mengambil sebuah Objek, jadi Anda mungkin bertanya-tanya
     * mengapa ada opsi untuk menyediakan Pemasok di sini (metode orElseGet).
     */

    // Mempertimbangkan:

    /*
     * String value = "something";
     * return Optional.ofNullable(value)
     * .orElse(getValueThatIsHardToCalculate()); // returns "something"
     */

    /*
     * Itu akan tetap memanggil getValueThatIsHardToCalculate() meskipun hasilnya
     * tidak digunakan karena opsionalnya tidak kosong.
     * 
     * Untuk menghindari penalti ini, Anda memberikan pemasok:
     */

    /*
     * String value = "something";
     * return Optional.ofNullable(value)
     * .orElseGet(() -> getValueThatIsHardToCalculate()); // returns "something"
     * 
     */

    /*
     * Dengan cara ini getValueThatIsHardToCalculate() hanya akan dipanggil jika
     * Opsionalnya kosong.
     */

    public static void main(String[] args) {
        String value = "something";
        String result = Optional.ofNullable(value)
                .orElse(getValueThatIsHardToCalculate());

        System.out.println(result); // output: something
    }

    private static String getValueThatIsHardToCalculate() {
        // Logic to calculate the value that is hard to calculate
        return "calculatedValue";
    }

}
