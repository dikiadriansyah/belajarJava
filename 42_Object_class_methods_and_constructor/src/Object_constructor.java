public class Object_constructor {
    // Object constructor

    /*
     * Semua konstruktor di Java harus melakukan panggilan ke konstruktor Objek. Hal
     * ini dilakukan dengan panggilan super(). Ini harus menjadi baris pertama dalam
     * konstruktor. Alasannya adalah agar objek benar-benar dapat dibuat di heap
     * sebelum inisialisasi tambahan dilakukan.
     * 
     * Jika Anda tidak menentukan panggilan ke super() dalam konstruktor, kompiler
     * akan memasukkannya untuk Anda.
     * 
     * Jadi ketiga contoh ini secara fungsional identik
     * 
     * dengan panggilan eksplisit ke konstruktor super()
     * public class MyClass {
     * public MyClass() {
     * super();
     * }
     * }
     * 
     * dengan panggilan implisit ke konstruktor super()
     * public class MyClass {
     * public MyClass() {
     * // empty
     * }
     * }
     * 
     * dengan konstruktor implisit
     * public class MyClass {
     * }
     * 
     * Bagaimana dengan Rantai Konstruktor?
     * Dimungkinkan untuk memanggil konstruktor lain sebagai instruksi pertama dari
     * sebuah konstruktor. Karena panggilan eksplisit ke konstruktor super dan
     * panggilan ke konstruktor lain harus berupa instruksi pertama, keduanya saling
     * eksklusif
     * public class MyClass {
     * public MyClass(int size) {
     * doSomethingWith(size);
     * }
     * 
     * public MyClass(Collection<?> initialValues) {
     * this(initialValues.size());
     * addInitialValues(initialValues);
     * }
     * }
     * 
     * Memanggil new MyClass(Arrays.asList("a", "b", "c")) akan memanggil
     * konstruktor kedua dengan argumen Daftar,
     * yang pada gilirannya akan mendelegasikan ke konstruktor pertama (yang akan
     * mendelegasikan secara implisit ke super()) dan kemudian memanggil
     * addInitialValues(int size) dengan ukuran kedua dari daftar. Ini digunakan
     * untuk mengurangi duplikasi kode di mana beberapa konstruktor perlu melakukan
     * pekerjaan yang sama.
     * Bagaimana cara memanggil konstruktor tertentu?
     * 
     * Dengan memberikan contoh di atas, seseorang dapat memanggil new
     * MyClass("argument") atau new MyClass("argument", 0). Dengan kata lain,
     * seperti halnya metode kelebihan beban, Anda cukup memanggil konstruktor
     * dengan parameter yang diperlukan untuk konstruktor pilihan Anda.
     * Apa yang akan terjadi pada konstruktor kelas Object?
     * 
     * Tidak lebih dari yang akan terjadi pada subkelas yang memiliki konstruktor
     * kosong default (tanpa panggilan ke super()).
     * 
     * Konstruktor kosong default dapat didefinisikan secara eksplisit tetapi jika
     * tidak, kompiler akan memasukkannya untuk Anda selama tidak ada konstruktor
     * lain yang ditentukan.
     * Bagaimana sebuah Objek kemudian dibuat dari konstruktor di Objek?
     * 
     * Pembuatan objek sebenarnya bergantung pada JVM. Setiap konstruktor di Java
     * muncul dengan nama metode khusus
     * <init> yang bertanggung jawab untuk inisialisasi instance. Metode <init> ini
     * disediakan oleh kompiler dan karena
     * <init> bukan pengidentifikasi yang valid di Java, tidak dapat digunakan
     * secara langsung dalam bahasa tersebut.
     * Bagaimana JVM memanggil metode <init> ini?
     * 
     * JVM akan memanggil metode <init> menggunakan instruksi invokespecial dan
     * hanya dapat dipanggil pada instance kelas yang tidak diinisialisasi.
     * 
     * Untuk informasi lebih lanjut lihat spesifikasi JVM dan Spesifikasi Bahasa
     * Java:
     * Special Methods (JVM) - JVMS - 2.9
     * Constructors - JLS - 8.8
     * 
     * 
     */

    public static void main(String[] args) {
    }
}
