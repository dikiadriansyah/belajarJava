import java.nio.ByteBuffer;

public class Basic_usage_using_directbytebuffer {
    // Basic Usage - Using DirectByteBuffer/Penggunaan Dasar - Menggunakan
    // DirectByteBuffer

    /*
     * DirectByteBuffer adalah implementasi khusus dari ByteBuffer yang tidak
     * memiliki byte[] di bawahnya.
     * Kita dapat mengalokasikan ByteBuffer tersebut dengan memanggil:
     * ByteBuffer directBuffer = ByteBuffer.allocateDirect(16);
     */

    /*
     * Operasi ini akan mengalokasikan 16 byte memori. Konten buffer langsung
     * mungkin berada di luar garbage-collected normal.
     * Kami dapat memverifikasi apakah ByteBuffer langsung dengan menelepon:
     * directBuffer.isDirect(); // true
     */

    /*
     * Karakteristik utama dari DirectByteBuffer adalah bahwa JVM akan mencoba untuk
     * bekerja secara native pada memori yang dialokasikan tanpa buffering tambahan
     * sehingga operasi yang dilakukan pada JVM mungkin lebih cepat daripada yang
     * dilakukan pada ByteBuffers dengan array yang terletak di bawahnya.
     * 
     * Disarankan untuk menggunakan DirectByteBuffer dengan operasi IO berat yang
     * mengandalkan kecepatan eksekusi, seperti komunikasi waktu nyata.
     * 
     * Kita harus menyadari bahwa jika kita mencoba menggunakan metode array() kita
     * akan mendapatkan UnsupportedOperationException. Jadi merupakan praktik yang
     * baik untuk memeriksa apakah ByteBuffer kita memilikinya (byte array) sebelum
     * kita mencoba mengaksesnya:
     * byte[] arrayOfBytes;
     * if(buffer.hasArray()) {
     * arrayOfBytes = buffer.array();
     * }
     */

    /*
     * Penggunaan lain dari buffer byte langsung adalah interop melalui JNI. Karena
     * buffer byte langsung tidak menggunakan byte[], tetapi blok memori sebenarnya,
     * memori tersebut dapat diakses secara langsung melalui penunjuk dalam kode
     * asli. Hal ini dapat menghemat sedikit masalah dan overhead dalam menyusun
     * antara Java dan representasi data asli.
     * 
     * Antarmuka JNI mendefinisikan beberapa fungsi untuk menangani buffer byte
     * langsung: Dukungan NIO.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // -------------------
        // ByteBuffer directBuffer = ByteBuffer.allocateDirect(16);
        // System.out.println(directBuffer.isDirect()); // true
        // ------------------
        // Contoh penggunaan kode
        ByteBuffer buffer = ByteBuffer.allocate(10); // Membuat ByteBuffer dengan kapasitas 10 byte
        byte[] arrayOfBytes;

        if (buffer.hasArray()) {
            // Jika ByteBuffer memiliki array yang didukung
            arrayOfBytes = buffer.array();
            // Lakukan sesuatu dengan arrayOfBytes
            System.out.println("Ukuran arrayOfBytes: " + arrayOfBytes.length);
        } else {
            // Jika ByteBuffer tidak memiliki array yang didukung
            System.out.println("ByteBuffer tidak memiliki array yang didukung.");
        }
        /*
         * output:
         * Ukuran arrayOfBytes: 10
         */
    }
}
