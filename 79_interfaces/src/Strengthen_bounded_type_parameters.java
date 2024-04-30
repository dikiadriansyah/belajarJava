
public class Strengthen_bounded_type_parameters {
    // Strengthen bounded type parameters/Perkuat parameter tipe terbatas

    /*
     * Parameter tipe terikat memungkinkan Anda menetapkan batasan pada argumen tipe
     * generik:
     * 
     * class SomeClass {
     * }
     * class Demo<T extends SomeClass> {
     * }
     */

    /*
     * Namun parameter tipe hanya dapat mengikat satu tipe kelas saja.
     * 
     * Tipe antarmuka dapat diikat ke tipe yang sudah terikat. Hal ini dicapai
     * dengan menggunakan simbol &:
     * 
     * interface SomeInterface {
     * }
     * class GenericClass<T extends SomeClass & SomeInterface> {
     * }
     */

    /*
     * Hal ini memperkuat ikatan, yang berpotensi memerlukan argumen tipe untuk
     * diturunkan dari beberapa tipe.
     * Beberapa tipe antarmuka dapat diikat ke parameter tipe:
     * class Demo<T extends SomeClass & FirstInterface & SecondInterface> {
     * }
     */

    /*
     * Namun harus digunakan dengan hati-hati. Pengikatan beberapa antarmuka
     * biasanya merupakan tanda bau kode, yang menunjukkan bahwa tipe baru harus
     * dibuat yang bertindak sebagai adaptor untuk tipe lainnya:
     * 
     * interface NewInterface extends FirstInterface, SecondInterface {
     * }
     * class Demo<T extends SomeClass & NewInterface> {
     * }
     */

    public static void main(String[] args) {
        // Membuat objek Demo dengan parameter tipe SomeClass
        SomeClass someObject = new SomeClass("Custom Data");
        Demo<SomeClass> demoObject = new Demo<>(someObject);

        // Menampilkan informasi
        demoObject.displayInfo();

        // Menggunakan metode getData
        SomeClass retrievedData = demoObject.getData();
        System.out.println("Retrieved data type: " + retrievedData.getClass().getName());
        /*
         * output:
         * Data type: SomeClass
         * Retrieved data type: SomeClass
         */
    }
}
