public class Constructors {
    // Constructors

    /*
     * Konstruktor adalah metode khusus yang diberi nama berdasarkan kelas dan tanpa
     * tipe kembalian, dan digunakan untuk membuat objek. Konstruktor, seperti
     * halnya metode, dapat mengambil parameter masukan. Konstruktor digunakan untuk
     * menginisialisasi objek. Kelas abstrak juga dapat memiliki konstruktor.
     */

    /*
     * public class Hello{
     * // constructor
     * public Hello(String wordToPrint){
     * printHello(wordToPrint);
     * }
     * public void printHello(String word){
     * System.out.println(word);
     * }
     * }
     * 
     * // instantiates the object during creating and prints out the content
     * // of wordToPrint
     */

    /*
     * Penting untuk dipahami bahwa konstruktor berbeda dari metode dalam beberapa
     * hal:
     * 1. Konstruktor hanya dapat mengambil pengubah public, private, dan protected,
     * dan tidak dapat dinyatakan abstract, final, statis, atau synchronized.
     * 2. Konstruktor tidak memiliki tipe return.
     * 3. Nama konstruktor HARUS sama dengan nama kelas. Dalam contoh Hello, objek
     * Hello-nya
     * nama konstruktor sama dengan nama kelas.
     * 4. Kata kunci this memiliki penggunaan tambahan di dalam konstruktor.
     * this.method(...) memanggil metode di contoh saat ini, sementara this(...)
     * merujuk ke konstruktor lain di kelas saat ini dengan tanda tangan berbeda.
     */

    // Konstruktor juga bisa dipanggil melalui pewarisan dengan menggunakan kata
    // kunci super

    /*
     * public class SuperManClass{
     * public SuperManClass(){
     * // some implementation
     * }
     * 
     * // ... methods
     * }
     * public class BatmanClass extends SupermanClass{
     * public BatmanClass(){
     * super();
     * }
     * //... methods...
     * }
     */

    // constructor
    // public Constructors(String wordToPrint) {
    // printHello(wordToPrint);
    // }

    // public void printHello(String word) {
    // System.out.println(word);
    // }

    public static void main(String[] args) {
        // Constructors box1 = new Constructors("Hai Dunia");
        /*
         * output: Hai Dunia
         */
        // ---------------------------
        // Membuat objek dari kelas BatmanClass
        BatmanClass batmanObject = new BatmanClass();
        /*
         * output:
         * SuperManClass constructor called torage\d9602477601c708719467e15f0d64fa9
         * BatmanClass constructor called
         */

    }
}
