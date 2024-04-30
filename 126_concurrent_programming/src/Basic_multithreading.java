public class Basic_multithreading implements Runnable {
    // Basic Multithreading/Multithread Dasar

    /*
     * Jika Anda memiliki banyak tugas untuk dijalankan, dan semua tugas ini tidak
     * bergantung pada hasil dari tugas-tugas preseden, Anda
     * dapat menggunakan Multithreading untuk komputer Anda untuk melakukan semua
     * tugas ini secara bersamaan menggunakan lebih banyak prosesor jika komputer
     * Anda bisa. Ini dapat membuat eksekusi program Anda lebih cepat jika Anda
     * memiliki beberapa tugas independen yang besar.
     */

    /*
     * class CountAndPrint implements Runnable {
     * private final String name;
     * CountAndPrint(String name) {
     * this.name = name;
     * }
     * // This is what a CountAndPrint will do
     * 
     * @Override
     * public void run() {
     * for (int i = 0; i < 10000; i++) {
     * System.out.println(this.name + ": " + i);
     * }
     * }
     * public static void main(String[] args) {
     * // Launching 4 parallel threads
     * for (int i = 1; i <= 4; i++) {
     * // `start` method will call the `run` method
     * // of CountAndPrint in another thread
     * new Thread(new CountAndPrint("Instance " + i)).start();
     * }
     * // Doing some others tasks in the main Thread
     * for (int i = 0; i < 10000; i++) {
     * System.out.println("Main: " + i);
     * }
     * }
     * }
     */

    /*
     * Kode metode run dari berbagai instance CountAndPrint akan dieksekusi dalam
     * urutan yang tidak dapat diprediksi. Cuplikan contoh eksekusi mungkin terlihat
     * seperti ini:
     */

    // ------------
    private final String name;

    Basic_multithreading(String name) {
        this.name = name;
    }

    /** This is what a CountAndPrint will do */
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(this.name + ": " + i);
        }
    }

    public static void main(String[] args) throws Exception {

        // Launching 4 parallel threads
        for (int i = 1; i <= 4; i++) {
            // `start` method will call the `run` method
            // of CountAndPrint in another thread
            new Thread(new Basic_multithreading("Instance " + i)).start();
        }
        // Doing some others tasks in the main Thread
        for (int i = 0; i < 50; i++) {
            System.out.println("Main: " + i);
        }
        /*
         * Main: 0
         * Main: 1
         * Main: 2
         * Main: 3
         * Main: 4
         * Main: 5
         * Main: 6
         * Main: 7
         * Main: 8
         * Main: 9
         * Main: 10
         * Main: 11
         * Main: 12
         * Main: 13
         * Main: 14
         * Main: 15
         * Main: 16
         * Main: 17
         * Main: 18
         * Main: 19
         * Main: 20
         * Main: 21
         * Main: 22
         * Main: 23
         * Main: 24
         * Main: 25
         * Main: 26
         * Main: 27
         * Main: 28
         * Main: 29
         * Main: 30
         * Main: 31
         * Main: 32
         * Main: 33
         * Main: 34
         * Main: 35
         * Main: 36
         * Main: 37
         * Main: 38
         * Main: 39
         * Main: 40
         * Main: 41
         * Main: 42
         * Main: 43
         * Main: 44
         * Main: 45
         * Instance 1: 0
         * Instance 3: 0
         * Instance 4: 0
         * Instance 3: 1
         * Instance 1: 1
         * Instance 2: 0
         * Instance 2: 1
         * Main: 46
         * Instance 2: 2
         * Instance 1: 2
         * Instance 3: 2
         * Instance 4: 1
         * Instance 3: 3
         * Instance 3: 4
         * Instance 3: 5
         * Instance 3: 6
         * Instance 3: 7
         * Instance 1: 3
         * Instance 2: 3
         * Main: 47
         * Instance 2: 4
         * Instance 1: 4
         * Instance 3: 8
         * Instance 3: 9
         * Instance 3: 10
         * Instance 4: 2
         * Instance 3: 11
         * Instance 3: 12
         * Instance 1: 5
         * Instance 1: 6
         * Instance 1: 7
         * Instance 2: 5
         * Main: 48
         * Instance 2: 6
         * Instance 1: 8
         * Instance 3: 13
         * Instance 4: 3
         * Instance 4: 4
         * Instance 3: 14
         * Instance 1: 9
         * Instance 1: 10
         * Instance 2: 7
         * Main: 49
         * Instance 2: 8
         * Instance 1: 11
         * Instance 1: 12
         * Instance 3: 15
         * Instance 3: 16
         * Instance 3: 17
         * Instance 4: 5
         * Instance 4: 6
         * Instance 3: 18
         * Instance 1: 13
         * Instance 2: 9
         * Instance 1: 14
         * Instance 3: 19
         * Instance 4: 7
         * Instance 3: 20
         * Instance 1: 15
         * Instance 2: 10
         * Instance 1: 16
         * Instance 3: 21
         * Instance 4: 8
         * Instance 3: 22
         * Instance 1: 17
         * Instance 2: 11
         * Instance 1: 18
         * Instance 3: 23
         * Instance 4: 9
         * Instance 3: 24
         * Instance 1: 19
         * Instance 2: 12
         * Instance 1: 20
         * Instance 3: 25
         * Instance 4: 10
         * Instance 3: 26
         * Instance 1: 21
         * Instance 2: 13
         * Instance 1: 22
         * Instance 3: 27
         * Instance 4: 11
         * Instance 3: 28
         * Instance 1: 23
         * Instance 1: 24
         * Instance 2: 14
         * Instance 1: 25
         * Instance 1: 26
         * Instance 3: 29
         * Instance 4: 12
         * Instance 3: 30
         * Instance 1: 27
         * Instance 2: 15
         * Instance 2: 16
         * Instance 1: 28
         * Instance 3: 31
         * Instance 4: 13
         * Instance 3: 32
         * Instance 1: 29
         * Instance 2: 17
         * Instance 1: 30
         * Instance 3: 33
         * Instance 4: 14
         * Instance 3: 34
         * Instance 1: 31
         * Instance 1: 32
         * Instance 2: 18
         * Instance 1: 33
         * Instance 3: 35
         * Instance 4: 15
         * Instance 4: 16
         * Instance 3: 36
         * Instance 3: 37
         * Instance 3: 38
         * Instance 1: 34
         * Instance 1: 35
         * Instance 1: 36
         * Instance 1: 37
         * Instance 2: 19
         * Instance 1: 38
         * Instance 3: 39
         * Instance 4: 17
         * Instance 3: 40
         * Instance 1: 39
         * Instance 2: 20
         * Instance 1: 40
         * Instance 3: 41
         * Instance 4: 18
         * Instance 3: 42
         * Instance 1: 41
         * Instance 2: 21
         * Instance 1: 42
         * Instance 3: 43
         * Instance 4: 19
         * Instance 3: 44
         * Instance 1: 43
         * Instance 2: 22
         * Instance 1: 44
         * Instance 3: 45
         * Instance 4: 20
         * Instance 3: 46
         * Instance 1: 45
         * Instance 2: 23
         * Instance 1: 46
         * Instance 3: 47
         * Instance 4: 21
         * Instance 3: 48
         * Instance 1: 47
         * Instance 1: 48
         * Instance 1: 49
         * Instance 2: 24
         * Instance 3: 49
         * Instance 4: 22
         * Instance 2: 25
         * Instance 4: 23
         * Instance 2: 26
         * Instance 4: 24
         * Instance 2: 27
         * Instance 4: 25
         * Instance 2: 28
         * Instance 4: 26
         * Instance 2: 29
         * Instance 4: 27
         * Instance 2: 30
         * Instance 4: 28
         * Instance 2: 31
         * Instance 4: 29
         * Instance 2: 32
         * Instance 4: 30
         * Instance 2: 33
         * Instance 4: 31
         * Instance 4: 32
         * Instance 2: 34
         * Instance 4: 33
         * Instance 2: 35
         * Instance 4: 34
         * Instance 2: 36
         * Instance 4: 35
         * Instance 2: 37
         * Instance 4: 36
         * Instance 2: 38
         * Instance 4: 37
         * Instance 2: 39
         * Instance 4: 38
         * Instance 2: 40
         * Instance 4: 39
         * Instance 2: 41
         * Instance 4: 40
         * Instance 2: 42
         * Instance 4: 41
         * Instance 2: 43
         * Instance 4: 42
         * Instance 2: 44
         * Instance 4: 43
         * Instance 4: 44
         * Instance 2: 45
         * Instance 4: 45
         * Instance 2: 46
         * Instance 4: 46
         * Instance 2: 47
         * Instance 4: 47
         * Instance 2: 48
         * Instance 4: 48
         * Instance 2: 49
         * Instance 4: 49
         */

    }
}
