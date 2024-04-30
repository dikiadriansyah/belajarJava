import java.util.Scanner;

public class Introduction {
    // Introduction / perkenalan
    /*
     * Pengecualian adalah kesalahan yang terjadi ketika suatu program sedang
     * dijalankan. Perhatikan program Java di bawah ini yang membagi dua bilangan
     * bulat.
     * 
     * int a, b, result;
     * Scanner input = new Scanner(System.in);
     * System.out.println("Input two integers");
     * a = input.nextInt();
     * b = input.nextInt();
     * result = a / b;
     * System.out.println("Result = " + result);
     */

    // Sekarang kita kompilasi dan jalankan kode di atas, dan lihat output dari
    // percobaan pembagian dengan nol:

    /*
     * Input two integers
     * 7 0
     * Exception in thread "main" java.lang.ArithmeticException: / by zero
     * at Division.main(Disivion.java:14)
     * 
     */

    /*
     * Pembagian dengan nol adalah operasi tidak valid yang akan menghasilkan nilai
     * yang tidak dapat direpresentasikan sebagai bilangan bulat. Java menangani hal
     * ini dengan memberikan excpetion. Dalam hal ini, pengecualiannya adalah
     * turunan dari kelas ArithmeticException.
     */

    /*
     * Catatan: Contoh pembuatan dan pembacaan pelacakan tumpukan menjelaskan arti
     * keluaran setelah kedua angka tersebut.
     * 
     * Kegunaan exception adalah kontrol aliran yang diperbolehkan. Tanpa
     * menggunakan pengecualian, solusi umum untuk masalah ini adalah dengan
     * memeriksa terlebih dahulu apakah b == 0:
     */

    /*
     * class Division {
     * public static void main(String[] args) {
     * int a, b, result;
     * Scanner input = new Scanner(System.in);
     * System.out.println("Input two integers");
     * a = input.nextInt();
     * b = input.nextInt();
     * if (b == 0) {
     * System.out.println("You cannot divide by zero.");
     * return;
     * }
     * result = a / b;
     * System.out.println("Result = " + result);
     * }
     * }
     * 
     */

    /*
     * Ini akan mencetak pesan Anda tidak dapat membagi dengan nol. ke konsol dan
     * keluar dari program dengan cara yang baik ketika pengguna mencoba membagi
     * dengan nol. Cara yang setara untuk mengatasi masalah ini melalui penanganan
     * pengecualian adalah dengan mengganti kontrol aliran if dengan blok
     * try-catch:
     */

    /*
     * a = input.nextInt();
     * b = input.nextInt();
     * try {
     * result = a / b;
     * }
     * catch (ArithmeticException e) {
     * System.out.
     * println("An ArithmeticException occurred. Perhaps you tried to divide by zero."
     * );
     * return;
     * }
     */

    /*
     * Blok try catch dijalankan sebagai berikut:
     * 1. Mulailah mengeksekusi kode di blok try.
     * 2. Jika pengecualian terjadi di blok coba, segera batalkan dan periksa apakah
     * pengecualian ini ditangkap oleh blok catch (dalam hal ini, ketika Exception
     * adalah turunan dari ArithmeticException).
     * 3. Jika pengecualian tertangkap, pengecualian tersebut ditugaskan ke variabel
     * e dan blok catch dijalankan.
     * 4. Jika blok try atau catch selesai (yaitu tidak ada pengecualian yang
     * tidak tertangkap yang terjadi selama eksekusi kode) maka
     * terus jalankan kode di bawah blok try-catch.
     */

    /*
     * Secara umum dianggap sebagai praktik yang baik untuk menggunakan penanganan
     * pengecualian sebagai bagian dari kontrol aliran normal aplikasi di mana
     * perilaku tidak terdefinisi atau tidak terduga. Misalnya, daripada
     * mengembalikan null ketika suatu metode gagal, biasanya lebih baik untuk
     * melemparkan pengecualian sehingga aplikasi yang menggunakan metode tersebut
     * dapat menentukan kontrol alirannya sendiri untuk situasi tersebut melalui
     * penanganan pengecualian seperti yang diilustrasikan di atas. Dalam beberapa
     * hal, hal ini mengatasi masalah keharusan mengembalikan tipe tertentu, karena
     * salah satu dari beberapa jenis pengecualian dapat diberikan untuk menunjukkan
     * masalah spesifik yang terjadi.
     * 
     * Untuk saran lebih lanjut tentang bagaimana dan bagaimana tidak menggunakan
     * pengecualian, lihat Kesalahan Java - Penggunaan pengecualian
     */

    public static void main(String[] args) {
        // int a, b, result;
        // Scanner input = new Scanner(System.in);
        // System.out.println("Input two integers");
        // a = input.nextInt();
        // b = input.nextInt();
        // result = a / b;
        // System.out.println("Result = " + result);
        /*
         * output:
         * Input two integers
         * 9
         * 0
         * Exception in thread "main" java.lang.ArithmeticException: / by zero
         */

        // ---------------
        int a, b, result;
        Scanner input = new Scanner(System.in);
        System.out.println("Input two integers");
        a = input.nextInt();
        b = input.nextInt();
        if (b == 0) {
            System.out.println("You cannot divide by zero.");
            return;
        }
        result = a / b;
        System.out.println("Result = " + result);

        /*
         * output:
         * Input two integers
         * 9
         * 3
         * Result = 3
         */

    }
}
