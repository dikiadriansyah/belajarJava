import javax.print.*;
import javax.print.event.PrintJobEvent;
import javax.print.event.PrintJobListener;
import java.util.logging.Logger;

import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;

public class Listening_print_job_request_status_change {
    // Listening print job request status change/Mendengarkan perubahan status
    // permintaan pekerjaan cetak

    /*
     * Bagi sebagian besar klien pencetakan, sangat berguna untuk mengetahui apakah
     * pekerjaan pencetakan telah selesai atau gagal.
     * Java Print Service API menyediakan beberapa fungsi untuk mendapatkan
     * informasi tentang skenario ini. Yang harus kita lakukan adalah:
     * 
     * 1. menyediakan implementasi untuk antarmuka PrintJobListener dan
     * 2. daftarkan implementasi ini pada pekerjaan pencetakan.
     * 
     */

    /*
     * Ketika status pekerjaan pencetakan berubah, kami akan diberitahu. Kita bisa
     * melakukan apa saja yang diperlukan, misalnya:
     * 1. perbarui antarmuka pengguna,
     * 2. memulai proses bisnis lain,
     * 3. mencatat sesuatu ke dalam database,
     * atau cukup catat saja.
     * 
     */

    // Pada contoh di bawah ini, kami akan mencatat setiap perubahan status
    // pekerjaan pencetakan:
    /*
     * import javax.print.event.PrintJobEvent;
     * import javax.print.event.PrintJobListener;
     * public class LoggerPrintJobListener implements PrintJobListener {
     * // Your favorite Logger class goes here!
     * private static final Logger LOG =
     * Logger.getLogger(LoggerPrintJobListener.class);
     * public void printDataTransferCompleted(PrintJobEvent pje) {
     * LOG.info("Print data transfer completed ;) ");
     * }
     * public void printJobCompleted(PrintJobEvent pje) {
     * LOG.info("Print job completed =) ");
     * }
     * public void printJobFailed(PrintJobEvent pje) {
     * LOG.info("Print job failed =( ");
     * }
     * public void printJobCanceled(PrintJobEvent pje) {
     * LOG.info("Print job canceled :| ");
     * }
     * public void printJobNoMoreEvents(PrintJobEvent pje) {
     * LOG.info("No more events to the job ");
     * }
     * public void printJobRequiresAttention(PrintJobEvent pje) {
     * LOG.info("Print job requires attention :O ");
     * }
     * }
     */

    /*
     * Terakhir, kita dapat menambahkan implementasi print job listening pada tugas
     * cetak sebelum permintaan cetak itu sendiri, sebagai berikut:
     * 
     * DocPrintJob printJob = printService.createPrintJob();
     * printJob.addPrintJobListener(new LoggerPrintJobListener());
     * printJob.print(doc, pras);
     * 
     */

    // The PrintJobEvent pje argument/Argumen PrintJobEvent pje
    /*
     * Perhatikan bahwa setiap metode memiliki argumen pje PrintJobEvent. Kami tidak
     * menggunakannya dalam contoh ini untuk tujuan kesederhanaan, namun Anda dapat
     * menggunakannya untuk menjelajahi status. Misalnya:
     * 
     * pje.getPrintJob().getAttributes();
     * 
     * Akan mengembalikan instance objek PrintJobAttributeSet dan Anda dapat
     * menjalankannya dengan cara apa pun.
     */

    // Another way to achieve the same goal/Cara lain untuk mencapai tujuan yang
    // sama
    /*
     * Pilihan lain untuk mencapai tujuan yang sama adalah memperluas kelas
     * PrintJobAdapter, seperti namanya, adalah adaptor
     * untuk PrintJobListener. Mengimplementasikan antarmuka kita wajib harus
     * mengimplementasikan semuanya. Keuntungan dari cara ini adalah kita hanya
     * perlu mengganti metode yang kita inginkan. Mari kita lihat cara kerjanya:
     */

    /*
     * import javax.print.event.PrintJobEvent;
     * import javax.print.event.PrintJobAdapter;
     * public class LoggerPrintJobAdapter extends PrintJobAdapter {
     * private static final Logger LOG =
     * Logger.getLogger(LoggerPrintJobAdapter.class);
     * public void printJobCompleted(PrintJobEvent pje) {
     * LOG.info("Print job completed =) ");
     * }
     * public void printJobFailed(PrintJobEvent pje) {
     * LOG.info("Print job failed =( ");
     * }
     * }
     * 
     */

    /*
     * Perhatikan bahwa kami hanya mengganti beberapa metode tertentu.
     * Seperti halnya pada contoh penerapan antarmuka PrintJobListener, kita
     * menambahkan pendengar ke tugas pencetakan sebelum mengirimkannya untuk
     * dicetak:
     * 
     * printJob.addPrintJobListener(new LoggerPrintJobAdapter());
     * printJob.print(doc, pras);
     */

    public static void main(String[] args) throws Exception {
        // Membuat job print
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob printJob = defaultPrintService.createPrintJob();

        // Membuat dokumen yang akan di-print
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        String data = "Hello, world!";
        byte[] bytes = data.getBytes();
        Doc doc = new SimpleDoc(bytes, flavor, null);

        // Membuat parameter print
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        // Menambahkan listener ke job print
        printJob.addPrintJobListener(new LoggerPrintJobListener());

        try {
            // Memulai print job
            printJob.print(doc, pras);
        } catch (PrintException e) {
            e.printStackTrace();
        }

        /*
         * output:
         * Mar 22, 2024 11:21:31 AM LoggerPrintJobListener printDataTransferCompleted
         * INFO: Print data transfer completed ;)
         * Mar 22, 2024 11:21:31 AM LoggerPrintJobListener printJobNoMoreEvents
         * INFO: No more events to the job
         */

    }

}
