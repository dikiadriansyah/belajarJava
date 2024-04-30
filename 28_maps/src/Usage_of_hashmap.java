import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Usage_of_hashmap {
    // Usage of HashMap

    public static void main(String[] args) {
        /*
         * HashMap adalah implementasi antarmuka Peta yang menyediakan Struktur Data
         * untuk menyimpan data dalam pasangan Key-Value.
         */

        // 1. Declaring HashMap (Mendeklarasikan HashMap)
        /*
         * Map<KeyType, ValueType> myMap = new HashMap<KeyType, ValueType>();
         * 
         * KeyType dan ValueType harus berupa tipe yang valid di Java, seperti - String,
         * Integer, Float atau kelas khusus apa pun seperti Employee, Student, dll.
         */

        // For Example :
        Map<String, Integer> myMap = new HashMap<String, Integer>();

        // myMap.put("Bakso", 13000);
        // myMap.put("Es Teh", 5000);
        // myMap.put("Nasi Goreng Seafood", 27000);

        // System.out.println("Daftar Makanan: " + myMap);
        /*
         * Daftar Makanan: {Nasi Goreng Seafood=27000, Bakso=13000, Es Teh=5000}
         */

        // 2. Putting values in HashMap(Menempatkan nilai di HashMap).
        /*
         * Untuk memberi nilai pada HashMap, kita harus memanggil metode put pada objek
         * HashMap dengan meneruskan key dan value sebagai parameter.
         */
        myMap.put("Bakso", 13000);
        myMap.put("Es Teh", 5000);

        /*
         * Jika Anda memanggil metode put dengan key yang sudah ada di Map, metode
         * tersebut akan mengganti nilainya dan mengembalikan nilai lama.
         */

        // 3. Getting values from HashMap(Mendapatkan nilai dari HashMap).
        /*
         * Untuk mendapatkan nilai dari HashMap Anda harus memanggil metode get, dengan
         * meneruskan Kunci sebagai parameter.
         */
        myMap.get("key1"); // return 1 (class Integer)
        // Jika Anda meneruskan kunci yang tidak ada di HashMap, metode ini akan
        // mengembalikan null

        // 4. Check whether the Key is in the Map or not (Periksa apakah Kuncinya ada di
        // Peta atau tidak)
        String varKey = "Bakso";
        boolean result = myMap.containsKey(varKey);
        System.out.println("Apakah map berisi key bakso? " + result);
        /*
         * Apakah map berisi key bakso? true
         */

        // 5. Check whether the Value is in the Map or not(Periksa apakah Nilainya ada
        // di Peta atau tidak).
        // myMap.containsValue(varValue);

        /*
         * Metode di atas akan mengembalikan nilai boolean benar atau salah jika kunci,
         * nilai ada di Map atau tidak.
         */
    }
}
