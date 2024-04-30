import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;

public class Saving_properties_as_xml {
    // Saving Properties as XML/Menyimpan Properti sebagai XML

    // Menyimpan Properti dalam File XML

    /*
     * Cara Anda menyimpan file properti sebagai file XML sangat mirip dengan cara
     * Anda menyimpannya sebagai file .properties.
     * Alih-alih menggunakan store() Anda akan menggunakan storeToXML().
     */

    /*
     * public void saveProperties(String location) throws IOException{
     * // make new instance of properties
     * Properties prop = new Properties();
     * 
     * // set the property values
     * prop.setProperty("name", "Steve");
     * prop.setProperty("color", "green");
     * prop.setProperty("age", "23");
     * 
     * // check to see if the file already exists
     * File file = new File(location);
     * if (!file.exists()){
     * file.createNewFile();
     * }
     * // save the properties
     * prop.storeToXML(new FileOutputStream(file), "testing properties with xml");
     * }
     */

    // Saat Anda membuka file, tampilannya akan seperti ini.

    // Loading Properties from a XML File/Memuat Properti dari File XML
    /*
     * Sekarang untuk memuat file ini sebagai properti, Anda perlu memanggil
     * loadFromXML() alih-alih load() yang akan Anda gunakan
     * dengan file .properties biasa.
     */

    /*
     * public static void loadProperties(String location) throws
     * FileNotFoundException, IOException{
     * // make new properties instance to load the file into
     * Properties prop = new Properties();
     * 
     * // check to make sure the file exists
     * File file = new File(location);
     * if (file.exists()){
     * // load the file
     * prop.loadFromXML(new FileInputStream(file));
     * 
     * // print out all the properties
     * for (String name : prop.stringPropertyNames()){
     * System.out.println(name + "=" + prop.getProperty(name));
     * }
     * } else {
     * System.err.println("Error: No file found at: " + location);
     * }
     * }
     * 
     */

    // Saat Anda menjalankan kode ini, Anda akan mendapatkan yang berikut di konsol:
    /*
     * age=23
     * color=green
     * name=Steve
     */

    public static void main(String[] args) {
        // try {
        // saveProperties("example.xml");
        // System.out.println("Properties saved successfully.");
        // } catch (IOException e) {
        // System.err.println("Error saving properties: " + e.getMessage());
        // }
        // --------------------
        try {
            loadProperties("example.xml");
        } catch (IOException e) {
            System.err.println("Error loading properties: " + e.getMessage());
        }
        /*
         * output:
         * color=green
         * name=Steve
         * age=23
         */
    }

    // public static void saveProperties(String location) throws IOException {
    // // membuat instance properties baru
    // Properties prop = new Properties();

    // // set nilai properti
    // prop.setProperty("name", "Steve");
    // prop.setProperty("color", "green");
    // prop.setProperty("age", "23");

    // // cek apakah file sudah ada
    // File file = new File(location);
    // if (!file.exists()) {
    // file.createNewFile();
    // }

    // // simpan properti ke dalam file XML
    // prop.storeToXML(new FileOutputStream(file), "testing properties with xml");
    // }
    // --------------------------------
    public static void loadProperties(String location) throws IOException {
        // membuat instance properties baru untuk memuat file
        Properties prop = new Properties();

        // memeriksa apakah file ada
        File file = new File(location);
        if (file.exists()) {
            // memuat file
            prop.loadFromXML(new FileInputStream(file));

            // mencetak semua properti
            for (String name : prop.stringPropertyNames()) {
                System.out.println(name + "=" + prop.getProperty(name));
            }
        } else {
            System.err.println("Error: No file found at: " + location);
        }
    }
}
