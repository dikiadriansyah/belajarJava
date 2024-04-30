public class Java_closures_with_lambda_expressions {
    // Java Closures with lambda expressions / Penutupan Java dengan ekspresi lambda

    /*
     * Penutupan lambda dibuat ketika ekspresi lambda mereferensikan variabel dari
     * cakupan yang melingkupinya (global atau local). Aturan untuk melakukan hal
     * ini sama dengan metode inline dan kelas anonim.
     * 
     * Variabel lokal dari lingkup terlampir yang digunakan dalam lambda harus
     * bersifat final. Dengan Java 8 (yang paling awal versi yang mendukung lambda),
     * mereka tidak perlu dinyatakan final dalam konteks luar, tetapi harus
     * diperlakukan seperti itu. Misalnya:
     * int n = 0; // With Java 8 there is no need to explicit final
     * Runnable r = () -> { // Using lambda
     * int i = n;
     * // do something
     * };
     */

    /*
     * Hal ini sah selama nilai n variabel tidak diubah. Jika Anda mencoba mengubah
     * variabel, di dalam atau di luar lambda, Anda akan mendapatkan kesalahan
     * kompilasi berikut:
     * "variabel local yang direferensikan dari ekspresi lambda harus final atau final secara efektif"
     * 
     */

    // Misalnya:
    /*
     * int n = 0;
     * Runnable r = () -> { // Using lambda
     * int i = n;
     * // do something
     * };
     * n++; // Will generate an error.
     * 
     */

    /*
     * Jika perlu menggunakan variabel yang berubah dalam lambda, pendekatan
     * normalnya adalah mendeklarasikan salinan akhir variabel dan menggunakan
     * salinan tersebut. Misalnya
     * 
     * int n = 0;
     * final int k = n; // With Java 8 there is no need to explicit final
     * Runnable r = () -> { // Using lambda
     * int i = k;
     * // do something
     * };
     * n++; // Now will not generate an error
     * r.run(); // Will run with i = 0 because k was 0 when the lambda was created
     */

    /*
     * Secara alami, isi lambda tidak melihat perubahan pada variabel aslinya.
     * 
     * Perhatikan bahwa Java tidak mendukung penutupan yang sebenarnya. Lambda Java
     * tidak dapat dibuat sedemikian rupa sehingga memungkinkannya melihat perubahan
     * di lingkungan tempat lambda tersebut dibuat. Jika Anda ingin menerapkan
     * penutupan yang mengamati atau membuat perubahan pada lingkungannya, Anda
     * harus mensimulasikannya menggunakan kelas reguler. Misalnya:
     */

    /*
     * // Does not compile ...
     * public IntUnaryOperator createAccumulator() {
     * int value = 0;
     * IntUnaryOperator accumulate = (x) -> { value += x; return value; };
     * return accumulate;
     * }
     */

    /*
     * Contoh di atas tidak dapat dikompilasi karena alasan yang telah dibahas
     * sebelumnya. Kita dapat mengatasi kesalahan kompilasi sebagai berikut:
     * 
     * // Compiles, but is incorrect ...
     * public class AccumulatorGenerator {
     * private int value = 0;
     * public IntUnaryOperator createAccumulator() {
     * IntUnaryOperator accumulate = (x) -> { value += x; return value; };
     * return accumulate;
     * }
     * }
     */

    /*
     * Masalahnya adalah hal ini merusak kontrak desain untuk antarmuka
     * IntUnaryOperator yang menyatakan instance tersebut
     * harus fungsional dan tanpa kewarganegaraan. Jika penutupan seperti itu
     * diteruskan ke fungsi bawaan yang menerima objek fungsional, hal ini dapat
     * menyebabkan crash atau perilaku yang salah. Penutupan yang merangkum keadaan
     * yang bisa berubah harus diimplementasikan sebagai kelas reguler. Misalnya.
     * 
     * // Correct ...
     * public class Accumulator {
     * private int value = 0;
     * public int accumulate(int x) {
     * value += x;
     * return value;
     * }
     * }
     */
    // -------------------
    private int value = 0;

    public int accumulate(int x) {
        value += x;
        return value;
    }

    public static void main(String[] args) {
        // int n = 0; // With Java 8 there is no need to explicit final
        // Runnable r = () -> { // Using lambda
        // int i = n;

        // do something
        // System.out.println("Value of i: " + i);
        // };

        // r.run();
        /*
         * output:
         * Value of i: 0
         */
        // ------------------
        Java_closures_with_lambda_expressions myAccumulator = new Java_closures_with_lambda_expressions();

        // Contoh penggunaan
        System.out.println("Nilai awal: " + myAccumulator.accumulate(5)); // Output: Nilai awal: 5
        System.out.println("Setelah ditambah 3: " + myAccumulator.accumulate(3)); // Output: Setelah ditambah 3: 8
        System.out.println("Setelah ditambah 10: " + myAccumulator.accumulate(10)); // Output: Setelah ditambah 10: 18

    }

}
