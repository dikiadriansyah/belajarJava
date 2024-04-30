import java.util.ArrayList;
import java.util.List;

public class Final2 {
    // Final2

    /*
     * final di Java dapat merujuk pada variabel, metode, dan kelas. Ada tiga aturan
     * sederhana:
     * variabel final tidak dapat ditugaskan kembali
     * metode final tidak dapat ditimpa
     * kelas final tidak dapat diperpanjang
     */

    // Penggunaan

    // Good Programming Practice
    /*
     * Beberapa pengembang menganggap menandai variabel final sebagai praktik yang
     * baik jika Anda bisa. Jika Anda memiliki variabel yang tidak boleh diubah,
     * Anda harus menandainya sebagai final.
     * 
     * Penggunaan penting kata kunci final if untuk parameter metode. Jika Anda
     * ingin menekankan bahwa suatu metode tidak mengubah parameter masukannya,
     * tandai propertinya sebagai final.
     * 
     * public int sumup(final List<Integer> ints);
     * 
     * Ini menekankan bahwa metode sumup tidak akan mengubah int
     */

    // Inner class Access

    // Jika kelas dalam anonim Anda ingin mengakses suatu variabel, variabel
    // tersebut harus ditandai sebagai final

    /*
     * public IPrintName printName(){
     * String name;
     * return new IPrintName(){
     * 
     * @Override
     * public void printName(){
     * System.out.println(name);
     * }
     * };
     * }
     * 
     */

    // Kelas ini tidak dapat dikompilasi, karena name variabelnya, belum final.

    // Version ≥ Java SE 8

    /*
     * Variabel final secara efektif merupakan pengecualian. Ini adalah variabel
     * lokal yang ditulis hanya sekali dan oleh karena itu dapat dijadikan final.
     * Variabel final yang efektif juga dapat diakses dari kelas anonim.
     */

    // final static variable

    /*
     * Meskipun kode di bawah ini sepenuhnya sah variabel final jika foo tidak
     * static, jika static maka kode tersebut tidak akan dapat dikompilasi:
     * class TestFinal {
     * private final static List foo;
     * public Test() {
     * foo = new ArrayList();
     * }
     * }
     * 
     */

    /*
     * Alasannya, mari kita ulangi lagi, variabel akhir tidak dapat dipindahkan.
     * Karena foo bersifat statis, maka foo dibagikan ke semua instance kelas
     * TestFinal. Ketika instance baru dari kelas TestFinal dibuat, konstruktornya
     * dipanggil dan
     * oleh karena itu foo ditugaskan kembali kompiler mana yang tidak mengizinkan.
     * Cara yang benar untuk menginisialisasi variabel foo dalam kasus ini adalah:
     * 
     * class TestFinal {
     * private static final List foo = new ArrayList();
     * //..
     * }
     * 
     */

    // atau dengan menggunakan penginisialisasi statis:

    /*
     * class TestFinal {
     * private static final List foo;
     * static {
     * foo = new ArrayList();
     * }
     * //..
     * }
     */

    /*
     * metode final berguna ketika kelas dasar mengimplementasikan beberapa fungsi
     * penting yang tidak dimiliki oleh kelas turunan
     * seharusnya mengubahnya. Metode ini juga lebih cepat dibandingkan metode
     * non-final, karena tidak melibatkan konsep tabel virtual.
     * 
     * Semua kelas wrapper di Java bersifat final, seperti Integer, Long, dll.
     * Pembuat kelas ini tidak ingin siapa pun dapat melakukannya, mis. memperluas
     * Integer ke kelasnya sendiri dan mengubah perilaku dasar kelas Integer. Salah
     * satu persyaratan untuk membuat suatu kelas tidak dapat diubah adalah bahwa
     * subkelas tidak boleh mengesampingkan metode. Cara paling sederhana untuk
     * melakukan ini adalah dengan mendeklarasikan kelas tersebut sebagai kelas
     * final.
     */

    // ---------------------
    // public IPrintName printName() {
    // final String name = "John"; // inisialisasi variabel name
    // return new IPrintName() {
    // @Override
    // public void printName() {
    // System.out.println(name);
    // }
    // };
    // }
    // -------------------------
    private static final List foo;

    static {
        foo = new ArrayList();
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // -----------------
        // Final2 box = new Final2();
        // IPrintName box2 = box.printName();
        // box2.printName(); // output: John
        // ----------------------
        foo.add("Hello");
        foo.add("World");

        System.out.println("Contents of foo:");
        for (Object obj : foo) {
            System.out.println(obj);
        }
        /*
         * output:
         * Contents of foo:
         * Hello
         * World
         */
    }
}
