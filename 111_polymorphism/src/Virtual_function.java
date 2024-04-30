public class Virtual_function extends Apple {
    // Virtual functions/Fungsi maya

    /*
     * Metode Virtual adalah metode di Java yang bersifat non-statis dan tanpa kata
     * kunci Final di depannya. Semua metode oleh
     * defaultnya adalah virtual di Java. Metode Virtual memainkan peran penting
     * dalam Polimorfisme karena kelas anak-anak di Java
     * dapat mengganti metode kelas induknya jika fungsi yang diganti bersifat
     * non-statis dan memiliki metode yang sama
     * tanda tangan.
     * 
     * Namun, ada beberapa metode yang tidak bersifat virtual. Misalnya, jika metode
     * tersebut dinyatakan pribadi atau dengan
     * kata kunci final, maka metodenya bukan Virtual.
     * 
     * Pertimbangkan contoh warisan yang dimodifikasi berikut dengan Metode Virtual
     * dari postingan StackOverflow ini Bagaimana caranya
     * fungsi virtual berfungsi di C# dan Java? :
     * 
     * public class A{
     * public void hello(){
     * System.out.println("Hello");
     * }
     * 
     * public void boo(){
     * System.out.println("Say boo");
     * }
     * }
     * 
     * public class B extends A{
     * public void hello(){
     * System.out.println("No");
     * }
     * 
     * public void boo(){
     * System.out.println("Say haha");
     * }
     * }
     * 
     */

    /*
     * Jika kita memanggil kelas B dan memanggil hello() dan boo(), kita akan
     * mendapatkan "Tidak" dan "Katakan haha" sebagai keluaran yang dihasilkan
     * karena B
     * mengesampingkan metode yang sama dari A. Meskipun contoh di atas hampir sama
     * persis dengan penggantian metode, penting untuk dipahami bahwa metode di
     * kelas A semuanya, secara default, adalah Virtual.
     * 
     * Selain itu, kita dapat mengimplementasikan metode Virtual menggunakan kata
     * kunci abstract. Metode yang dideklarasikan dengan kata kunci "abstrak" tidak
     * memiliki definisi metode, artinya isi metode belum diimplementasikan.
     * Perhatikan kembali contoh di atas, kecuali metode boo() dinyatakan abstrak:
     */

    /*
     * public class A{
     * public void hello(){
     * System.out.println("Hello");
     * }
     * 
     * abstract void boo();
     * }
     * public class B extends A{
     * public void hello(){
     * System.out.println("No");
     * }
     * 
     * public void boo(){
     * System.out.println("Say haha");
     * }
     * }
     */

    /*
     * Jika kita memanggil boo() dari B, outputnya tetap "Say haha" karena B
     * mewarisi metode abstrak boo() dan membuatnya
     * boo () keluaran "Katakan haha".
     * 
     */

    // how do virtual functions work in c# and java?
    // Lihat jawaban hebat ini yang memberikan informasi lebih lengkap tentang
    // fungsi Virtual:

    // can you write virtual function / methods in java?

    public static void main(String[] args) throws Exception {
        Virtual_function box = new Virtual_function();
        box.hello(); // output: no
    }

    public void hello() {
        System.out.println("No");
    }

    public void boo() {
        System.out.println("Say haha");
    }
}
