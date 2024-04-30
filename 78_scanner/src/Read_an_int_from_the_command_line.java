import java.util.Scanner;

public class Read_an_int_from_the_command_line {
    // Read an int from the command line/Baca int dari baris perintah

    /*
     * import java.util.Scanner;
     * Scanner s = new Scanner(System.in);
     * int number = s.nextInt();
     * 
     */

    /*
     * Jika Anda ingin membaca int dari baris perintah, gunakan saja cuplikan ini.
     * Pertama-tama, Anda harus membuat objek Scanner, yang mendengarkan System.in,
     * yang secara default merupakan Command Line, ketika Anda memulai program dari
     * baris perintah. Setelah itu, dengan bantuan objek Scanner, Anda membaca int
     * pertama yang dimasukkan pengguna ke dalam
     * baris perintah dan menyimpannya dalam nomor variabel. Sekarang Anda dapat
     * melakukan apa pun yang Anda inginkan dengan int yang disimpan itu.
     */

    public static void main(String[] args) {
        // Membuat objek Scanner
        Scanner s = new Scanner(System.in);

        // Meminta pengguna memasukkan sebuah angka
        System.out.print("Masukkan sebuah angka: ");

        // Membaca input angka dari pengguna
        int number = s.nextInt();

        // Menampilkan angka yang dimasukkan oleh pengguna
        System.out.println("Anda memasukkan angka: " + number);

        // Menutup Scanner untuk menghindari resource leak
        s.close();

        /*
         * output:
         * Masukkan sebuah angka: 4
         * Anda memasukkan angka: 4
         */

    }
}
