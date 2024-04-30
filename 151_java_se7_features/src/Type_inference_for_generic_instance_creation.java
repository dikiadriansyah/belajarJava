import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.util.Map;

public class Type_inference_for_generic_instance_creation {
    // Type Inference for Generic Instance Creation/Ketik Inferensi untuk Pembuatan
    // Instans Generik

    // Anda dapat gunakan
    /*
     * Map<String, List<String>> myMap = new HashMap<>();
     * 
     * alih-alih
     * Map<String, List<String>> myMap = new HashMap<String, List<String>>();
     */

    // Namun, Anda tidak dapat menggunakannya
    /*
     * List<String> list = new ArrayList<>();
     * list.add("A");
     * // The following statement should fail since addAll expects
     * // Collection<? extends String>
     * list.addAll(new ArrayList<>());
     * 
     */

    /*
     * karena tidak dapat dikompilasi. Perhatikan bahwa berlian sering kali
     * berfungsi dalam pemanggilan metode; namun, disarankan agar Anda menggunakan
     * berlian terutama untuk deklarasi variabel.
     */

    public static void main(String[] args) throws Exception {
        // Deklarasi dan inisialisasi myMap
        Map<String, List<String>> myMap = new HashMap<String, List<String>>();

        // Menambahkan data ke dalam myMap
        List<String> list1 = new ArrayList<String>();
        list1.add("Nilai 1");
        list1.add("Nilai 2");

        List<String> list2 = new ArrayList<String>();
        list2.add("Nilai 3");
        list2.add("Nilai 4");

        myMap.put("Kunci1", list1);
        myMap.put("Kunci2", list2);

        // Menampilkan hasil
        System.out.println("Isi myMap:");
        for (Map.Entry<String, List<String>> entry : myMap.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            System.out.println("Kunci: " + key + ", Nilai: " + value);
        }

        /*
         * output:
         * Isi myMap:
         * Kunci: Kunci2, Nilai: [Nilai 3, Nilai 4]
         * Kunci: Kunci1, Nilai: [Nilai 1, Nilai 2]
         */

    }
}
