import java.util.Scanner;

public class Carefully_closing_a_scanner {
    // Carefully Closing a Scanner/Menutup Pemindai dengan Hati-hati

    /*
     * Bisa saja Anda menggunakan pemindai dengan System.in sebagai parameter untuk
     * konstruktornya, maka Anda perlu menyadari bahwa menutup pemindai akan menutup
     * InputStream juga sehingga setiap kali mencoba membaca input itu (Atau lainnya
     * objek pemindai) akan menampilkan java.util.NoSuchElementException atau
     * java.lang.IllegalStateException
     */

    // contoh
    /*
     * Scanner sc1 = new Scanner(System.in);
     * Scanner sc2 = new Scanner(System.in);
     * int x1 = sc1.nextInt();
     * sc1.close();
     * // java.util.NoSuchElementException
     * int x2 = sc2.nextInt();
     * // java.lang.IllegalStateException
     * x2 = sc1.nextInt();
     */

    public static void main(String[] args) {
        // Membuat objek Scanner pertama
        Scanner sc1 = new Scanner(System.in);

        // Membaca input pertama
        System.out.print("Masukkan nilai x1: ");
        int x1 = sc1.nextInt();

        // Menutup objek Scanner pertama
        sc1.close();

        // Membuat objek Scanner kedua
        Scanner sc2 = new Scanner(System.in);

        try {
            // Mencoba membaca input kedua
            System.out.print("Masukkan nilai x2: ");
            int x2 = sc2.nextInt();

            // Mencoba membaca input lagi dengan objek sc1 yang sudah ditutup
            x2 = sc1.nextInt(); // Ini akan menghasilkan java.util.NoSuchElementException
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Exception: java.util.NoSuchElementException");
        } catch (java.lang.IllegalStateException e) {
            System.out.println("Exception: java.lang.IllegalStateException");
        } finally {
            // Menutup objek Scanner kedua
            sc2.close();
        }
        /*
         * output:
         * Masukkan nilai x1: 4
         * Masukkan nilai x2: Exception: java.util.NoSuchElementException
         */

    }
}
