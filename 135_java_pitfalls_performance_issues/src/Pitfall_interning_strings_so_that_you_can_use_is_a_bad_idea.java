public class Pitfall_interning_strings_so_that_you_can_use_is_a_bad_idea {
    // Pitfall - Interning strings so that you can use == is a bad idea/Kesalahan -
    // Menggabungkan string sehingga Anda dapat menggunakan == adalah ide yang buruk

    /*
     * Ketika beberapa programmer melihat saran ini:
     * "Menguji string menggunakan == incorrect (kecuali string tersebut diinternir)"
     */

    /*
     * reaksi awal mereka adalah menginternir string sehingga dapat menggunakan ==.
     * (Lagipula == lebih cepat daripada menelepon
     * String.equals(...), bukan.)
     * 
     * Ini adalah pendekatan yang salah, dari beberapa sudut pandang:
     */

    // Fragility/Kerapuhan
    /*
     * Pertama-tama, Anda hanya dapat menggunakan == dengan aman jika Anda
     * mengetahui bahwa semua objek String yang Anda uji telah diinternir.
     * JLS menjamin bahwa literal String dalam kode sumber Anda akan diinternir.
     * Namun, tidak ada satu pun API Java SE standar yang menjamin untuk
     * mengembalikan string yang diinternir, selain dari String.intern(String) itu
     * sendiri. Jika Anda melewatkan satu sumber objek String saja yang belum
     * diinternir, aplikasi Anda tidak akan dapat diandalkan. Ketidakandalan
     * tersebut akan terlihat sebagai negatif palsu, bukan pengecualian, yang
     * cenderung mempersulit pendeteksian.
     */

    // Costs of using 'intern()'/Biaya menggunakan 'magang()'
    /*
     * Di balik terpal, magang bekerja dengan memelihara tabel hash yang berisi
     * objek String yang diinternir sebelumnya.
     * Beberapa jenis mekanisme referensi yang lemah digunakan agar tabel hash
     * internal tidak menjadi kebocoran penyimpanan.
     * Meskipun tabel hash diimplementasikan dalam kode asli (tidak seperti HashMap,
     * HashTable, dan sebagainya), panggilan magang masih tetap ada.
     * relatif mahal dalam hal CPU dan memori yang digunakan.
     * 
     * Biaya ini harus dibandingkan dengan penghematan yang akan kita peroleh dengan
     * menggunakan ==, bukan sama dengan. Faktanya, kita tidak akan mencapai titik
     * impas kecuali setiap string yang diinternir dibandingkan dengan string lain
     * "beberapa" kali.
     * 
     * (Selain itu: beberapa situasi di mana magang bermanfaat cenderung mengurangi
     * jejak memori aplikasi di mana string yang sama berulang berkali-kali, dan
     * string tersebut memiliki masa pakai yang lama.)
     */

    // The impact on garbage collection/Dampaknya terhadap pengumpulan sampah
    /*
     * Selain biaya CPU dan memori langsung yang dijelaskan di atas, String yang
     * diinternir berdampak pada kinerja pengumpul sampah.
     * 
     * Untuk versi Java sebelum Java 7, string yang diinternir disimpan di ruang
     * "PermGen" yang jarang dikumpulkan.
     * Jika PermGen perlu dikumpulkan, hal ini (biasanya) memicu pengumpulan sampah
     * secara penuh. Jika ruang PermGen terisi penuh, JVM akan mogok, meskipun ada
     * ruang kosong di ruang tumpukan biasa.
     * 
     * Di Java 7, kumpulan string dipindahkan dari "PermGen" ke tumpukan normal.
     * Namun, tabel hash masih akan menjadi struktur data yang berumur panjang, yang
     * akan menyebabkan string yang diinternir menjadi berumur panjang. (Bahkan jika
     * objek string yang diinternir dialokasikan di ruang Eden, kemungkinan besar
     * objek tersebut akan dipromosikan sebelum dikumpulkan.)
     * 
     * Jadi dalam semua kasus, menginternir sebuah string akan memperpanjang masa
     * pakainya dibandingkan dengan string biasa. Hal ini akan meningkatkan biaya
     * pengumpulan sampah selama masa pakai JVM.
     * 
     * Masalah kedua adalah bahwa tabel hash perlu menggunakan semacam mekanisme
     * referensi yang lemah untuk mencegah kebocoran memori string internal. Namun
     * mekanisme seperti itu lebih berhasil bagi pemulung.
     * 
     * Biaya overhead pengumpulan sampah ini sulit diukur, namun tidak diragukan
     * lagi bahwa biaya tersebut memang ada. Jika Anda menggunakan pekerja magang
     * secara ekstensif, itu bisa menjadi signifikan.
     */

    // The string pool hashtable size/Ukuran hashtable kumpulan string
    /*
     * Menurut sumber ini, mulai Java 6 dan seterusnya, kumpulan string
     * diimplementasikan sebagai tabel hash berukuran tetap dengan rantai untuk
     * menangani string yang melakukan hash ke keranjang yang sama. Pada rilis awal
     * Java 6, tabel hash memiliki (hard-wired)
     * ukuran konstan. Parameter penyetelan (-XX:StringTableSize) ditambahkan
     * sebagai pembaruan paruh baya ke Java 6. Kemudian dalam pembaruan paruh baya
     * ke Java 7, ukuran default kumpulan diubah dari 1009 menjadi 60013.
     * 
     * Intinya adalah jika Anda berniat menggunakan intern secara intensif dalam
     * kode Anda, disarankan untuk memilih versi Java yang ukuran tabel hashnya
     * dapat disesuaikan dan pastikan Anda menyetel ukurannya dengan tepat. Jika
     * tidak, kinerja pekerja magang kemungkinan besar akan menurun seiring
     * bertambahnya jumlah peserta magang.
     */

    // Interning as a potential denial of service vector/Magang sebagai potensi
    // penolakan vektor layanan
    /*
     * Algoritme kode hash untuk string sudah terkenal. Jika Anda menyimpan string
     * yang disediakan oleh pengguna atau aplikasi jahat,
     * ini dapat digunakan sebagai bagian dari serangan penolakan layanan (DoS).
     * Jika agen jahat mengatur agar semua string yang disediakannya memiliki kode
     * hash yang sama, hal ini dapat menyebabkan tabel hash yang tidak seimbang dan
     * kinerja O(N) untuk pekerja intern ...
     * dimana N adalah jumlah string yang bertabrakan.
     * 
     * (Ada cara yang lebih sederhana/efektif untuk meluncurkan serangan DoS
     * terhadap suatu layanan. Namun, vektor ini dapat digunakan jika tujuan
     * serangan DoS adalah untuk merusak keamanan, atau untuk menghindari pertahanan
     * DoS lini pertama.)
     */

    public static void main(String[] args) throws Exception {
    }
}
