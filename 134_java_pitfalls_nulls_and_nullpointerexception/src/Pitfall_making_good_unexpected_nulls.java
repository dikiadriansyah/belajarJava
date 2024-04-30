public class Pitfall_making_good_unexpected_nulls {
    // Pitfall - "Making good" unexpected nulls/Jebakan - "Membuat yang baik"
    // menjadi nol yang tidak terduga

    // Di StackOverflow, kita sering melihat kode seperti ini di Jawaban:
    /*
     * public String joinStrings(String a, String b) {
     * if (a == null) {
     * a = "";
     * }
     * if (b == null) {
     * b = "";
     * }
     * return a + ": " + b;
     * }
     */

    /*
     * Seringkali, ini disertai dengan pernyataan yang merupakan "praktik terbaik"
     * untuk menguji null seperti ini untuk menghindari NullPointerException.
     * 
     * Apakah ini praktik terbaik? Singkatnya: Tidak.
     * 
     * Ada beberapa asumsi mendasar yang perlu dipertanyakan sebelum kita dapat
     * mengatakan apakah melakukan hal ini di joinStrings adalah ide yang baik:
     */

    // What does it mean for "a" or "b" to be null?/Apa artinya "a" atau "b" menjadi
    // nol?

    /*
     * Nilai String bisa berupa nol atau lebih karakter, jadi kita sudah memiliki
     * cara untuk merepresentasikan string kosong. Apakah null memiliki arti yang
     * berbeda dengan " " ? Jika tidak, maka memiliki dua cara untuk
     * merepresentasikan string kosong akan menjadi masalah.
     */

    /*
     * Apakah null berasal dari variabel yang tidak diinisialisasi?
     * Null bisa berasal dari bidang yang tidak diinisialisasi, atau elemen array
     * yang tidak diinisialisasi. Nilainya mungkin tidak diinisialisasi karena
     * desainnya, atau secara tidak sengaja. Jika itu terjadi secara tidak sengaja
     * maka ini adalah bug.
     * 
     * Apakah nol mewakili "tidak tahu" atau "nilai yang hilang"?
     * Terkadang sebuah null dapat memiliki arti yang sebenarnya; misalnya bahwa
     * nilai sebenarnya dari suatu variabel tidak diketahui atau tidak tersedia atau
     * "opsional". Di Java 8, kelas Optional menyediakan cara yang lebih baik untuk
     * mengekspresikannya.
     * 
     * Jika ini adalah bug (atau kesalahan desain) haruskah kita "memperbaikinya"?
     * Salah satu interpretasi kode ini adalah bahwa kita "memperbaiki" null yang
     * tidak terduga dengan menggunakan string kosong sebagai gantinya. Apakah
     * strateginya benar? Apakah lebih baik membiarkan NullPointerException terjadi,
     * dan kemudian menangkap pengecualian lebih jauh dan mencatatnya sebagai bug?
     * 
     * Masalah dengan "memperbaiki" adalah bahwa hal itu cenderung menyembunyikan
     * masalah, atau membuatnya lebih sulit untuk didiagnosis.
     * 
     * Apakah ini efisien/bagus untuk kualitas kode?
     * Jika pendekatan "perbaiki" digunakan secara konsisten, kode Anda akan berisi
     * banyak pengujian nol "defensif". Hal ini akan membuat bacaan menjadi lebih
     * panjang dan sulit. Selain itu, semua pengujian dan "pembuatan yang baik" ini
     * kemungkinan besar akan berdampak pada kinerja aplikasi Anda.
     */

    /*
     * Singkatnya
     * Jika null adalah nilai yang berarti, maka pengujian untuk kasus null adalah
     * pendekatan yang tepat. Konsekuensinya adalah jika nilai null bermakna, maka
     * hal ini harus didokumentasikan dengan jelas dalam javadocs metode apa pun
     * yang menerima nilai null atau mengembalikannya.
     * 
     * Jika tidak, sebaiknya perlakukan null yang tidak terduga sebagai kesalahan
     * pemrograman, dan biarkan NullPointerException terjadi sehingga pengembang
     * mengetahui bahwa ada masalah dalam kode.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // --------------------------------------
        Pitfall_making_good_unexpected_nulls box = new Pitfall_making_good_unexpected_nulls();
        String result = box.joinStrings("Hello", "world!");
        System.out.println(result);
        /*
         * output:
         * Hello: world!
         */

    }

    public String joinStrings(String a, String b) {
        if (a == null) {
            a = "";
        }
        if (b == null) {
            b = "";
        }
        return a + ": " + b;
    }

}
