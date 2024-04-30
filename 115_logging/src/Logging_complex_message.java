import java.util.logging.*;

public class Logging_complex_message {
    // Logging complex messages (efficiently)/Mencatat pesan yang kompleks (secara
    // efisien)

    /*
     * Mari kita lihat contoh logging yang dapat Anda lihat di banyak program:
     * 
     * public class LoggingComplex {
     * 
     * private static final Logger logger =
     * Logger.getLogger(LoggingComplex.class.getName());
     * private int total = 50, orders = 20;
     * private String username = "Bob";
     * public void takeOrder() {
     * // (...) making some stuff
     * logger.fine(String.format("User %s ordered %d things (%d in total)",
     * username, orders, total));
     * // (...) some other stuff
     * }
     * // some other methods and calculations
     * }
     */

    /*
     * Contoh di atas terlihat baik-baik saja, tetapi banyak pemrogram lupa bahwa
     * Java VM adalah mesin tumpukan. Ini berarti bahwa semua parameter metode
     * dihitung sebelum menjalankan metode tersebut.
     * 
     * Fakta ini sangat penting untuk logging di Java, terutama untuk logging
     * sesuatu di level rendah seperti FINE, FINER, FINEST yang
     * dinonaktifkan secara default. Mari kita lihat bytecode Java untuk metode
     * takeOrder().
     * 
     * Hasil javap -c LoggingComplex.class kira-kira seperti ini:
     */

    /*
     * public void takeOrder();
     * Code:
     * 0: getstatic #27 // Field logger:Ljava/util/logging/Logger;
     * 3: ldc #45 // String User %s ordered %d things (%d in total)
     * 5: iconst_3
     * 6: anewarray #3 // class java/lang/Object
     * 9: dup
     * 10: iconst_0
     * 11: aload_0
     * 12: getfield #40 // Field username:Ljava/lang/String;
     * 15: aastore
     * 16: dup
     * 17: iconst_1
     * 18: aload_0
     * 19: getfield #36 // Field orders:I
     * 22: invokestatic #47 // Method
     * java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
     * 25: aastore
     * 26: dup
     * 27: iconst_2
     * 28: aload_0
     * 29: getfield #34 // Field total:I
     * 32: invokestatic #47 // Method
     * java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
     * 35: aastore
     * 36: invokestatic #53 // Method
     * java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/
     * String;
     * 39: invokevirtual #59 // Method
     * java/util/logging/Logger.fine:(Ljava/lang/String;)V
     * 42: return
     */

    /*
     * Baris 39 menjalankan pencatatan sebenarnya. Semua pekerjaan sebelumnya
     * (memuat variabel, membuat objek baru, menggabungkan String dalam metode
     * format) akan sia-sia jika level logging diatur lebih tinggi dari FINE (dan
     * secara default memang demikian). Pencatatan log seperti itu bisa sangat tidak
     * efisien, memakan memori dan sumber daya prosesor yang tidak diperlukan.
     * 
     * Itu sebabnya Anda harus menanyakan apakah level yang ingin Anda gunakan
     * diaktifkan.
     * 
     * Cara yang benar seharusnya:
     * 
     * public void takeOrder() {
     * // making some stuff
     * if (logger.isLoggable(Level.FINE)) {
     * // no action taken when there's no need for it
     * logger.fine(String.format("User %s ordered %d things (%d in total)",
     * username, orders, total));
     * }
     * // some other stuff
     * }
     */

    // Since Java 8:

    /*
     * Kelas Logger memiliki metode tambahan yang menggunakan Supplier<String>
     * sebagai parameter, yang dapat dengan mudah disediakan oleh lambda:
     * 
     * public void takeOrder() {
     * // making some stuff
     * logger.fine(() -> String.format("User %s ordered %d things (%d in total)",
     * username, orders, total));
     * // some other stuff
     * }
     */

    /*
     * Metode Suppliers get() - dalam hal ini lambda - hanya dipanggil ketika level
     * yang sesuai diaktifkan dan sebagainya konstruksi if tidak diperlukan lagi.
     */

    private static final Logger logger = Logger.getLogger(Logging_complex_message.class.getName());
    private int total = 50, orders = 20;
    private String username = "Bob";

    // public void takeOrder() {
    // // (...) making some stuff
    // logger.fine(String.format("User %s ordered %d things (%d in total)",
    // username, orders, total));
    // // (...) some other stuff
    // }
    // some other methods and calculations

    // ----------------------------
    // java 8
    public void takeOrder() {
        // making some stuff
        logger.fine(() -> String.format("User %s ordered %d things (%d in total)",
                username, orders, total));
        // some other stuff
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ----------------
        Logging_complex_message box = new Logging_complex_message();
        box.takeOrder();
        /*
         * karena kita menggunakan metode logger.fine(). Karena tingkat log standar
         * adalah INFO, maka log FINE tidak akan ditampilkan kecuali konfigurasinya
         * diubah
         */
    }
}
