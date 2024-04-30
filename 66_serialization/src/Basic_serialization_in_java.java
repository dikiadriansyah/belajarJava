import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Basic_serialization_in_java {
    // Basic Serialization in Java / Serialisasi Dasar di Java

    /*
     * Apa itu Serialization
     * 
     * Serialization adalah proses mengubah status objek (termasuk referensinya)
     * menjadi urutan byte, serta proses membangun kembali byte tersebut menjadi
     * objek aktif di masa mendatang. Serialisasi digunakan ketika Anda ingin
     * mempertahankan objek. Ini juga digunakan oleh Java RMI untuk meneruskan objek
     * antar JVM, baik sebagai argumen dalam pemanggilan metode dari klien ke server
     * atau sebagai nilai kembalian dari pemanggilan metode, atau sebagai
     * pengecualian yang diberikan oleh
     * metode jarak jauh. Secara umum, serialisasi digunakan ketika kita ingin objek
     * ada melebihi umur JVM.
     */

    // java.io.Serializable adalah antarmuka penanda (tidak memiliki isi). Itu hanya
    // digunakan untuk "menandai" kelas Java sebagai dapat diserialkan

    /*
     * Runtime serialisasi mengaitkan nomor versi dengan setiap kelas yang dapat
     * diserialkan, yang disebut serialVersionUID,
     * yang digunakan selama de-serialisasi untuk memverifikasi bahwa pengirim dan
     * penerima objek serial telah memuat kelas untuk objek tersebut yang kompatibel
     * dengan serialisasi. Jika penerima telah memuat kelas untuk objek yang
     * memiliki serialVersionUID berbeda dari kelas pengirim terkait, maka
     * deserialisasi akan menghasilkan InvalidClassException. Kelas serializable
     * dapat mendeklarasikan serialVersionUID miliknya sendiri secara eksplisit
     * dengan mendeklarasikan sebuah field
     * bernama serialVersionUID yang harus statis, final, dan bertipe long:
     */

    // ANY-ACCESS-MODIFIER static final long serialVersionUID = 1L

    // Cara membuat kelas memenuhi syarat untuk serialisasi

    /*
     * Untuk mempertahankan suatu objek, kelas masing-masing harus
     * mengimplementasikan antarmuka java.io.Serializable.
     * 
     * import java.io.Serializable;
     * public class SerialClass implements Serializable {
     * private static final long serialVersionUID = 1L;
     * private Date currentTime;
     * 
     * public SerialClass() {
     * currentTime = Calendar.getInstance().getTime();
     * }
     * public Date getCurrentTime() {
     * return currentTime;
     * }
     * }
     */

    // Cara menulis objek ke dalam file
    // Sekarang kita perlu menulis objek ini ke sistem file. Kami menggunakan
    // java.io.ObjectOutputStream untuk tujuan ini.

    /*
     * import java.io.FileOutputStream;
     * import java.io.ObjectOutputStream;
     * import java.io.IOException;
     * public class PersistSerialClass {
     * public static void main(String [] args) {
     * String filename = "time.ser";
     * SerialClass time = new SerialClass(); //We will write this object to file
     * system.
     * try {
     * ObjectOutputStream out = new ObjectOutputStream(new
     * FileOutputStream(filename));
     * out.writeObject(time); //Write byte stream to file system.
     * out.close();
     * } catch(IOException ex){
     * ex.printStackTrace();
     * }
     * }
     * }
     */

    // Cara membuat ulang objek dari status serialnya

    // Objek yang disimpan dapat dibaca dari sistem file di lain waktu menggunakan
    // java.io.ObjectInputStream seperti yang ditunjukkan di bawah ini:

    /*
     * import java.io.FileInputStream;
     * import java.io.ObjectInputStream;
     * import java.io.IOException;
     * import java.io.java.lang.ClassNotFoundException;
     * public class ReadSerialClass {
     * public static void main(String [] args) {
     * String filename = "time.ser";
     * SerialClass time = null;
     * try {
     * ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
     * time = (SerialClass)in.readObject();
     * in.close();
     * } catch(IOException ex){
     * ex.printStackTrace();
     * } catch(ClassNotFoundException cnfe){
     * cnfe.printStackTrace();
     * }
     * // print out restored time
     * System.out.println("Restored time: " + time.getTime());
     * }
     * }
     * 
     */

    /*
     * Kelas serial dalam bentuk biner. Deserialisasi dapat menjadi masalah jika
     * definisi kelas berubah: lihat
     * Pembuatan versi Objek Berseri bab Spesifikasi Serialisasi Java untuk
     * detailnya.
     * 
     * Membuat serial suatu objek membuat serialisasi seluruh grafik objek yang
     * menjadi akarnya, dan beroperasi dengan benar jika ada
     * dari grafik siklik. Metode reset() disediakan untuk memaksa
     * ObjectOutputStream melupakan objek yang memilikinya
     * sudah diserialkan.
     * 
     * Bidang sementara - Serialisasi
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        String filename = "time.ser";
        SerialClass time = new SerialClass(); // We will write this object to file system.
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(time); // Write byte stream to file system.
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        /*
         * output:
         * membuat file time.ser
         */

    }

}
