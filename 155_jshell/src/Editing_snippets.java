public class Editing_snippets {
    // Editting Snippets/Mengedit Cuplikan

    /*
     * Unit dasar kode yang digunakan oleh JShell adalah cuplikan, atau entri
     * sumber. Setiap kali Anda mendeklarasikan variabel lokal atau
     * mendefinisikan metode atau kelas lokal, Anda membuat cuplikan yang namanya
     * merupakan pengidentifikasi variabel/metode/kelas. Kapan saja, Anda dapat
     * mengedit cuplikan yang Anda buat dengan perintah /edit. Sebagai contoh,
     * katakanlah saya telah membuat kelas Foo dengan satu metode, bar:
     */

    /*
     * jshell> class Foo {
     * ...> void bar() {
     * ...> }
     * ...> }
     * 
     */

    // Sekarang, saya ingin mengisi isi metode saya. Daripada menulis ulang seluruh
    // kelas, saya bisa mengeditnya:

    /*
     * jshell> /edit Foo
     */

    /*
     * Secara default, editor ayunan akan muncul dengan fitur paling dasar. Namun
     * Anda dapat mengubah editor itu
     * JShell menggunakan:
     * jshell> /set editor emacs
     * jshell> /set editor vi
     * jshell> /set editor nano
     * jshell> /set editor -default
     * 
     */

    /*
     * Perhatikan bahwa jika cuplikan versi baru mengandung kesalahan sintaksis,
     * cuplikan tersebut mungkin tidak disimpan. Demikian pula, cuplikan hanya
     * dibuat jika deklarasi/definisi asli benar secara sintaksis; berikut ini tidak
     * berfungsi:
     * 
     * jshell> String st = String 3
     * //error omitted
     * jshell> /edit st
     * | No such snippet: st
     */

    /*
     * Namun, cuplikan dapat dikompilasi dan karenanya dapat diedit meskipun terjadi
     * kesalahan waktu kompilasi tertentu, seperti jenis yang tidak cocok—hal
     * berikut ini berfungsi:
     * jshell> int i = "hello"
     * //error omitted
     * jshell> /edit i
     */

    // Terakhir, cuplikan dapat dihapus menggunakan perintah /drop:
    /*
     * jshell> int i = 13
     * jshell> /drop i
     * jshell> System.out.println(i)
     * | Error:
     * | cannot find symbol
     * | symbol: variable i
     * | System.out.println(i)
     * 
     */

    // Untuk menghapus semua cuplikan, sehingga mengatur ulang status JVM, gunakan
    // \reset:

    /*
     * jshell> int i = 2
     * jshell> String s = "hi"
     * jshell> /reset
     * | Resetting state.
     * jshell> i
     * | Error:
     * | cannot find symbol
     * | symbol: variable i
     * | i
     * | ^
     * jshell> s
     * | Error:
     * | cannot find symbol
     * | symbol: variable s
     * | s
     * | ^
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
    }
}
