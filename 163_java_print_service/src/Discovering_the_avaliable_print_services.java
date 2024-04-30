import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class Discovering_the_avaliable_print_services {
    // Discovering the available print services/Menemukan layanan pencetakan yang
    // tersedia

    /*
     * Untuk menemukan semua layanan pencetakan yang tersedia, kita dapat
     * menggunakan kelas PrintServiceLookup. Mari kita lihat caranya:
     * 
     * import javax.print.PrintService;
     * import javax.print.PrintServiceLookup;
     * public class DiscoveringAvailablePrintServices {
     * public static void main(String[] args) {
     * discoverPrintServices();
     * }
     * public static void discoverPrintServices() {
     * PrintService[] allPrintServices =
     * PrintServiceLookup.lookupPrintServices(null, null);
     * 
     * for (Printservice printService : allPrintServices) {
     * System.out.println("Print service name: " + printService.getName());
     * }
     * }
     * }
     */

    // Program ini, ketika dijalankan di lingkungan Windows, akan mencetak sesuatu
    // seperti ini:
    /*
     * Print service name: Fax
     * Print service name: Microsoft Print to PDF
     * Print service name: Microsoft XPS Document Viewer
     * 
     */
    public static void main(String[] args) {
        discoverPrintServices();
        /*
         * output:
         * Print service name: OneNote for Windows 10
         * Print service name: POS-58
         * Print service name: OneNote (Desktop)
         * Print service name: Microsoft XPS Document Writer
         * a\jdt_ws\belajarJava_4f317acc\bin' 'Discovering_the_avaliable_print_services'
         * Print service name: Microsoft Print to PDF
         * Print service name: Fax
         * Print service name: EPSONA3AC4F (L5190 Series)
         * Print service name: EPSON L3150 Series
         */
    }

    public static void discoverPrintServices() {
        PrintService[] allPrintServices = PrintServiceLookup.lookupPrintServices(null, null);

        for (PrintService printService : allPrintServices) {
            System.out.println("Print service name: " + printService.getName());
        }
    }

}
