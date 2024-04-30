import java.util.Arrays;

public class How_do_you_change_the_size_of_an_array {
    // How do you change the size of an array?
    /*
     * Jawaban sederhananya adalah Anda tidak bisa melakukan ini. Setelah array
     * dibuat, ukurannya tidak dapat diubah. Alih-alih, sebuah array hanya dapat
     * "diubah ukurannya" dengan membuat array baru dengan ukuran yang sesuai dan
     * menyalin elemen dari array yang ada ke array yang baru.
     */
    public static void main(String[] args) {
        String[] listOfCities = new String[3]; // array created with size 3.
        listOfCities[0] = "New York";
        listOfCities[1] = "London";
        listOfCities[2] = "Berlin";
        /*
         * Misalkan (misalnya) elemen baru perlu ditambahkan ke array listOfCities yang
         * didefinisikan seperti di atas. Untuk melakukan ini, Anda perlu:
         * 1. buat new array dengan size 4,
         * 2. salin 3 elemen array lama yang ada ke array baru pada offset 0, 1 dan 2,
         * dan
         * 3. tambahkan elemen baru ke new array di offset 3.
         * 
         * Ada berbagai cara untuk melakukan hal di atas. Sebelum Java 6, cara paling
         * ringkas adalah:
         */
        String[] newArray = new String[listOfCities.length + 1];
        System.arraycopy(listOfCities, 0, newArray, 0, listOfCities.length);
        newArray[listOfCities.length] = "Sydney";

        // System.out.println("Data Bawaan: ");
        // for (String city : listOfCities) {
        // System.out.println(city);
        // }
        /*
         * Data Bawaan:
         * New York
         * London
         * Berlin
         */

        // System.out.println("Data Baru: ");
        // for (String city : newArray) {
        // System.out.println(city);
        // }
        /*
         * Data Baru:
         * New York
         * London
         * Berlin
         * Sydney
         */

        /*
         * Mulai Java 6 dan seterusnya, metode Arrays.copyOf dan Arrays.copyOfRange
         * dapat melakukan ini dengan lebih sederhana
         */

        String[] newArray2 = Arrays.copyOf(listOfCities, listOfCities.length + 1);
        newArray2[listOfCities.length] = "Sydney";
        for (String city : newArray2) {
            System.out.println(city);
        }
        /*
         * New York
         * London
         * Berlin
         * Sydney
         */

        /*
         * Untuk cara lain menyalin array, lihat contoh berikut. Ingatlah bahwa Anda
         * memerlukan salinan array dengan panjang yang berbeda dari aslinya saat
         * mengubah ukuran.
         * - Copying arrays
         */

        // A better alternatives to array resizing
        /*
         * Ada dua kelemahan utama dalam mengubah ukuran array seperti dijelaskan di
         * atas:
         * 1. Tidak efisien. Membuat array lebih besar (atau lebih kecil) melibatkan
         * penyalinan banyak atau semua elemen array yang ada, dan mengalokasikan objek
         * array baru. Semakin besar susunannya, semakin mahal harganya.
         * 
         * 2. Anda harus dapat memperbarui variabel "langsung" apa pun yang berisi
         * referensi ke array lama.
         */
        /*
         * Salah satu alternatifnya adalah membuat array dengan ukuran yang cukup besar
         * untuk memulai. Ini hanya dapat dilakukan jika Anda dapat menentukan ukuran
         * tersebut secara akurat sebelum mengalokasikan array. Jika Anda tidak dapat
         * melakukan itu, maka masalah mengubah ukuran array akan muncul lagi.
         * 
         * Alternatif lainnya adalah dengan menggunakan kelas struktur data yang
         * disediakan oleh perpustakaan kelas Java SE atau perpustakaan pihak ketiga.
         * Misalnya, kerangka kerja "koleksi" Java SE menyediakan sejumlah implementasi
         * List, Set, dan Maps API dengan properti runtime yang berbeda. Kelas
         * ArrayList paling dekat dengan karakteristik kinerja array biasa (mis.
         * O(N) pencarian, O(1) dapatkan dan setel, O(N) penyisipan dan penghapusan
         * acak) sambil memberikan pengubahan ukuran yang lebih efisien tanpa masalah
         * pembaruan referensi.
         * 
         * (Efisiensi pengubahan ukuran untuk ArrayList berasal dari strateginya dalam
         * menggandakan ukuran array pendukung pada setiap pengubahan ukuran.
         * Untuk kasus penggunaan umum, ini berarti Anda hanya mengubah ukuran sesekali.
         * Saat Anda mengamortisasi sepanjang umur daftar tersebut,
         * biaya pengubahan ukuran per sisipan adalah O(1). Dimungkinkan untuk
         * menggunakan strategi yang sama ketika mengubah ukuran array biasa.)
         */
    }
}
