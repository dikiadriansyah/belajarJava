import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource; // tambahkan impor untuk InputSource

public class Evaluating_a_nodelist_in_an_xml_document {
    // Evaluating a NodeList in an XML document/Mengevaluasi NodeList dalam dokumen
    // XML

    // Mengingat dokumen XML berikut:
    /*
     * <documentation>
     * <tags>
     * <tag name="Java">
     * <topic name="Regular expressions">
     * <example>Matching groups</example>
     * <example>Escaping metacharacters</example>
     * </topic>
     * <topic name="Arrays">
     * <example>Looping over arrays</example>
     * <example>Converting an array to a list</example>
     * </topic>
     * </tag>
     * <tag name="Android">
     * <topic name="Building Android projects">
     * <example>Building an Android application using Gradle</example>
     * <example>Building an Android application using Maven</example>
     * </topic>
     * <topic name="Layout resources">
     * <example>Including layout resources</example>
     * <example>Supporting multiple device screens</example>
     * </topic>
     * </tag>
     * </tags>
     * </documentation>
     */

    /*
     * Berikut ini mengambil semua example node untuk tag Java (Gunakan metode ini
     * jika hanya mengevaluasi XPath dalam XML satu kali.
     * Lihat contoh lain ketika beberapa panggilan XPath dievaluasi dalam file XML
     * yang sama.):
     * XPathFactory xPathFactory = XPathFactory.newInstance();
     * XPath xPath = xPathFactory.newXPath(); //Make new XPath
     * InputSource inputSource = new InputSource("path/to/xml.xml"); //Specify XML
     * file path
     * NodeList javaExampleNodes = (NodeList)
     * xPath.evaluate("/documentation/tags/tag[@name='Java']//example", inputSource,
     * XPathConstants.NODESET); //Evaluate the XPath
     * 
     */

    public static void main(String[] args) throws Exception {
        // Membuat instance dari XPathFactory
        XPathFactory xPathFactory = XPathFactory.newInstance();

        // Membuat instance dari XPath
        XPath xPath = xPathFactory.newXPath();

        // Menentukan path file XML
        String xmlFilePath = "/belajarJava/109_xml_xpath_evaluation/src/demo2.xml";

        // Membuat InputSource dari path file XML
        InputSource inputSource = new InputSource(xmlFilePath);

        // Menggunakan XPath untuk mengevaluasi XPath dan mendapatkan NodeList
        NodeList javaExampleNodes = (NodeList) xPath.evaluate("/documentation/tags/tag[@name='Java']//example",
                inputSource,
                XPathConstants.NODESET);

        // Menampilkan hasil
        System.out.println("Hasil XPath Evaluation:");
        for (int i = 0; i < javaExampleNodes.getLength(); i++) {
            org.w3c.dom.Node node = javaExampleNodes.item(i); // perubahan di sini
            System.out.println("Example " + (i + 1) + ": " + node.getTextContent());
        }
        /*
         * output:
         * Hasil XPath Evaluation:
         * Example 1: Matching groups
         * Example 2: Escaping metacharacters
         * Example 3: Looping over arrays
         * Example 4: Converting an array to a list
         */

    }
}
