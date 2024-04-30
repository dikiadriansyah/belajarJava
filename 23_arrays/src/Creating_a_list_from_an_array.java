import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Creating_a_list_from_an_array {
    // Creating a List from an Array
    /*
     * Metode Arrays.asList() dapat digunakan untuk mengembalikan List berukuran
     * tetap yang berisi elemen array tertentu.
     * 
     * Daftar yang dihasilkan akan memiliki tipe parameter yang sama dengan tipe
     * dasar array
     */
    public static void main(String[] args) throws Exception {
        String[] stringArray = { "foo", "bar", "baz" };
        List<String> stringList = Arrays.asList(stringArray);
        // System.out.println(stringList); // [foo, bar, baz]

        /*
         * Catatan: List ini didukung oleh (tampilan) array asli, artinya setiap
         * perubahan pada List akan mengubah array dan sebaliknya. Namun, perubahan
         * pada List yang akan mengubah ukurannya (dan karenanya panjang array) akan
         * menimbulkan pengecualian.
         * 
         * Untuk membuat salinan daftar, gunakan konstruktor java.util.ArrayList dengan
         * menggunakan Koleksi sebagai argumen:
         * 
         */
        String[] box1 = { "apel", "belimbing", "ceri" };
        List<String> box2 = new ArrayList<String>(Arrays.asList(box1));
        // System.out.println(box2); // [apel, belimbing, ceri]

        /*
         * Di Java SE 7 dan yang lebih baru, sepasang tanda kurung siku <> (kumpulan
         * argumen tipe kosong) dapat digunakan, yang disebut
         * Berlian. Kompiler dapat menentukan argumen tipe dari konteksnya. Ini berarti
         * informasi tipe dapat diabaikan saat memanggil konstruktor ArrayList dan akan
         * disimpulkan secara otomatis selama kompilasi. Ini disebut Type Inference yang
         * merupakan bagian dari Java Generics.
         */

        // Using Arrays.asList()
        String[] box3 = { "foo", "bar", "baz" };
        List<String> box4 = new ArrayList<>(Arrays.asList(box3));
        // System.out.println(box4); // [foo, bar, baz]

        // Using ArrayList.addAll()
        String[] box5 = { "foo", "bar", "baz" };
        ArrayList<String> box6 = new ArrayList<>();
        box6.addAll(Arrays.asList(box5));
        // System.out.println(box6); // [foo, bar, baz]

        // Using Collections.addAll()
        String[] box7 = { "foo", "bar", "baz" };
        ArrayList<String> box8 = new ArrayList<>();
        boolean box9 = Collections.addAll(box8, box7);
        // System.out.println(box9); // true

        // Hal yang perlu diperhatikan tentang Berlian adalah bahwa Berlian tidak dapat
        // digunakan dengan Kelas Anonim.
        // Using Streams
        int[] box10 = { 1, 2, 3 };
        List<Integer> box11 = Arrays.stream(box10).boxed().collect(Collectors.toList());
        // System.out.println(box11); // [1,2,3]

        String[] box12 = { "foo", "bar", "baz" };
        List<Object> box13 = Arrays.stream(box12).collect(Collectors.toList());
        // System.out.println(box13); // [foo, bar, baz]

        // Important notes related to using Arrays.asList() method(Catatan penting
        // terkait penggunaan metode Arrays.asList())
        /*
         * 1. Metode ini mengembalikan List, yang merupakan turunan dari
         * Arrays$ArrayList(kelas dalam statis dari Array) dan bukan
         * java.util.ArrayList. List yang dihasilkan berukuran tetap. Artinya,
         * menambah atau menghapus elemen tidak didukung dan akan memunculkan
         * UnsupportedOperationException:
         * stringList.add("something"); // throws
         * java.lang.UnsupportedOperationException
         * 
         * 2. new List dapat dibuat dengan meneruskan List yang didukung array ke
         * konstruktor new List . Ini membuat salinan data baru, yang ukurannya dapat
         * diubah dan tidak didukung oleh array asli
         * List<String> modifiableList = new ArrayList<>(Arrays.asList("foo", "bar"));
         * 
         * 3. Memanggil <T> List<T> asList(T... a) pada array primitif, seperti int[],
         * akan menghasilkan List<int[]>
         * yang satu-satunya elemennya adalah array primitif sumber, bukan elemen
         * sebenarnya dari array sumber.
         * 
         * Alasan perilaku ini adalah tipe primitif tidak dapat digunakan sebagai
         * pengganti parameter tipe generik, sehingga seluruh array primitif
         * menggantikan parameter tipe generik dalam kasus ini. Untuk mengonversi array
         * primitif menjadi Daftar, pertama-tama, konversikan array primitif menjadi
         * array dengan tipe pembungkus yang sesuai (yaitu panggilan
         * Arrays.asList pada Integer[] bukannya int[]).
         * 
         * Oleh karena itu, ini akan mencetak false:
         * 
         * 
         */
        int[] box14 = { 1, 2, 3 }; // primitive array of int
        // System.out.println(Arrays.asList(box14).contains(1)); // false

        // Di sisi lain, ini akan mencetak true:
        Integer[] box15 = { 1, 2, 3 }; // object array of Integer (wrapper for int)
        // System.out.println(Arrays.asList(box15).contains(1)); // true

        // Ini juga akan mencetak nilai true, karena array akan ditafsirkan sebagai
        // Integer[]):
        System.out.println(Arrays.asList(1, 2, 3).contains(1)); // true
    }
}
