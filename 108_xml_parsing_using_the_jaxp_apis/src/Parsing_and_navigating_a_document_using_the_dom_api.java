import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class Parsing_and_navigating_a_document_using_the_dom_api {
    // Parsing and navigating a document using the DOM API/Mengurai dan menavigasi
    // dokumen menggunakan DOM API

    // Mengingat dokumen berikut:
    /*
     * <?xml version='1.0' encoding='UTF-8' ?>
     * <library>
     * <book id='1'>Effective Java</book>
     * <book id='2'>Java Concurrency In Practice</book>
     * </library>
     */

    // Seseorang dapat menggunakan kode berikut untuk membangun pohon DOM dari
    // sebuah String:
    /*
     * import org.w3c.dom.Document;
     * import org.w3c.dom.Node;
     * import org.w3c.dom.NodeList;
     * import org.xml.sax.InputSource;
     * import javax.xml.parsers.DocumentBuilder;
     * import javax.xml.parsers.DocumentBuilderFactory;
     * import java.io.StringReader;
     * public class DOMDemo {
     * public static void main(String[] args) throws Exception {
     * String xmlDocument = "<?xml version='1.0' encoding='UTF-8' ?>"
     * + "<library>"
     * + "<book id='1'>Effective Java</book>"
     * + "<book id='2'>Java Concurrency In Practice</book>"
     * + "</library>";
     * DocumentBuilderFactory documentBuilderFactory =
     * DocumentBuilderFactory.newInstance();
     * // This is useless here, because the XML does not have namespaces, but this
     * option is usefull to
     * know in cas
     * documentBuilderFactory.setNamespaceAware(true);
     * DocumentBuilder documentBuilder =
     * documentBuilderFactory.newDocumentBuilder();
     * // There are various options here, to read from an InputStream, from a file,
     * ...
     * Document document = documentBuilder.parse(new InputSource(new
     * StringReader(xmlDocument)));
     * // Root of the document
     * System.out.println("Root of the XML Document: " +
     * document.getDocumentElement().getLocalName());
     * // Iterate the contents
     * NodeList firstLevelChildren = document.getDocumentElement().getChildNodes();
     * for (int i = 0; i < firstLevelChildren.getLength(); i++) {
     * Node item = firstLevelChildren.item(i);
     * System.out.println("First level child found, XML tag name is: " +
     * item.getLocalName());
     * System.out.println("\tid attribute of this tag is : " +
     * item.getAttributes().getNamedItem("id").getTextContent());
     * }
     * // Another way would have been
     * NodeList allBooks =
     * document.getDocumentElement().getElementsByTagName("book");
     * }
     * }
     */

    // Kode menghasilkan yang berikut:
    /*
     * Root of the XML Document: library
     * First level child found, XML tag name is: book
     * id attribute of this tag is : 1
     * First level child found, XML tag name is: book
     * id attribute of this tag is : 2
     */

    public static void main(String[] args) throws Exception {
        String xmlDocument = "<?xml version='1.0' encoding='UTF-8' ?>"
                + "<library>"
                + "<book id='1'>Effective Java</book>"
                + "<book id='2'>Java Concurrency In Practice</book>"
                + "</library>";
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        // This is useless here, because the XML does not have namespaces, but this
        // option is usefull to
        // know in cas
        documentBuilderFactory.setNamespaceAware(true);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        // There are various options here, to read from an InputStream, from a file, ...
        Document document = documentBuilder.parse(new InputSource(new StringReader(xmlDocument)));
        // Root of the document
        System.out.println("Root of the XML Document: " +
                document.getDocumentElement().getLocalName());
        // Iterate the contents
        NodeList firstLevelChildren = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < firstLevelChildren.getLength(); i++) {
            Node item = firstLevelChildren.item(i);
            System.out.println("First level child found, XML tag name is: " + item.getLocalName());
            System.out.println("\tid attribute of this tag is : " +
                    item.getAttributes().getNamedItem("id").getTextContent());
        }
        // Another way would have been
        NodeList allBooks = document.getDocumentElement().getElementsByTagName("book");
        /*
         * output:
         * Root of the XML Document: library
         * First level child found, XML tag name is: book
         * id attribute of this tag is : 1
         * First level child found, XML tag name is: book
         * id attribute of this tag is : 2
         */
    }
}
