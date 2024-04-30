public class Pausing_execution {
    // Pausing Execution/Menjeda Eksekusi

    /*
     * Thread.sleep menyebabkan thread saat ini menunda eksekusi untuk jangka waktu
     * tertentu. Ini adalah cara yang efisien membuat waktu prosesor tersedia untuk
     * thread lain dari suatu aplikasi atau aplikasi lain yang mungkin sedang
     * berjalan pada sistem komputer. Ada dua metode sleep yang kelebihan beban di
     * kelas Thread.
     */

    // Yang menentukan waktu tidur hingga milidetik
    // public static void sleep(long millis) throws InterruptedException

    // Salah satu yang menentukan waktu tidur hingga nanodetik
    // public static void sleep(long millis, int nanos)

    // Menjeda Eksekusi selama 1 detik
    // Thread.sleep(1000);

    /*
     * Penting untuk dicatat bahwa ini adalah petunjuk untuk penjadwal kernel sistem
     * operasi. Ini mungkin belum tentu tepat, dan beberapa implementasi bahkan
     * tidak mempertimbangkan parameter nanodetik (mungkin dibulatkan ke milidetik
     * terdekat).
     * 
     * Disarankan untuk menyertakan panggilan ke Thread.sleep di try/catch dan catch
     * InterruptedException.
     */

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Memulai sesuatu...");

        try {
            // Menunda eksekusi selama 1000 milidetik (1 detik)
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Setelah menunggu 1 detik.");
        /*
         * output:
         * Memulai sesuatu...
         * Setelah menunggu 1 detik.
         */
    }
}
