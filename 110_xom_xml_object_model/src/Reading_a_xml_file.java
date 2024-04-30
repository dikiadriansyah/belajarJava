import java.io.File;
import java.io.IOException;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;

public class Reading_a_xml_file {

    // Reading a xml file/ Membaca file xml

    /*
     * Untuk memuat data XML dengan XOM Anda perlu membuat Builder yang dapat Anda
     * buat menjadi Dokumen.
     * 
     * Builder builder = new Builder();
     * Document doc = builder.build(file);
     */

    /*
     * Untuk mendapatkan elemen root, induk tertinggi dalam file xml, Anda perlu
     * menggunakan getRootElement() pada Document instance.
     * Element root = doc.getRootElement();
     */

    /*
     * Sekarang kelas Element memiliki banyak metode praktis yang membuat membaca
     * xml menjadi sangat mudah. Beberapa yang paling berguna tercantum di bawah
     * ini:
     * 1. getChildElements(String name) - mengembalikan instance Elements yang
     * bertindak sebagai array elemen
     * 2. getFirstChildElement(String name) - mengembalikan elemen anak pertama
     * dengan tag itu.
     * 3. getValue() - mengembalikan nilai di dalam elemen.
     * 4. getAttributeValue(String name) - mengembalikan nilai atribut dengan nama
     * yang ditentukan.
     */

    /*
     * Saat Anda memanggil getChildElements() Anda mendapatkan instance Elements.
     * Dari sini Anda dapat mengulang dan memanggil
     * get(int indeks) metode di atasnya untuk mengambil semua elemen di dalamnya.
     */

    /*
     * Elements colors = root.getChildElements("color");
     * for (int q = 0; q < colors.size(); q++){
     * Element color = colors.get(q);
     * }
     * 
     */

    // contoh: Berikut adalah contoh membaca File XML:

    // XML File:
    /*
     * <example>
     * <person>
     * <name>
     * <first>Diki</first>
     * <last>Adr</last>
     * </name>
     * <age unit="years">23</age>
     * <fav_color>Green</fav_color>
     * </person>
     * 
     * <person>
     * <name>
     * <first>Bob</first>
     * <last>Autry</last>
     * </name>
     * <age unit="months">3</age>
     * <fav_color>N/A</fav_color>
     * </person>
     * 
     * </example>
     * 
     */

    // Kode untuk membaca dan mencetaknya:

    /*
     * import java.io.File;
     * import java.io.IOException;
     * import nu.xom.Builder;
     * import nu.xom.Document;
     * import nu.xom.Element;
     * import nu.xom.Elements;
     * import nu.xom.ParsingException;
     * public class XMLReader {
     * 
     * public static void main(String[] args) throws ParsingException, IOException{
     * File file = new File("insert path here");
     * // builder builds xml data
     * Builder builder = new Builder();
     * Document doc = builder.build(file);
     * 
     * // get the root element <example>
     * Element root = doc.getRootElement();
     * 
     * // gets all element with tag <person>
     * Elements people = root.getChildElements("person");
     * 
     * for (int q = 0; q < people.size(); q++){
     * // get the current person element
     * Element person = people.get(q);
     * 
     * // get the name element and its children: first and last
     * Element nameElement = person.getFirstChildElement("name");
     * Element firstNameElement = nameElement.getFirstChildElement("first");
     * Element lastNameElement = nameElement.getFirstChildElement("last");
     * 
     * // get the age element
     * Element ageElement = person.getFirstChildElement("age");
     * 
     * // get the favorite color element
     * Element favColorElement = person.getFirstChildElement("fav_color");
     * 
     * String fName, lName, ageUnit, favColor;
     * int age;
     * 
     * try {
     * fName = firstNameElement.getValue();
     * lName = lastNameElement.getValue();
     * age = Integer.parseInt(ageElement.getValue());
     * ageUnit = ageElement.getAttributeValue("unit");
     * favColor = favColorElement.getValue();
     * 
     * System.out.println("Name: " + lName + ", " + fName);
     * System.out.println("Age: " + age + " (" + ageUnit + ")");
     * System.out.println("Favorite Color: " + favColor);
     * System.out.println("----------------");
     * 
     * } catch (NullPointerException ex){
     * ex.printStackTrace();
     * } catch (NumberFormatException ex){
     * ex.printStackTrace();
     * }
     * }
     * }
     * 
     * }
     */

    // Ini akan dicetak di konsol:

    /*
     * Name: Smith, Dan
     * Age: 23 (years)
     * Favorite Color: green
     * ----------------
     * Name: Autry, Bob
     * Age: 3 (months)
     * Favorite Color: N/A
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // ----------------
        File file = new File("insert path here");
        // builder builds xml data
        Builder builder = new Builder();
        Document doc = builder.build(file);

        // get the root element <example>
        Element root = doc.getRootElement();

        // gets all element with tag <person>
        Elements people = root.getChildElements("person");

        for (int q = 0; q < people.size(); q++) {
            // get the current person element
            Element person = people.get(q);

            // get the name element and its children: first and last
            Element nameElement = person.getFirstChildElement("name");
            Element firstNameElement = nameElement.getFirstChildElement("first");
            Element lastNameElement = nameElement.getFirstChildElement("last");

            // get the age element
            Element ageElement = person.getFirstChildElement("age");

            // get the favorite color element
            Element favColorElement = person.getFirstChildElement("fav_color");

            String fName, lName, ageUnit, favColor;
            int age;

            try {
                fName = firstNameElement.getValue();
                lName = lastNameElement.getValue();
                age = Integer.parseInt(ageElement.getValue());
                ageUnit = ageElement.getAttributeValue("unit");
                favColor = favColorElement.getValue();

                System.out.println("Name: " + lName + ", " + fName);
                System.out.println("Age: " + age + " (" + ageUnit + ")");
                System.out.println("Favorite Color: " + favColor);
                System.out.println("----------------");

            } catch (NullPointerException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
    }
}
