public class Expression_basics {
    // Expression Basics/Dasar-dasar Ekspresi

    // Ekspresi di Java adalah konstruksi utama untuk melakukan penghitungan.
    // Berikut beberapa contohnya:

    /*
     * 1 // A simple literal is an expression
     * 1 + 2 // A simple expression that adds two numbers
     * (i + j) / k // An expression with multiple operations
     * (flag) ? c : d // An expression using the "conditional" operator
     * (String) s // A type-cast is an expression
     * obj.test() // A method call is an expression
     * new Object() // Creation of an object is an expression
     * new int[] // Creation of an object is an expression
     */

    // Secara umum suatu ekspresi terdiri dari bentuk-bentuk berikut:
    /*
     * 1. Nama ekspresi yang terdiri dari:
     * Pengidentifikasi sederhana; misalnya someIdentifier
     * Pengidentifikasi yang memenuhi syarat; misalnya MyClass.someField
     * 2. Pratama yang terdiri dari:
     * Literals; e.g. 1, 1.0, 'X', "hello", false and null
     * Class literal expressions; e.g. MyClass.class
     * this and <TypeName> . this
     * Parenthesized expressions; e.g. ( a + b )
     * Class instance creation expressions; e.g. new MyClass(1, 2, 3)
     * Array instance creation expressions; e.g. new int[3]
     * Field access expressions; e.g. obj.someField or this.someField
     * Array access expressions; e.g. vector[21]
     * Method invocations; e.g. obj.doIt(1, 2, 3)
     * Method references (Java 8 and later); e.g. MyClass::doIt
     * 
     * 3. Unary operator expressions; e.g. !a or i++
     * 4. Binary operator expressions; e.g. a + b or obj == null
     * 5. Ternary operator expressions; e.g. (obj == null) ? 1 : obj.getCount()
     * 6. Lambda expressions (Java 8 and later); e.g. obj -> obj.getCount()
     */

    // Detail berbagai bentuk ekspresi dapat ditemukan di Topik lain.
    /*
     * 1. Topik Operator mencakup ekspresi operator unary, biner, dan ternary.
     * 2. Topik ekspresi Lambda mencakup ekspresi lambda dan ekspresi referensi
     * metode.
     * 3. Topik Kelas dan Objek mencakup ekspresi pembuatan instance kelas.
     * 4. Topik Array mencakup ekspresi akses array dan ekspresi pembuatan instance
     * array.
     * 5. Topik Literal mencakup berbagai jenis ekspresi literal.
     */

    // Jenis Ekspresi
    /*
     * Dalam kebanyakan kasus, ekspresi memiliki tipe statis yang dapat ditentukan
     * pada waktu kompilasi dengan memeriksa dan subekspresinya. Ini disebut sebagai
     * ekspresi yang berdiri sendiri.
     * 
     * Namun, (di Java 8 dan yang lebih baru) jenis ekspresi berikut mungkin
     * merupakan ekspresi poli:
     * Parenthesized expressions
     * Class instance creation expressions
     * Method invocation expressions
     * Method reference expressions
     * Conditional expressions
     * Lambda expressions
     * 
     */

    // Jika suatu ekspresi adalah ekspresi poli, tipenya mungkin dipengaruhi oleh
    // tipe target ekspresi; yaitu untuk apa itu digunakan.

    // Nilai sebuah Ekspresi
    /*
     * Nilai suatu ekspresi adalah penugasan yang sesuai dengan tipenya.
     * Pengecualian untuk hal ini adalah ketika polusi tumpukan telah terjadi;
     * misalnya karena peringatan "konversi tidak aman" telah (secara tidak pantas)
     * disembunyikan atau diabaikan.
     */

    // Pernyataan Ekspresi
    /*
     * Tidak seperti banyak bahasa lainnya, Java umumnya tidak mengizinkan ekspresi
     * digunakan sebagai pernyataan. Misalnya:
     * public void compute(int i, int j) {
     * i + j; // ERROR
     * }
     */

    /*
     * Karena hasil evaluasi ekspresi seperti tidak dapat digunakan, dan karena
     * tidak dapat mempengaruhi eksekusi program dengan cara lain, para perancang
     * Java mengambil posisi bahwa penggunaan tersebut adalah sebuah kesalahan, atau
     * salah arah.
     * 
     * Namun, hal ini tidak berlaku untuk semua ekspresi. Sebagian ekspresi
     * (sebenarnya) sah sebagai pernyataan. Set
     * terdiri dari:
     * Ekspresi penugasan(assignment expression), termasuk penugasan operasi dan
     * menjadi.
     * Ekspresi kenaikan dan penurunan sebelum dan sesudah.
     * Panggilan metode (void atau non void).
     * Ekspresi pembuatan instance kelas.
     */

    public static void main(String[] args) throws Exception {
        int i = 3;
        int j = 4;
        int k = 2;
        boolean flag = true;
        char c = 'a';
        char d = 'b';
        String s = "Hello";
        Expression_basics obj = new Expression_basics();

        System.out.println("1: " + 1);
        System.out.println("1 + 2: " + (1 + 2));
        System.out.println("(i + j) / k: " + ((i + j) / k));
        System.out.println("(flag) ? c : d: " + ((flag) ? c : d));
        System.out.println("(String) s: " + ((String) s));
        System.out.println("obj.test(): " + obj.test());
        System.out.println("new Object(): " + new Object());
        System.out.println("new int[]: " + new int[5]);
        /*
         * output:
         * 1: 1
         * 1 + 2: 3
         * (i + j) / k: 3
         * (flag) ? c : d: a
         * (String) s: Hello
         * obj.test(): 5
         * new Object(): java.lang.Object@6c629d6e
         * new int[]: [I@5ecddf8f
         */
    }

    public int test() {
        return 5;
    }
}
