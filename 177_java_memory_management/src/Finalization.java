public class Finalization {
    // Finalization/Finalisasi

    /*
     * Objek Java dapat mendeklarasikan metode finalisasi. Metode ini dipanggil
     * tepat sebelum Java melepaskan memori untuk objek tersebut. Biasanya akan
     * terlihat seperti ini:
     * 
     * public class MyClass {
     * //Methods for the class
     * 
     * @Override
     * protected void finalize() throws Throwable {
     * // Cleanup code
     * }
     * }
     * 
     */

    /*
     * Namun, ada beberapa peringatan penting mengenai perilaku finalisasi Java.
     * 1. Java tidak memberikan jaminan kapan metode finalize() akan dipanggil.
     * 2. Java bahkan tidak menjamin bahwa metode finalize() akan dipanggil suatu
     * saat selama masa pakai aplikasi yang sedang berjalan.
     * 3. Satu-satunya jaminan adalah bahwa metode akan dipanggil sebelum objek
     * dihapus...jika objek dihapus.
     */

    /*
     * Peringatan di atas berarti bahwa mengandalkan metode finalisasi untuk
     * melakukan tindakan pembersihan (atau lainnya) yang harus dilakukan tepat
     * waktu adalah ide yang buruk. Ketergantungan yang berlebihan pada finalisasi
     * dapat menyebabkan kebocoran penyimpanan, kebocoran memori, dan masalah
     * lainnya.
     * 
     * Singkatnya, hanya ada sedikit situasi di mana finalisasi sebenarnya merupakan
     * solusi yang baik.
     */

    // Finalizers only run once/Finalizer hanya berjalan satu kali
    /*
     * Biasanya, suatu objek dihapus setelah diselesaikan. Namun, hal ini tidak
     * terjadi setiap saat. Perhatikan contoh1 berikut:
     * 
     * public class CaptainJack {
     * public static CaptainJack notDeadYet = null;
     * protected void finalize() {
     * // Resurrection!
     * notDeadYet = this;
     * }
     * }
     */

    /*
     * Ketika instance CaptainJack tidak dapat dijangkau dan pemulung mencoba
     * mengambilnya kembali, metode finalize() akan menetapkan referensi ke instance
     * tersebut ke variabel notDeadYet. Hal ini akan membuat instance dapat
     * dijangkau sekali lagi, dan pengumpul sampah tidak akan menghapusnya.
     * Pertanyaan: Apakah Kapten Jack abadi?
     */

    /*
     * Jawaban: Tidak.
     * Tangkapannya adalah JVM hanya akan menjalankan finalizer pada suatu objek
     * sekali seumur hidupnya. Jika Anda menetapkan null ke notDeadYet
     * menyebabkan instance yang dihidupkan kembali menjadi tidak dapat dijangkau
     * sekali lagi, pengumpul sampah tidak akan memanggil finalize() pada objek
     * tersebut.
     * 
     * 1 - Lihat https://en.wikipedia.org/wiki/Jack_Harkness.
     */

    // Methods for the class

    @Override
    protected void finalize() throws Throwable {
        try {
            // Cleanup code
            System.out.println("Finalizing MyClass");
        } finally {
            super.finalize();
        }
    }

    public static void main(String[] args) {
        // Creating an instance of MyClass
        Finalization obj = new Finalization();

        // Making obj eligible for garbage collection
        obj = null;

        // Triggering garbage collection
        System.gc();

        // Wait for a while to let finalize() to execute
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // output: Finalizing MyClass

    }

}
