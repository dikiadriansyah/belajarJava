import java.util.logging.Logger;
import java.util.logging.Level;

public class Logging_levels {
    // Logging levels/Tingkat pencatatan

    /*
     * Java Logging Api memiliki 7 level. Tingkatan dalam urutan menurun adalah:
     * SEVERE (highest value)
     * WARNING
     * INFO
     * CONFIG
     * FINE
     * FINER
     * FINEST (lowest value)
     */

    /*
     * Level defaultnya adalah INFO (tetapi ini tergantung pada sistem dan mesin
     * virtual yang digunakan).
     * 
     * Catatan : Ada juga level OFF (bisa digunakan untuk mematikan logout) dan ALL
     * (kebalikan dari OFF).
     * 
     * Contoh kode untuk ini:
     * 
     * import java.util.logging.Logger;
     * public class Levels {
     * private static final Logger logger =
     * Logger.getLogger(Levels.class.getName());
     * public static void main(String[] args) {
     * logger.severe("Message logged by SEVERE");
     * logger.warning("Message logged by WARNING");
     * logger.info("Message logged by INFO");
     * logger.config("Message logged by CONFIG");
     * logger.fine("Message logged by FINE");
     * logger.finer("Message logged by FINER");
     * logger.finest("Message logged by FINEST");
     * // All of above methods are really just shortcut for
     * // public void log(Level level, String msg):
     * logger.log(Level.FINEST, "Message logged by FINEST");
     * }
     * }
     */

    // Secara default, menjalankan kelas ini hanya akan menampilkan pesan dengan
    // level lebih tinggi dari CONFIG:
    /*
     * Jul 23, 2016 9:16:11 PM LevelsExample main
     * SEVERE: Message logged by SEVERE
     * Jul 23, 2016 9:16:11 PM LevelsExample main
     * WARNING: Message logged by WARNING
     * Jul 23, 2016 9:16:11 PM LevelsExample main
     * INFO: Message logged by INFO
     */

    // ------------------
    private static final Logger logger = Logger.getLogger(Logging_levels.class.getName());

    public static void main(String[] args) throws Exception {
        logger.severe("Message logged by SEVERE");
        logger.warning("Message logged by WARNING");
        logger.info("Message logged by INFO");
        logger.config("Message logged by CONFIG");
        logger.fine("Message logged by FINE");
        logger.finer("Message logged by FINER");
        logger.finest("Message logged by FINEST");
        // All of above methods are really just shortcut for
        // public void log(Level level, String msg):
        logger.log(Level.FINEST, "Message logged by FINEST");

        /*
         * output:
         * Mar 03, 2024 2:51:16 PM Logging_levels main
         * SEVERE: Message logged by SEVERE
         * Mar 03, 2024 2:51:16 PM Logging_levels main
         * WARNING: Message logged by WARNING
         * Mar 03, 2024 2:51:16 PM Logging_levels main
         * INFO: Message logged by INFO
         */

    }
}
