import java.util.Scanner;
import java.io.File;

public class Reading_file_input_using_scanner {
    // Reading file input using Scanner/Membaca input file menggunakan Scanner

    /*
     * Scanner scanner = null;
     * try {
     * scanner = new Scanner(new File("Names.txt"));
     * while (scanner.hasNext()) {
     * System.out.println(scanner.nextLine());
     * }
     * } catch (Exception e) {
     * System.err.println("Exception occurred!");
     * } finally {
     * if (scanner != null)
     * scanner.close();
     * }
     */

    /*
     * Di sini objek Pemindai dibuat dengan meneruskan objek File yang berisi nama
     * file teks sebagai masukan. File teks ini akan dibuka oleh objek File dan
     * dibaca oleh objek pemindai pada baris berikut. scanner.hasNext() akan
     * memeriksa apakah ada baris data berikutnya dalam file teks. Menggabungkannya
     * dengan perulangan while akan memungkinkan Anda melakukan iterasi
     * melalui setiap baris data dalam file Names.txt. Untuk mengambil datanya
     * sendiri kita bisa menggunakan cara seperti
     * nextLine(),nextInt(),nextBoolean(), dll. Pada contoh di atas,
     * scanner.nextLine() digunakan. nextLine() mengacu pada baris berikut dalam
     * file teks, dan menggabungkannya dengan objek pemindai memungkinkan Anda
     * mencetak konten baris tersebut.
     * Untuk menutup objek pemindai, Anda akan menggunakan .close().
     */

    // Menggunakan sumber daya coba (mulai dari Java 7 dan seterusnya), kode yang
    // disebutkan di atas dapat ditulis dengan elegan seperti di bawah ini.

    /*
     * try (Scanner scanner = new Scanner(new File("Names.txt"))) {
     * while (scanner.hasNext()) {
     * System.out.println(scanner.nextLine());
     * }
     * } catch (Exception e) {
     * System.err.println("Exception occurred!");
     * }
     */

    public static void main(String[] args) {
        // Scanner scanner = null;
        // try {
        // scanner = new Scanner(new File("hello.txt"));
        // while (scanner.hasNext()) {
        // System.out.println(scanner.nextLine());
        // }
        // } catch (Exception e) {
        // System.err.println("Exception occurred!");
        // } finally {
        // if (scanner != null)
        // scanner.close();
        // }
        /*
         * output:
         * I love Bangladesh.
         */
        // ------------------------------
        try (Scanner scanner = new Scanner(new File("hello.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.err.println("Exception occurred!");
            e.printStackTrace();
        }
        /*
         * output:
         * I love Bangladesh.
         */

    }
}
