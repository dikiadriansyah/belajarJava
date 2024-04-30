
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
import java.net.InetAddress;
import java.util.Arrays;

public class Pitfall_the_overheads_of_creating_log_messages {
    // Pitfall - The overheads of creating log messages/Kesalahan - Biaya tambahan
    // dalam pembuatan pesan log

    /*
     * Level log TRACE dan DEBUG ada untuk dapat menyampaikan detail tinggi tentang
     * pengoperasian kode yang diberikan saat runtime. Menyetel level log di atas
     * ini biasanya disarankan, namun harus berhati-hati agar pernyataan ini tidak
     * memengaruhi kinerja bahkan ketika tampaknya "turned of".
     * 
     * Pertimbangkan pernyataan log ini:
     * // Processing a request of some kind, logging the parameters
     * LOG.debug("Request coming from " + myInetAddress.toString()
     * + " parameters: " + Arrays.toString(veryLongParamArray));
     */

    /*
     * Bahkan ketika level log diatur ke INFO, argumen yang diteruskan ke debug()
     * akan dievaluasi pada setiap eksekusi baris.
     * Hal ini membuatnya memakan waktu yang tidak perlu dalam beberapa hal:
     * 1. Penggabungan string: beberapa instance String akan dibuat
     * 2. InetAddress bahkan mungkin melakukan pencarian DNS.
     * 3. veryLongParamArray mungkin sangat panjang - membuat String darinya akan
     * menghabiskan memori, membutuhkan waktu
     */

    /*
     * solusi
     * Kebanyakan kerangka logging menyediakan sarana untuk membuat pesan log
     * menggunakan string perbaikan dan referensi objek. Pesan log akan dievaluasi
     * hanya jika pesan tersebut benar-benar dicatat. Contoh:
     * 
     * // No toString() evaluation, no string concatenation if debug is disabled
     * LOG.debug("Request coming from {} parameters: {}", myInetAddress,
     * parameters));
     * 
     */

    /*
     * Ini berfungsi dengan baik selama semua parameter dapat dikonversi menjadi
     * string menggunakan String.valueOf(Object). Jika perhitungan pesan log lebih
     * kompleks, level log dapat diperiksa sebelum logging:
     * 
     * if (LOG.isDebugEnabled()) {
     * // Argument expression evaluated only when DEBUG is enabled
     * LOG.debug("Request coming from {}, parameters: {}", myInetAddress,
     * Arrays.toString(veryLongParamArray);
     * }
     */

    /*
     * Di sini, LOG.debug() dengan perhitungan Arrays.toString(Obect[]) yang mahal
     * diproses hanya ketika DEBUG sebenarnya diaktifkan.
     */
    // -------------------------
    // private static final Logger LOG =
    // LogManager.getLogger(Pitfall_the_overheads_of_creating_log_messages.class);

    public static void main(String[] args) throws Exception {
        // Dummy InetAddress and parameter array for demonstration
        InetAddress myInetAddress = InetAddress.getLoopbackAddress();
        String[] veryLongParamArray = { "param1", "param2", "param3" };

        // Processing a request of some kind, logging the parameters
        // LOG.debug("Request coming from " + myInetAddress.toString()
        // + " parameters: " + Arrays.toString(veryLongParamArray));
        // -------------------------
        // No toString() evaluation, no string concatenation if debug is disabled
        // LOG.debug("Request coming from {} parameters: {}", myInetAddress,
        // veryLongParamArray);
    }
}
