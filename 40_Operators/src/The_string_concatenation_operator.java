public class The_string_concatenation_operator {
    // The String Concatenation Operator (+) / Operator Penggabungan String (+)

    public static void main(String[] args) {
        /*
         * Simbol + dapat berarti tiga operator berbeda di Java:
         * 1. Jika tidak ada operan sebelum +, maka itu adalah operator unary Plus.
         * 2. Jika ada dua operan dan keduanya numerik. maka itu adalah operator
         * Penjumlahan biner.
         * 3. Jika ada dua operan, dan setidaknya salah satunya adalah String, maka itu
         * adalah operator Penggabungan biner.
         */

        // Dalam kasus sederhana, operator Penggabungan menggabungkan dua string untuk
        // menghasilkan string ketiga. Misalnya:
        // String s1 = "a String";
        // String s2 = "This is " + s1; // s2 contains "This is a String"

        // System.out.println(s2); // This is a String

        /*
         * Jika salah satu dari dua operan bukan string, maka akan diubah menjadi String
         * sebagai berikut:
         * 1. Operan yang tipenya merupakan tipe primitif dikonversi seolah-olah dengan
         * memanggil toString() pada nilai kotak.
         * 2. Operan yang tipenya merupakan tipe referensi dikonversi dengan memanggil
         * metode toString() operan. Jika operandnya null, atau jika metode toString()
         * mengembalikan null, maka literal string "null" akan digunakan.
         * 
         */

        // contoh:
        int one = 1;
        String s3 = "One is " + one; // s3 contains "One is 1"
        String s4 = null + " is null"; // s4 contains "null is null"
        String s5 = "{1} is " + new int[] { 1 }; // s5 contains something like
        // "{} is [I@xxxxxxxx"

        // System.out.println(s4); // null is null

        /*
         * Penjelasan untuk contoh s5 adalah bahwa metode toString() pada tipe array
         * diwarisi darinya java.lang.Object, dan perilakunya adalah menghasilkan string
         * yang terdiri dari nama tipe, dan kode hash identitas objek.
         * 
         * Operator Penggabungan ditentukan untuk membuat objek new String, kecuali
         * jika ekspresinya adalah Ekspresi Konstan. Dalam kasus terakhir, ekspresi
         * dievaluasi pada tipe kompilasi, dan nilai runtimenya setara dengan string
         * literal. Artinya, tidak ada overhead runtime dalam pemisahan literal string
         * panjang seperti ini:
         */

        String typing = "The quick brown fox " +
                "jumped over the " +
                "lazy dog"; // constant expression

        // System.out.println(typing); // The quick brown fox jumped over the lazy dog

        // Optimalisasi dan efisiensi
        /*
         * Seperti disebutkan di atas, dengan pengecualian ekspresi konstan, setiap
         * ekspresi penggabungan string membuat new String object. Pertimbangkan kode
         * ini:
         */
        The_string_concatenation_operator main = new The_string_concatenation_operator();
        String result = main.stars(5);
        System.out.println(result); // *****

        // -----------------------
        String s1 = "Dhiki";
        String s2 = "Bali";
        String test = "Hello " + s1 + ". Welcome to " + s2 + "\n";

        // System.out.println(test); // Hello Dhiki. Welcome to Bali

        // biasanya akan dioptimalkan oleh kompiler bytecode menjadi seperti ini;
        // StringBuilder tmp = new StringBuilder();
        // tmp.append("Hello ");
        // tmp.append(s1 == null ? "null" + s1);
        // tmp.append("Welcome to ");
        // tmp.append(s2 == null ? "null" + s2);
        // tmp.append("\n");
        // String test = tmp.toString();

        /*
         * (Kompilator JIT dapat mengoptimalkannya lebih lanjut jika dapat menyimpulkan
         * bahwa s1 atau s2 tidak boleh null.) Namun perlu diingat bahwa pengoptimalan
         * ini hanya diperbolehkan dalam satu ekspresi.
         * 
         * Singkatnya, jika Anda mengkhawatirkan efisiensi penggabungan string:
         * 1. Lakukan optimasi tangan jika Anda melakukan penggabungan berulang dalam
         * satu lingkaran (atau serupa)
         * 2. Jangan mengoptimalkan satu ekspresi rangkaian secara manual.
         * 
         */

    }

    public String stars(int count) {
        String res = "";
        for (int i = 0; i < count; i++) {
            res = res + "*";
        }
        return res;
    }

    /*
     * Pada metode di atas, setiap iterasi perulangan akan menghasilkan String baru
     * yang panjangnya satu karakter dibandingkan iterasi sebelumnya. Setiap
     * rangkaian menyalin semua karakter dalam string operan untuk membentuk new
     * String
     *
     * Jadi, star(N) akan:
     * 1. create N new String objects, and throw away all but the last one,
     * 2. copy N * (N + 1) / 2 characters, and
     * 3. generate O(N^2) bytes of garbage.
     */

    /*
     * Ini sangat mahal untuk N yang besar. Memang, kode apa pun yang menggabungkan
     * string dalam satu loop kemungkinan besar mengalami masalah ini.
     * Cara yang lebih baik untuk menulis ini adalah sebagai berikut:
     */

    public String stars2(int count) {
        // Create a string builder with capacity 'count'
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append("*");
        }
        return sb.toString();
    }

    /*
     * Idealnya, Anda harus mengatur kapasitas StringBuilder, namun jika hal ini
     * tidak praktis, kelas akan secara otomatis mengembangkan array pendukung yang
     * digunakan pembuat untuk menampung karakter. (Catatan: implementasi memperluas
     * array pendukung secara eksponensial. Strategi ini menjaga jumlah karakter
     * yang disalin ke O(N) daripada O(N^2).)
     * 
     * Beberapa orang menerapkan pola ini ke semua rangkaian string. Namun, hal ini
     * tidak diperlukan karena JLS mengizinkan kompiler Java untuk mengoptimalkan
     * rangkaian string dalam satu ekspresi. Misalnya:
     */

}
