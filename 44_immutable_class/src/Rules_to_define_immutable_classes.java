public class Rules_to_define_immutable_classes {
    // Rules to define immutable classes / Aturan untuk mendefinisikan kelas yang
    // tidak dapat diubah

    // Aturan berikut menentukan strategi sederhana untuk membuat objek yang tidak
    // dapat diubah

    /*
     * 1. Jangan menyediakan metode "setter" - metode yang mengubah bidang atau
     * objek yang dirujuk oleh bidang.
     * 2. Jadikan semua bidang bersifat final dan pribadi.
     * 3. Jangan izinkan subkelas mengesampingkan metode. Cara paling sederhana
     * untuk melakukan ini adalah dengan mendeklarasikan kelas tersebut sebagai
     * kelas final. Pendekatan yang lebih canggih adalah menjadikan konstruktor
     * pribadi dan membuat instance dalam metode pabrik.
     * 4. Jika kolom instance menyertakan referensi ke objek yang dapat diubah,
     * jangan izinkan objek tersebut diubah:
     * 5. Jangan menyediakan metode yang mengubah objek yang bisa berubah.
     * 6. Jangan membagikan referensi ke objek yang bisa berubah. Jangan pernah
     * menyimpan referensi ke objek eksternal yang dapat diubah dan diteruskan
     * konstruktor; jika perlu, buat salinan, dan simpan referensi ke salinan
     * tersebut. Demikian pula, buat salinannya
     * objek internal Anda yang dapat diubah bila diperlukan untuk menghindari
     * pengembalian yang asli dalam metode Anda.
     */

    public static void main(String[] args) {
    }
}
