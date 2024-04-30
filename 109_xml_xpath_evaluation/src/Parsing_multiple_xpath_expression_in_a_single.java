import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class Parsing_multiple_xpath_expression_in_a_single {
    // Parsing multiple xpath expression in a single/ Mengurai beberapa Ekspresi
    // XPath dalam satu XML

    /*
     * Menggunakan contoh yang sama seperti Mengevaluasi NodeList dalam dokumen XML,
     * berikut adalah cara Anda membuat banyak Panggilan XPath secara efisien:
     * 
     * Mengingat dokumen XML berikut:
     * 
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
     * 
     */

    // Inilah cara Anda menggunakan XPath untuk mengevaluasi beberapa ekspresi dalam
    // satu dokumen:

    /*
     * XPath xPath = XPathFactory.newInstance().newXPath(); //Make new XPath
     * DocumentBuilder builder = DocumentBuilderFactory.newInstance();
     * Document doc = builder.parse(new File("path/to/xml.xml")); //Specify XML file
     * path
     * NodeList javaExampleNodes = (NodeList)
     * xPath.evaluate("/documentation/tags/tag[@name='Java']//example", doc,
     * XPathConstants.NODESET);
     * //Evaluate the XPath
     * xPath.reset(); //Resets the xPath so it can be used again
     * NodeList androidExampleNodes = (NodeList)
     * xPath.evaluate("/documentation/tags/tag[@name='Android']//example", doc,
     * XPathConstants.NODESET);
     * //Evaluate the XPath
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // --------------------------
        // Menampilkan contoh untuk tag Java
        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("/belajarJava/109_xml_xpath_evaluation/src/demo2.xml"));

            // Mengevaluasi XPath untuk contoh Java
            NodeList javaExampleNodes = (NodeList) xPath.evaluate(
                    "/documentation/tags/tag[@name='Java']//example",
                    doc,
                    XPathConstants.NODESET);

            // Menampilkan contoh untuk tag Java
            System.out.println("Contoh untuk tag Java:");
            for (int i = 0; i < javaExampleNodes.getLength(); i++) {
                Node node = javaExampleNodes.item(i);
                System.out.println(node.getTextContent());
            }

            // Mengevaluasi XPath untuk contoh Android
            NodeList androidExampleNodes = (NodeList) xPath.evaluate(
                    "/documentation/tags/tag[@name='Android']//example",
                    doc,
                    XPathConstants.NODESET);

            // Menampilkan contoh untuk tag Android
            System.out.println("\nContoh untuk tag Android:");
            for (int i = 0; i < androidExampleNodes.getLength(); i++) {
                Node node = androidExampleNodes.item(i);
                System.out.println(node.getTextContent());
            }
        } catch (XPathExpressionException | IOException | SAXException
                | javax.xml.parsers.ParserConfigurationException e) {
            e.printStackTrace();
        }
        /*
         * output:
         * Contoh untuk tag Java:
         * Matching groups
         * Escaping metacharacters
         * Looping over arrays
         * Converting an array to a list
         * 
         * Contoh untuk tag Android:
         * Building an Android application using Gradle
         * Building an Android application using Maven
         * Including layout resources
         * Supporting multiple device screens
         */
    }
}
