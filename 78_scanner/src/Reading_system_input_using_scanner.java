import java.util.Scanner;

public class Reading_system_input_using_scanner {
    // Reading system input using Scanner/Membaca input sistem menggunakan Scanner

    /*
     * Scanner scanner = new Scanner(System.in); //Scanner obj to read System input
     * String inputTaken = new String();
     * while (true) {
     * String input = scanner.nextLine(); // reading one line of input
     * if (input.matches("\\s+")) // if it matches spaces/tabs, stop reading
     * break;
     * inputTaken += input + " ";
     * }
     * System.out.println(inputTaken);
     */

    /*
     * Objek pemindai diinisialisasi untuk membaca input dari keyboard. Jadi untuk
     * input dari keyboard di bawah ini akan menghasilkan keluaran sebagai Membaca
     * from keyboard
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner obj to read System input
        String inputTaken = new String();
        while (true) {
            String input = scanner.nextLine(); // reading one line of input
            if (input.matches("\\s+")) // if it matches spaces/tabs, stop reading
                break;
            inputTaken += input + " ";
        }
        System.out.println(inputTaken);
        /*
         * output:
         * jika tekan tab terus enter maka hasil keluar
         */
    }
}
