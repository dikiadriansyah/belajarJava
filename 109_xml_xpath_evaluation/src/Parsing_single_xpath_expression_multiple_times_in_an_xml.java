import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.File;

public class Parsing_single_xpath_expression_multiple_times_in_an_xml {
    // Parsing single XPath Expression multiple times in an XML

    // Dalam hal ini, Anda ingin ekspresi dikompilasi sebelum evaluasi, sehingga
    // setiap panggilan untuk mengevaluasi tidak mengkompilasi ekspresi yang sama.
    // Sintaks sederhananya adalah:
    /*
     * XPath xPath = XPathFactory.newInstance().newXPath(); //Make new XPath
     * XPathExpression exp =
     * xPath.compile("/documentation/tags/tag[@name='Java']//example");
     * DocumentBuilder builder = DocumentBuilderFactory.newInstance();
     * Document doc = builder.parse(new File("path/to/xml.xml")); //Specify XML file
     * path
     * NodeList javaExampleNodes = (NodeList) exp.evaluate(doc,
     * XPathConstants.NODESET); //Evaluate the
     * XPath from the already-compiled expression
     * NodeList javaExampleNodes2 = (NodeList) exp.evaluate(doc,
     * XPathConstants.NODESET); //Do it again
     */

    // Secara keseluruhan, dua panggilan ke XPathExpression.evaluate() akan jauh
    // lebih efisien daripada dua panggilan ke XPath.evaluate().

    public static void main(String[] args) throws Exception {
        XPath xPath = XPathFactory.newInstance().newXPath(); // Make new XPath
        XPathExpression exp = xPath.compile("/documentation/tags/tag[@name='Java']//example");
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("/belajarJava/109_xml_xpath_evaluation/src/demo2.xml")); // Specify XML
                                                                                                       // file path
        NodeList javaExampleNodes = (NodeList) exp.evaluate(doc, XPathConstants.NODESET); // Evaluate the
        // XPath from the already-compiled expression
        NodeList javaExampleNodes2 = (NodeList) exp.evaluate(doc, XPathConstants.NODESET); // Do it again

        // Print results
        for (int i = 0; i < javaExampleNodes.getLength(); i++) {
            System.out.println("Example " + (i + 1) + ": " + javaExampleNodes.item(i).getTextContent());
        }
        /*
         * output:
         * Example 1: Matching groups path specified)
         * Example 2: Escaping metacharacters
         * Example 3: Looping over arrays
         * Example 4: Converting an array to a list
         */
    }

}
