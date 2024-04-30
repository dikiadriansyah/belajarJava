import java.io.FileInputStream;
import java.io.IOException;

public class Pitfall_forgetting_to_free_resources {
    // Pitfall: forgetting to free resources/Jebakan: lupa mengosongkan sumber daya

    /*
     * Setiap kali program membuka sumber daya, seperti file atau koneksi jaringan,
     * penting untuk mengosongkan sumber daya tersebut setelah Anda selesai
     * menggunakannya. Kehati-hatian serupa juga harus diambil jika ada pengecualian
     * yang terjadi selama pengoperasian sumber daya tersebut. Ada yang berpendapat
     * bahwa FileInputStream memiliki finalizer yang memanggil metode close() pada
     * acara pengumpulan sampah; namun, karena kami tidak dapat memastikan kapan
     * siklus pengumpulan sampah akan dimulai, aliran masukan dapat menghabiskan
     * sumber daya komputer untuk jangka waktu yang tidak terbatas. Sumber daya
     * harus ditutup di bagian finally dari try-catch block:
     */

    // Version < Java SE 7

    /*
     * private static void printFileJava6() throws IOException {
     * FileInputStream input;
     * try {
     * input = new FileInputStream("file.txt");
     * int data = input.read();
     * while (data != -1){
     * System.out.print((char) data);
     * data = input.read();
     * }
     * } finally {
     * if (input != null) {
     * input.close();
     * }
     * }
     * }
     */

    /*
     * Sejak Java 7 ada pernyataan yang sangat berguna dan rapi yang diperkenalkan
     * di Java 7 khususnya untuk kasus ini, yang disebut try-withresources:
     * 
     * private static void printFileJava7() throws IOException {
     * try (FileInputStream input = new FileInputStream("file.txt")) {
     * int data = input.read();
     * while (data != -1){
     * System.out.print((char) data);
     * data = input.read();
     * }
     * }
     * }
     */

    /*
     * Pernyataan coba-dengan-sumber daya dapat digunakan dengan objek apa pun yang
     * mengimplementasikan antarmuka Closeable atau AutoCloseable. Ini memastikan
     * bahwa setiap sumber daya ditutup pada akhir pernyataan. Perbedaan antara
     * kedua antarmuka tersebut adalah, metode close() dari Closeable memunculkan
     * IOException yang harus ditangani dengan cara tertentu.
     * 
     * Dalam kasus di mana sumber daya telah dibuka tetapi harus ditutup dengan aman
     * setelah digunakan, seseorang dapat menetapkannya ke variabel lokal di dalam
     * try-with-resources.
     */

    // Version ≥ Java SE 7
    /*
     * private static void printFileJava7(InputStream extResource) throws
     * IOException {
     * try (InputStream input = extResource) {
     * ... //access resource
     * }
     * }
     */

    /*
     * Variabel sumber daya lokal yang dibuat dalam konstruktor try-with-resources
     * bersifat final.
     */

    public static void main(String[] args) {
        try {
            printFileJava7();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * output:
         * Hello, World!
         */
    }

    private static void printFileJava7() throws IOException {
        try (FileInputStream input = new FileInputStream("file.txt")) {
            int data = input.read();
            while (data != -1) {
                System.out.print((char) data);
                data = input.read();
            }
        }
    }

}
