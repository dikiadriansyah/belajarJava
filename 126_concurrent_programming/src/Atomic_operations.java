import java.text.MessageFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Atomic_operations {
    // Atomic operations/Operasi atom

    /*
     * Operasi atom adalah operasi yang dijalankan "sekaligus", tanpa ada
     * kemungkinan thread lain mengamati atau
     * mengubah keadaan selama eksekusi operasi atom.
     * 
     * Mari kita pertimbangkan CONTOH BURUK.
     */

    /*
     * private static int t = 0;
     * public static void main(String[] args) {
     * ExecutorService executorService = Executors.newFixedThreadPool(400); // The
     * high thread count
     * is for demonstration purposes.
     * for (int i = 0; i < 100; i++) {
     * executorService.execute(() -> {
     * t++;
     * System.out.println(MessageFormat.format("t: {0}", t));
     * });
     * }
     * executorService.shutdown();
     * }
     * 
     */

    /*
     * Dalam hal ini, ada dua persoalan. Masalah pertama adalah operator kenaikan
     * pasca bukan atomik. Ini terdiri dari
     * beberapa operasi: dapatkan nilainya, tambahkan 1 ke nilainya, tetapkan
     * nilainya. Makanya kalau kita jalankan contohnya kemungkinan besar begitu
     * kita tidak akan melihat t: 100 pada output - dua thread mungkin secara
     * bersamaan mendapatkan nilainya, menaikkannya, dan mengaturnya: katakanlah
     * nilai t adalah 10, dan dua utas bertambah t. Kedua thread akan menetapkan
     * nilai t menjadi 11, sejak thread kedua
     * thread mengamati nilai t sebelum thread pertama selesai menambahnya.
     * 
     * Masalah kedua adalah bagaimana kita mengamati t. Saat kita mencetak nilai t,
     * mungkin nilainya sudah ada
     * telah diubah oleh thread lain setelah operasi penambahan thread ini.
     */

    /*
     * Untuk memperbaiki masalah tersebut, kita akan menggunakan
     * java.util.concurrent.atomic.AtomicInteger, yang memiliki banyak operasi atom
     * untuk kita gunakan.
     */

    /*
     * private static AtomicInteger t = new AtomicInteger(0);
     * public static void main(String[] args) {
     * ExecutorService executorService = Executors.newFixedThreadPool(400); // The
     * high thread count
     * is for demonstration purposes.
     * for (int i = 0; i < 100; i++) {
     * executorService.execute(() -> {
     * int currentT = t.incrementAndGet();
     * System.out.println(MessageFormat.format("t: {0}", currentT));
     * });
     * }
     * executorService.shutdown();
     * }
     */

    /*
     * Metode incrementAndGet dari AtomicInteger secara atomik menambah dan
     * mengembalikan nilai baru, sehingga menghilangkan kondisi balapan sebelumnya.
     * Perlu dicatat bahwa dalam contoh ini baris-barisnya akan tetap rusak karena
     * kita tidak berupaya untuk mengurutkan panggilan println dan ini berada di
     * luar cakupan contoh ini, karena memerlukan
     * sinkronisasi dan tujuan dari contoh ini adalah untuk menunjukkan cara
     * menggunakan AtomicInteger untuk menghilangkan kondisi balapan terkait status.
     */
    // ---------------------
    private static AtomicInteger t = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(400); // The high thread count is for
                                                                             // demonstration purposes.
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                int currentT = t.incrementAndGet();
                System.out.println(MessageFormat.format("t: {0}", currentT));
            });
        }
        executorService.shutdown();
        /*
         * output:
         * t: 48
         * t: 32
         * t: 83
         * t: 20
         * t: 9
         * t: 29
         * t: 60
         * t: 47
         * t: 98
         * t: 80
         * t: 33
         * t: 76
         * t: 46
         * t: 25
         * t: 94
         * t: 51
         * t: 72
         * t: 63
         * t: 97
         * t: 86
         * t: 92
         * t: 22
         * t: 99
         * t: 88
         * t: 3
         * t: 79
         * t: 42
         * t: 77
         * t: 40
         * t: 23
         * t: 64
         * t: 96
         * t: 38
         * t: 74
         * t: 53
         * t: 68
         * t: 54
         * t: 70
         * t: 19
         * t: 5
         * t: 87
         * t: 58
         * t: 59
         * t: 41
         * t: 24
         * t: 50
         * t: 31
         * t: 85
         * t: 93
         * t: 30
         * t: 44
         * t: 21
         * t: 39
         * t: 61
         * t: 16
         * t: 15
         * t: 78
         * t: 82
         * t: 84
         * t: 26
         * t: 28
         * t: 81
         * t: 91
         * t: 7
         * t: 27
         * t: 100
         * t: 8
         * t: 18
         * t: 89
         * t: 12
         * t: 10
         * t: 17
         * t: 2
         * t: 67
         * t: 71
         * t: 35
         * t: 4
         * t: 66
         * t: 13
         * t: 37
         * t: 45
         * t: 11
         * t: 36
         * t: 52
         * t: 14
         * t: 69
         * t: 75
         * t: 57
         * t: 73
         * t: 49
         * t: 55
         * t: 1
         * t: 56
         * t: 90
         * t: 43
         * t: 65
         * t: 62
         * t: 34
         * t: 6
         * t: 95
         */
    }
}
