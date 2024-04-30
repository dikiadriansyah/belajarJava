public class Throwing_an_exception {
    // Throwing an exception/Memberikan pengecualian

    /*
     * Contoh berikut menunjukkan dasar-dasar pelemparan pengecualian:
     * public void checkNumber(int number) throws IllegalArgumentException {
     * if (number < 0) {
     * throw new IllegalArgumentException("Number must be positive: " + number);
     * }
     * }
     */

    /*
     * Pengecualian dilemparkan pada baris ke-3. Pernyataan ini dapat dipecah
     * menjadi dua bagian:
     * 1. new IllegalArgumentException(...) membuat instance kelas
     * IllegalArgumentException, dengan pesan yang menjelaskan kesalahan yang
     * dilaporkan oleh pengecualian.
     * 
     * 2. throw ... kemudian melempar objek pengecualian.
     */

    /*
     * Ketika pengecualian dilempar, hal ini menyebabkan pernyataan terlampir
     * berhenti secara tidak normal sampai pengecualian tersebut ditangani. Hal ini
     * dijelaskan dalam contoh lain.
     * 
     * Merupakan praktik yang baik untuk membuat dan membuang objek pengecualian
     * dalam satu pernyataan, seperti yang ditunjukkan di atas. Ini juga merupakan
     * praktik yang baik untuk menyertakan pesan kesalahan yang berarti dalam
     * pengecualian untuk membantu pemrogram memahami penyebab masalahnya. Namun,
     * ini belum tentu merupakan pesan yang harus Anda tampilkan kepada pengguna
     * akhir.
     * (Sebagai permulaan, Java tidak memiliki dukungan langsung untuk
     * internasionalisasi pesan pengecualian.)
     */

    /*
     * Ada beberapa poin lagi yang perlu disampaikan:
     * 1. Kami telah mendeklarasikan checkNumber sebagai throws
     * IllegalArgumentException. Hal ini tidak sepenuhnya diperlukan,
     * karena IllegalArgumentException adalah pengecualian yang dicentang; lihat
     * Hierarki Pengecualian Java - Tidak dicentang dan
     * Pengecualian yang Diperiksa. Namun, merupakan praktik yang baik untuk
     * melakukan hal ini, dan juga menyertakan pengecualian yang diberikan pada
     * komentar javadoc suatu metode.
     * 
     * 2. Kode segera setelah pernyataan throw tidak dapat dijangkau. Oleh karena
     * itu
     * jika kita menulis ini:
     * throw new IllegalArgumentException("it is bad");
     * return;
     */

    // Exception chaining/Rangkaian pengecualian

    /*
     * Banyak pengecualian standar yang memiliki konstruktor dengan argumen penyebab
     * kedua selain argumen konvensional
     * argumen message. Penyebabnya memungkinkan Anda membuat rangkaian
     * pengecualian.
     * Ini sebuah contoh.
     * 
     * Pertama, kita mendefinisikan pengecualian yang tidak dicentang yang akan
     * dibuang oleh aplikasi kita ketika menemukan kesalahan yang tidak dapat
     * dipulihkan. Perhatikan bahwa kami telah menyertakan konstruktor yang menerima
     * argumen sebab.
     */

    /*
     * public class AppErrorException extends RuntimeException {
     * public AppErrorException() {
     * super();
     * }
     * public AppErrorException(String message) {
     * super(message);
     * }
     * public AppErrorException(String message, Throwable cause) {
     * super(message, cause);
     * }
     * }
     * 
     */

    // Selanjutnya, berikut adalah beberapa kode yang menggambarkan rangkaian
    // pengecualian

    /*
     * public String readFirstLine(String file) throws AppErrorException {
     * try (Reader r = new BufferedReader(new FileReader(file))) {
     * String line = r.readLine();
     * if (line != null) {
     * return line;
     * } else {
     * throw new AppErrorException("File is empty: " + file);
     * }
     * } catch (IOException ex) {
     * throw new AppErrorException("Cannot read file: " + file, ex);
     * }
     * }
     */

    /*
     * throw dalam blok try mendeteksi masalah dan melaporkannya melalui
     * pengecualian dengan pesan sederhana. Sebaliknya, throw dalam blok catch
     * menangani IOException dengan membungkusnya dalam pengecualian baru (yang
     * dicentang).
     * Namun, ini tidak membuang pengecualian aslinya. Dengan meneruskan IOException
     * sebagai penyebabnya, kita mencatatnya agar dapat dicetak di stacktrace,
     * seperti yang dijelaskan dalam Membuat dan membaca stacktraces.
     */

    public static void main(String[] args) {
        Throwing_an_exception box1 = new Throwing_an_exception();

        try {
            // Contoh penggunaan dengan angka positif
            box1.checkNumber(5);

            // Contoh penggunaan dengan angka negatif
            // Akan menghasilkan IllegalArgumentException
            box1.checkNumber(-2);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        /*
         * output:
         * Number is positive: 5
         * Exception caught: Number must be positive: -2
         */

    }

    public void checkNumber(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be positive: " + number);
        }
        System.out.println("Number is positive: " + number);
    }

}
