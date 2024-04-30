import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.PrintQuality;

public class Defining_print_request_attributes {
    // Defining print request attributes/Mendefinisikan atribut permintaan cetak

    /*
     * Terkadang kita perlu menentukan beberapa aspek dari permintaan pencetakan.
     * Kami akan menyebutnya atribut.
     * Apakah contoh atribut permintaan cetak:
     * 
     * 1. amount of copies (1, 2 etc),
     * 2. orientation (portrait or landscape)
     * 3. chromacity (monochrome, color)
     * 4. quality (draft, normal, high)
     * 5. sides (one-sided, two-sided etc)
     * and so on...
     * 
     */

    /*
     * Sebelum memilih salah satu dari atribut tersebut dan nilai apa yang dimiliki
     * masing-masing atribut, pertama-tama kita perlu membuat sekumpulan atribut:
     * 
     * PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
     */

    // Sekarang kita dapat menambahkannya. Beberapa contohnya adalah:
    /*
     * pras.add(new Copies(5));
     * pras.add(MediaSize.ISO_A4);
     * pras.add(OrientationRequested.PORTRAIT);
     * pras.add(PrintQuality.NORMAL);
     */

    // Objek pras sekarang dapat dikirim ke permintaan pekerjaan pencetakan (lihat
    // Membuat pekerjaan pencetakan dari layanan pencetakan).
    public static void main(String[] args) {
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        pras.add(new Copies(5));
        pras.add(MediaSize.ISO_A4);
        pras.add(OrientationRequested.PORTRAIT);
        pras.add(PrintQuality.NORMAL);

        // Print or display the attributes
        System.out.println("Print Request Attributes:");
        System.out.println(pras);
    }
}
