import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class Parsing_a_document_using_the_stax_api {
    // Parsing a document using the StAX API/Mengurai dokumen menggunakan StAX API

    // Mengingat dokumen berikut:
    /*
     * <?xml version='1.0' encoding='UTF-8' ?>
     * <library>
     * <book id='1'>Effective Java</book>
     * <book id='2'>Java Concurrency In Practice</book>
     * <notABook id='3'>This is not a book element</notABook>
     * </library>
     */

    // Seseorang dapat menggunakan kode berikut untuk menguraikannya dan membuat
    // peta judul buku berdasarkan id buku.

    /*
     * import javax.xml.stream.XMLInputFactory;
     * import javax.xml.stream.XMLStreamConstants;
     * import javax.xml.stream.XMLStreamReader;
     * import java.io.StringReader;
     * import java.util.HashMap;
     * import java.util.Map;
     * public class StaxDemo {
     * public static void main(String[] args) throws Exception {
     * String xmlDocument = "<?xml version='1.0' encoding='UTF-8' ?>"
     * + "<library>"
     * + "<book id='1'>Effective Java</book>"
     * + "<book id='2'>Java Concurrency In Practice</book>"
     * + "<notABook id='3'>This is not a book element </notABook>"
     * + "</library>";
     * XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
     * // Various flavors are possible, e.g. from an InputStream, a Source, ...
     * XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new
     * StringReader(xmlDocument));
     * Map<Integer, String> bookTitlesById = new HashMap<>();
     * // We go through each event using a loop
     * while (xmlStreamReader.hasNext()) {
     * switch (xmlStreamReader.getEventType()) {
     * case XMLStreamConstants.START_ELEMENT:
     * System.out.println("Found start of element: " +
     * xmlStreamReader.getLocalName());
     * // Check if we are at the start of a <book> element
     * if ("book".equals(xmlStreamReader.getLocalName())) {
     * int bookId = Integer.parseInt(xmlStreamReader.getAttributeValue("", "id"));
     * String bookTitle = xmlStreamReader.getElementText();
     * bookTitlesById.put(bookId, bookTitle);
     * }
     * break;
     * // A bunch of other things are possible : comments, processing instructions,
     * Whitespace...
     * default:
     * break;
     * }
     * xmlStreamReader.next();
     * }
     * System.out.println(bookTitlesById);
     * }
     */

    // hasil:
    /*
     * Found start of element: library
     * Found start of element: book
     * Found start of element: book
     * Found start of element: notABook
     * {1=Effective Java, 2=Java Concurrency In Practice}
     * 
     */

    // Dalam contoh ini, seseorang harus memperhatikan beberapa hal:
    /*
     * 1. Penggunaan xmlStreamReader.getAttributeValue berfungsi karena kita telah
     * memeriksa terlebih dahulu apakah parsernya ada
     * negara bagian START_ELEMENT. Di setiap negara bagian lain (kecuali ATRIBUT),
     * parser diberi mandat untuk melempar
     * IllegalStateException, karena atribut hanya dapat muncul di awal elemen.
     * 2. hal yang sama berlaku untuk xmlStreamReader.getTextContent(), ini
     * berfungsi karena kita berada di START_ELEMENT dan kita
     * ketahui dalam dokumen ini bahwa elemen <book> tidak memiliki node anak
     * non-teks.
     */

    /*
     * Untuk penguraian dokumen yang lebih kompleks (elemen yang lebih dalam dan
     * bersarang, ...), praktik yang baik adalah "delegate" parser ke
     * sub-metode atau objek lain, mis. memiliki kelas atau metode BookParser, dan
     * menangani setiap elemen dari
     * START_ELEMENT ke END_ELEMENT tag XML buku.
     * 
     * Seseorang juga dapat menggunakan objek Stack untuk menyimpan data penting di
     * atas dan di bawah pohon.
     */
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        String xmlDocument = "<?xml version='1.0' encoding='UTF-8' ?>"
                + "<library>"
                + "<book id='1'>Effective Java</book>"
                + "<book id='2'>Java Concurrency In Practice</book>"
                + "<notABook id='3'>This is not a book element </notABook>"
                + "</library>";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        // Various flavors are possible, e.g. from an InputStream, a Source, ...
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new StringReader(xmlDocument));
        Map<Integer, String> bookTitlesById = new HashMap<>();
        // We go through each event using a loop
        while (xmlStreamReader.hasNext()) {
            switch (xmlStreamReader.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    System.out.println("Found start of element: " + xmlStreamReader.getLocalName());
                    // Check if we are at the start of a <book> element
                    if ("book".equals(xmlStreamReader.getLocalName())) {
                        int bookId = Integer.parseInt(xmlStreamReader.getAttributeValue("", "id"));
                        String bookTitle = xmlStreamReader.getElementText();
                        bookTitlesById.put(bookId, bookTitle);
                    }
                    break;
                // A bunch of other things are possible : comments, processing instructions,
                // Whitespace...
                default:
                    break;
            }
            xmlStreamReader.next();

        }
        System.out.println(bookTitlesById);
        /*
         * output:
         * Found start of element: library
         * Found start of element: book
         * Found start of element: book
         * Found start of element: notABook
         * {1=Effective Java, 2=Java Concurrency In Practice}
         */
    }
}