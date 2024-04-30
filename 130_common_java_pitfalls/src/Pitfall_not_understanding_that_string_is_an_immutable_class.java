public class Pitfall_not_understanding_that_string_is_an_immutable_class {
    // Pitfall: Not understanding that String is an immutable class / Kesalahan:
    // Tidak memahami bahwa String adalah kelas yang tidak dapat diubah

    /*
     * Pemrogram Java baru sering kali lupa, atau gagal memahami sepenuhnya, bahwa
     * kelas Java String tidak dapat diubah. Hal ini menyebabkan masalah seperti
     * pada contoh berikut:
     * 
     * public class Shout {
     * public static void main(String[] args) {
     * for (String s : args) {
     * s.toUpperCase();
     * System.out.print(s);
     * System.out.print(" ");
     * }
     * System.out.println();
     * }
     * }
     * 
     */

    /*
     * Kode di atas seharusnya mencetak argumen baris perintah dalam huruf besar.
     * Sayangnya, hal tersebut tidak berhasil, kasus argumennya tidak diubah.
     * Masalahnya adalah pernyataan ini:
     * s.toUpperCase();
     */

    /*
     * Anda mungkin berpikir bahwa memanggil toUpperCase() akan mengubah s menjadi
     * string huruf besar. Tidak. Tidak bisa! Objek string tidak dapat diubah.
     * Mereka tidak dapat diubah.
     * 
     * Pada kenyataannya, metode toUpperCase() mengembalikan objek String yang
     * merupakan versi huruf besar dari String yang Anda gunakan untuk memanggilnya.
     * Ini mungkin berupa objek new String, tetapi jika s sudah menggunakan huruf
     * besar semua, hasilnya bisa berupa string yang sudah ada.
     */

    /*
     * Jadi untuk menggunakan metode ini secara efektif, Anda perlu menggunakan
     * objek yang dikembalikan oleh pemanggilan metode; Misalnya:
     * s = s.toUpperCase();
     */

    /*
     * Faktanya, aturan "string tidak pernah berubah" berlaku untuk semua metode
     * String. Jika Anda mengingatnya, maka Anda dapat menghindari seluruh kategori
     * kesalahan pemula
     */

    public static void main(String[] args) {

        for (String s : args) {
            s = s.toUpperCase(); // Menyimpan hasil perubahan ke huruf besar
            System.out.print(s);
            System.out.print(" ");
        }
        System.out.println();
    }
}
