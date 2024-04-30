import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Building_the_doc_that_will_be_printed {
    // Building the Doc that will be printed/Membangun Doc yang akan dicetak

    /*
     * Doc adalah antarmuka dan Java Print Service API menyediakan implementasi
     * sederhana yang disebut SimpleDoc.
     * Setiap instance Doc pada dasarnya terdiri dari dua aspek:
     * 1. isi data cetak itu sendiri (E-mail, gambar, dokumen, dll)
     * 2. format data cetak, disebut DocFlavor (tipe MIME + kelas Representasi).
     */

    /*
     * Sebelum membuat objek Doc, kita perlu memuat dokumen kita dari suatu tempat.
     * Dalam contoh ini, kita akan memuat file tertentu dari disk:
     * 
     * FileInputStream pdfFileInputStream = new FileInputStream("something.pdf");
     */

    /*
     * Jadi sekarang, kita harus memilih DocFlavor yang cocok dengan konten kita.
     * Kelas DocFlavor memiliki sekumpulan konstanta untuk mewakili tipe data yang
     * paling umum. Mari kita pilih yang INPUT_STREAM.PDF:
     * 
     * DocFlavor pdfDocFlavor = DocFlavor.INPUT_STREAM.PDF;
     */

    // Sekarang, kita dapat membuat instance baru dari SimpleDoc:
    // Doc doc = new SimpleDoc(pdfFileInputStream, pdfDocFlavor , null);

    // Objek doc sekarang dapat dikirim ke permintaan pekerjaan pencetakan (lihat
    // Membuat pekerjaan pencetakan dari layanan pencetakan).

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // -----------------------
        try {
            FileInputStream pdfFileInputStream = new FileInputStream(
                    "D:\\belajarJava\\163_java_print_service\\src\\pendaftar_cetak.pdf");
            // Lakukan operasi lain di sini

            // Baca data dari file dan cetak ke konsol
            int data;
            while ((data = pdfFileInputStream.read()) != -1) {
                System.out.print((char) data);
            }

            // Jangan lupa untuk menutup file setelah selesai
            pdfFileInputStream.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            e.printStackTrace();
        }

        /*
         * output:
         * ??»?E?mà►u·t7B?d?`ï?EQt?è9smÅ{??8♠x(W↕úy?x??ö?kN4í-'?v♥??½¥ë^'i☻¢?%b8?§?Ö?↔ª!
         * ñ?«?S☼Önò²?@?/åª@èè5(?ñ▬¶???C4???E??ë⌂Öª§?C◄USW☼?5?4_=?í↓L↨K5?|,►?
         * wpaceStorage\44a01b534d757a977492f8382d1624a1\redhat.java\jdt_ws\
         * belajarJava_4f317acc\bin' 'Building_the_doc_that_will_be_printed'
         * &?'?♂?f<)▬*«[?n±d▼☺???á?d▼Ñ%‼5¢·Ö?ñ?^í(??ë{??↓?P?[ní?Ö?Æ?♣`?·%D?kà→¿ß???Dî?♫¡
         * |☼Ü‼?▲Ü??E?K#??I▬☼{‼?‼ñQ\«£÷äòFôt▲??ïNö^?á♣Ä5í??»?t½???$?qµ?/i_?ëy♫??æ↕↑÷]j↔?
         * ▲?Ñ???\FB÷0o?æKûAe????ZF?05p?i?¥£aä3?r??ö¢?@?à?æ>á?▲3^Ébio?♠D?Ü☻"X6p??[ºyñT♦
         * Üûu¡??Ü?WÖª9#?ÿºU±W.?y4
         * Ü??,ù(nÅT/?v?n??Zê?æ?^{K?*öü°¼¥O>Ñúv↨µ/?nH?c▬{&ù?z)▼¡+7qm?å▲SÆl?é?¶[??¥?→∟k4q
         * ♦?►?♠♫o4qÜ¬?¶z??R?↑º±??ûUhq:ô@ÅH`↔#j?á0ÄÜE????ßHT?]µ?%L?r±(.Ä??ç«?><jf???2#??
         * ?{??¥¿?7◄3Ç?$?? ♀f?b0►?äV?xÇ?è
         * ?h?¥C±¬Fa??&äú:c?XVÅ?5e??∟?_í7◄4?Æ?♣a?·ED?kà→¿ß?!Lo?¿??jà»b#a???Å??O*Y?çe¡·l?
         * ª??Ö???▬ÖûZyÖ?57?m±ïngß↔Q`???;?♠¼_?UN?/ù???æ°É?ój[?²(?♫¿Ju?:^?G?↨w;?Å](à*HC?P
         * ???>o./.??\?«???ì?º3??p??♫#9?MMO??°????Jq?tD÷-♠??ª?v??//j_ZXä???û?å?\ª°‼?óßv?
         * ¿??Oï;rQ?`·Y▬+??á♠▲«Ü∟?#?#♥w¢Üü?)??↨G\è`ªz13GOóM^;Å4!-£½?→♫OHà►▼qE?é_=?Éôh)▼+
         * ?☼?¬????îigF-óâQéY>a$??→MQK?
         * ??á)â>lU↓µ?S◄??L]!8ü∟i!?F?↕Fª↨?jì?Ñ?j`4;-0?↔♥?7?<¢K??¶???ìwÆ♀âaOÜ∟ÿhñ'?+☻?
         * é_ÿ¢3ú«ÿ4?>#¶??§M}??
         * ??!ªoé♠b¿»?#?ü!|?;??⌂?û£q???¶fæ♂^N?Å>???_??¢ö&öG??#/o+ôö↔?éü¥ï?]°ï???+Ä«3
         * endstreamPage
         * endobjt 1 0 R
         * 1 0 objces 2 0 R
         * <</Type /PagesR>>
         * /Kids [3 0 R ]
         * /Count 1
         * /MediaBox [0 0 595.28 841.89]h 2198>>
         * >>ream
         * endobjß?§u?Ö☼/?_?ù???ëÑ??
         * p8á?☺o?♦2ùU?µ,?äñô?~Jaa?â/?j♫ùÄk♫?ñ'P?▼?sô???é???/??û?º?☻?Q?)♦¡C?sx⌂5?♠?~??8▲
         * ÆY2►½Y6?⌂A*²[ñQ♀⌂?égu§?
         * 5 0 obj0s?A/-àx@???9?K????G$♀?éú?☼???µh?çh?(?£$↨
         * ↔YÉ-°?ux{ÿ?|?Ças"Æ?É°ûÿ?ÅCâ?▬??0☼<?!ç?‼7?*?Éë?¿?µ¿óæ0?"?C??lï?+?B♣}_♀Ä?
         * û»?0▬◄▬∟_~??i ?ï+?◄?\8g▲ñ^?Ä☼Çf}????W?é?å\>lee?IC↔í
         * <</Type /Font4
         * /BaseFont /Helvetica
         * /Subtype /Type1
         * /Encoding /WinAnsiEncoding
         * >>
         * endobj
         * 6 0 obj
         * <</Type /Font
         * /BaseFont /Helvetica-Bold
         * /Subtype /Type1
         * /Encoding /WinAnsiEncoding
         * >>
         * endobj
         * 7 0 obj
         * <</Type /Font
         * /BaseFont /Helvetica-Oblique
         * /Subtype /Type1
         * /Encoding /WinAnsiEncoding
         * >>
         * endobj
         * 2 0 obj
         * <</ProcSet [/PDF /Text /ImageB /ImageC /ImageI]
         * /Font <<
         * /F1 5 0 R
         * /F2 6 0 R
         * /F3 7 0 R
         * >>
         * >>
         * endobj
         * 8 0 obj
         * <<
         * /Producer (FPDF 1.52)
         * /Title (:: Cetak Data Pelamar)
         * /Creator (HTML2FPDF >> http://html2fpdf.sf.net)
         * /CreationDate (D:20220315163634)
         * >>
         * endobj
         * 9 0 obj
         * <<
         * /Type /Catalog
         * /Pages 1 0 R
         * /OpenAction [3 0 R /FitH null]
         * /PageLayout /OneColumn
         * >>
         * endobj
         * xref
         * 0 10
         * 0000000000 65535 f
         * 0000002356 00000 n
         * 0000002744 00000 n
         * 0000000009 00000 n
         * 0000000087 00000 n
         * 0000002443 00000 n
         * 0000002539 00000 n
         * 0000002640 00000 n
         * 0000002852 00000 n
         * 0000003007 00000 n
         * trailer
         * <<
         * /Size 10
         * /Root 9 0 R
         * /Info 8 0 R
         * >>
         * startxref
         * 3110
         * %%EOF
         */

    }
}
