public class Method_overloading {
    // Method Overloading/Metode Kelebihan Beban

    /*
     * Kelebihan metode, juga dikenal sebagai kelebihan fungsi, adalah kemampuan
     * suatu kelas untuk memiliki banyak metode
     * nama yang sama, asalkan berbeda dalam jumlah atau jenis argumen.
     * 
     * Kompiler memeriksa tanda tangan metode untuk mengetahui kelebihan metode
     * 
     * Tanda tangan metode terdiri dari tiga hal -
     * 1. Method name
     * 2. Number of parameters
     * 3. Types of parameters
     */

    // Jika ketiganya sama untuk dua metode mana pun di kelas, maka kompiler akan
    // memunculkan kesalahan metode duplikat
    /*
     * Jenis polimorfisme ini disebut polimorfisme static atau polimorfisme waktu
     * kompilasi karena metode yang tepat untuk dipanggil ditentukan oleh kompiler
     * selama waktu kompilasi berdasarkan daftar argumen.
     * 
     * class Polymorph {
     * public int add(int a, int b){
     * return a + b;
     * }
     * 
     * public int add(int a, int b, int c){
     * return a + b + c;
     * }
     * public float add(float a, float b){
     * return a + b;
     * }
     * public static void main(String... args){
     * Polymorph poly = new Polymorph();
     * int a = 1, b = 2, c = 3;
     * float d = 1.5, e = 2.5;
     * System.out.println(poly.add(a, b));
     * System.out.println(poly.add(a, b, c));
     * System.out.println(poly.add(d, e));
     * }
     * }
     */

    // Hal ini akan mengakibatkan:
    /*
     * 2
     * 6
     * 4.000000
     */

    // Metode yang kelebihan beban mungkin bersifat statis atau non-statis. Ini juga
    // tidak mempengaruhi kelebihan metode

    /*
     * public class Polymorph {
     * private static void methodOverloaded()
     * {
     * //No argument, private static method
     * }
     * private int methodOverloaded(int i)
     * {
     * //One argument private non-static method
     * return i;
     * }
     * static int methodOverloaded(double d)
     * {
     * //static Method
     * return 0;
     * }
     * public void methodOverloaded(int i, double d)
     * {
     * //Public non-static Method
     * }
     * }
     */

    // Juga jika Anda mengubah tipe pengembalian metode, kami tidak dapat
    // mendapatkannya sebagai metode yang kelebihan beban.

    /*
     * public class Polymorph {
     * void methodOverloaded(){
     * //No argument and No return type
     * }
     * int methodOverloaded(){
     * //No argument and int return type
     * return 0;
     * }
     */
    // -----------------------
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public float add(float a, float b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        Method_overloading box = new Method_overloading();
        int a = 1, b = 2, c = 3;
        float d = 1.5f, e = 2.5f;

        System.out.println(box.add(a, b)); // output: 3
        System.out.println(box.add(a, b, c)); // output: 6
        System.out.println(box.add(d, e)); // output: 4.0

    }
}
