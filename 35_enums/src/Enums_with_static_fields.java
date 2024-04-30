import java.util.*;

public class Enums_with_static_fields {
    // Enums with static fields / Enum dengan bidang statis

    /*
     * Jika kelas enum Anda diharuskan memiliki bidang statis, ingatlah bahwa bidang
     * tersebut dibuat setelah nilai enum itu sendiri. Artinya, kode berikut akan
     * menghasilkan NullPointerException:
     */

    // enum Example {
    // ONE(1), TWO(2);

    // static Map<String, Integer> integers = new HashMap<>();

    // private Example(int value) {
    // integers.put(this.name(), value);
    // }
    // }

    // Cara yang mungkin untuk memperbaikinya:
    // enum Example2 {
    // ONE(1), TWO(2);

    // static Map<String, Integer> integers;

    // private Example2(int value) {
    // putValue(this.name(), value);
    // }

    // private static void putValue(String name, int value) {
    // if (integers == null)
    // integers = new HashMap<>();
    // integers.put(name, value);
    // }
    // }

    // Jangan inisialisasi bidang statis:
    // enum Example3 {
    // ONE(1), TWO(2);

    // after initialisisation integers is null!!
    // static Map<String, Integer> integers = null;

    // private Example3(int value) {
    // putValue(this.name(), value);
    // }

    // private static void putValue(String name, int value) {
    // if (integers == null)
    // integers = new HashMap<>();
    // integers.put(name, value);
    // }

    // // !!this may lead to null poiner exception!!
    // public int getValue() {
    // return (Example.integers.get(this.name()));
    // }
    // }

    /*
     * inisialisasi:
     * 1. buat nilai enum
     * sebagai efek samping putValue() disebut yang menginisialisasi bilangan bulat
     * 
     * 2. nilai statis ditetapkan
     * integers = null; // dieksekusi setelah enum sehingga isi bilangan bulat
     * hilang
     */

    public static void main(String[] args) {
        // System.out.println("Values in integers map:");
        // for (Map.Entry<String, Integer> entry : Example2.integers.entrySet()) {
        // System.out.println(entry.getKey() + ": " + entry.getValue());
        // }

        /*
         * output:
         * Values in integers map:
         * ONE: 1
         * TWO: 2
         */

    }
}
