import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class Discovering_the_default_print_service {
    // Discovering the default print service/Menemukan layanan pencetakan default

    /*
     * Untuk menemukan layanan pencetakan default, kita dapat menggunakan kelas
     * PrintServiceLookup. Mari kita lihat caranya ::
     * 
     * import javax.print.PrintService;
     * import javax.print.PrintServiceLookup;
     * public class DiscoveringDefaultPrintService {
     * public static void main(String[] args) {
     * discoverDefaultPrintService();
     * }
     * public static void discoverDefaultPrintService() {
     * PrintService defaultPrintService =
     * PrintServiceLookup.lookupDefaultPrintService();
     * System.out.println("Default print service name: " +
     * defaultPrintService.getName());
     * }
     * }
     */

    public static void main(String[] args) {
        discoverDefaultPrintService();
        /*
         * output:
         * Mar 22, 2024 11:21:31 AM LoggerPrintJobListener printDataTransferCompleted
         * INFO: Print data transfer completed ;)
         * Mar 22, 2024 11:21:31 AM LoggerPrintJobListener printJobNoMoreEvents
         * INFO: No more events to the job
         */
    }

    public static void discoverDefaultPrintService() {
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
        System.out.println("Default print service name: " + defaultPrintService.getName());
    }
}
