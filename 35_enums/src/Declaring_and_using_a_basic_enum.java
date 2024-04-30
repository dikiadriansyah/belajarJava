public class Declaring_and_using_a_basic_enum {
    // Declaring and using a basic enum / Mendeklarasikan dan menggunakan enum dasar

    /*
     * ENUM dapat dianggap sebagai gula sintaks untuk kelas tertutup yang
     * instantiated hanya beberapa kali yang diketahui pada waktu kompilasi untuk
     * menentukan satu set konstanta.
     * 
     * Enum sederhana untuk mendaftar musim yang berbeda akan dinyatakan sebagai
     * berikut:
     * public enum Season {
     * WINTER,
     * SPRING,
     * SUMMER,
     * FALL
     * }
     * 
     * Sementara konstanta enum tidak perlu dalam semua caps, itu adalah konvensi
     * Java bahwa nama-nama konstanta sepenuhnya huruf besar(uppercase), dengan
     * kata-kata yang dipisahkan oleh garis bawah(underscores).
     * 
     * Anda dapat mendeklarasikan enum di file sendiri
     * 
     */

    /**
     * This enum is declared in the Season.java file.
     */
    public enum Season {
        WINTER, SPRING, SUMMER, FALL
    }

    /*
     * Tetapi Anda juga dapat mendeklarasikannya di dalam kelas lain:
     */

    // private Season season;
    // public String getSeason() {
    // return season.name();
    // }
    // public void setSeason(String season) {
    // this.season = Season.valueOf(season);
    // }

    /**
     * This enum is declared inside the Day.java file and
     * cannot be accessed outside because it's declared as private.
     */
    // private enum Season {
    // WINTER, SPRING, SUMMER, FALL
    // }

    /*
     * Akhirnya, Anda tidak dapat mendeklarasikan enum di dalam badan metode atau
     * konstruktor:
     */
    /**
     * Constructor
     */
    // public Declaring_and_using_a_basic_enum() {
    // // Illegal. Compilation error
    // enum Season{WINTER,SPRING,SUMMER,FALL}
    // }

    // public void aSimpleMethod() {
    // // Legal. You can declare a primitive (or an Object) inside a method.
    // Compile!
    // int primitiveInt = 42;
    // // Illegal. Compilation error.
    // enum Season{WINTER,SPRING,SUMMER,FALL}
    // Season season = Season.SPRING;
    // }

    // Konstanta enum duplikat tidak diperbolehkan:
    // public enum Season {
    // WINTER,
    // WINTER, //Compile Time Error : Duplicate Constants
    // SPRING,
    // SUMMER,
    // FALL
    // }

    /*
     * Setiap konstanta enum bersifat public, static dan final secara default.
     * Karena setiap konstanta static, mereka dapat diakses secara langsung
     * menggunakan nama enum.
     * 
     * Konstanta enum dapat dilewatkan sebagai parameter metode:
     */

    // public static void display(Season s) {
    // System.out.println(s.name()); // name() is a built-in method that gets the
    // exact name of the enum constant
    // }

    // display(Season.WINTER); // Prints out "WINTER"

    /*
     * Anda bisa mendapatkan array dari konstanta enum menggunakan metode values().
     * Nilai dijamin dalam urutan deklarasi di array yang dikembalikan:
     * Season[] seasons = Season.values();
     * 
     * Catatan: Metode ini mengalokasikan array nilai baru setiap kali disebut.
     * Untuk mengulangi konstanta enum:
     */
    public static void enumIterate() {
        for (Season s : Season.values()) {
            System.out.println(s.name());
        }
    }

    // Anda dapat menggunakan enum dalam pernyataan switch:
    public static void enumSwitchExample(Season s) {
        switch (s) {
            case WINTER:
                System.out.println("It's pretty cold");
                break;
            case SPRING:
                System.out.println("It's warming up");
                break;
            case SUMMER:
                System.out.println("It's pretty hot");
                break;
            case FALL:
                System.out.println("It's cooling down");
                break;
        }
    }

    // Anda juga dapat membandingkan konstanta enum menggunakan ==:
    // Season.FALL == Season.WINTER // false
    // Season.SPRING == Season.SPRING // true

    /*
     * Cara lain untuk membandingkan konstanta enum adalah dengan menggunakan
     * Equals() seperti di bawah ini, yang dianggap sebagai praktik buruk karena
     * Anda dapat dengan mudah jatuh ke dalam jebakan sebagai berikut:
     */
    // Season.FALL.equals(Season.FALL); // true
    // Season.FALL.equals(Season.WINTER); // false
    // Season.FALL.equals("FALL"); // false and no compiler error

    /*
     * Selain itu, meskipun serangkaian instance dalam enum tidak dapat diubah saat
     * run-time, instance itu sendiri tidak secara inheren tidak dapat diubah karena
     * seperti kelas lainnya, enum dapat berisi bidang yang dapat berubah seperti
     * yang ditunjukkan di bawah ini.
     */
    public enum MutableExample {
        A, B;

        private int count = 0;

        public void increment() {
            count++;
        }

        public void print() {
            System.out.println("The count of " + name() + " is " + count);
        }
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // Usage:
        MutableExample.A.print();
        /*
         * output:
         * The count of A is 0
         */

        MutableExample.A.increment();

        MutableExample.A.print();
        /*
         * output:
         * The count of A is 1 -- we've changed a field
         */

        MutableExample.B.print();
        /*
         * output:
         * The count of B is 0 -- another instance remains unchanged
         */

        /*
         * Namun, praktik yang baik adalah membuat contoh enum tidak dapat diubah, yaitu
         * ketika mereka tidak memiliki bidang tambahan atau semua bidang tersebut
         * ditandai sebagai final dan tidak dapat diubah sendiri. Ini akan memastikan
         * bahwa untuk seumur hidup aplikasi, enum tidak akan membocorkan memori apa pun
         * dan aman untuk menggunakan instance di semua utas.
         * 
         * Enums secara implisit mengimplementasikan serial yang dapat diseriali dan
         * sebanding karena kelas enum melakukannya:
         */

        // public abstract class Enum<E extends Enum<E>>
        // extends Object
        // implements Comparable<E>, Serializable
    }

}
