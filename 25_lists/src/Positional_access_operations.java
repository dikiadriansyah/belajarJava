import java.util.*;

public class Positional_access_operations {
    // Positional Access Operations

    public static void main(String[] args) {
        /*
         * List API memiliki delapan metode untuk operasi akses posisi:
         * add(T type)
         * add(int index, T type)
         * remove(Object o)
         * remove(int index)
         * get(int index)
         * set(int index, E element)
         * int indexOf(Object o)
         * int lastIndexOf(Object o)
         * 
         * Jadi, jika kita memiliki Daftar:
         */
        List<String> strings = new ArrayList<String>();
        /*
         * Dan kami ingin menambahkan string "Halo dunia!" dan "Selamat tinggal dunia!"
         * untuk itu, kami akan melakukannya seperti ini:
         */
        strings.add("Hello world!");
        strings.add("Goodbye world!");

        /*
         * Dan daftar kami akan berisi dua elemen tersebut. Sekarang katakanlah kita
         * ingin menambahkan "Program dimulai!" di bagian depan daftar. Kami akan
         * melakukan ini seperti ini:
         */
        strings.add(0, "Program starting!");

        // NOTE: The first element is 0.
        /*
         * Sekarang, jika kita ingin menghapus pesan "Selamat tinggal dunia!" baris,
         * kita bisa melakukannya seperti ini:
         */
        strings.remove("Goodbye world!");

        /*
         * Dan jika kita ingin menghapus baris pertama (yang dalam hal ini adalah
         * "Program dimulai!", kita dapat melakukannya seperti ini:
         */

        strings.remove(0);

        /*
         * Catatan:
         * 1. Menambah dan menghapus elemen daftar akan mengubah daftar, dan ini dapat
         * menyebabkan ConcurrentModificationException jika daftar sedang diulang secara
         * bersamaan.
         * 2. Menambah dan menghapus elemen bisa O(1) atau O(N) tergantung pada kelas
         * daftar, metode yang digunakan, dan apakah Anda menambahkan/menghapus elemen
         * di awal, akhir, atau di tengah daftar.
         */

        /*
         * Untuk mengambil elemen daftar pada posisi tertentu Anda dapat menggunakan
         * metode E get(int index); metode Daftar API. Misalnya:
         */
        strings.get(0);

        /*
         * akan mengembalikan elemen pertama dari daftar.
         * 
         * Anda dapat mengganti elemen apa pun pada posisi tertentu dengan menggunakan
         * set(int indeks, elemen E);. Misalnya:
         */
        strings.set(0, "This is a replacement");

        /*
         * Ini akan menetapkan String "Ini adalah pengganti" sebagai elemen pertama dari
         * daftar.
         * 
         * Catatan: Metode set akan menimpa elemen pada posisi 0. Metode ini tidak akan
         * menambahkan String baru pada posisi 0
         * dan dorong yang lama ke posisi 1.
         * 
         * int indexOf(Objek o); mengembalikan posisi kemunculan pertama objek yang
         * diteruskan sebagai argumen. Jika tidak ada kemunculan objek dalam daftar maka
         * nilai -1 dikembalikan. Melanjutkan contoh sebelumnya jika Anda menelepon:
         */
        strings.indexOf("This is a replacement");

        /*
         * angka 0 diharapkan dikembalikan saat kita menyetel String
         * "Ini adalah pengganti" di posisi 0 dalam daftar kita. Dalam hal
         * dimana terdapat lebih dari satu kejadian dalam daftar ketika int
         * indexOf(Object o); dipanggil maka seperti yang disebutkan indeks kemunculan
         * pertama akan dikembalikan. Dengan memanggil int lastIndexOf(Object o) Anda
         * dapat mengambil indeks kejadian terakhir dalam daftar. Jadi jika kita
         * menambahkan "Ini penggantinya" yang lain:
         */
        strings.add("Ini penggantinya");
        strings.lastIndexOf("Ini penggantinya");

        System.out.println("List akhir pada string: " + strings);
        /*
         * output:
         * List akhir pada string: [This is a replacement, Ini adalah penggantinya]
         */
        // Kali ini angka 1 yang akan dikembalikan dan bukan angka 0;
    }
}
