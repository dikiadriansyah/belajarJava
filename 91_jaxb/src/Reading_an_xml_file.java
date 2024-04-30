
/*
 * Parameter | Details
fileObjOfXML | File object of an XML file
className | Name  of a class with .class extension

JAXB atau Java Architecture for XML Binding (JAXB) adalah kerangka perangkat lunak yang memungkinkan pengembang Java memetakan kelas Java ke representasi XML.
 Halaman ini akan memperkenalkan JAXB kepada pembaca menggunakan contoh rinci tentang fungsinya yang disediakan terutama untuk menyusun dan membatalkan penyusunan Objek Java ke dalam format xml dan sebaliknya.

 */
import javax.xml.bind.JAXB;
import java.io.File;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Reading_an_xml_file {
    // Reading an XML file (unmarshalling)/Membaca file XML (unmarshalling)

    // Untuk membaca file XML bernama UserDetails.xml dengan konten di bawah ini

    /*
     * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
     * <user>
     * <name>Jon Skeet</name>
     * <userID>8884321</userID>
     * </user>
     */

    // Kita membutuhkan kelas POJO bernama User.java seperti di bawah ini

    /*
     * import javax.xml.bind.annotation.XmlRootElement;
     * 
     * @XmlRootElement
     * public class User {
     * private long userID;
     * private String name;
     * // getters and setters
     * }
     */

    /*
     * Di sini kita telah membuat variabel dan nama kelas sesuai dengan node XML.
     * Untuk memetakannya, kami menggunakan anotasi XmlRootElement di kelas.
     * 
     * public class XMLReader {
     * public static void main(String[] args) {
     * try {
     * User user = JAXB.unmarshal(new File("UserDetails.xml"), User.class);
     * System.out.println(user.getName()); // prints Jon Skeet
     * System.out.println(user.getUserID()); // prints 8884321
     * } catch (Exception e) {
     * System.err.println("Exception occurred while reading the XML!");
     * }
     * }
     * }
     * 
     */

    /*
     * Di sini metode unmarshal() digunakan untuk mengurai file XML. Dibutuhkan nama
     * file XML dan tipe kelas sebagai dua argumen. Kemudian kita bisa menggunakan
     * metode pengambil objek untuk mencetak data.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // -------------------
        try {
            User user = JAXB.unmarshal(new File("UserDetails.xml"), User.class);
            System.out.println(user.getName()); // prints Jon Skeet
            System.out.println(user.getUserID()); // prints 8884321
        } catch (Exception e) {
            System.err.println("Exception occurred while reading the XML!");
        }
    }
}
