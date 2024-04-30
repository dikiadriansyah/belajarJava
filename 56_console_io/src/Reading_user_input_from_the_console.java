
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Locale;

public class Reading_user_input_from_the_console {
    // Reading user input from the console / Membaca masukan pengguna dari konsol

    // Gunakan BufferedReader:
    /*
     * System.out.println("Please type your name and press Enter.");
     * 
     * BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
     * try{
     * String name = reader.readLine();
     * System.out.println("Hello "+name+"!");
     * }catch(IOException e){
     * System.out.println("An error occurred: " + e.getMessage());
     * }
     */

    // Impor berikut diperlukan untuk kode ini:
    /*
     * import java.io.BufferedReader;
     * import java.io.IOException;
     * import java.io.InputStreamReader;
     */

    // gunakan Scanner:
    // versi > java se 5

    /*
     * System.out.println("Please type your name and press Enter");
     * Scanner scanner = new Scanner(System.in);
     * String name = scanner.nextLine();
     * System.out.println("Hello, " + name + "!");
     */

    // Impor berikut diperlukan untuk contoh ini:
    // import java.util.Scanner;

    /*
     * Untuk membaca lebih dari satu baris, aktifkan scanner.nextLine() berulang
     * kali:
     * System.out.
     * println("Please enter your first and your last name, on separate lines.");
     * Scanner scanner = new Scanner(System.in);
     * String firstName = scanner.nextLine();
     * String lastName = scanner.nextLine();
     * System.out.println("Hello, " + firstName + " "+lastName+"!");
     * 
     */

    /*
     * Ada dua metode untuk mendapatkan String, next() dan nextLine(). next()
     * mengembalikan teks hingga spasi pertama (juga dikenal sebagai "token"), dan
     * nextLine() mengembalikan semua teks yang dimasukkan pengguna hingga menekan
     * enter.
     */

    // Pemindai juga menyediakan metode utilitas untuk membaca tipe data selain
    // String. Ini termasuk:
    /*
     * scanner.nextByte();
     * scanner.nextShort();
     * scanner.nextInt();
     * scanner.nextLong();
     * scanner.nextFloat();
     * scanner.nextDouble();
     * scanner.nextBigInteger();
     * scanner.nextBigDecimal();
     */

    /*
     * Mengawali salah satu metode ini dengan has (seperti pada hasNextLine(),
     * hasNextInt()) akan menghasilkan nilai true jika aliran memiliki jenis
     * permintaan lainnya. Catatan: Metode ini akan membuat program crash jika input
     * bukan tipe yang diminta (misalnya, mengetik "a" untuk nextInt() ). Anda bisa
     * menggunakan try {} catch() {} untuk mencegah hal ini (lihat: Pengecualian)
     */

    /*
     * Scanner scanner = new Scanner(System.in); //Create the scanner
     * scanner.useLocale(Locale.US); //Set number format excepted
     * System.out.println("Please input a float, decimal separator is .");
     * if (scanner.hasNextFloat()){ //Check if it is a float
     * float fValue = scanner.nextFloat(); //retrive the value directly as float
     * System.out.println(fValue + " is a float");
     * }else{
     * String sValue = scanner.next(); //We can not retrive as float
     * System.out.println(sValue + " is not a float");
     * }
     */

    // Gunakan System.console:
    // versi > java se 6
    /*
     * String name =
     * System.console().readLine("Please type your name and press Enter%n");
     * System.out.printf("Hello, %s!", name);
     * //To read passwords (without echoing as in unix terminal)
     * char[] password = System.console().readPassword();
     */

    /*
     * Keuntungan:
     * Metode membaca disinkronkan
     * Sintaks format string dapat digunakan
     */

    /*
     * Catatan: Ini hanya akan berfungsi jika program dijalankan dari baris perintah
     * sebenarnya tanpa mengalihkan input standar dan
     * aliran keluaran. Itu tidak berfungsi ketika program dijalankan dari dalam IDE
     * tertentu, seperti Eclipse. Untuk kode yang berfungsi dalam IDE dan dengan
     * pengalihan aliran, lihat contoh lainnya.
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // System.out.println("Please type your name and press Enter.");
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // try {
        // String name = reader.readLine();
        // System.out.println("Hello, " + name + "!");
        // } catch (IOException e) {
        // System.out.println("An error occurred: " + e.getMessage());
        // }
        /*
         * output:
         * Please type your name and press Enter.
         * dhiki
         * Hello, dhiki!
         */

        // -----------
        // System.out.println("Please type your name and press Enter");
        // Scanner scanner = new Scanner(System.in);
        // String name = scanner.nextLine();
        // System.out.println("Hello, " + name + "!");
        /*
         * output:
         * Please type your name and press Enter
         * Dhiki Adr
         * Hello, Dhiki Adr!
         */
        // -----------
        // System.out.println("Please enter your first and your last name, on separate
        // lines.");

        // Scanner scanner = new Scanner(System.in);
        // String firstName = scanner.nextLine();
        // String lastName = scanner.nextLine();

        // System.out.println("Hello, " + firstName + " " + lastName + "!");
        /*
         * output:
         * Please enter your first and your last name, on separate lines.
         * Dhiki
         * Adriansyah
         * Hello, Dhiki Adriansyah!
         */

        // -----------
        // Scanner scanner = new Scanner(System.in); // Create the scanner
        // scanner.useLocale(Locale.US); // Set number format excepted
        // System.out.println("Please input a float, decimal separator is .");
        // if (scanner.hasNextFloat()) { // Check if it is a float
        // float fValue = scanner.nextFloat(); // retrive the value directly as float
        // System.out.println(fValue + " is a float");
        // } else {
        // String sValue = scanner.next(); // We can not retrive as float
        // System.out.println(sValue + " is not a float");
        // }

        /*
         * output:
         * Please input a float, decimal separator is .
         * d
         * d is not a float
         */
        // -----------
        // Membaca nama dari pengguna
        String name = System.console().readLine("Please type your name and press Enter%n");
        System.out.printf("Hello, %s!", name);

        System.out.println();

        // To read passwords (without echoing as in unix terminal)
        char[] password = System.console().readPassword("Please enter your password:");

        // Contoh tampilan kata sandi (hanya untuk demonstrasi, sebaiknya tidak
        // ditampilkan di produksi)
        System.out.println("Password entered: " + new String(password));
        /*
         * output:
         * Please type your name and press Enter
         * Dhiki
         * Hello, Dhiki!
         * Please enter your password:
         * Password entered: diki123
         */
    }
}
