import java.util.*;
import java.lang.*;
import java.io.*;

public class ComparingString {
    public static void main(String[] args) throws Exception {
        // String (java.lang.String) adalah potongan teks yang disimpan dalam program
        // Anda. String bukan tipe data primitif di
        // Java(http://stackoverflow.com/questions/10430582/primitive-data-types-in-java),
        // namun, mereka sangat umum dalam program Java.

        // Di Java, String tidak dapat diubah, artinya tidak dapat diubah.
        // (http://stackoverflow.com/questions/279507/what-is-meant-by-immutable
        // untuk penjelasan yang lebih menyeluruh dari immutability.)

        // Untuk membandingkan String untuk kesetaraan, Anda harus menggunakan metode
        // objek String yang
        // equals(https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#equals-java.lang.Object-)
        // atau
        // equalsIgnoreCase(https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#equalsIgnoreCase-java.lang.String-).

        // Misalnya, cuplikan berikut akan menentukan apakah dua contoh String sama pada
        // semua karakter:

        // System.out.println("Hello, Worl222d!");

        String firstString = "Dhiki123";
        String secondString = "Dhiki" + 123;
        // if (firstString.equals(secondString)) {
        // System.out.print("Equal");
        // } else {
        // System.out.print("Not Equal");
        // }
        // output: Equals
        // karena fungsi equals() memeriksa value firstString dan secondString

        // ------------------------------
        // Contoh ini akan membandingkannya, terlepas dari kasusnya:
        String firstParagraph = "Dhiki123";
        String lastParagraph = "DHIKI123";
        // if (firstParagraph.equalsIgnoreCase(lastParagraph)) {
        // Kedua String sama, mengabaikan kasus karakter individu.
        // System.out.print("Equal");
        // } else {
        // System.out.print("Not Equal");
        // }
        // output: Equals
        // karena fungsi equalsIgnoreCase() memeriksa value firstString dan secondString

        // Perhatikan bahwa equalsIgnoreCase tidak mengizinkan Anda menentukan Locale.
        // Misalnya, jika Anda membandingkan dua kata "Taki"
        // dan "TAKI" dalam bahasa Inggris sama; namun, dalam bahasa Turki keduanya
        // berbeda (dalam bahasa Turki, huruf kecil I adalah ı). Untuk kasus seperti
        // ini, mengonversi kedua string menjadi huruf kecil (atau huruf besar) dengan
        // Locale dan kemudian membandingkannya dengan yang sama solusinya.

        String ucapanPertama = "Taki";
        String ucapanKedua = "TAKI";
        // System.out.println(ucapanPertama.equalsIgnoreCase(ucapanKedua));
        // output:
        // true

        Locale locale = Locale.forLanguageTag("tr-TR");
        // System.out.println(ucapanPertama.toLowerCase(locale).equals(ucapanKedua.toLowerCase(locale)));
        // output:
        // false

        // Jangan gunakan operator == untuk membandingkan String
        // Kecuali Anda dapat menjamin bahwa semua string telah diinternir (lihat di
        // bawah), Anda sebaiknya tidak menggunakan operator == atau != untuk
        // membandingkan String. Operator ini benar-benar menguji referensi, dan karena
        // banyak objek String bisa mewakili String yang sama, ini mungkin memberikan
        // jawaban yang salah.

        // Sebagai gantinya, gunakan metode String.equals(Object) , yang akan
        // membandingkan objek String berdasarkan nilainya. Untuk sebuah
        // penjelasan rinci, silakan merujuk ke Jebakan: menggunakan == untuk
        // membandingkan string.

        // Membandingkan String dalam pernyataan switch(Comparing Strings in a switch
        // statement)
        // Version ≥ Java SE 7
        // Pada Java 1.7, dimungkinkan untuk membandingkan variabel String dengan
        // literal dalam pernyataan switch. Pastikan bahwa String bukan null, jika tidak
        // maka akan selalu memunculkan NullPointerException. Nilai dibandingkan
        // menggunakan String.equals, mis. case sensitive.

        String stringToSwitch = "B";
        // switch (stringToSwitch) {
        // case "a":
        // System.out.println("a");
        // break;
        // case "A":
        // System.out.println("A");
        // break;
        // case "B":
        // System.out.println("B"); // the code goes here
        // break;
        // default:
        // break;
        // }

        // output: B
        // -----------------------------
        // Membandingkan String dengan nilai konstanta(Comparing Strings with constant
        // values)
        // Saat membandingkan String dengan nilai konstanta, Anda dapat meletakkan nilai
        // konstanta di sisi kiri sama dengan untuk memastikan bahwa Anda tidak akan
        // mendapatkan NullPointerException jika String lainnya adalah null.
        // "about".equals(foo);
        // Sementara foo.equals("about") akan melempar NullPointerException jika foo
        // adalah null, "about".equals(foo) akan dievaluasi menjadi false.

        // Version ≥ Java SE 7
        // Alternatif yang lebih mudah dibaca adalah menggunakan Objects.equals(), yang
        // melakukan pemeriksaan null pada kedua parameter:
        // Objek.sama dengan(foo, "about").

        // (Catatan: Masih bisa diperdebatkan apakah lebih baik menghindari
        // NullPointerExceptions secara umum, atau membiarkannya terjadi dan
        // kemudian perbaiki root penyebabnya; lihat di sini dan di sini. Tentu saja,
        // menyebut strategi penghindaran sebagai "praktik terbaik" tidak dapat
        // dibenarkan.)

        // String orderings
        // Kelas String mengimplementasikan Comparable<String> dengan metode
        // String.compareTo (seperti yang dijelaskan di awal
        // contoh ini). Hal ini membuat urutan alami objek String peka huruf
        // besar-kecil. Kelas String menyediakan konstanta Comparator<String> yang
        // disebut CASE_INSENSITIVE_ORDER cocok untuk penyortiran case-insensitive.

        // Comparing with interned Strings
        // spesifikasi java language(JLS 3.10.6) menyatakn sebagai berikut:
        // "Moreover, a string literal always refers to the same instance of class
        // String. This is because string literals - or, more generally, strings that
        // are the values of constant expressions - are interned so as to share
        // unique instances, using the method String.intern.

        // Ini berarti aman untuk membandingkan referensi ke dua literal string
        // menggunakan ==. Selain itu, hal yang sama berlaku untuk referensi
        // ke objek String yang telah dihasilkan menggunakan metode String.intern().

        // contoh:
        String salamObj = new String("Assalamualaikum");
        String salamObj2 = "Assalamualaikum";

        // The two string references point two strings that are equal
        // if (salamObj.equals(salamObj2)) {
        // System.out.println("String adalah equals");
        // } else {
        // System.out.println("String adalah Not equals");
        // }
        // output:
        // String adalah equals

        // The two string references do not point to the same object
        // if (salamObj != salamObj2) {
        // System.out.println("String bukan objek yang sama");
        // } else {
        // System.out.println("String objek yang sama");
        // }
        // output:
        // String bukan objek yg sama

        // If we intern a string that is equal to a given literal, the result is
        // a string that has the same reference as the literal.

        String internedStr = salamObj.intern();
        if (internedStr == salamObj2) {
            System.out.println("String yang diinternir dan literal adalah objek yang sama");
        } else {
            System.out.println("String yang diinternir dan literal adalah objek yang tidak sama");
        }
        // output:
        // String yang diinternir dan literal adalah objek yang sama

        // Di belakang layar, mekanisme interning mempertahankan tabel hash yang berisi
        // semua string yang diinternir yang masih dapat dijangkau. Saat Anda memanggil
        // intern() pada sebuah String, metode mencari objek di tabel hash:
        // - Jika string ditemukan, maka nilai tersebut dikembalikan sebagai string yang
        // diinternir.
        // - Jika tidak, salinan string ditambahkan ke tabel hash dan string tersebut
        // dikembalikan sebagai string yang diinternir.

        // Dimungkinkan untuk menggunakan magang untuk memungkinkan string dibandingkan
        // menggunakan ==. Namun, ada masalah yang signifikan dengan melakukan ini;
        // lihat Pitfall - Menginternir string sehingga Anda dapat menggunakan == adalah
        // ide yang buruk untuk detailnya. Hal ini tidak dianjurkan umumnya.

    }
}
