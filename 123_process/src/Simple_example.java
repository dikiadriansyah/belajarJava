import java.io.IOException;

public class Simple_example {
    // Simple example (Java version < 1.5)/Contoh sederhana (versi Java <1.5)

    /*
     * Contoh ini akan memanggil kalkulator windows. Penting untuk diperhatikan
     * bahwa kode keluar akan bervariasi sesuai dengan program/script yang
     * dipanggil.
     * 
     * package process.example;
     * import java.io.IOException;
     * public class App {
     * public static void main(String[] args) {
     * try {
     * // Executes windows calculator
     * Process p = Runtime.getRuntime().exec("calc.exe");
     * // Wait for process until it terminates
     * int exitCode = p.waitFor();
     * System.out.println(exitCode);
     * } catch (IOException e) {
     * e.printStackTrace();
     * } catch (InterruptedException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     */
    public static void main(String[] args) throws Exception {
        try {
            // Executes windows calculator
            Process p = Runtime.getRuntime().exec("calc.exe");
            // Wait for process until it terminates
            int exitCode = p.waitFor();
            System.out.println(exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
