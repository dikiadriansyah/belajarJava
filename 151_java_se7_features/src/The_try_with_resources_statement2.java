import java.io.*;

public class The_try_with_resources_statement2 {
    // The try-with-resources statement/Pernyataan coba-dengan-sumber daya

    /*
     * Contohnya membaca baris pertama dari sebuah file. Ia menggunakan instance
     * BufferedReader untuk membaca data dari file.
     * BufferedReader adalah sumber daya yang harus ditutup setelah program selesai:
     */

    /*
     * static String readFirstLineFromFile(String path) throws IOException {
     * try (BufferedReader br = new BufferedReader(new FileReader(path))) {
     * return br.readLine();
     * }
     * }
     */

    /*
     * Dalam contoh ini, sumber daya yang dideklarasikan dalam pernyataan
     * coba-dengan-sumber daya adalah BufferedReader. Pernyataan deklarasi muncul
     * dalam tanda kurung tepat setelah kata kunci try. Kelas BufferedReader, di
     * Java SE 7 dan yang lebih baru, mengimplementasikan antarmuka
     * java.lang.AutoCloseable. Karena instance BufferedReader dideklarasikan dalam
     * pernyataan try-with-resource, instance tersebut akan ditutup terlepas dari
     * apakah pernyataan try selesai secara normal atau tidak.
     * secara tiba-tiba (sebagai akibat dari metode BufferedReader.readLine yang
     * melemparkan IOException).
     */

    public static void main(String[] args) throws Exception {
        try {
            String path = "file1.txt"; // Ganti dengan nama file yang ingin Anda baca
            String firstLine = readFirstLineFromFile(path);
            System.out.println("Baris pertama dari file adalah: " + firstLine);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }

        /*
         * output:
         * Baris pertama dari file adalah: Stackoverflow documentation seems fun.
         */
    }

    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

}
