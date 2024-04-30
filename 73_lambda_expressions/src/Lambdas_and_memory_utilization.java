public class Lambdas_and_memory_utilization {
    // Lambdas and memory utilization/Lambdas dan pemanfaatan memori

    /*
     * Karena lambda Java adalah penutupan, mereka dapat "menangkap" nilai-nilai
     * variabel dalam lingkup leksikal yang melingkupinya. Meskipun tidak semua
     * lambda menangkap apa pun -- lambda sederhana seperti s -> s.length() tidak
     * menangkap apa pun dan disebut stateless --
     * menangkap lambda memerlukan objek sementara untuk menampung variabel yang
     * ditangkap. Dalam cuplikan kode ini, lambda ()-> j adalah lambda penangkap,
     * dan dapat menyebabkan objek dialokasikan ketika dievaluasi:
     * 
     * public static void main(String[] args) throws Exception {
     * for (int i = 0; i < 1000000000; i++) {
     * int j = i;
     * doSomethingWithLambda(() -> j);
     * }
     * }
     */

    /*
     * Meskipun mungkin tidak langsung terlihat karena kata kunci new tidak muncul
     * di mana pun dalam cuplikan, kode ini bertanggung jawab untuk membuat
     * 1.000.000.000 objek terpisah untuk mewakili contoh ekspresi lambda () -> j.
     * Namun, perlu juga dicatat bahwa versi Java1 yang akan datang mungkin dapat
     * mengoptimalkan hal ini sehingga pada runtime instance lambda digunakan
     * kembali, atau direpresentasikan dengan cara lain.
     */

    /*
     * 1 - Misalnya, Java 9 memperkenalkan fase "tautan" opsional ke urutan build
     * Java yang akan menyediakan peluang untuk melakukan optimasi global seperti
     * ini.
     */

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int j = i;
            doSomethingWithLambda(() -> System.out.println("Value of j: " + j));
        }
        /*
         * output:
         * Value of j: 0
         * Value of j: 1
         * Value of j: 2
         * Value of j: 3
         * Value of j: 4
         * Value of j: 5
         * Value of j: 6
         * Value of j: 7
         * Value of j: 8
         * Value of j: 9
         */

    }

    static void doSomethingWithLambda(Runnable lambda) {
        lambda.run();
    }
}
