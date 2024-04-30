public class Default_constructor {
    // Default Constructor

    /*
     * "Default" untuk konstruktor adalah mereka tidak memiliki argumen apa pun.
     * Jika Anda tidak menentukan konstruktor apa pun,
     * kompiler akan menghasilkan konstruktor default untuk Anda.
     * Ini berarti dua cuplikan berikut setara secara semantik:
     * 
     * public class TestClass {
     * private String test;
     * }
     * public class TestClass {
     * private String test;
     * public TestClass() {
     * }
     * }
     * 
     * Visibilitas konstruktor default sama dengan visibilitas kelas. Jadi kelas
     * yang didefinisikan packageprivately memiliki konstruktor default
     * paket-pribadi
     * 
     * Namun, jika Anda memiliki konstruktor non-default, kompiler tidak akan
     * membuat konstruktor default untuk Anda. Jadi ini tidak setara:
     * 
     * public class TestClass {
     * private String test;
     * public TestClass(String arg) {
     * }
     * }
     * public class TestClass {
     * private String test;
     * public TestClass() {
     * }
     * public TestClass(String arg) {
     * }
     * }
     * 
     * Berhati-hatilah karena konstruktor yang dihasilkan tidak melakukan
     * inisialisasi non-standar. Ini berarti semua bidang di kelas Anda
     * akan memiliki nilai defaultnya, kecuali jika mereka memiliki inisialisasi
     **/

    private String testData;

    public Default_constructor() {
        testData = "Test";
    }

    public String getTestData() {
        return testData;
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // Konstruktor dipanggil seperti ini:
        Default_constructor testClass = new Default_constructor();
        System.out.println("Hasil: " + testClass.getTestData()); // Hasil: Test

    }
}
