public class What_is_bytecode {
    // What is Bytecode?/Apa itu Bytecode?

    // Bytecode adalah kumpulan instruksi yang digunakan oleh JVM. Untuk
    // mengilustrasikannya mari kita ambil program Hello World ini.

    /*
     * public static void main(String[] args){
     * System.out.println("Hello World");
     * }
     */

    // Inilah yang terjadi ketika dikompilasi menjadi bytecode
    /*
     * public static main([Ljava/lang/String; args)V
     * getstatic java/lang/System out Ljava/io/PrintStream;
     * ldc "Hello World"
     * invokevirtual java/io/PrintStream print(Ljava/lang/String;)V
     * 
     */

    /*
     * Apa logika di balik ini?
     * getstatic - Mengambil nilai bidang statis suatu kelas. Dalam hal ini,
     * PrintStream "Keluar" dari System.
     */

    /*
     * ldc - Dorong konstanta ke tumpukan. Dalam hal ini, String "Halo Dunia"
     * 
     * invokevirtual - Memanggil metode pada referensi yang dimuat di tumpukan dan
     * meletakkan hasilnya di tumpukan. Parameter metode ini juga diambil dari
     * tumpukan.
     */

    // Ya, pasti ada lebih banyak lagi kan?

    /*
     * Terdapat 255 opcode, namun belum semuanya diimplementasikan. Sebuah tabel
     * dengan semua opcode saat ini dapat berupa ditemukan di sini: Daftar instruksi
     * bytecode Java.
     */

    /*
     * Bagaimana saya bisa menulis/mengedit bytecode?
     * Ada beberapa cara untuk menulis dan mengedit bytecode. Anda dapat menggunakan
     * kompiler, menggunakan perpustakaan, atau menggunakan program.
     * 
     */

    /*
     * For writing:
     * Jasmin
     * Krakatau
     * For editing:
     * Libraries
     * ASM
     * Javassist
     * BCEL - Doesn't support Java 8+
     * Tools
     * Bytecode-Viewer
     * JBytedit
     * reJ - Doesn't support Java 8+
     * JBE - Doesn't support Java 8+
     */

    // Saya ingin mempelajari lebih lanjut tentang bytecode!
    /*
     * Mungkin ada halaman dokumentasi khusus untuk bytecode. Halaman ini berfokus
     * pada modifikasi bytecode menggunakan perpustakaan dan alat yang berbeda.
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
