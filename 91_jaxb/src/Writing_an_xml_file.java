import java.io.File;
import javax.xml.bind.JAXB;

public class Writing_an_xml_file {
    // Writing an XML file (marshalling an object)/Menulis file XML (menyusun objek)

    /*
     * import javax.xml.bind.annotation.XmlRootElement;
     * 
     * @XmlRootElement
     * public class User {
     * private long userID;
     * private String name;
     * 
     * // getters and setters
     * }
     * 
     */

    /*
     * Dengan menggunakan anotasi XMLRootElement, kita dapat menandai suatu kelas
     * sebagai elemen root dari file XML.
     * 
     * import java.io.File;
     * import javax.xml.bind.JAXB;
     * public class XMLCreator {
     * public static void main(String[] args) {
     * User user = new User();
     * user.setName("Jon Skeet");
     * user.setUserID(8884321);
     * try {
     * JAXB.marshal(user, new File("UserDetails.xml"));
     * } catch (Exception e) {
     * System.err.println("Exception occurred while writing in XML!");
     * } finally {
     * System.out.println("XML created");
     * }
     * }
     * }
     * 
     */

    /*
     * marshal() digunakan untuk menulis konten objek ke dalam file XML. Di sini
     * objek user dan objek File baru diteruskan sebagai argumen ke marshal().
     */

    /*
     * Jika eksekusi berhasil, ini membuat file XML bernama UserDetails.xml di jalur
     * kelas dengan konten di bawah ini.
     * 
     * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
     * <user>
     * <name>Jon Skeet</name>
     * <userID>8884321</userID>
     * </user>
     */

    public static void main(String[] args) {
        User2 user = new User2();
        user.setName("Jon Skeet");
        user.setUserID(8884321);

        try {
            JAXB.marshal(user, new File("UserDetails.xml"));
        } catch (Exception e) {
            System.err.println("Exception occurred while writing in XML!");
        } finally {
            System.out.println("XML created");
        }
    }
}
