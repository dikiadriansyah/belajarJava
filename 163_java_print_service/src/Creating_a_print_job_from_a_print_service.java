import javax.print.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public class Creating_a_print_job_from_a_print_service {
    // Creating a print job from a print service/Membuat pekerjaan pencetakan dari
    // layanan pencetakan

    /*
     * Pekerjaan pencetakan adalah permintaan untuk mencetak sesuatu pada layanan
     * pencetakan tertentu. Ini pada dasarnya terdiri dari:
     * 
     * 1. data yang akan dicetak (lihat Membangun Dokumen yang akan dicetak)
     * 2. sekumpulan atribut
     */

    /*
     * Setelah mengambil contoh layanan pencetakan yang tepat, kita dapat meminta
     * pembuatan pekerjaan pencetakan:
     * DocPrintJob printJob = printService.createPrintJob();
     * 
     */

    /*
     * Antarmuka DocPrintJob memberi kita metode pencetakan:
     * printJob.print(doc, pras);
     * 
     */

    /*
     * Argumen doc adalah Doc: data yang akan dicetak.
     * 
     * Dan argumen pras adalah antarmuka PrintRequestAttributeSet: satu set
     * PrintRequestAttribute. Apakah contoh atribut permintaan cetak:
     * 1. jumlah salinan (1, 2 dst),
     * 2. orientasi (potret atau lanskap)
     * 3. kromisitas (monokrom, warna)
     * 4. kualitas (draft, normal, tinggi)
     * 5. sisi (satu sisi, dua sisi dll)
     * dan seterusnya...
     */

    // Metode cetak mungkin memunculkan PrintException
    public static void main(String[] args) {
        // Mendapatkan default print service
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        // Mengecek apakah default print service tersedia
        if (defaultPrintService != null) {
            // Mencoba membuka file dokumen yang ingin dicetak
            try {
                FileInputStream fileInputStream = new FileInputStream("pendaftar_cetak.pdf");

                // Membuat dokumen yang akan dicetak
                Doc doc = new SimpleDoc(fileInputStream, DocFlavor.INPUT_STREAM.AUTOSENSE, null);

                // Menyiapkan parameter print job
                PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

                // Membuat print job
                DocPrintJob printJob = defaultPrintService.createPrintJob();

                // Mencetak dokumen
                printJob.print(doc, pras);
            } catch (FileNotFoundException | PrintException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Tidak ada printer yang tersedia.");
        }
    }
}
