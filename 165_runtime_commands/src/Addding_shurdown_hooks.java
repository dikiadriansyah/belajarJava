import java.io.IOException;

public class Addding_shurdown_hooks {

    // Adding shutdown hooks/Menambahkan kait penutup

    /*
     * Terkadang Anda memerlukan sepotong kode untuk dieksekusi ketika program
     * berhenti, seperti melepaskan sumber daya sistem yang Anda buka. Anda dapat
     * menjalankan thread ketika program berhenti dengan metode addShutdownHook:
     */

    /*
     * Runtime.getRuntime().addShutdownHook(new Thread(() -> {
     * ImportantStuff.someImportantIOStream.close();
     * }));
     */

    public static IOStream someImportantIOStream;

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // Inisialisasi objek IOStream (contoh)
        someImportantIOStream = new IOStream();

        // Menambahkan shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                // Menutup IOStream ketika shutdown hook dipanggil
                Addding_shurdown_hooks.someImportantIOStream.close();
                System.out.println("IOStream ditutup secara sukses saat shutdown.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        // Berjalan contoh aplikasi
        System.out.println("Aplikasi berjalan...");
        // Di sini Anda bisa menambahkan logika aplikasi Anda

        /*
         * output:
         * Aplikasi berjalan...
         * IOStream ditutup.
         * IOStream ditutup secara sukses saat shutdown.
         */

    }
}
