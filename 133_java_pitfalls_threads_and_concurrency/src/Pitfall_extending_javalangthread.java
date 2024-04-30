public class Pitfall_extending_javalangthread {
    // Pitfall - Extending 'java.lang.Thread'/Kesalahan - Memperluas
    // 'java.lang.Thread'

    /*
     * Javadoc untuk kelas Thread menunjukkan dua cara untuk mendefinisikan dan
     * menggunakan thread:
     * 
     * Menggunakan kelas utas khusus:
     * 
     * class PrimeThread extends Thread {
     * long minPrime;
     * PrimeThread(long minPrime) {
     * this.minPrime = minPrime;
     * }
     * public void run() {
     * // compute primes larger than minPrime
     * . . .
     * }
     * }
     * PrimeThread p = new PrimeThread(143);
     * p.start();
     */

    // Menggunakan Runnable:
    /*
     * class PrimeRun implements Runnable {
     * long minPrime;
     * PrimeRun(long minPrime) {
     * this.minPrime = minPrime;
     * }
     * public void run() {
     * // compute primes larger than minPrime
     * . . .
     * }
     * }
     * PrimeRun p = new PrimeRun(143);
     * new Thread(p).start();
     * 
     */

    // Sumber: java.lang.Thread javadoc

    /*
     * Pendekatan kelas thread khusus berfungsi, tetapi memiliki beberapa masalah:
     * 1. Sulit menggunakan PrimeThread dalam konteks yang menggunakan kumpulan
     * thread klasik, eksekutor, atau ForkJoin
     * kerangka. (Bukan tidak mungkin, karena PrimeThread secara tidak langsung
     * mengimplementasikan Runnable, namun menggunakan custom
     * Kelas thread sebagai Runnable tentu saja canggung, dan mungkin tidak dapat
     * dijalankan... tergantung pada aspek lain dari kelas tersebut.)
     * 2. Ada lebih banyak peluang untuk kesalahan dalam metode lain. Misalnya, jika
     * Anda mendeklarasikan PrimeThread.start() tanpa mendelegasikan ke
     * Thread.start(), Anda akan mendapatkan "thread" yang berjalan pada thread saat
     * ini.
     */

    /*
     * Pendekatan menempatkan logika thread ke dalam Runnable menghindari masalah
     * ini. Memang benar, jika Anda menggunakan kelas anonim (Java 1.1 dan
     * seterusnya) untuk mengimplementasikan Runnable, hasilnya akan lebih ringkas,
     * dan lebih mudah dibaca dibandingkan contoh di atas.
     */

    /*
     * final long minPrime = ...
     * new Thread(new Runnable() {
     * public void run() {
     * // compute primes larger than minPrime
     * . . .
     * }
     * }.start();
     */

    /*
     * Dengan ekspresi lambda (Java 8 dan seterusnya), contoh di atas akan menjadi
     * lebih elegan:
     * final long minPrime = ...
     * new Thread(() -> {
     * // compute primes larger than minPrime
     * . . .
     * }).start();
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // --------------------------

        // PrimeThread box = new PrimeThread(143);
        // box.start();
        /*
         * output:
         * 1236751 is prime
         * 1236757 is prime
         * 1236761 is prime
         * 1236769 is prime
         * 1236787 is prime
         * 1236791 is prime
         * 1236797 is prime
         * 1236803 is prime
         */
        // --------------------------
        // PrimeRun p = new PrimeRun(143);
        // new Thread(p).start();
        /*
         * output:
         * 89819 is prime
         * 89821 is prime
         * 89833 is prime
         * 89839 is prime
         * 89849 is prime
         * 89867 is prime
         * 89891 is prime
         * 89897 is prime
         * 89899 is prime
         * 89909 is prime
         * 89917 is prime
         * 89923 is prime
         * 89939 is prime
         */
        // ------------------------------------
        final long minPrime = 143;
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Computing primes larger than " + minPrime);
                long num = minPrime;
                while (true) {
                    if (isPrime(num)) {
                        System.out.println(num + " is prime");
                    }
                    num++;
                }
            }

            // Method to check if a number is prime
            private boolean isPrime(long n) {
                if (n <= 1)
                    return false;
                if (n <= 3)
                    return true;
                if (n % 2 == 0 || n % 3 == 0)
                    return false;
                for (int i = 5; i * i <= n; i += 6) {
                    if (n % i == 0 || n % (i + 2) == 0)
                        return false;
                }
                return true;
            }
        }).start();

        /*
         * output:
         * 89443 is prime
         * 89449 is prime
         * 89459 is prime
         * 89477 is prime
         * 89491 is prime
         * 89501 is prime
         * 89513 is prime
         * 89519 is prime
         * 89521 is prime
         * 89527 is prime
         * 89533 is prime
         * 89561 is prime
         * 89563 is prime
         * 89567 is prime
         * 89591 is prime
         * 89597 is prime
         */

    }
}
