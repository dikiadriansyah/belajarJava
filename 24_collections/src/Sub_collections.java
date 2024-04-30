import java.util.*;

public class Sub_collections {
    // Sub Collections
    public static void main(String[] args) {
        // List subList(int fromIndex, int toIndex)
        /*
         * Di sini fromIndex bersifat inklusif dan toIndex bersifat eksklusif.
         * List list = new ArrayList();
         * List list1 = list.subList(fromIndex,toIndex);
         * 
         * 1. Jika daftar tidak ada dalam rentang yang diberikan, ia akan memunculkan
         * IndexOutofBoundException.
         * 2. Perubahan apa pun yang dilakukan pada list1 akan berdampak pada perubahan
         * yang sama pada daftar. Ini disebut koleksi yang didukung.
         * 3. Jika fromnIndex lebih besar dari toIndex (fromIndex > toIndex) maka
         * IllegalArgumentException akan muncul.
         */

        // Contoh:
        // List<String> list = new ArrayList<String>();

        List<String> list = new ArrayList<String>();
        list.add("Apple");
        list.add("Banana");
        // System.out.println("Before Sublist " + list);

        List<String> list2 = list.subList(0, 1);
        list2.add("Cherry");
        // System.out.println("After sublist changes " + list);
        /*
         * output:
         * Before Sublist [Apple, Banana]
         * After sublist changes [Apple, Cherry, Banana]
         */

        // Set subSet(fromIndex,toIndex)
        /*
         * Di sini fromIndex bersifat inklusif dan toIndex bersifat eksklusif.
         */

        // Set set = new TreeSet();

        // Menentukan indeks awal dan akhir untuk subset
        // int fromIndex = 2;
        // int toIndex = 4;
        // Set set1 = set.subSet(fromIndex, toIndex);
        /*
         * Set yang dikembalikan akan memunculkan IllegalArgumentException saat mencoba
         * memasukkan elemen di luar jangkauannya
         */

        // Map subMap(fromKey,toKey)
        /*
         * fromKey bersifat inklusif dan toKey bersifat eksklusif
         */
        TreeMap<Integer, String> map = new TreeMap<>();

        // Menambahkan elemen ke dalam TreeMap
        map.put(1, "Nilai 1");
        map.put(2, "Nilai 2");
        map.put(3, "Nilai 3");
        map.put(4, "Nilai 4");
        map.put(5, "Nilai 5");

        // Menampilkan isi TreeMap
        System.out.println("Map sebelum pembuatan submap: " + map);
        /*
         * output:
         * Map sebelum pembuatan submap: {1=Nilai 1, 2=Nilai 2, 3=Nilai 3, 4=Nilai 4,
         * 5=Nilai 5}
         */

        // Menentukan kunci awal dan kunci akhir untuk submap
        int fromKey = 2;
        int toKey = 4;

        // Membuat submap menggunakan subMap
        // Map<Integer, String> map1 = map.subMap(fromKey, toKey);
        /*
         * Jika fromKey lebih besar dari toKey atau jika peta ini sendiri memiliki
         * jangkauan terbatas, dan fromKey atau toKey terletak di luar batas jangkauan,
         * maka IllegalArgumentException akan muncul.
         * 
         * Semua koleksi mendukung koleksi yang didukung berarti perubahan yang
         * dilakukan pada subkoleksi akan memiliki perubahan yang sama pada koleksi
         * utama.
         */
    }
}
