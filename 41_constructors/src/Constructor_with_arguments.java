public class Constructor_with_arguments {
    // Constructor with Arguments

    // Konstruktor dapat dibuat dengan segala jenis argumen

    // private String testData;

    // public Constructor_with_arguments(String testData) {
    // this.testData = testData;
    // }

    // public String getTestData() {
    // return testData;
    // }

    public static void main(String[] args) {
        Constructor_with_arguments box1 = new Constructor_with_arguments("Test Data");
        System.out.println("Hasil: " + box1.getTestData()); // Hasil: Test Data
    }

    /*
     * Sebuah kelas dapat memiliki banyak konstruktor dengan tanda tangan berbeda.
     * Untuk merangkai panggilan konstruktor (memanggil konstruktor berbeda dari
     * kelas yang sama saat membuat instance) gunakan ini().
     */

    private String testData;

    public Constructor_with_arguments(String testData) {
        this.testData = testData;
    }

    public Constructor_with_arguments() {
        this("Test"); // testData defaults to "Test"
    }

    public String getTestData() {
        return testData;
    }

}
