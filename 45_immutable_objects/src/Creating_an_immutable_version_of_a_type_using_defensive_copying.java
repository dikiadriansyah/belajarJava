import java.util.Arrays;

public class Creating_an_immutable_version_of_a_type_using_defensive_copying {

    // Creating an immutable version of a type using defensive copying / Membuat
    // versi tipe yang tidak dapat diubah menggunakan penyalinan defensif

    /*
     * Beberapa tipe dan kelas dasar di Java pada dasarnya bisa berubah. Misalnya,
     * semua tipe array bisa berubah, begitu pula kelas seperti java.util.Data. Ini
     * bisa menjadi canggung dalam situasi di mana tipe yang tidak dapat diubah
     * diamanatkan.
     * 
     * Salah satu cara untuk mengatasinya adalah dengan membuat pembungkus yang
     * tidak dapat diubah untuk tipe yang dapat diubah. Berikut adalah pembungkus
     * sederhana untuk array bilangan bulat(integers)
     */

    /*
     * public class ImmutableIntArray {
     * private final int[] array;
     * 
     * public ImmutableIntArray(int[] array) {
     * this.array = array.clone();
     * }
     * public int[] getValue() {
     * return this.clone();
     * }
     * }
     */

    /*
     * Kelas ini bekerja dengan menggunakan penyalinan defensif untuk mengisolasi
     * keadaan yang bisa diubah (int[]) dari kode apa pun yang mungkin mengubahnya:
     * 1. Konstruktor menggunakan clone() untuk membuat salinan berbeda dari array
     * parameter. Jika pemanggil konstruktor selanjutnya mengubah larik parameter,
     * hal ini tidak akan memengaruhi status ImmutableIntArray.
     * 2. Metode getValue() juga menggunakan clone() untuk membuat array yang
     * dikembalikan. Jika pemanggil mengubah larik hasil, hal itu tidak akan
     * memengaruhi status ImmutableIntArray.
     * 
     */

    /*
     * Kita juga bisa menambahkan metode ke ImmutableIntArray untuk melakukan
     * operasi read-only pada array yang dibungkus; misalnya mendapatkan panjangnya,
     * mendapatkan nilai pada indeks tertentu, dan seterusnya.
     * 
     * Perhatikan bahwa tipe pembungkus yang tidak dapat diubah yang diterapkan
     * dengan cara ini bukanlah tipe yang kompatibel dengan tipe aslinya. Anda tidak
     * bisa begitu saja mengganti yang pertama dengan yang kedua.
     */

    private final int[] array;

    public Creating_an_immutable_version_of_a_type_using_defensive_copying(int[] array) {
        // Membuat salinan dari array agar tidak dapat diubah dari luar kelas
        this.array = array.clone();
    }

    public int[] getValue() {
        // Mengembalikan salinan dari array agar nilai asli tetap tidak dapat diubah
        return array.clone();
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Contoh penggunaan kelas
        // Creating_an_immutable_version_of_a_type_using_defensive_copying
        int[] originalArray = { 1, 2, 3, 4, 5 };
        Creating_an_immutable_version_of_a_type_using_defensive_copying immutableArray = new Creating_an_immutable_version_of_a_type_using_defensive_copying(
                originalArray);

        // Mengambil nilai array dari objek ImmutableIntArray
        int[] retrievedArray = immutableArray.getValue();

        // Menampilkan nilai array asli
        System.out.println("Original Array: " + Arrays.toString(originalArray)); // Original Array: [1, 2, 3, 4, 5]

        // Menampilkan nilai array yang diambil dari objek ImmutableIntArray
        System.out.println("Retrieved Array: " + Arrays.toString(retrievedArray)); // Retrieved Array: [1, 2, 3, 4, 5]

        // Mengubah nilai dalam array asli
        originalArray[0] = 100;

        // Menampilkan nilai array asli setelah diubah
        System.out.println("Modified Original Array: " + Arrays.toString(originalArray)); // Modified Original Array:
                                                                                          // [100, 2, 3, 4, 5]

        // Menampilkan nilai array yang diambil dari objek ImmutableIntArray (harus
        // tetap tidak berubah)
        System.out.println("Retrieved Array after Modification: " + Arrays.toString(immutableArray.getValue())); // Retrieved
                                                                                                                 // Array
                                                                                                                 // after
                                                                                                                 // Modification:
                                                                                                                 // [1,
                                                                                                                 // 2,
                                                                                                                 // 3,
                                                                                                                 // 4,
                                                                                                                 // 5]
    }
}
