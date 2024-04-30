import java.util.*;

public class Use_custom_object_as_key {
    // Use custom object as key

    /*
     * Sebelum menggunakan objek Anda sendiri sebagai kunci, Anda harus mengganti
     * metode hashCode() dan equals() objek Anda.
     * 
     * Dalam kasus sederhana Anda akan memiliki sesuatu seperti:
     */

    private String name;

    Use_custom_object_as_key(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Use_custom_object_as_key) {
            return this.name.equals(((Use_custom_object_as_key) obj).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    /*
     * hashCode akan menentukan keranjang hash mana yang memiliki kunci tersebut
     * dan sama dengan akan memutuskan objek mana di dalam keranjang hash tersebut.
     */

    /*
     * Tanpa metode ini, referensi objek Anda akan digunakan untuk perbandingan di
     * atas yang tidak akan berfungsi kecuali Anda menggunakan referensi objek yang
     * sama setiap saat.
     */

    public static void main(String[] args) {
        // membuat objek Use_custom_object_as_key
        // Use_custom_object_as_key box1 = new Use_custom_object_as_key("box1");
        // Use_custom_object_as_key box2 = new Use_custom_object_as_key("box2");

        // HashMap<Use_custom_object_as_key, String> box3 = new HashMap<>();

        // // menambahkan nilai ke dalam Map
        // box3.put(box1, "Apple");
        // box3.put(box2, "Banana");

        // System.out.println(box3);
        /*
         * output:
         * 
         * {Use_custom_object_as_key@2e3bc6=Apple,
         * Use_custom_object_as_key@2e3bc7=Banana}
         */

        // printMap(box3);
        /*
         * output:
         * Key: box1, Value: Apple
         * Key: box2, Value: Banana
         */

    }

    // Metode untuk mencetak nilai Map
    // private static void printMap(Map<Use_custom_object_as_key, String> map) {
    // for (Map.Entry<Use_custom_object_as_key, String> entry : map.entrySet()) {
    // System.out.println("Key: " + entry.getKey().name + ", Value: " +
    // entry.getValue());
    // }
    // }
}
