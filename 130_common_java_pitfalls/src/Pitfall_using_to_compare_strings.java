public class Pitfall_using_to_compare_strings {
    // Pitfall: using == to compare strings/Kesalahan: menggunakan == untuk
    // membandingkan string

    /*
     * Kesalahan umum yang dilakukan pemula Java adalah menggunakan operator ==
     * untuk menguji apakah dua string sama. Misalnya:
     * 
     * public class Hello {
     * public static void main(String[] args) {
     * if (args.length > 0) {
     * if (args[0] == "hello") {
     * System.out.println("Hello back to you");
     * } else {
     * System.out.println("Are you feeling grumpy today?");
     * }
     * }
     * }
     * }
     */

    /*
     * Program di atas seharusnya menguji argumen baris perintah pertama dan
     * mencetak pesan yang berbeda ketika itu dan
     * bukankah kata "halo". Tapi masalahnya adalah itu tidak akan berhasil. Program
     * itu akan menampilkan "Apakah kamu merasa kesal hari ini?" tidak peduli apa
     * argumen baris perintah pertama.
     * 
     * Dalam kasus khusus ini String "hello" diletakkan di kumpulan string sementara
     * String args[0] berada di heap. Artinya ada dua objek yang mewakili literal
     * yang sama, masing-masing dengan referensinya. Karena == menguji referensi,
     * bukan persamaan sebenarnya, perbandingannya sering kali menghasilkan hasil
     * yang salah. Ini tidak berarti bahwa hal itu akan selalu terjadi.
     * 
     * Saat Anda menggunakan == untuk menguji string, yang sebenarnya Anda uji
     * adalah apakah dua objek String adalah objek Java yang sama.
     * Sayangnya, kesetaraan string di Java bukanlah hal tersebut. Faktanya, cara
     * yang benar untuk menguji string adalah dengan menggunakan
     * equals(Object) metode. Untuk sepasang string, kita biasanya ingin menguji
     * apakah string tersebut terdiri dari karakter yang sama dalam urutan yang
     * sama.
     */

    /*
     * public class Hello2 {
     * public static void main(String[] args) {
     * if (args.length > 0) {
     * if (args[0].equals("hello")) {
     * System.out.println("Hello back to you");
     * } else {
     * System.out.println("Are you feeling grumpy today?");
     * }
     * }
     * }
     * }
     */

    // Namun kenyataannya justru menjadi lebih buruk. Masalahnya adalah == akan
    // memberikan jawaban yang diharapkan dalam beberapa keadaan. Misalnya

    /*
     * public class Test1 {
     * public static void main(String[] args) {
     * String s1 = "hello";
     * String s2 = "hello";
     * if (s1 == s2) {
     * System.out.println("same");
     * } else {
     * System.out.println("different");
     * }
     * }
     * }
     */

    /*
     * Menariknya, ini akan mencetak "sama", meskipun kita menguji stringnya dengan
     * cara yang salah. Mengapa demikian? Karena Java language specification (Bagian
     * 3.10.5: String Literals) menetapkan bahwa dua string >>literals<< yang
     * terdiri dari karakter yang sama akan diwakili oleh objek Java yang sama. Oleh
     * karena itu, tes == akan memberikan nilai true untuk literal yang sama.
     * (String literal "diinternir" dan ditambahkan ke "kumpulan string" bersama
     * saat kode Anda dimuat, tetapi itu sebenarnya adalah detail implementasi.)
     */

    /*
     * Untuk menambah kebingungan, Spesifikasi Bahasa Java juga menetapkan bahwa
     * ketika Anda memiliki ekspresi konstan waktu kompilasi yang menggabungkan dua
     * literal string, itu setara dengan satu literal. Dengan demikian:
     * 
     * public class Test1 {
     * public static void main(String[] args) {
     * String s1 = "hello";
     * String s2 = "hel" + "lo";
     * String s3 = " mum";
     * if (s1 == s2) {
     * System.out.println("1. same");
     * } else {
     * System.out.println("1. different");
     * }
     * if (s1 + s3 == "hello mum") {
     * System.out.println("2. same");
     * } else {
     * System.out.println("2. different");
     * }
     * }
     * }
     */

    /*
     * Ini akan menampilkan "1.same" dan "2.different". Dalam kasus pertama,
     * ekspresi + dievaluasi pada waktu kompilasi dan kita membandingkan satu objek
     * String dengan dirinya sendiri. Dalam kasus kedua, ini dievaluasi pada saat
     * run time dan kami membandingkan dua objek String yang berbeda
     * 
     * Singkatnya, menggunakan == untuk menguji string di Java hampir selalu salah,
     * namun tidak menjamin memberikan jawaban yang salah.
     */

    public static void main(String[] args) {
        // if (args.length > 0) {
        // if (args[0] == "hello") {
        // System.out.println("Hello back to you");
        // } else {
        // System.out.println("Are you feeling grumpy today?");
        // }
        // }
        // ----------------------------
        // if (args.length > 0) {
        // if (args[0].equals("hello")) {
        // System.out.println("Hello back to you");
        // } else {
        // System.out.println("Are you feeling grumpy today?");
        // }
        // }
        // ---------------------------------
        // String s1 = "hello";
        // String s2 = "hello";
        // if (s1 == s2) {
        // System.out.println("same");
        // } else {
        // System.out.println("different");
        // }
        /*
         * output: same
         */
        // ------------------------------
        String s1 = "hello";
        String s2 = "hel" + "lo";
        String s3 = " mum";
        if (s1 == s2) {
            System.out.println("1. same");
        } else {
            System.out.println("1. different");
        }
        if (s1 + s3 == "hello mum") {
            System.out.println("2. same");
        } else {
            System.out.println("2. different");
        }

        /*
         * output:
         * 1. same
         * 2. different
         */
    }
}
