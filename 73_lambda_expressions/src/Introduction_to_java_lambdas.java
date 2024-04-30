// interface Foo1 {
//     void bar();
// }

// interface Foo2 {
//     int bar(boolean baz);
// }

// interface Foo3 {
//     String bar(Object baz, int mink);
// }

// interface Foo4 {
//     default String bar() {
//         return "baz";
//     }

//     void quux();
// }

// @FunctionalInterface
// interface Foo5 {
//     void bar();
// }

// @FunctionalInterface
// interface BlankFoo1 extends Foo3 {
//     // inherits abstract method from Foo3
// }

// @FunctionalInterface
// interface Foo6 {
//     void bar();

//     boolean equals(Object obj); // overrides one of Object's method so not counted
// }
// ------------------------------------
@FunctionalInterface
interface MyFunctionalInterface {
    void theOneMethod();
}

// -------------
public class Introduction_to_java_lambdas {
    // Introduction to Java lambdas/Pengantar lambda Java

    /*
     * Functional Interfaces/Antarmuka Fungsional
     * 
     * Lambdas hanya dapat beroperasi pada antarmuka fungsional, yaitu antarmuka
     * dengan satu metode abstrak saja. Antarmuka fungsional dapat memiliki sejumlah
     * metode default atau static. (Untuk alasan ini, kadang-kadang disebut sebagai
     * Antarmuka Single Abstract Method, atau Antarmuka SAM)
     * 
     * interface Foo1 {
     * void bar();
     * }
     * interface Foo2 {
     * int bar(boolean baz);
     * }
     * interface Foo3 {
     * String bar(Object baz, int mink);
     * }
     * interface Foo4 {
     * default String bar() { // default so not counted
     * return "baz";
     * }
     * void quux();
     * }
     * 
     * 
     * Saat mendeklarasikan antarmuka fungsional, anotasi @FunctionalInterface dapat
     * ditambahkan. Ini tidak memiliki efek khusus, namun kesalahan kompiler akan
     * dihasilkan jika anotasi ini diterapkan pada antarmuka yang tidak berfungsi,
     * sehingga bertindak sebagai pengingat bahwa antarmuka tidak boleh diubah.
     * 
     * @FunctionalInterface
     * interface Foo5 {
     * void bar();
     * }
     * 
     * @FunctionalInterface
     * interface BlankFoo1 extends Foo3 { // inherits abstract method from Foo3
     * }
     * 
     * @FunctionalInterface
     * interface Foo6 {
     * void bar();
     * boolean equals(Object obj); // overrides one of Object's method so not
     * counted
     * }
     * 
     * 
     * Sebaliknya, ini bukan antarmuka fungsional, karena memiliki lebih dari satu
     * metode abstrak:
     * interface BadFoo {
     * void bar();
     * void quux(); // <-- Second method prevents lambda: which one should
     * // be considered as lambda?
     * }
     * 
     * 
     * Ini juga bukan antarmuka yang fungsional, karena tidak memiliki metode apa
     * pun:
     * interface BlankFoo2 { }
     * 
     */

    /*
     * Perhatikan hal berikut ini. Misalkan Anda punya
     * interface Parent { public int parentMethod(); }
     * 
     * dan
     * interface Child extends Parent { public int ChildMethod(); }
     */

    // Maka Child tidak dapat menjadi antarmuka fungsional karena memiliki dua
    // metode yang ditentukan

    /*
     * Java 8 juga menyediakan sejumlah antarmuka fungsional bertemplat umum dalam
     * paket java.util.function. Misalnya, bawaan interface Predicate<T> membungkus
     * metode tunggal yang memasukkan nilai type T dan mengembalikan boolean.
     */

    // Lambda Expressions/Ekspresi Lambda

    // Struktur dasar ekspresi Lambda adalah:

    /*
     * fi kemudian akan menampung instance tunggal dari suatu kelas, mirip dengan
     * anonymous class, yang mengimplementasikan FunctionalInterface dan definisi
     * metodenya adalah { System.out.println("Hello"); }. Dengan kata lain, hal di
     * atas sebagian besar setara dengan:
     * FunctionalInterface fi = new FunctionalInterface() {
     * 
     * @Override
     * public void theOneMethod() {
     * System.out.println("Hello");
     * }
     * };
     */

    /*
     * Lambda hanya "sebagian besar setara" dengan kelas anonim karena dalam lambda,
     * arti ekspresi seperti this, super atau toString() merujuk pada kelas di mana
     * penugasan dilakukan, bukan objek yang baru dibuat.
     */

    /*
     * Anda tidak dapat menentukan nama metode saat menggunakan lambda—tetapi Anda
     * tidak perlu melakukannya, karena berfungsi antarmuka harus hanya memiliki
     * satu metode abstrak, jadi Java akan mengganti metode tersebut.
     * 
     * Dalam kasus di mana tipe lambda tidak pasti, (misalnya metode yang kelebihan
     * beban), Anda dapat menambahkan pemeran ke lambda untuk memberi tahu kompiler
     * tentang tipenya yang seharusnya, seperti:
     * Object fooHolder = (Foo1) () -> System.out.println("Hello");
     * System.out.println(fooHolder instanceof Foo1); // returns true
     */

    /*
     * Jika metode tunggal antarmuka fungsional mengambil parameter, nama formal
     * lokalnya akan muncul di antara tanda kurung lambda. Tidak perlu
     * mendeklarasikan tipe parameter atau return karena ini diambil dari antarmuka
     * (walaupun mendeklarasikan tipe parameter bukanlah suatu kesalahan jika Anda
     * mau). Jadi, keduanya contohnya setara:
     * Foo2 longFoo = new Foo2() {
     * 
     * @Override
     * public int bar(boolean baz) {
     * return baz ? 1 : 0;
     * }
     * };
     * Foo2 shortFoo = (x) -> { return x ? 1 : 0; };
     */

    /*
     * Tanda kurung di sekitar argumen dapat dihilangkan jika fungsi hanya mempunyai
     * satu argumen:
     * Foo2 np = x -> { return x ? 1 : 0; }; // okay
     * Foo3 np2 = x, y -> x.toString() + y // not okay
     */

    // Implicit Returns/Pengembalian Implisit
    /*
     * Jika kode yang ditempatkan di dalam lambda adalah ekspresi Java dan bukan
     * pernyataan, kode tersebut diperlakukan sebagai metode yang mengembalikan
     * nilai ekspresi. Jadi, dua hal berikut ini setara:
     * IntUnaryOperator addOneShort = (x) -> (x + 1);
     * IntUnaryOperator addOneLong = (x) -> { return (x + 1); };
     */

    // Accessing Local Variables (value closures)/Mengakses Variabel Lokal
    // (penutupan nilai)

    /*
     * Karena lambda adalah singkatan sintaksis untuk kelas anonim, lambda mengikuti
     * aturan yang sama untuk mengakses variabel lokal dalam lingkup terlampir;
     * variabel harus diperlakukan sebagai final dan tidak diubah di dalam lambda.
     * 
     * IntUnaryOperator makeAdder(int amount) {
     * return (x) -> (x + amount); // Legal even though amount will go out of scope
     * // because amount is not modified
     * }
     * IntUnaryOperator makeAccumulator(int value) {
     * return (x) -> { value += x; return value; }; // Will not compile
     * }
     * 
     * Jika perlu untuk menggabungkan variabel yang berubah dengan cara ini, objek
     * biasa yang menyimpan salinan variabel harus digunakan. Baca selengkapnya di
     * Penutupan Java dengan ekspresi lambda.
     */

    // Accepting Lambdas/Menerima Lambda
    /*
     * Karena lambda adalah implementasi antarmuka, tidak ada hal khusus yang perlu
     * dilakukan agar suatu metode dapat diterima lambda: fungsi apa pun yang
     * menggunakan antarmuka fungsional juga dapat menerima lambda.
     * public void passMeALambda(Foo1 f) {
     * f.bar();
     * }
     * passMeALambda(() -> System.out.println("Lambda called"));
     */

    // The Type of a Lambda Expression/Jenis Ekspresi Lambda

    /*
     * Ekspresi lambda, dengan sendirinya, tidak memiliki tipe tertentu. Meskipun
     * benar bahwa tipe dan jumlah parameter, serta tipe nilai yang dikembalikan
     * dapat menyampaikan beberapa informasi tipe, informasi tersebut hanya akan
     * membatasi tipe apa yang dapat ditetapkan. Lambda menerima tipe ketika
     * ditetapkan ke tipe antarmuka fungsional dengan salah satu cara berikut:
     * 
     * Penugasan langsung ke tipe fungsional, mis. myPredicate = s -> s.isEmpty()
     * 
     * Meneruskannya sebagai parameter yang memiliki tipe fungsional, mis.
     * stream.filter(s -> s.isEmpty())
     * 
     * Mengembalikannya dari fungsi yang mengembalikan tipe fungsional, mis. kembali
     * s -> s.isEmpty()
     * 
     * Mentransmisikannya ke tipe fungsional, mis. (Predicate<String>) s ->
     * s.isEmpty()
     */

    /*
     * Sampai penugasan ke tipe fungsional dibuat, lambda tidak memiliki tipe pasti.
     * Menggambarkan, pertimbangkan ekspresi lambda o -> o.isEmpty(). Ekspresi
     * lambda yang sama dapat ditetapkan ke banyak tipe fungsi berbeda:
     * 
     * Predicate<String> javaStringPred = o -> o.isEmpty();
     * Function<String, Boolean> javaFunc = o -> o.isEmpty();
     * Predicate<List> javaListPred = o -> o.isEmpty();
     * Consumer<String> javaStringConsumer = o -> o.isEmpty(); // return value is
     * ignored!
     * com.google.common.base.Predicate<String> guavaPredicate = o -> o.isEmpty();
     */

    /*
     * Sekarang setelah ditetapkan, contoh yang ditampilkan memiliki tipe yang
     * benar-benar berbeda meskipun ekspresi lambda terlihat sama, dan tidak dapat
     * ditetapkan satu sama lain.
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Implementing Foo1
        // Foo1 foo1 = () -> System.out.println("Implementing Foo1");
        // foo1.bar();
        /*
         * output:
         * Implementing Foo1
         */

        // Implementing Foo2
        // Foo2 foo2 = baz -> {
        // if (baz)
        // return 1;
        // else
        // return 0;
        // };
        // int result = foo2.bar(true);
        // System.out.println("Implementing Foo2: " + result);
        /*
         * output:
         * Implementing Foo2: 1
         */

        // Implementing Foo3
        // Foo3 foo3 = (baz, mink) -> "Result: " + baz.toString() + " " + mink;
        // String resultFoo3 = foo3.bar("Hello", 42);
        // System.out.println("Implementing Foo3: " + resultFoo3);
        /*
         * output:
         * Implementing Foo3: Result: Hello 42
         */

        // Implementing Foo4
        // Foo4 foo4 = new Foo4() {
        // @Override
        // public void quux() {
        // System.out.println("Quux method implementation");
        // }
        // };
        /*
         * output:
         * Quux method implementation
         */

        // foo4.quux();
        // System.out.println("Default method result from Foo4: " + foo4.bar());
        /*
         * output:
         * Default method result from Foo4: baz
         */

        // Implementing Foo5 (Functional Interface)
        // Foo5 foo5 = () -> System.out.println("Implementing Foo5");
        // foo5.bar();
        /*
         * output:
         * Implementing Foo5
         */

        // Implementing BlankFoo1 (Functional Interface inheriting from Foo3)
        // BlankFoo1 blankFoo1 = (baz, mink) -> "BlankFoo1: " + baz.toString() + " " +
        // mink;
        // String resultBlankFoo1 = blankFoo1.bar("World", 24);
        // System.out.println(resultBlankFoo1);
        /*
         * output:
         * BlankFoo1: World 24
         */

        // Implementing Foo6
        // Foo6 foo6 = () -> System.out.println("Implementing Foo6");
        // foo6.bar();
        /*
         * output:
         * Implementing Foo6
         */

        // ------------------------------
        MyFunctionalInterface fi = () -> System.out.println("Hello");

        // Panggil metode dari functional interface
        fi.theOneMethod(); // output: Hello

    }
}
