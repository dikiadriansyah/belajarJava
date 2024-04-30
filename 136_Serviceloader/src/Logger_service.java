import java.io.IOException;

public class Logger_service {
    // Logger Service/Layanan Pencatat

    /*
     * Contoh berikut menunjukkan cara membuat instance kelas untuk logging melalui
     * ServiceLoader.
     */

    // Service
    /*
     * package servicetest;
     * import java.io.IOException;
     * public interface Logger extends AutoCloseable {
     * 
     * void log(String message) throws IOException;
     * }
     */

    // Implementasi layanan
    /*
     * Implementasi berikut hanya menulis pesan ke System.err
     * 
     * package servicetest.logger;
     * import servicetest.Logger;
     * public class ConsoleLogger implements Logger {
     * 
     * @Override
     * public void log(String message) {
     * System.err.println(message);
     * }
     * 
     * @Override
     * public void close() {
     * }
     * }
     */

    // Implementasi berikut menulis pesan ke file teks:

    /*
     * package servicetest.logger;
     * import java.io.BufferedWriter;
     * import java.io.FileWriter;
     * import java.io.IOException;
     * import servicetest.Logger;
     * public class FileLogger implements Logger {
     * private final BufferedWriter writer;
     * public FileLogger() throws IOException {
     * writer = new BufferedWriter(new FileWriter("log.txt"));
     * }
     * 
     * @Override
     * public void log(String message) throws IOException {
     * writer.append(message);
     * writer.newLine();
     * }
     * 
     * @Override
     * public void close() throws IOException {
     * writer.close();
     * }
     * }
     */

    // META-INF/services/servicetest.Logger
    /*
     * File META-INF/services/servicetest.Logger mencantumkan nama implementasi
     * Logger
     * 
     * servicetest.logger.ConsoleLogger
     * servicetest.logger.FileLogger
     */

    // penggunaan
    /*
     * Metode main berikut ini menulis pesan ke semua logger yang tersedia. Para
     * logger dipakai menggunakan ServiceLoader.
     */

    /*
     * 
     */
    public static void main(String[] args) throws Exception {
        try {
            Logger consoleLogger = new ConsoleLogger();
            consoleLogger.log("This is a message logged to console.");
            consoleLogger.close();

            Logger fileLogger = new FileLogger();
            fileLogger.log("This is a message logged to file.");
            fileLogger.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * output:
         * Logger cannot be resolved to a type
         * Logger cannot be resolved to a type
         */

    }
}
